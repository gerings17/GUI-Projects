package org.jointheleague.gerings17.smileyface;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
public class SmileyFaceGraphics{
	
	private static final int INCH = 72; //in points
	private static final Color PURPLE = new Color(178, 102, 255);
	private static final int UNIT = INCH/8;
	private static Stroke penWidth = new BasicStroke(5);

	public void drawSelf(Graphics2D g2){
		g2.setColor(PURPLE);
		g2.fillOval(0, 0, INCH, INCH);
		g2.setColor(Color.BLUE);
		g2.fillOval(UNIT*5, UNIT, UNIT, 3*UNIT);
		g2.setColor(Color.GREEN);
		g2.fillOval(UNIT*2, UNIT, UNIT, 3*UNIT);
		g2.setColor(Color.BLACK);
		Stroke stroke = new BasicStroke(10);
		g2.setStroke(penWidth);
		g2.drawArc(2*UNIT, 3*UNIT, 4*UNIT, 4*UNIT, 225, 90);
		
		
	}

}
