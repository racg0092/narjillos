package org.nusco.narjillos.creature.body;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AtrophicOrganTest {

	protected AtrophicOrgan createConnectiveTissue() {
		return new AtrophicOrgan(null);
	}

	@Test
	public void hasNoVisibleShape() {
		assertEquals(0, createConnectiveTissue().getLength(), 0.0);
		assertEquals(0, createConnectiveTissue().getThickness(), 0.0);
	}

	@Test
	public void hasNoMass() {
		assertEquals(0, createConnectiveTissue().getMass(), 0.0);
	}
}