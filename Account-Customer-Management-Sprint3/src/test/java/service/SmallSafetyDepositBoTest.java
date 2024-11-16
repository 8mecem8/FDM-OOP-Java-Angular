package service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmallSafetyDepositBoTest {

	

	    private SmallSafetyDepositBox box;

	    @BeforeEach
	    public void setUp() {
	        box = new SmallSafetyDepositBox();
	    }

	    @Test
	    void testGetCapacity() {
	        double capacity = 10.0;
	        box.setCapacity(capacity);
	        assertEquals(capacity, box.getCapacity());
	    }

	    @Test
	    void testSetCapacity() {
	        double capacity = 20.0;
	        box.setCapacity(capacity);
	        assertEquals(capacity, box.getCapacity());
	    }

	   

	    @Test
	    void testIsAllotted() {
	        box.setAllotted(true);
	        assertTrue(box.isAllotted());

	        box.setAllotted(false);
	        assertFalse(box.isAllotted());
	    }

	    @Test
	    void testGetId() {
	        double id = box.getId();
	        assertTrue(id >= 0); // Since ID is initialized with Math.random()*10, it should be >= 0
	    }

	    @Test
	    void testSetId() {
	        double id = 12345.0;
	        box.setId(id);
	        assertEquals(id, box.getId());
	    }

	   
	

}
