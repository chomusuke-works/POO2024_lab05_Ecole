package school;

public abstract class Person {
    private String firstName;
    private String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected abstract String getJob();

    @Override
    public String toString() {
        return String.format("%s %s %s", getJob(), firstName, lastName);
    }
}
