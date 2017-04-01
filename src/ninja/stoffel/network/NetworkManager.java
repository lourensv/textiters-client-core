package ninja.stoffel.network;

import java.io.*;
import java.net.Socket;

/**
 * Created by Lourens on 01-Apr-17.
 */
public class NetworkManager {

    private int port;
    private String ip;


    public NetworkManager(int port, String ip) {
        this.port = port;
        this.ip = ip;
    }

    public void connect() {
        try {
            System.out.println("Connecting to :" + ip + ":" + port);
            Socket client = new Socket(ip, port);
            System.out.println("Connected to server");
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
