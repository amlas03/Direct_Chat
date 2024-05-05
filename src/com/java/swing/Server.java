package com.java.swing;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Server implements ActionListener{
	
	private JTextField msg;
	private JPanel mid;
	private JScrollPane scrollPane ;
	static Box vertical = Box.createVerticalBox();
	static DataOutputStream dout;
	static JFrame f=new JFrame();
	
	public Server() {
		f.setLayout(null);
		f.setSize(450,600);
		f.setVisible(true);
		f.getContentPane().setBackground(Color.WHITE);
		f.setLocation(300,50);
			
		JPanel p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(102, 0, 153));
		p1.setBounds(0,0,450,70);
		f.add(p1);
		
		Icon i1=new Icon("home.png",35,35);
		i1.addMouseEffect(i1.getLa(), "exit");
		i1.getLa().setBounds(5,20,25,25);
		p1.add(i1.getLa());
		
		Icon i2=new Icon("video.png",60,60);
		i2.addMouseEffect(i2.getLa(), "video");
		i2.getLa().setBounds(320,20,30,30);
		p1.add(i2.getLa());
		
		Icon i3=new Icon("call.png",70,70);
		i3.addMouseEffect(i3.getLa(), "call");
		i3.getLa().setBounds(370,20,30,30);
		p1.add(i3.getLa());
		
		Icon i4=new Icon("dots.png",40,30);
		i4.getLa().setBounds(410,20,30,30);
		p1.add(i4.getLa());
		
		Icon i5=new Icon("profile.png",50,50);
		i5.getLa().setBounds(45,9,60,50);
		p1.add(i5.getLa());
		
		JLabel user=new JLabel("User1");
		user.setFont(new Font("SAN_SERIF",Font.BOLD, 18));
		user.setForeground(Color.WHITE);
		user.setBounds(114,17,120,25);
		p1.add(user);
		
		JLabel statut=new JLabel("Active now");
		statut.setFont(new Font("SAN_SERIF",Font.BOLD, 14));
		statut.setForeground(Color.WHITE);
		statut.setBounds(114,35,90,25);
		p1.add(statut);
		
		mid=new JPanel(new BorderLayout());
		mid.setBounds(4,75,427,450); //mid.setBackground(new Color(254, 253, 240));
		
		scrollPane = new JScrollPane(mid);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(4,75,427,450);
        scrollPane.setVisible(true);
		f.add(scrollPane);
		
		msg=new JTextField();
		msg.setBounds(4, 528, 320, 30);
		msg.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		f.add(msg);
		
		JButton send=new JButton("Send");
		send.addActionListener(this);
		send.setForeground(Color.WHITE);
		send.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		send.setBounds(327, 528, 107, 31);
		send.setBackground(new Color(102, 0, 153));
		f.add(send);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
            String out = msg.getText();

            JPanel p2 = formatLabel(out);

            mid.setLayout(new BorderLayout());

            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));
            
            mid.add(vertical, BorderLayout.PAGE_START);
            
            dout.writeUTF(out); //envoyer le flux de sortie(msg) au client
            
            msg.setText("");
            
            /*scrollPane = new JScrollPane(mid);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            */
          //  getContentPane().remove(vertical); 
            f.add(scrollPane, BorderLayout.CENTER);
            
            f.repaint();
            f.invalidate();
            f.validate();
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	}
		
		public static JPanel formatLabel(String out) {
			JPanel msgPanel=new JPanel();
			msgPanel.setLayout(new BoxLayout(msgPanel,BoxLayout.Y_AXIS));
			
			JLabel output=new JLabel(out);
			
			output.setBorder(new EmptyBorder(15,15,15,50));
			output.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        output.setBackground(new Color(136, 77, 167));
	        output.setOpaque(true);
	        Dimension size = new Dimension(200, 50);
	        output.setMaximumSize(size);
	        output.setMinimumSize(size);
	        output.setPreferredSize(size);
	        msgPanel.add(output);
	        
	        Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	        
	        JLabel time = new JLabel();
	        time.setText(sdf.format(cal.getTime()));
	        
	        msgPanel.add(time);
	        
	        msgPanel.setBackground(new Color(136, 77, 167));
	        
	        return msgPanel;
			
		}
		
		public static JPanel formatLabel2(String out) {
			JPanel msgPanel=new JPanel();
			msgPanel.setLayout(new BoxLayout(msgPanel,BoxLayout.Y_AXIS));
			
			JLabel output=new JLabel(out);
			
			output.setBorder(new EmptyBorder(15,150,15,15));
			output.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        output.setBackground(new Color(136, 77, 167));
	        output.setOpaque(true);
	        Dimension size = new Dimension(200, 50);
	        output.setMaximumSize(size);
	        output.setMinimumSize(size);
	        output.setPreferredSize(size);
	        msgPanel.add(output);
	        
	        Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	        
	        JLabel time = new JLabel();
	        time.setText(sdf.format(cal.getTime()));
	        
	        msgPanel.add(time);
	        
	        msgPanel.setBackground(new Color(136, 77, 167));
	        
	        return msgPanel;
			
		}

	
	public static void main(String args[]) {
		new Server();
		try {
		ServerSocket ss=new ServerSocket(6500);
		while(true) {
			Socket s=ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            while(true) {
            	String msg = din.readUTF();
                JPanel panel = formatLabel2(msg);
                
                JPanel left = new JPanel(new BorderLayout());
                left.add(panel, BorderLayout.LINE_START);
                vertical.add(left);
                f.validate();
            }
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
}