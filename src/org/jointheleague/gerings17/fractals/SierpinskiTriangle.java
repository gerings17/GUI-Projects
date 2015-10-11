package org.jointheleague.gerings17.fractals;

import java.awt.geom.AffineTransform;

public class SierpinskiTriangle implements FractalSpec {
	private static AffineTransform[] TRANSFORMS = new AffineTransform[] {
			new AffineTransform(0.5, 0, 0, 0.5, .25, 0),
			new AffineTransform(0.5, 0, 0, 0.5, 0, 0.5),
			new AffineTransform(0.5, 0, 0, 0.5, 0.5, 0.5) };
	@Override
	public AffineTransform[] getTransformations() {
		return TRANSFORMS;
	}

	@Override
	public int getLevel() {
		return 10;
	}

}
