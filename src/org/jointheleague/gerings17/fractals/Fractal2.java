package org.jointheleague.gerings17.fractals;

import java.awt.geom.AffineTransform;

public class Fractal2 implements FractalSpec {
	private static AffineTransform[] TRANSFORMS = new AffineTransform[] {
			new AffineTransform(-.25, .25, .25, .25, .25, 0),
			new AffineTransform(-.25, .25, .25, .25, .75, 0),
			new AffineTransform(-.25, .25, .25, .25, .25, .5), 
			new AffineTransform(-.25, .25, .25, .25, .75, .5 )};
	@Override
	public AffineTransform[] getTransformations() {
		return TRANSFORMS;
	}

	@Override
	public int getLevel() {
		return 4;
	}

}
