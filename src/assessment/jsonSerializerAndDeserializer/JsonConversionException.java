package assessment.jsonSerializerAndDeserializer;

public class JsonConversionException extends Exception {

    public JsonConversionException(String message) {
        super(message);
    }

    public JsonConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}