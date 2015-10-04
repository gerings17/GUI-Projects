package org.jointheleague.gerings17.fractals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FractalWindow extends JPanel implements Runnable {
	private static final int MARGIN = 10;
	private static final Random RNG = new Random();
	private AffineTransform[] sierpinskiTransforms = new AffineTransform[] {
			new AffineTransform(0.5, 0, 0, 0.5, .25, 0),
			new AffineTransform(0.5, 0, 0, 0.5, 0, 0.5),
			new AffineTransform(0.5, 0, 0, 0.5, 0.5, 0.5) };

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new FractalWindow());

	}

	@Override
	public void run() {
		JFrame frame = new JFrame();
		this.setPreferredSize(new Dimension(1000, 1000));
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.translate(MARGIN, MARGIN);
		g2.scale(getWidth() - (2 * MARGIN), getHeight() - (2 * MARGIN));
		drawFractal(g2, 10);
		// g2.transform(new AffineTransform(0.5,0.6, -0.1, 0.8, 0.2, 0.1));
		// g2.setColor(randomColor());
		// g2.fillRect(0, 0, 1, 1);

	}

	private void drawFractal(Graphics2D g2, int level) {
		if (level == 0) {
			g2.fillRect(0, 0, 1, 1);
		} else {
			AffineTransform standard = g2.getTransform();
			for (int i = 0; i < sierpinskiTransforms.length; i++) {
				g2.transform(sierpinskiTransforms[i]);
				g2.setColor(randomColor());
				drawFractal(g2, level - 1);
				g2.setTransform(standard);
			}
		}
	}

	private Color randomColor() {
		return new Color(RNG.nextInt(256), RNG.nextInt(256), RNG.nextInt(256));
	}

}
