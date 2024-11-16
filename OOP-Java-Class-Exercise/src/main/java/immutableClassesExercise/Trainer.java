package immutableClassesExercise;

import java.util.ArrayList;
import java.util.List;

public class Trainer 
{
    private String name;
    private ArrayList<String> streamsTaught;

    public Trainer(String name) 
    {
        this.name = name;
        this.streamsTaught = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStream(String stream) {
        streamsTaught.add(stream);
    }

    public List<String> getAllStreams() {
        return streamsTaught;
    }

	@Override
	public String toString() {
		return "Trainer [name=" + name + ", streamsTaught=" + streamsTaught + "]";
	}
    
    
}
