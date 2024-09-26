package experiment;
import javax.swing.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame {

    private JTextField tempInput;
    private JButton toCelsiusButton;
    private JButton toFahrenheitButton;
    private JLabel resultLabel;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel promptLabel = new JLabel("Enter Temperature:");
        promptLabel.setBounds(20, 20, 120, 25);
        add(promptLabel);

        tempInput = new JTextField();
        tempInput.setBounds(150, 20, 100, 25);
        add(tempInput);

        toCelsiusButton = new JButton("To Celsius");
        toCelsiusButton.setBounds(20, 60, 110, 30);
        add(toCelsiusButton);

        toFahrenheitButton = new JButton("To Fahrenheit");
        toFahrenheitButton.setBounds(140, 60, 130, 30);
        add(toFahrenheitButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(20, 100, 200, 25);
        add(resultLabel);

        toCelsiusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertToCelsius();
            }
        });

        toFahrenheitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertToFahrenheit();
            }
        });
    }

    private void convertToCelsius() {
        try {
            double fahrenheit = Double.parseDouble(tempInput.getText());
            double celsius = (fahrenheit - 32) * 5 / 9;
            resultLabel.setText(String.format("Result: %.2f °C", celsius));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private void convertToFahrenheit() {
        try {
            double celsius = Double.parseDouble(tempInput.getText());
            double fahrenheit = celsius * 9 / 5 + 32;
            resultLabel.setText(String.format("Result: %.2f °F", fahrenheit));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        TemperatureConverter frame = new TemperatureConverter();
        frame.setVisible(true);
    }
}
