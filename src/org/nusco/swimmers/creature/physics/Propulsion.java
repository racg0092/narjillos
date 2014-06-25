package org.nusco.swimmers.creature.physics;

import java.util.LinkedList;
import java.util.List;

import org.nusco.swimmers.creature.body.MovementListener;
import org.nusco.swimmers.physics.Vector;

public class Propulsion implements MovementListener {

	private static final double PROPULSION_SCALE = 0.01;
	
	private final List<Vector> forces = new LinkedList<>();
	private final Vector direction;

	public Propulsion(Vector direction) {
		this.direction = direction;
	}

	@Override
	public void moveEvent(Vector beforeVector, Vector beforeStartPoint, Vector afterVector, Vector afterStartPoint) {
		double velocityAngle = afterVector.getAngleWith(beforeVector);
		double force = velocityAngle * beforeVector.getLength() * PROPULSION_SCALE;
		
		Vector normal = beforeVector.getNormal();
		
		addForce(Vector.polar(normal.getAngle(), force));
	}

	void addForce(Vector force) {
		forces.add(force);
	}

	private Vector getTotalForce() {
		Vector sum = Vector.ZERO;
		for (Vector force : forces)
			sum = sum.plus(force);
		return sum;
	}

	public Vector getTangentialForce() {
		return getTotalForce().getProjectionOn(direction);
	}

	public Vector getNormalForce() {
		return getTotalForce().getNormalComponentOn(direction);
	}
}