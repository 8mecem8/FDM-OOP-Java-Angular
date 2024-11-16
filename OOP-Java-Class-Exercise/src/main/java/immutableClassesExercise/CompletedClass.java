package immutableClassesExercise;

import java.util.ArrayList;
import java.util.List;

public final class CompletedClass {
    private final String subject;
    private final Trainer trainer;
    private final ArrayList<Trainee> trainees;

    public CompletedClass(String subject, Trainer trainer, List<Trainee> traineeList) 
    {
        this.subject = subject;
        this.trainer = trainer;
        this.trainees = new ArrayList<>();
        for (Trainee arg : traineeList) {
            this.trainees.add(new Trainee(arg.getName(),arg.getStream(), arg.getWeek()));
        }
    }

    public String getSubject() {
        return subject;
    }

    public Trainer getTrainer() {return trainer;}

    public List<Trainee> getTrainees() {return trainees;}
}
