package com.java.swing;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Icon {
	
	private ImageIcon ia1;
	private ImageIcon ia2;
	private Image i;
	private JLabel la;
	
	public Icon(String imgPath, int L, int l){
		ia1=new ImageIcon(ClassLoader.getSystemResource(imgPath));
		i=ia1.getImage().getScaledInstance(L, l, Image.SCALE_DEFAULT);
		ia2=new ImageIcon(i);
		la=new JLabel(ia2);
	}
	
	public JLabel getLa() {
		return la;
	}
	
	public void addMouseEffect(JLabel l, String effect) {
		if(effect.equals("exit")) {
			l.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					System.exit(0);
				}
				public void mouseEntered(MouseEvent me) {
					l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			});
		}
		else if(effect.equals("video")) {
			l.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					JOptionPane.showMessageDialog(null, "Video call \n Ringing.....");
				}
				public void mouseEntered(MouseEvent me) {
					l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			});
		}
		else if(effect.equals("call")) {
			l.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					JOptionPane.showMessageDialog(null, "Audio call \n Ringing.....");
				}
				public void mouseEntered(MouseEvent me) {
					l.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			});
		}
	}
}
