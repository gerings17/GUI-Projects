package org.jointheleague.gerings17.smileyface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
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
	private BufferedImage background;

	private static final int INCH = 72;
	private static final Dimension US_LETTER = new Dimension(
			(int) (8.5 * INCH), 11 * INCH);

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
		background = buildBackground();
		frame.setVisible(true);
		new Timer(20, e -> repaint()).start();

	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawImage(background, 0, 0, null);

		// for(int i = INCH/2; i<US_LETTER.getWidth();i+=0.5*INCH){
		// g2.drawLine(i, 0,i,getHeight());
		// }
		// for(int i = INCH/2; i<US_LETTER.getHeight();i+=0.5*INCH){
		// g2.drawLine(0, i, getWidth(), i);
		// }
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		int min = now.getMinute();
		int sec = now.getSecond();
		int nano = now.getNano();
		g2.translate(getWidth() / 2, getHeight() / 2);
		AffineTransform center = g2.getTransform();
		drawHour(g2, hour, min);
		g2.setTransform(center);
		drawMin(g2, min, sec);
		g2.setTransform(center);
		drawSec(g2, sec, nano);
	}

	private BufferedImage buildBackground() {
		BufferedImage img = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = img.createGraphics();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.translate(getWidth() / 2, getHeight() / 2);
		g2.setColor(Color.BLACK);
		AffineTransform center = g2.getTransform();
		for (int i = 0; i < 60; i++) {
			double angle = (PI / 30) * i;
			g2.rotate(angle);
			if (i % 5 == 0) {
				g2.setStroke(penWidth);
			} else {
				g2.setStroke(new BasicStroke(1));
			}
			g2.drawLine(3 * INCH, 0, (int) (3.5 * INCH), 0);
			g2.setTransform(center);
		}

		return img;
	}

	private void drawHour(Graphics2D g2, int hour, int min) {
		double hourAngle = (((hour * 60) + min) / (12.0 * 60)) * (2 * PI);

		g2.rotate(hourAngle);
		g2.setStroke(penWidth);
		g2.drawLine(0, 0, 0,(-1 * INCH));
		g2.translate(-INCH / 2, -2 * INCH);
		smiley.drawSelf(g2);
	}

	private void drawMin(Graphics2D g2, int min, int sec) {
		double minAngle = (PI / 30) * (min + (sec / 60.0));

		g2.rotate(minAngle);
		g2.setStroke(penWidth);
		g2.drawLine(0, 0, 0, (int) (-1.5 * INCH));
		g2.scale(0.75, 0.75);
		g2.translate(-INCH / 2, -2.5 * INCH);
		smiley.drawSelf(g2);
	}

	private void drawSec(Graphics2D g2, int sec, int nano) {
		double secAngle = (PI / 30) * (sec + (nano * 1e-9));
		g2.rotate(secAngle);
		g2.setStroke(penWidth);
		g2.drawLine(0, 0, 0, (int)(-2.75 * INCH));
		g2.scale(0.5, 0.5);
		g2.translate(-INCH/2, -6*INCH);
		if(sec%2 ==0){
			g2.translate(INCH/2, INCH/2);
			g2.scale(-1, 1);
			g2.translate(-INCH/2, -INCH/2);
		}
		
		smiley.drawSelf(g2);

	}

}
