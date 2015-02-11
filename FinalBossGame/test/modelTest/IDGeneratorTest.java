package modelTest;

import static org.junit.Assert.*;
import model.IDGenerator;

import org.junit.Test;

public class IDGeneratorTest {

	@Test
	public void testGenerateID() {
		
		IDGenerator idGen = new IDGenerator();
		
		// UID Range: [100000, 999999]
		for (int i = 100000; i != 999999; ++i){
			if (idGen.generateID("Trial") == -1){
				fail("Duplicate ID generated before all possible IDs were generated");
			}
		}
		
		//If loop is exited correctly, the test passes as expected
		assertEquals(1, 1);
		
		//Delete all those written IDs 
		for (int i = 100000; i != 999999; ++i){
			idGen.returnID(i);
		}
	}

}
