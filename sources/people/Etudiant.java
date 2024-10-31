package people;

public class Etudiant extends Personne {
    private int matricule;

    Etudiant(String firstName, String lastName, int matricule) {
        super(firstName, lastName);

        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
