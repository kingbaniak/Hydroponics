import javax.swing.*;
import java.net.*;
import java.io.*;

public class HydroponicApp {
    private JButton button1;
    Server server;

    public static void main(String[] args) {
        Server server = new Server();
        server.connect("192.168.0.2",80);

        server.write();
        server.read();
    }
}
