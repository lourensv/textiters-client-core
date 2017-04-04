package ninja.stoffel.network;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Lourens on 04-Apr-17.
 */
public class ServerListener extends Thread {

    private NetworkManager networkManager;

    ServerListener(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    public void run() {
        BufferedReader reader = networkManager.getInput();
        while (true) {
            try {
                String line = reader.readLine();
                System.out.println("Server: " + line);

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}
