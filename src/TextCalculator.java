import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

        JComboBox<String> inputTypeComboBox = new JComboBox<>(new String[]{"Text"});
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
                String outputType = (String) outputTypeComboBox.getSelectedItem();
                String input = inputText.getText();
                String output = null;

                try {
                    switch (outputType) {
                        case "AES":
                            output = TextTransform.encryptAES(input);
                            break;
                        case "DES":
                            output = TextTransform.encryptDES(input);
                            break;
                        case "Hash":
                            output = TextTransform.sha256Hash(input);
                            break;
                        case "Blowfish":
                            output = TextTransform.encryptBlowfish(input);
                            break;
                    }

                    outputText.setText(output);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
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

