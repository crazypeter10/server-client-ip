public class DatePersonale {

    // Campuri ascunse

    private String nume;

    private String acronim_facultate;

    private String prenume;

    private int varsta;



    // Constructori

    public DatePersonale(String n, String a, String p, int an) {

        nume = new String(n);      // copiere „hard” a obiectelor primite ca parametri,

        acronim_facultate = new String(a);  // adica se copiaza obiectul camp cu camp,

        prenume = new String(p);   // nu doar referintele ca pana acum

        varsta = an;

    }

    // Interfata publica si implementarea ascunsa

    public String getNume() {      return (nume);   }

    public String getPrenume() {   return (prenume);   }

    public String getacronimFacultate() {   return (acronim_facultate);   }

    public int getvarsta() {    return (varsta);   }

    public String toString() {    // forma „String” a campurilor obiectului

        return (nume + " " + acronim_facultate + " " + prenume + " (" + varsta + ")");

    }

}