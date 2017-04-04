package ninja.stoffel;

import ninja.stoffel.network.NetworkManager;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Lourens on 10/30/2016.
 */
public class Main {

    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public static void main(String[] args) {
        try {
            int port = 9999;
            String server = "127.0.0.1";//"textiters.stoffel.ninja";
            String ip = server;
            if (!validate(server)) {
                ip = InetAddress.getByName(server).getHostAddress();
            }

            NetworkManager networkManager = new NetworkManager(port, ip);
            networkManager.connect();

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter the data:");
            while (true) {
                String inData = scan.nextLine();
                networkManager.send(inData);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public static boolean validate(final String ip) {
        return PATTERN.matcher(ip).matches();
    }

}
