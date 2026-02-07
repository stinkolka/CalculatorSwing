import javax.swing.*;
import java.awt.*;

public class KalkulackaGUI extends JFrame {

    private JTextField textField;
    private Button[] numberButton;

    public KalkulackaGUI() {
        super("Kalkulačka");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        addGuiComponents();
    }

    private void addGuiComponents() {
        addDisplayComponents();
        addButtonComponents();
    }

    private void addDisplayComponents() {
        textField = new JTextField();
        textField.setBounds(10, 10, 415, 100);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(textField);
    }

    private void addButtonComponents() {}
}

