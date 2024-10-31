package people;

public class Professeur extends Personne {
    private String abreviation;

    Professeur(String firstName, String lastName, String abreviation) {
        super(firstName, lastName);

        this.abreviation = abreviation;
    }

    public String getAbreviation() {
        return abreviation;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String horaire() {
        return "";
    }
}
