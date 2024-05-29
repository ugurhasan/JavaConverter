import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter {

    // Exchange rates
    private static final double USD_TO_EUR = 0.85;
    private static final double EUR_TO_USD = 1.18;
    private static final double USD_TO_GBP = 0.75;
    private static final double GBP_TO_USD = 1.33;
    private static final double EUR_TO_GBP = 0.88;
    private static final double GBP_TO_EUR = 1.14;

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create components
        JLabel label1 = new JLabel("Source Currency (USD, EUR, GBP):");
        label1.setBounds(20, 20, 200, 25);
        frame.add(label1);

        JTextField sourceField = new JTextField();
        sourceField.setBounds(220, 20, 100, 25);
        frame.add(sourceField);

        JLabel label2 = new JLabel("Target Currency (USD, EUR, GBP):");
        label2.setBounds(20, 60, 200, 25);
        frame.add(label2);

        JTextField targetField = new JTextField();
        targetField.setBounds(220, 60, 100, 25);
        frame.add(targetField);

        JLabel label3 = new JLabel("Amount:");
        label3.setBounds(20, 100, 200, 25);
        frame.add(label3);

        JTextField amountField = new JTextField();
        amountField.setBounds(220, 100, 100, 25);
        frame.add(amountField);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 150, 100, 25);
        frame.add(convertButton);

        JLabel resultLabel = new JLabel("Converted Amount: ");
        resultLabel.setBounds(20, 200, 300, 25);
        frame.add(resultLabel);

        // Add action listener to the button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sourceCurrency = sourceField.getText().toUpperCase();
                String targetCurrency = targetField.getText().toUpperCase();
                double amount;
                try {
                    amount = Double.parseDouble(amountField.getText());
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid amount. Please enter a number.");
                    return;
                }

                double convertedAmount = convertCurrency(sourceCurrency, targetCurrency, amount);
                if (convertedAmount == -1) {
                    resultLabel.setText("Invalid currency input. Please use USD, EUR, or GBP.");
                } else {
                    resultLabel.setText(String.format("%.2f %s is %.2f %s", amount, sourceCurrency, convertedAmount, targetCurrency));
                }
            }
        });

        // Set the frame to be visible
        frame.setVisible(true);
    }

    /**
     * Converts the amount from one currency to another using predefined exchange rates.
     *
     * @param sourceCurrency The currency to convert from.
     * @param targetCurrency The currency to convert to.
     * @param amount         The amount of money to be converted.
     * @return The converted amount, or -1 if an invalid currency is provided.
     */
    private static double convertCurrency(String sourceCurrency, String targetCurrency, double amount) {
        if (sourceCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return amount * USD_TO_EUR;
        } else if (sourceCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return amount * EUR_TO_USD;
        } else if (sourceCurrency.equals("USD") && targetCurrency.equals("GBP")) {
            return amount * USD_TO_GBP;
        } else if (sourceCurrency.equals("GBP") && targetCurrency.equals("USD")) {
            return amount * GBP_TO_USD;
        } else if (sourceCurrency.equals("EUR") && targetCurrency.equals("GBP")) {
            return amount * EUR_TO_GBP;
        } else if (sourceCurrency.equals("GBP") && targetCurrency.equals("EUR")) {
            return amount * GBP_TO_EUR;
        } else {
            return -1; // Invalid currency input
        }
    }
}
