package service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class FeeCalculatorServiceImplTest 
{
	

	    @InjectMocks
	    private FeeCalculatorServiceImpl service;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void testCalculateFeeFor100() {
	        assertEquals(20.00, service.calculateFee(100));
	    }

	    @Test
	    void testCalculateFeeFor200() {
	        assertEquals(15.00, service.calculateFee(200));
	    }

	    @Test
	    void testCalculateFeeFor600() {
	        assertEquals(10.00, service.calculateFee(600));
	    }

	    @Test
	    void testCalculateFeeFor1500() {
	        assertEquals(5.00, service.calculateFee(1500));
	    }

	    @Test
	    void testCalculateFeeFor2500() {
	        assertEquals(0.00, service.calculateFee(2500));
	    }
	    
	    
	
}
