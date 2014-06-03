package org.nusco.swimmers.creature.body;

import java.util.LinkedList;
import java.util.List;

import org.nusco.swimmers.creature.pns.Nerve;
import org.nusco.swimmers.physics.Vector;

public abstract class Organ {

	protected final int length;
	protected final int thickness;
	protected final double relativeAngle;
	protected final int rgb;

	private Nerve nerve;

	protected final Organ parent;
	private List<Organ> children = new LinkedList<>();
	private Vector outputSignal = Vector.ZERO_ONE;
	
	protected Organ(int length, int thickness, int relativeAngle, int rgb, Nerve nerve, Organ parent) {
		this.length = length;
		this.thickness = thickness;
		this.relativeAngle = relativeAngle;
		this.rgb = rgb;
		setNerve(nerve);
		this.parent = parent;
	}
	
	public int getLength() {
		return length;
	}

	public int getThickness() {
		return thickness;
	}

	public double getRelativeAngle() {
		return relativeAngle;
	}

	public int getRGB() {
		return rgb;
	}

	public abstract Vector getStartPoint();

	public Vector getEndPoint() {
		return getStartPoint().plus(Vector.polar(getAngle(), length));
	}

	public abstract double getAngle();

	public Nerve getNerve() {
		return nerve;
	}

	public Organ getParent() {
		return parent;
	}

	public List<Organ> getChildren() {
		return children;
	}

	public Organ sproutOrgan(int length, int thickness, int relativeAngle, int rgb) {
		return addChild(new Segment(length, thickness, relativeAngle, rgb, this));
	}

	Organ sproutOrgan(Nerve nerve) {
		return addChild(new Segment(nerve));
	}

	public Organ sproutNullOrgan() {
		return addChild(new NullOrgan(this));
	}

	Organ addChild(Organ child) {
		children.add(child);
		return child;
	}

	final void setNerve(Nerve nerve) {
		this.nerve = nerve;
	}

	public Vector tick(Vector inputSignal) {
		outputSignal = getNerve().send(inputSignal);
		for(Organ child : getChildren())
			child.tick(outputSignal);
		return outputSignal;
	}

	protected Vector getOutputSignal() {
		return outputSignal;
	}
}