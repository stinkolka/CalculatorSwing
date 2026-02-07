import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KalkulackaLogic implements ActionListener {

    private JTextField textField;
    private StringBuilder currentInput;
    private double result;
    private String lastOperator;

    public KalkulackaLogic(JTextField textField) {
        this.textField = textField;
        this.currentInput = new StringBuilder();
        this.result = 0;
        this.lastOperator = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch(command) {
            case "<-":
                if(!currentInput.isEmpty()) {
                    currentInput.deleteCharAt(currentInput.length() - 1);
                }
                textField.setText(!currentInput.isEmpty() ? currentInput.toString() : "0");
                break;

            case "AC":
                if(!currentInput.isEmpty()) {
                    currentInput.setLength(0);
                    result = 0;
                    lastOperator = "";
                    textField.setText("0");
                }
                break;

            case "%":
                if(!currentInput.isEmpty()) {
                    double value = Double.parseDouble(currentInput.toString()) / 100;
                    currentInput.setLength(0);
                    currentInput.append(value);
                    textField.setText(currentInput.toString());
                }
                break;

            case "/": case "*": case "-": case "+":
                calculate();
                lastOperator = command;
                currentInput.setLength(0);
                break;

            case "=":
                calculate();
                lastOperator = "";
                break;

            case "+/-":
                if(!currentInput.isEmpty() && !currentInput.toString().equals("0")) {
                    if(currentInput.charAt(0) == '-') currentInput.deleteCharAt(0);
                    else currentInput.insert(0, '-');
                    textField.setText(currentInput.toString());
                }
                break;

            default:
                currentInput.append(command);
                textField.setText(currentInput.toString());
                break;
        }

    }

    private void calculate() {
        if(currentInput.isEmpty()) return;
        double inputValue = Double.parseDouble(currentInput.toString());

        switch(lastOperator) {
            case "": result = inputValue; break;
            case "+": result += inputValue; break;
            case "-": result -= inputValue; break;
            case "*": result *= inputValue; break;
            case "/":
                if(inputValue != 0) result /= inputValue;
                else textField.setText("Error");
                break;
        }

        textField.setText(String.valueOf(result));

    }

}
