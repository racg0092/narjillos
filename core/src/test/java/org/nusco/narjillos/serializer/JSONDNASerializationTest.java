package org.nusco.narjillos.serializer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.nusco.narjillos.creature.genetics.DNA;
import org.nusco.narjillos.serializer.JSON;

public class JSONDNASerializationTest {

	@Test
	public void serializesAndDeserializesDNA() {
		DNA dna = new DNA("{001_002_003_004_005_006_007}{008_009_010_011_012_013_014}");
		String json = JSON.toJson(dna, DNA.class);
		DNA deserialized = JSON.fromJson(json, DNA.class);

		assertArrayEquals(dna.getGenes(), deserialized.getGenes());
	}

	@Test
	public void nicelyFormatsDNA() {
		String dnaDocument = "{001_002_003_004_005_006_007}{008_009_010_011_012_013_014}";
		DNA dna = new DNA(dnaDocument);
		String json = JSON.toJson(dna, DNA.class);
		
		assertEquals("\"" + dnaDocument + "\"", json);
	}
}
