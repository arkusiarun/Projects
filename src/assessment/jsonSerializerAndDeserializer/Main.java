package assessment.jsonSerializerAndDeserializer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JsonConverter jsonConverter = new JsonConverterImpl();

        // Example: Convert Java object with List to JSON string
        Person person = new Person("John Doe", "30", "johndoe@example.com", Arrays.asList("123-456-7890", "987-654-3210"));

        try {
            String jsonString = jsonConverter.toJson(person);
            System.out.println("Serialized JSON: " + jsonString);

            // Convert JSON string back to Java object
            Person deserializedPerson = jsonConverter.fromJson(jsonString, Person.class);
            System.out.println("Deserialized Object: " + deserializedPerson);
        } catch (JsonConversionException e) {
            e.printStackTrace();
        }
    }
}