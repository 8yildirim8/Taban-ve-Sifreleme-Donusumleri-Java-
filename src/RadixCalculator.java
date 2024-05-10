import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadixCalculator extends JFrame {
    private JButton pageChangeButton;
    private JButton calculateButton;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    public RadixCalculator() {
        setTitle("Radix Calculator");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());


        // Input and Output components
        JPanel centerPanel = new JPanel(new GridLayout(2, 2));

        JLabel inputLabel = new JLabel("Input Type:");
        centerPanel.add(inputLabel);

        JComboBox<String> inputTypeComboBox = new JComboBox<>(new String[]{"Binary", "Decimal", "Hexadecimal", "Octal", "ASCII"});
        centerPanel.add(inputTypeComboBox);

        JLabel inputTextLabel = new JLabel("Input:");
        centerPanel.add(inputTextLabel);

        JTextField inputText = new JTextField();
        centerPanel.add(inputText);

        JLabel outputLabel = new JLabel("Output Type:");
        centerPanel.add(outputLabel);

        JComboBox<String> outputTypeComboBox = new JComboBox<>(new String[]{"Binary", "Decimal", "Hexadecimal", "Octal", "ASCII"});
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

                String x = inputText.getText();

                RadixTransform transform = new RadixTransform();

                // Decimal to -> ...
                if(inputTypeComboBox.getSelectedItem().equals("Decimal")) {
                    if(outputTypeComboBox.getSelectedItem().equals("Binary")) {
                        String y = transform.DecBin(x);
                        outputText.setText(y);
                    } else if(outputTypeComboBox.getSelectedItem().equals("Octal")) {
                        String y = transform.DecOct(x);
                        outputText.setText(y);
                    } else if(outputTypeComboBox.getSelectedItem().equals("Hexadecimal")) {
                        String y = transform.DecHex(x.toUpperCase());
                        outputText.setText(y);
                    } else if(outputTypeComboBox.getSelectedItem().equals("ASCII")) {
                        char y = transform.DecAscii(x);
                        outputText.setText(String.valueOf(y));
                    } else {
                        outputText.setText("Please select a different valid type");
                    }
                }

                // Binary to -> ...
                else if(inputTypeComboBox.getSelectedItem().equals("Binary")) {
                    if(outputTypeComboBox.getSelectedItem().equals("Decimal")) {
                        int y = transform.BinDec(x);
                        outputText.setText(String.valueOf(y));
                    } else if(outputTypeComboBox.getSelectedItem().equals("Octal")) {
                        String y = transform.BinOct(x);
                        outputText.setText(y);
                    } else if(outputTypeComboBox.getSelectedItem().equals("Hexadecimal")) {
                        String y = transform.BinHex(x);
                        outputText.setText(y.toUpperCase());
                    } else if(outputTypeComboBox.getSelectedItem().equals("ASCII")) {
                        char y = transform.BinAscii(x);
                        outputText.setText(String.valueOf(y));
                    } else {
                        outputText.setText("Please select a different valid type");
                    }
                }

                // Octal to -> ...
                else if(inputTypeComboBox.getSelectedItem().equals("Octal")) {
                    if(outputTypeComboBox.getSelectedItem().equals("Decimal")) {
                        int y = transform.OctDec(x);
                        outputText.setText(String.valueOf(y));
                    } else if(outputTypeComboBox.getSelectedItem().equals("Binary")) {
                        String y = transform.OctBin(x);
                        outputText.setText(y);
                    } else if(outputTypeComboBox.getSelectedItem().equals("Hexadecimal")) {
                        String y = transform.OctHex(x);
                        outputText.setText(y.toUpperCase());
                    } else if(outputTypeComboBox.getSelectedItem().equals("ASCII")) {
                        char y = transform.OctAscii(x);
                        outputText.setText(String.valueOf(y));
                    } else {
                        outputText.setText("Please select a different valid type");
                    }
                }

                // Hexadecimal to -> ...
                else if(inputTypeComboBox.getSelectedItem().equals("Hexadecimal")) {
                    if(outputTypeComboBox.getSelectedItem().equals("Decimal")) {
                        int y = transform.HexDec(x);
                        outputText.setText(String.valueOf(y));
                    } else if(outputTypeComboBox.getSelectedItem().equals("Binary")) {
                        String y = transform.HexBin(x);
                        outputText.setText(y);
                    } else if(outputTypeComboBox.getSelectedItem().equals("Octal")) {
                        String y = transform.HexOct(x);
                        outputText.setText(y);
                    } else if(outputTypeComboBox.getSelectedItem().equals("ASCII")) {
                        char y = transform.HexAscii(x);
                        outputText.setText(String.valueOf(y));
                    } else {
                        outputText.setText("Please select a different valid type");
                    }
                }

                // ASCII to -> ...
                else if (inputTypeComboBox.getSelectedItem().equals("ASCII")) {
                    if(outputTypeComboBox.getSelectedItem().equals("Decimal")) {
                        int y = transform.AsciiDec(x);
                        outputText.setText(String.valueOf(y));
                    } else if(outputTypeComboBox.getSelectedItem().equals("Binary")) {
                        String y = transform.AsciiBin(x);
                        outputText.setText(y);
                    } else if(outputTypeComboBox.getSelectedItem().equals("Octal")) {
                        String y = transform.AsciiOct(x);
                        outputText.setText(y);
                    } else if(outputTypeComboBox.getSelectedItem().equals("Hexadecimal")) {
                        String y = transform.AsciiHex(x);
                        outputText.setText(y);
                    } else {
                        outputText.setText("Please select a different valid type");
                    }
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
                new TextCalculator(); // Open TextCalculator
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
                new RadixCalculator();
            }
        });
    }
}
