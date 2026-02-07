import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.Constants;

public class KalkulackaGUI extends JFrame implements ActionListener {

    private JTextField textField;
    private JPanel buttonPanel;
    private JButton[] buttons;

    public KalkulackaGUI() {
        super("Kalkulačka");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Constants.APP_SIZE[0], Constants.APP_SIZE[1]);
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
        textField.setBounds(Constants.TEXTFIELD_X, Constants.TEXTFIELD_Y, Constants.TEXTFIELD_WIDTH, Constants.TEXTFIELD_HEIGHT);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField.setFont(new Font("Arial", Font.PLAIN, Constants.FONT_SIZE));
        textField.setText("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField);
    }

    private void addButtonComponents() {
        buttonPanel = new JPanel();
        buttonPanel.setBounds(Constants.BUTTON_PANEL_X, Constants.BUTTON_PANEL_Y, Constants.BUTTON_PANEL_WIDTH, Constants.BUTTON_PANEL_HEIGHT);
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
                "<-", "AC", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ".", "="
        };

        buttons = new JButton[Constants.BUTTON_COUNT];
        for(int i = 0; i < Constants.BUTTON_COUNT; i++){
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, Constants.BUTTON_FONT_SIZE));
            buttons[i].addActionListener (this);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}



