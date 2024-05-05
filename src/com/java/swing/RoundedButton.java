package com.java.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);  // Ajout de cette ligne pour supprimer la bordure
        setPreferredSize(new Dimension(100,40));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        RoundRectangle2D.Float background = new RoundRectangle2D.Float(0, 0, width, height, height, height);
        g2.setColor(getBackground());
        g2.fill(background);

        super.paintComponent(g);
        g2.dispose();
    }
}
