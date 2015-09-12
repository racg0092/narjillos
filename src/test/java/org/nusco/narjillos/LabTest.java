package org.nusco.narjillos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.nusco.narjillos.genomics.DNA;

public class LabTest {

//	@Test
//	public void getsMostSuccessfulDNA() {
//		genePool.createDna("111_111_111_222_111_000_000_000_000_000_000_000_000_000", numGen);
//		genePool.createDna("111_111_111_111_111_000_000_000_000_000_000_000_000_000", numGen);
//		genePool.createDna("111_111_111_222_222_000_000_000_000_000_000_000_000_000", numGen);
//		genePool.createDna("111_111_222_111_222_000_000_000_000_000_000_000_000_000", numGen);
//		genePool.createDna("111_222_222_222_222_000_000_000_000_000_000_000_000_000", numGen);
//
//		DNA mostSuccessful = genePool.getMostSuccessfulDna();
//		
//		assertEquals("{111_111_111_222_111_000_000_000_000_000_000_000_000_000}", mostSuccessful.toString());
//	}
//	
//	@Test
//	public void getsNullAsTheMostSuccesfulInAnEmptyPool() {
//		assertNull(genePool.getMostSuccessfulDna());
//	}

//	@Test
//	public void hasHistory() {
//		DNA parent1 = genePool.createDna("{0}", numGen);
//		genePool.mutateDna(parent1, numGen);
//
//		DNA parent2 = genePool.createDna("{0}", numGen);
//		DNA child2_1 = genePool.mutateDna(parent2, numGen);
//		genePool.mutateDna(parent2, numGen);
//
//		DNA child2_2_1 = genePool.mutateDna(child2_1, numGen);
//
//		List<DNA> ancestry = genePool.getAncestryOf(child2_2_1.getId());
//		
//		assertEquals(3, ancestry.size());
//		assertEquals(parent2, ancestry.get(0));
//		assertEquals(child2_1, ancestry.get(1));
//		assertEquals(child2_2_1, ancestry.get(2));
//	}
//		
//	@Test
//	public void getAncestryOfDna() {
//		DNA gen1 = genePool.createDna("{0}", numGen);
//		DNA gen2 = genePool.mutateDna(gen1, numGen);
//		DNA gen3 = genePool.mutateDna(gen2, numGen);
//		
//		List<DNA> ancestry = genePool.getAncestryOf(gen3.getId());
//		
//		assertEquals(3, ancestry.size());
//		assertEquals(gen1, ancestry.get(0));
//		assertEquals(gen2, ancestry.get(1));
//		assertEquals(gen3, ancestry.get(2));
//	}
//	
//	@Test
//	public void knowsDNAAncestry() {
//		DNA gen1 = genePool.createDna("{0}", numGen);
//		DNA gen2 = genePool.mutateDna(gen1, numGen);
//		DNA gen3 = genePool.mutateDna(gen2, numGen);
//		
//		List<DNA> ancestry = genePool.getAncestryOf(gen3.getId());
//		
//		assertEquals(3, ancestry.size());
//		assertEquals(gen1, ancestry.get(0));
//		assertEquals(gen2, ancestry.get(1));
//		assertEquals(gen3, ancestry.get(2));
//	}

}
