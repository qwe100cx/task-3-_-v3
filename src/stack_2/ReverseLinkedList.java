package stack_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
    }
}

class Stack {
    Node top;

    public void push(String data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public String pop() {
        if (top == null) {
            return null;
        }
        String data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public void push(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void reverseUsingCustomStack() {
        Stack stack = new Stack();
        Node current = head;

        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        current = head;
        while (!stack.isEmpty()) {
            current.data = stack.pop();
            current = current.next;
        }
    }

    public void printList(JTextArea textArea) {
        Node current = head;
        while (current != null) {
            textArea.append(current.data + " ");
            current = current.next;
        }
        textArea.append("\n");
    }
}

public class ReverseLinkedList {
    private final JTextField sizeField;
    private final JTextArea listArea;
    private final JTextArea resultArea;
    private LinkedList list;

    public ReverseLinkedList() {
        JFrame frame = new JFrame("Reverse Linked List");
        JPanel panel = new JPanel();
        JLabel sizeLabel = new JLabel("введите размер массива");
        sizeField = new JTextField(5);
        JButton createButton = new JButton("создайте массив");
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

                list.reverseUsingCustomStack();




                list.printList(resultArea);
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
                new ReverseLinkedList();
            }});
    }
}