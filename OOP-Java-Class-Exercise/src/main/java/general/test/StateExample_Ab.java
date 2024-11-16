package general.test;

public class StateExample_Ab 
{
	public Context controlState;

	public StateExample_Ab(Context controlState) {
		super();
		this.controlState = controlState;
	}

	public String getControlState() {
		return controlState.getState();
	}

	public void setControlState(String text) {
		controlState.setState(text);;
	}

}
