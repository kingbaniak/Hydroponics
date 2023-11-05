import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HydroponicApp {
    Server server;
    private JButton LEDONButton;
    private JButton LEDOFFButton;
    private JTextField info;
    private JPanel Popup;
    private JButton checkLED;

    JFrame window = new JFrame();

    public HydroponicApp() {

        window.setMinimumSize(new Dimension(1000,1000));
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(Popup);
        LEDONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                info.setText("Led is on");
                server.write("1");
            }
        });
        LEDOFFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                info.setText("Led is off");
                server.write("0");
            }
        });
        checkLED.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.write("2");
                server.read();
            }
        });
    }

    public static void main(String[] args) {
        HydroponicApp app = new HydroponicApp();
        app.server = new Server();
        app.server.connect("192.168.0.54",80);
    }
}