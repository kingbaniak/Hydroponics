import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Server implements Functionality {
    Socket socketVal;
    PrintWriter prtVal;
    InputStreamReader ioVal;
    BufferedReader bufVal;

    Server(){

    }

    public void connect(String ip, Integer port){
        try {
            socketVal = new Socket(ip, port);
            prtVal = new PrintWriter(socketVal.getOutputStream());
            ioVal = new InputStreamReader(socketVal.getInputStream());
        } catch (IOException e) {
            System.out.println("Failed to connect");
        }

        bufVal = new BufferedReader(ioVal);
    }

    public String read() {
        try {
            String readVal = bufVal.readLine();
            System.out.println("server: " + readVal);
            return readVal;
        } catch (IOException e) {
            System.out.println("Cannot read value");
            return null; // Handle the exception and return null or an error message
        }
    }

    public void write(String command){
        prtVal.println(command);
        prtVal.flush();
    }
    public void disconnect(){}
}
