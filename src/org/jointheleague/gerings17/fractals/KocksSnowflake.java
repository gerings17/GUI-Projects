package org.jointheleague.gerings17.fractals;

import java.awt.geom.AffineTransform;
import static java.lang.Math.*;

public class KocksSnowflake implements FractalSpec{
	
	@Override
	public AffineTransform[] getTransformations() {
		double a = 1.0 / 6.0; // == cos(PI / 3.0) / 3.0
		double b = sqrt(3.0) / 6.0; // == sin(PI / 3.0) / 3.0
		double s = 1.0 / 3.0;
		return new AffineTransform[] {
				new AffineTransform(s, 0.0, 0.0, s, 0.0, 0.0),
				new AffineTransform(a, b, -b, a, s, 0.0),
				new AffineTransform(a, -b, b, a, 0.5, b),
				new AffineTransform(s, 0.0, 0.0, s, 2 * s, 0.0)
		};
	}

	@Override
	public int getLevel() {
		return 5;
	}


}


