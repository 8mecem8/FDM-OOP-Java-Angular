package service;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SafetyDepositBoxServiceTest 
{
		//private static final Logger logger = LogManager.getLogger(SafetyDepositBoxServiceTest.class);//SafetyDepositBoxService service;
	 
		//@BeforeEach
		//void SetUp(){service = SafetyDepositBoxService.getInstance();service.setwaitFlagStatus(false);}
							
	    @Test
	    void testNoThreadKeptWaiting() throws InterruptedException 
	    {
	    		SafetyDepositBoxService service = SafetyDepositBoxService.getInstance();
	         Runnable requestBox = () -> 
	         {   try {SafetyDepositBox box = service.allocateSafetyDepositBox(); Thread.sleep(5000); service.releaseSafetyDepositBox(box);} 
	             catch (InterruptedException e) {Thread.currentThread().interrupt();}    };

	         Thread thread1 = new Thread(requestBox, "Thread1");Thread thread2 = new Thread(requestBox, "Thread2");

	         thread1.start();thread2.start();
	         thread1.join(); thread2.join();
	          	         	        
	         assertEquals(false, service.getwaitFlagStatus());
	     }

	    @Test
	    void testThreadKeptWaiting() throws InterruptedException 
	    {
	    		SafetyDepositBoxService service = SafetyDepositBoxService.getInstance();
	        Runnable requestBox = () -> 
	        {
	            try {
	            		SafetyDepositBox box = service.allocateSafetyDepositBox();
	                
	            		//logger.info(Thread.currentThread().getName()+"has the box ? = " + box.isAllotted());
	            		Thread.sleep(5000);
	                service.releaseSafetyDepositBox(box);
	             
	            } catch (InterruptedException e) {Thread.currentThread().interrupt();}};
	        Thread thread1 = new Thread(requestBox, "Thread1"); Thread thread2 = new Thread(requestBox, "Thread2");Thread thread3 = new Thread(requestBox, "Thread3");

	        thread1.start();thread2.start();thread3.start();
	        thread1.join();thread2.join();thread3.join();
	
	        assertEquals(true, service.getwaitFlagStatus());
	    }
}
