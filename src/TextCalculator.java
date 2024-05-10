import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextCalculator extends JFrame {
    private JButton pageChangeButton;
    private JButton calculateButton;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    public TextCalculator() {
        setTitle("Text Calculator");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());


        // Input and Output components
        JPanel centerPanel = new JPanel(new GridLayout(2, 2));

        JLabel inputLabel = new JLabel("Input Type:");
        centerPanel.add(inputLabel);

        JComboBox<String> inputTypeComboBox = new JComboBox<>(new String[]{"AES", "DES", "Hash", "Blowfish"});
        centerPanel.add(inputTypeComboBox);

        JLabel inputTextLabel = new JLabel("Input:");
        centerPanel.add(inputTextLabel);

        JTextField inputText = new JTextField();
        centerPanel.add(inputText);

        JLabel outputLabel = new JLabel("Output Type:");
        centerPanel.add(outputLabel);

        JComboBox<String> outputTypeComboBox = new JComboBox<>(new String[]{"AES", "DES", "Hash", "Blowfish"});
        centerPanel.add(outputTypeComboBox);

        JLabel outputTextLabel = new JLabel("Output:");
        centerPanel.add(outputTextLabel);

        JTextField outputText = new JTextField();
        centerPanel.add(outputText);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Calculate Button
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputType = (String) inputTypeComboBox.getSelectedItem();
                String outputType = (String) outputTypeComboBox.getSelectedItem();
                String input = inputText.getText();
                String output = null;

                switch (inputType) {
                    case "AES":
                        switch (outputType) {
                            case "AES":
                                output = TextTransform.encryptAES(input, "yourAESKey");
                                break;
                            case "DES":
                                output = TextTransform.encryptDES(TextTransform.decryptAES(input, "yourAESKey"), "yourDESKey");
                                break;
                            case "Hash":
                                output = TextTransform.hash(input, "SHA-256"); // You can choose any hash algorithm
                                break;
                            case "Blowfish":
                                output = TextTransform.encryptBlowfish(input, "yourBlowfishKey");
                                break;
                        }
                        break;
                    case "DES":
                        switch (outputType) {
                            case "AES":
                                output = TextTransform.encryptAES(TextTransform.decryptDES(input, "yourDESKey"), "yourAESKey");
                                break;
                            case "DES":
                                output = TextTransform.encryptDES(input, "yourDESKey");
                                break;
                            case "Hash":
                                output = TextTransform.hash(input, "SHA-256"); // You can choose any hash algorithm
                                break;
                            case "Blowfish":
                                output = TextTransform.encryptBlowfish(TextTransform.decryptDES(input, "yourDESKey"), "yourBlowfishKey");
                                break;
                        }
                        break;
                    case "Hash":
                        // Hash input directly to the selected output type
                        output = TextTransform.hash(input, outputType);
                        break;
                    case "Blowfish":
                        switch (outputType) {
                            case "AES":
                                output = TextTransform.encryptAES(TextTransform.decryptBlowfish(input, "yourBlowfishKey"), "yourAESKey");
                                break;
                            case "DES":
                                output = TextTransform.encryptDES(TextTransform.decryptBlowfish(input, "yourBlowfishKey"), "yourDESKey");
                                break;
                            case "Hash":
                                output = TextTransform.hash(TextTransform.decryptBlowfish(input, "yourBlowfishKey"), "SHA-256"); // Hash decrypted Blowfish output
                                break;
                            case "Blowfish":
                                output = TextTransform.encryptBlowfish(input, "yourBlowfishKey");
                                break;
                        }
                        break;
                }

                outputText.setText(output);
            }
        });

        mainPanel.add(calculateButton, BorderLayout.EAST);

        // Page change button
        pageChangeButton = new JButton("Change Page");
        pageChangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current frame
                new RadixCalculator(); // Open RadixCalculator
            }
        });
        mainPanel.add(pageChangeButton, BorderLayout.NORTH);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextCalculator();
            }
        });
    }
}

