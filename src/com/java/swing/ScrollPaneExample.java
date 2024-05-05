package com.java.swing;
import javax.swing.*;
import java.awt.*;

public class ScrollPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JScrollPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Création d'un panneau contenant plusieurs boutons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 1)); // GridLayout avec 10 lignes

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton("Button " + i);
            panel.add(button);
        }

        // Création d'un JScrollPane et ajout du panneau à l'intérieur
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
