package ninja.stoffel.network;

import java.io.*;
import java.net.Socket;

/**
 * Created by Lourens on 01-Apr-17.
 */
public class NetworkManager {

    private int port;
    private String ip;

    private Socket server;
    private PrintWriter output;
    private BufferedReader input;

    private ServerListener serverListener;

    public NetworkManager(int port, String ip) {
        this.port = port;
        this.ip = ip;
    }

    public void connect() {
        try {
            System.out.println("Connecting to :" + ip + ":" + port);
            server = new Socket(ip, port);
            System.out.println("Connected to server");

            output = new PrintWriter(server.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(server.getInputStream()));

            serverListener = new ServerListener(this);
            serverListener.start();
//            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader getInput() {
        return input;
    }

    public void send(String msg) {
        output.write(msg);
        output.flush();
    }

}
