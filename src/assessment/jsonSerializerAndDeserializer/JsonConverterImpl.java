package assessment.jsonSerializerAndDeserializer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JsonConverterImpl implements JsonConverter {

    // Convert Java object to JSON string
    @Override
    public String toJson(Object object) throws JsonConversionException {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        try {
            Field[] fields = object.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);

                String fieldName = field.getName();
                Object fieldValue = field.get(object);

                if (fieldValue instanceof List) {
                    jsonBuilder.append("\"").append(fieldName).append("\":").append(listToJson((List<?>) fieldValue));
                } else {
                    jsonBuilder.append("\"").append(fieldName).append("\":\"").append(fieldValue).append("\"");
                }

                if (i < fields.length - 1) {
                    jsonBuilder.append(",");
                }
            }
        } catch (IllegalAccessException e) {
            throw new JsonConversionException("Error accessing object fields", e);
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    // Convert JSON string to Java object
    @Override
    public <T> T fromJson(String json, Class<T> clazz) throws JsonConversionException {
        T object;
        try {
            object = clazz.getDeclaredConstructor().newInstance();

            json = json.trim().substring(1, json.length() - 1);
            String[] pairs = json.split(",");
            for (String pair : pairs) {
                String[] keyValue = pair.split(":");
                String fieldName = keyValue[0].trim().replace("\"", "");
                String fieldValue = keyValue[1].trim().replace("\"", "");

                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                if (field.getType() == List.class) {
                    field.set(object, jsonToList(fieldValue, field.getType()));
                } else {
                    field.set(object, fieldValue);
                }
            }
        } catch (Exception e) {
            throw new JsonConversionException("Error converting JSON to Java object", e);
        }

        return object;
    }

    // Helper method to serialize a List to JSON
    private String listToJson(List<?> list) throws JsonConversionException {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");

        for (int i = 0; i < list.size(); i++) {
            Object item = list.get(i);
            try {
                jsonBuilder.append(toJson(item));
            } catch (JsonConversionException e) {
                throw new JsonConversionException("Error serializing list item", e);
            }

            if (i < list.size() - 1) {
                jsonBuilder.append(",");
            }
        }

        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    // Helper method to deserialize JSON into a List
    private List<Object> jsonToList(String json, Class<?> clazz) throws JsonConversionException {
        List<Object> list = new ArrayList<>();

        // Strip off the square brackets and trim the JSON string
        json = json.trim().substring(1, json.length() - 1).trim();

        // Handle the case when the list is empty
        if (json.isEmpty()) {
            return list;
        }

        // Split the JSON by commas (assuming simple objects or strings for now)
        String[] items = json.split(",");

        for (String item : items) {
            item = item.trim().replace("\"", "");  // Removing the surrounding quotes for simple values

            try {
                // Simple case: If the element is a string, add it directly
                if (clazz == String.class) {
                    list.add(item);
                } else if (clazz == Integer.class) {
                    list.add(Integer.parseInt(item));
                } else {
                    // For complex objects, use reflection to instantiate and set fields
                    Object obj = clazz.getDeclaredConstructor().newInstance();
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (field.getType() == String.class) {
                            field.set(obj, item);
                        }
                    }
                    list.add(obj);
                }
            } catch (Exception e) {
                throw new JsonConversionException("Error parsing list item", e);
            }
        }

        return list;
    }
}
