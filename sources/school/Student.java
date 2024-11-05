package school;

public class Student extends Person {
    private int number;

    Student(String firstName, String lastName, int number) {
        super(firstName, lastName);

        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
