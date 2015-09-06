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

public class SmileyFace extends JPanel implements Runnable {
	
	private static final Color PURPLE = new Color(178, 102, 255);
	private static Stroke penWidth = new BasicStroke(5);
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SmileyFace());
	}
	@Override
	public void run() {
		JFrame frame = new JFrame("Smiley Face");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
	}
	protected void paintComponent (Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.fillRect(0,0,getWidth(), getHeight());
		g2.setColor(PURPLE);
		g2.fillOval(42, 30, 400, 400);
		g2.setColor(Color.WHITE);
		g2.fillOval(125, 125, 75, 125);
		g2.fillOval(275, 125, 75, 125);
		g2.setColor(Color.BLACK);
		g2.fillOval(152, 187, 40, 60);
		g2.fillOval(285, 187, 40, 60);
		Stroke stroke = new BasicStroke(10);
		g2.setStroke(penWidth);
		g2.drawArc(150, 150, 200, 200, 225, 90);
		g2.drawLine(215, 290, 250, 230);
		g2.drawLine(215, 290, 250, 290);
	}
	

}
