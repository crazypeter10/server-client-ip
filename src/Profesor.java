public class Profesor implements Human {

    // Campuri ascunse


    private DatePersonale date;


    private String materie;




    // Constructori

    public Profesor(String nume, String acronim_facultate, String prenume, int varsta,String materie) {

        date = new DatePersonale(nume, acronim_facultate, prenume, varsta); // copiere „hard”
setMaterie(materie);
    }



    // Interfata publica si implementarea ascunsa (include punct intrare program)

    public void setMaterie(String m) {

        materie = new String(m);      // copiere „hard” a obiectului primit ca parametru

    }

    public String toString() {                // forma „String” a campurilor

        return ("Profesorul " + date +  "este la materia " + materie);

    }

    public static void main(String[] args) {

        // Crearea unui nou Profesor, initializarea campurilor noului obiect

     //   Profesor pr = new Profesor("Nulescu", "C.", "Ion", 40);

       // pr.setMaterie("Matematica");
     //   System.out.println(pr.getVarsta());
        // Utilizarea informatiilor privind Profesorul
       // System.out.println(pr.toString());    // afisarea formei „String” a campurilor

    }
    @Override
    public void greeting(){
        System.out.println("[Prof." + this.date.getNume() + " says Hello!]\n");
    }

    @Override
    public void dowork(){
        System.out.println("[Prof." + this.date.getNume() + " prepares the homework for the Students!]\n");
    }

    @Override
    public Integer getVarsta() {
        return this.date.getvarsta();
    }


    @Override
    public int compareTo(Human obj){
        return this.getVarsta().compareTo(obj.getVarsta());
    }
}