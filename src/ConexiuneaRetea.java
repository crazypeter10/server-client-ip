import java.net.*;
import java.io.*;
import java.util.Scanner;
//incepusem ideea altfel printr-un client server care trimitea mesaje pur si simple iar server-ul le afisa si aveam de gand
//sa creez mai multe servere si mai multi clienti dar complicam problema.
public class ConexiuneaRetea {
    private Socket conexiune;
    private Scanner scannerTCP;
    private PrintStream printerTCP;
    public ConexiuneaRetea(Socket conexiune) throws IOException {
        this.conexiune = conexiune;
        this.scannerTCP = new Scanner(conexiune.getInputStream());
        this.printerTCP = new PrintStream(conexiune.getOutputStream());
    }
    public String nextLine() {
        return this.scannerTCP.nextLine();
    }
    public int nextInt() {
        return this.scannerTCP.nextInt();
    }
    public void printLine(String text) {
        this.printerTCP.println(text);
        this.printerTCP.flush();
    }
}