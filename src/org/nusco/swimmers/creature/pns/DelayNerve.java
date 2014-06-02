package org.nusco.swimmers.creature.pns;

import java.util.LinkedList;

import org.nusco.swimmers.physics.Vector;

public class DelayNerve extends Nerve {

	private final int delay;
	private final LinkedList<Vector> buffer = new LinkedList<>();

	public DelayNerve(int delay) {
		this.delay = delay;
	}

	public Vector process(Vector inputSignal) {
		buffer.add(inputSignal);
		if(buffer.size() < delay)
			return Vector.ZERO_ONE;
		return buffer.pop();
	}
}