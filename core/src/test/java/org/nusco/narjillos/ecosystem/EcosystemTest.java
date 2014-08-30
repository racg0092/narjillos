package org.nusco.narjillos.ecosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.nusco.narjillos.creature.Narjillo;
import org.nusco.narjillos.creature.genetics.DNA;
import org.nusco.narjillos.ecosystem.Ecosystem;
import org.nusco.narjillos.ecosystem.EcosystemEventListener;
import org.nusco.narjillos.shared.physics.Vector;
import org.nusco.narjillos.shared.things.FoodPiece;
import org.nusco.narjillos.shared.things.Thing;
import org.nusco.narjillos.shared.utilities.RanGen;

public class EcosystemTest {
	
	Ecosystem ecosystem;
	FoodPiece foodPiece1;
	FoodPiece foodPiece2;
	FoodPiece foodPiece3;
	Narjillo narjillo1;
	Narjillo narjillo2;

	@Before
	public void initialize() {
		try {
			RanGen.reset();
		} catch (RuntimeException e) {
		}
		RanGen.initializeWith(42);

		ecosystem = new Ecosystem(1000) {};
		foodPiece1 = ecosystem.spawnFood(Vector.cartesian(100, 100));
		foodPiece2 = ecosystem.spawnFood(Vector.cartesian(1000, 1000));
		foodPiece3 = ecosystem.spawnFood(Vector.cartesian(10000, 10000));
		narjillo1 = ecosystem.spawnNarjillo(Vector.cartesian(150, 150), DNA.random());
		narjillo2 = ecosystem.spawnNarjillo(Vector.cartesian(1050, 1050), DNA.random());
	}

	@Before
	public void tickEcosystemOnce() {
		ecosystem.tick();
	}
	
	@Test
	public void countsFoodPieces() {
		assertEquals(3, ecosystem.getNumberOfFoodPieces());
	}

	@Test
	public void countsNarjillos() {
		assertEquals(2, ecosystem.getNumberOfNarjillos());
	}

	@Test
	public void returnsAllTheThings() {
		Set<Thing> things = ecosystem.getThings();
		
		assertTrue(things.contains(narjillo1));
		assertTrue(things.contains(foodPiece1));
	}
	
	@Test
	public void sendsEventsWhenAddingThings() {
		final boolean[] eventFired = {false};
		ecosystem.addEventListener(new EcosystemEventListener() {

			@Override
			public void thingAdded(Thing thing) {
				eventFired[0] = true;
			}

			@Override
			public void thingRemoved(Thing thing) {
			}
		});
		
		ecosystem.spawnFood(Vector.ZERO);
		assertTrue(eventFired[0]);
	}
}
