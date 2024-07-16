import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, modulusButton, clearButton;

    public CalculatorApp() {
        setTitle("Simple Calculator");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel for holding components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));

        // First number input
        panel.add(new JLabel("First Number:"));
        firstNumberField = new JTextField(10);
        panel.add(firstNumberField);

        // Second number input
        panel.add(new JLabel("Second Number:"));
        secondNumberField = new JTextField(10);
        panel.add(secondNumberField);

        // Result display
        panel.add(new JLabel("Result:"));
        resultField = new JTextField(10);
        resultField.setEditable(false);
        panel.add(resultField);

        // Buttons for operations
        addButton = new JButton("+");
        addButton.addActionListener(this);
        panel.add(addButton);

        subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        panel.add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        panel.add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.addActionListener(this);
        panel.add(divideButton);

        modulusButton = new JButton("%");
        modulusButton.addActionListener(this);
        panel.add(modulusButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        panel.add(clearButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                result = num1 / num2;
            } else if (e.getSource() == modulusButton) {
                result = num1 % num2;
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Cannot divide by zero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorApp();
            }
        });
    }
}
