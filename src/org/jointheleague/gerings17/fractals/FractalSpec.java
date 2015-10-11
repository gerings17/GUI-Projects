package org.jointheleague.gerings17.fractals;

import java.awt.geom.AffineTransform;

public interface FractalSpec {
	AffineTransform [] getTransformations();
	int getLevel();

}
