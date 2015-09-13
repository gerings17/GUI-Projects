package org.jointheleague.gerings17.smileyface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SmileyFaceWindow extends JPanel implements Runnable {
	
	private static final Color PURPLE = new Color(178, 102, 255);
	private static Stroke penWidth = new BasicStroke(5);
	private SmileyFaceGraphics smiley = new SmileyFaceGraphics();
	
	private static final int INCH = 72;
	private static final Dimension  US_LETTER = new Dimension((int) (8.5*INCH), 11*INCH);
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SmileyFaceWindow());
	}
	
	@Override
	public void run() {
		JFrame frame = new JFrame("Smiley Face");
		this.setPreferredSize(US_LETTER);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		
	}
	protected void paintComponent (Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		this.setBackground(Color.WHITE);
		
		for(int i = INCH/2; i<US_LETTER.getWidth();i+=0.5*INCH){
			g2.drawLine(i, 0,i,getHeight());
		}
		for(int i = INCH/2; i<US_LETTER.getHeight();i+=0.5*INCH){
			g2.drawLine(0, i, getWidth(), i);
		}
		g2.translate(INCH, 0);
		g2.rotate(Math.PI/2);
		smiley.drawSelf(g2);
		
	}
	

}
