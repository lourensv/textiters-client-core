import java.io.*;
import java.net.Socket;
/**
 * Created by Lourens on 10/30/2016.
 */
public class Main {

    public static void main(String[] args) {
        int port = 9999;
        String server = "10.0.0.9";

        try {
            Socket client = new Socket(server, port);

            OutputStream outToServer = client.getOutputStream();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            System.out.println("Connected to server");
            out.print("Hello from " + client.getLocalAddress());
            out.flush();

//            InputStream inFromServer = client.getInputStream();
            BufferedReader in = new  BufferedReader( new InputStreamReader(client.getInputStream()));
            System.out.println(in.readLine());
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
