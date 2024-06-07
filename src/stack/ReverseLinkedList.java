package stack;

import javax.swing.*;
import java.util.Stack;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
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

    public void reverseUsingStack() {
        Stack<String> stack = new Stack<>();
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

    public void printListToTextArea(JTextArea textArea) {
        Node current = head;
        while (current != null) {
            textArea.append(current.data + " ");
            current = current.next;
        }
        textArea.append("\n");
    }

    public String getListAsString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}
