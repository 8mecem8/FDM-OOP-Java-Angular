package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SafetyDepositBoxService extends SmallSafetyDepositBox
{
	private static final Logger logger = LogManager.getLogger(SafetyDepositBoxService.class);
	
	private static SafetyDepositBoxService instance;
    private final List<SafetyDepositBox> safetyDepositBoxes = new ArrayList<>();
    private static int numberOfSafetyDepositBox = 2;
    private boolean waitFlagStatus = false;

    

    public static synchronized SafetyDepositBoxService getInstance() {if (instance == null) {instance = new SafetyDepositBoxService();}return instance;}

    public synchronized SafetyDepositBox allocateSafetyDepositBox() 
    {
    		var availableDepositBox = getReleasedSafetyDepositBox();
    		
        if(availableDepositBox.isPresent()) 
        {
        		SafetyDepositBox box = availableDepositBox.get();
        		box.setAllotted(true);
        	    return box;
        }
        
        if(!availableDepositBox.isPresent()) 
        {
	        		if (safetyDepositBoxes.size() < numberOfSafetyDepositBox) 
	        		{
	                SafetyDepositBox box = new SmallSafetyDepositBox();
	                box.setId(box.getId()+1); box.setAllotted(true);
	                safetyDepositBoxes.add(box);
	                		logger.info("new box created"+ " id =" +" "+box.getId());
	                return box;
	                
	                
	            }
	        		
	        		while(safetyDepositBoxes.size() >= numberOfSafetyDepositBox)
	                {
	                		try {	
	                				
	                				setwaitFlagStatus(true);
								wait();
									logger.info("box become empty now");
								SafetyDepositBox box = getReleasedSafetyDepositBox().get();
				        			box.setAllotted(true);
				        			return box;
							} catch (InterruptedException e) {e.printStackTrace();}
	                }
        }
	        		// This line should never be reached because the loop will either return or throw
	        	    throw new IllegalStateException("Unable to allocate a SafetyDepositBox");
        
    }

     

	public synchronized void releaseSafetyDepositBox(SafetyDepositBox box) 
    {
    		SafetyDepositBox boxToBeReleased = null;
    		
    		for(SafetyDepositBox arg : safetyDepositBoxes){if(arg.getId() == box.getId()){boxToBeReleased = arg;}}
    		
    		if(boxToBeReleased != null)  
    		{
    			boxToBeReleased.setAllotted(false);logger.info("a box released" + " " + Thread.currentThread().getName());
        		notifyAll();
    		}
        
        
    }

	
	public synchronized int getNumberOfAvailableSafetyBoxes() {
		//logger.info("all boxes number:"+" "+ safetyDepositBoxes.size() +safetyDepositBoxes.get(0).isAllotted() + safetyDepositBoxes.get(1).isAllotted());
        return safetyDepositBoxes.stream().filter(box -> !box.isAllotted()).collect(Collectors.toList()).size();
    }

    
    public synchronized Optional<SafetyDepositBox> getReleasedSafetyDepositBox() 
    {
        //return safetyDepositBoxes.stream().filter(box -> !box.isAllotted()).collect(Collectors.toList());
    		//System.out.println("=====>>>  "  + safetyDepositBoxes.stream().filter(box -> !box.isAllotted()).findFirst().isPresent());
    		return safetyDepositBoxes.stream().filter(box -> !box.isAllotted()).findFirst();
    }
    
    
    public boolean getwaitFlagStatus() 
    {
    		return waitFlagStatus;
    }
    
    public void setwaitFlagStatus(boolean status) 
    {
    	 	waitFlagStatus = status ;
    }
    
    @Override
	public String toString() {return "SafetyDepositBoxService [safetyDepositBoxes=" + safetyDepositBoxes + ", allocateSafetyDepositBox()="+ allocateSafetyDepositBox() + ", getNumberOfAvailableSafetyBoxes()=" 	+ getNumberOfAvailableSafetyBoxes() + ", getReleasedSafetyDepositBox()=" + getReleasedSafetyDepositBox()+ "]";}
}
