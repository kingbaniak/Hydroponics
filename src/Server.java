import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Server {
    Socket s;
    PrintWriter pr;

    InputStreamReader in;
    BufferedReader bf;

    Server(){

    }

    public void connect(String ip, Integer port){
        try {
            s = new Socket(ip, port);
            pr = new PrintWriter(s.getOutputStream());
            in = new InputStreamReader(s.getInputStream());
        } catch (IOException e) {
            System.out.println("nie polaczn");
        }

        bf = new BufferedReader(in);
    }

    public void read(){
        String str = null;
        try {
            str = bf.readLine();
        } catch (IOException e) {
            System.out.println("OH mY GOD");
        }
        System.out.println("server: "+str);
    }
    public void write(){
        pr.println("is it working?");
        pr.flush();
    }
    public void disconnect(){}
}
