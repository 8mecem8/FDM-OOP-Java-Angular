package service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class AllMethodsTests {

	 	@InjectMocks
	    private SafetyDepositBoxService service;

	    @Mock
	    private SafetyDepositBox mockBox;

	    @BeforeEach
	    public void setup() {
	        service = SafetyDepositBoxService.getInstance();
	        mockBox = service.allocateSafetyDepositBox();      
	        
	        
	    }

	    @Test
	    void testAllocateSafetyDepositBox_NewBoxCreated() {
	        
	        assertNotNull(mockBox);
	        assertTrue(mockBox.isAllotted());
	    }

//	    @Test
//	    void testGetNumberOfAvailableSafetyBoxes() 
//	    {
//	    	service.releaseSafetyDepositBox(mockBox);
//	    	assertEquals(1, service.getNumberOfAvailableSafetyBoxes());
//	    }
	    
	    @Test
	    void testReleaseSafetyDepositBox() {
	        SafetyDepositBox box = service.allocateSafetyDepositBox();
	        service.releaseSafetyDepositBox(box);
	        assertEquals(1, service.getNumberOfAvailableSafetyBoxes());
	    }


	    @Test
	    void testGetReleasedSafetyDepositBox() {
	        service.releaseSafetyDepositBox(mockBox);
	        Optional<SafetyDepositBox> box = service.getReleasedSafetyDepositBox();
	        assertTrue(box.isPresent());
	    }
}
