package school.people;

import school.Group;

public class Etudiant extends Personne {
    private final int matricule;
    private Group group;

    public Etudiant(String firstName, String lastName, int matricule) {
        super(firstName, lastName);

        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
