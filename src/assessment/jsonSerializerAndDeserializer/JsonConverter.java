package assessment.jsonSerializerAndDeserializer;

public interface JsonConverter {
    String toJson(Object object) throws JsonConversionException;
    <T> T fromJson(String json, Class<T> clazz) throws JsonConversionException;
}
