public class Student implements Human {

    // Campuri ascunse


    private DatePersonale date;


    private int an_studiu;




    // Constructori

    public Student(String nume, String acronim_facultate, String prenume, int varsta,int an_studiu) {

        date = new DatePersonale(nume, acronim_facultate, prenume, varsta); // copiere hard
    setAnStudiu(an_studiu);
    }



    // Interfata publica si implementarea ascunsa (include punct intrare program)

    public void setAnStudiu(int an_s) {

        an_studiu = an_s;     // copiere „hard” a obiectului primit ca parametru

    }

    public String toString() {                // forma „String” a campurilor

        return ("Studentul " + date +  "este in anul de studiu " + an_studiu);

    }

    public static void main(String[] args) {

        // Crearea unui nou Profesor, initializarea campurilor noului obiect

    //   Student sd = new Student("Marian", "C.", "Mariu", 20);

      //  sd.setAnStudiu(2);

        // Utilizarea informatiilor privind Profesorul

        //     System.out.println(sd.toString());    // afisarea formei „String” a campurilor

    }
    @Override
    public void greeting(){
        System.out.println("[Sd." + this.date.getNume()+ " says Hello!]\n");
    }

    @Override
    public void dowork(){
        System.out.println("[Sd. " + this.date.getNume() + " does the homework!]\n");
    }

    @Override
    public Integer getVarsta() {
        return date.getvarsta();
    }




    @Override
    public int compareTo(Human obj){
        return this.getVarsta().compareTo(obj.getVarsta());
    }
}