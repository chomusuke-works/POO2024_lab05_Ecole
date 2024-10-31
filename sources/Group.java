import java.util.ArrayList;
import java.util.List;

public class Group {
	private final int number;
	private final String orientation;
	private final int quarter;
	private final List<Object> students = new ArrayList<>();  // TODO list of students

	public Group(int number, String orientation, int quarter) {
		this.number = number;
		this.orientation = orientation;
		this.quarter = quarter;
	}

	public String horaire() {
		return "";
	}

	public String nom() {
		return "";
	}

	public int nombreEtudiants() {
		return students.size();
	}

	public void defineLessons(Object ... args) {

	}
}
