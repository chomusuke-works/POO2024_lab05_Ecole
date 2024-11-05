package school;

public abstract class Person {
    private final String firstName;
    private final String lastName;

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
