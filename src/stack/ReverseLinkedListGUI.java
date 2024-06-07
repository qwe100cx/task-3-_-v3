package stack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReverseLinkedListGUI {
    private final JTextField sizeField;
    private final JTextArea listArea;
    private final JTextArea resultArea;
    private LinkedList list;

    public ReverseLinkedListGUI() {
        JFrame frame = new JFrame("Reverse Linked List");
        JPanel panel = new JPanel();
        JLabel sizeLabel = new JLabel("введите размер массива:");
        sizeField = new JTextField(5);
        JButton createButton = new JButton("создать массив");
        listArea = new JTextArea(10, 20);
        JButton reverseButton = new JButton("перевернуть массив");
        resultArea = new JTextArea(10, 20);
        list = new LinkedList();

        panel.add(sizeLabel);
        panel.add(sizeField);
        panel.add(createButton);
        panel.add(listArea);
        panel.add(reverseButton);
        panel.add(resultArea);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size = Integer.parseInt(sizeField.getText());
                list = new LinkedList();

            }
        });

        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = listArea.getText();
                String[] elements = input.split("\\s+");

                for (String element : elements) {
                    list.push(element);
                }

                list.reverseUsingStack();



                list.printListToTextArea(resultArea);
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReverseLinkedListGUI();
            }
        });
    }
}
