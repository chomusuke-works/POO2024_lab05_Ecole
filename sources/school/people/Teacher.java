package school.people;

public class Teacher extends Person {
    private String abbreviation;

    Teacher(String firstName, String lastName, String abbreviation) {
        super(firstName, lastName);

        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String schedule() {
        return "";
    }
}
