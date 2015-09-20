package org.jointheleague.gerings17.smileyface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import static java.lang.Math.PI;

public class SmileyFaceWindow extends JPanel implements Runnable {
	
	private static final Color PURPLE = new Color(178, 102, 255);
	private static Stroke penWidth = new BasicStroke(3);
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
		new Timer(20, e -> repaint());
		
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
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		int min = now.getMinute();
		int sec = now.getSecond();
		int nano = now.getNano();
		g2.translate(getWidth()/2, getHeight()/2);
		AffineTransform center = g2.getTransform();
		drawHour(g2, hour, min);
		g2.setTransform(center);
		drawMin(g2, min, sec);
		g2.setTransform(center);
		drawSec(g2, sec);
		
		
	}
	
	private void drawHour(Graphics2D g2, int hour, int min){
		double hourAngle = (((hour *60) +min)/(12.0*60))*(2*PI);
		
		g2.rotate(hourAngle);
		g2.setStroke(penWidth);
		g2.drawLine(0,0,0, (int) (-1.5*INCH));
		g2.translate(-INCH/2, -2.5*INCH);
		smiley.drawSelf(g2);
	}
	private void drawMin(Graphics2D g2, int min, int sec){
		double minAngle = (min + (sec/60))/(60)*(2*PI);
		
		g2.rotate(minAngle);
		g2.setStroke(penWidth);
		g2.drawLine(0,0,0, (int) (-2.5*INCH));
		g2.translate(-INCH/2, -3.5*INCH);
		smiley.drawSelf(g2);
	}
	
	
	private void drawSec(Graphics2D g2, int sec){
		double secAngle = sec/60*(2*PI);
		g2.rotate(secAngle);
		g2.setStroke(penWidth);
		g2.drawLine(0, 0, 0, (int) (-3.25*INCH));
		g2.translate(-INCH/2, -4.25*INCH);
		smiley.drawSelf(g2);
		
	}

}
