package school;

public class Person {
    private String firstName;
    private String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String getJob() {
        return "Pers.";
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getJob(), firstName, lastName);
    }
}
