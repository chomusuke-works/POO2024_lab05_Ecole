package school;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private String abbreviation;
    final List<Lesson> lessons = new ArrayList<>();  // Package visibility -> modified when creating lessons taught by this teacher

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
