import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;
    double num1 = 0;
    String operator = "";

    Calculator() {
        setTitle("Simple Calculator");
        setSize(320, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            display.setText(display.getText() + cmd);
        }

        else if (cmd.equals("+") || cmd.equals("-") || 
                 cmd.equals("*") || cmd.equals("/")) {

            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = cmd;
                display.setText("");
            }
        }

        else if (cmd.equals("=")) {

            if (!display.getText().isEmpty()) {
                double num2 = Double.parseDouble(display.getText());
                double result = 0;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            display.setText("Cannot divide by 0");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }

                display.setText(String.valueOf(result));
            }
        }

        else if (cmd.equals("C")) {
            display.setText("");
            num1 = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
