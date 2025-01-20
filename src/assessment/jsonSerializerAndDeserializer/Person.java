package assessment.jsonSerializerAndDeserializer;

import java.util.List;

public class Person {

    private String name;
    private String age;
    private String email;
    private List<String> phoneNumbers;

    // Default constructor
    public Person() {}

    // Constructor with parameters
    public Person(String name, String age, String email, List<String> phoneNumbers) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "', phoneNumbers=" + phoneNumbers + "}";
    }
}