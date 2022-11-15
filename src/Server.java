import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

public class Server {
    public static void main(String args[]) throws IOException {
        int port = 80;//Integer.parseInt(args[0]);
        ServerSocket server = new ServerSocket(port);

        while(true) {
            Socket client = null;
            try {
                client = server.accept();

                System.out.println("A new client is connected : " + client);
                DataInputStream dis = new DataInputStream(client.getInputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                System.out.println("Assigning new thread for this client");

                Thread new_thread = new ClientHandler(client, dis, dos);
                new_thread.start();
            }
            catch (IOException e) {
                server.close();
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread
{
    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;


    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
    {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run()
    {
        ArrayList<Human> Humans = new ArrayList<Human>();
        String received;
        String toreturn;
        String toreturn1;
        while (true)
        {
            try {

                // Ask user what he wants
                dos.writeUTF("Type Student/Profesor, Your Name,Univesity,Surname,Age,Curicullum/uni year...\n"+
                        "Type Exit to terminate connection.");


                // receive the answer from client
                received = dis.readUTF();
                //System.out.println(received.toString());
                String split[] = received.split(" ");
                if (split[0].equals("Student")){
                    try {
                        Humans.add(new Student(split[1], split[2], split[3], Integer.parseInt(split[4]), Integer.parseInt(split[5])));
                    }
                    catch(Exception e) {        dos.writeUTF("Something went wrong.\n");


                    }

                    }
                else if (split[0].equals("Profesor")){
                    try {
                        Humans.add(new Profesor(split[1], split[2], split[3], Integer.parseInt(split[4]), split[5]));
                    }
               catch(Exception e) {        dos.writeUTF("Something went wrong.\n");

                        }
                    }

                if(received.equals("Exit"))
                {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            //for (Human index : Humans){
            //System.out.println(index.toString());
            //}
            Collections.sort(Humans);
            for (Human index : Humans){
                System.out.println(index.toString());
            }
        }

        try
        {
            // closing resources
            this.dis.close();
            this.dos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}