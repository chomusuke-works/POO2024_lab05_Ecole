import school.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Teacher dre = new Teacher("Daniel", "Rossier", "DRE");
		Teacher pdo = new Teacher("Pier", "Donini", "PDO");

		Lesson poo1 = new Lesson("POO", 0, 9, 2, "G01", pdo);
		Lesson poo2 = new Lesson("POO", 3, 5, 2, "G01", pdo);
		Lesson poo3 = new Lesson("POO", 3, 7, 2, "G01", pdo);
		Lesson sye1 = new Lesson("SYE", 1, 5, 2, "B23", dre);
		Lesson sye2 = new Lesson("SYE", 1, 7, 2, "B23", dre);
		Lesson tic = new Lesson("TIC", 1, 9, 2, "F06", null);

		Student johnLennon = new Student("John", "Lennon", 1234);
		Student paulMcCartney = new Student("Paul", "McCartney", 2341);
		Student ringoStarr = new Student("Ringo", "Starr", 3241);
		Student georgeHarisson = new Student("George", "Harisson", 4321);
		Student rogerWaters = new Student("Roger", "Waters", 1324);
		Student davidGilmour = new Student("David", "Gilmour", 4312);

		Group il61 = new Group(1, "IL", 6,
			johnLennon,
			paulMcCartney,
			ringoStarr,
			georgeHarisson
		);

		Group si61 = new Group(1, "SI", 6,
			rogerWaters,
			davidGilmour
		);

		il61.defineLessons(poo1, poo2, poo3, sye1, sye2, tic);

		si61.defineLessons(poo1, poo2, poo3);

		System.out.println("-- Membres de l'école");
		List<Person> people = List.of(dre, pdo, johnLennon, paulMcCartney, ringoStarr, georgeHarisson, rogerWaters, davidGilmour);
		for (Person person : people) {
			System.out.println(person);
		}

		System.out.println("\n-- Horaire du groupe IL6-1 (4 etudiants)");
		System.out.println(il61.schedule());

		System.out.println("\n-- Horaire du Prof. Pier Donini (PDO)");
		System.out.println(pdo.schedule());
	}
}