import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
public class HydroponicApp {
    Server server;
    private JLabel Temperature;
    private JPanel Popup;
    private JLabel Humidity;
    private JLabel Pressure;
    private JLabel LastUpdate;

    JFrame window = new JFrame();
    Font customFont = new Font("Arial", Font.BOLD, 16);

    public HydroponicApp() {

        window.setMinimumSize(new Dimension(1000,1000));
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(Popup);

        LastUpdate.setFont(customFont);

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateValues();
            }
        });
        timer.start();
    }

    private void updateValues() {
        server.write("0");
        String temperature = server.read() + " *C";
        String pressure = server.read() +" hPa";
        String humidity = server.read()+" %";

        Temperature.setText(temperature);
        Pressure.setText(pressure);
        Humidity.setText(humidity);

        updateLastUpdateField();
    }

    private void updateLastUpdateField() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastUpdate = dateFormat.format(new Date());
        LastUpdate.setText("Ostatnia aktualizacja: " + lastUpdate);
    }

        public static void main(String[] args) {
        HydroponicApp app = new HydroponicApp();
        app.server = new Server();
        app.server.connect("192.168.0.54",80);
    }
}