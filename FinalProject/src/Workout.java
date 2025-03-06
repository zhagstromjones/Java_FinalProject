import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Workout implements Serializable {
	private static final long serialVersionUID = 1L;
	private String focus;			//Focus of the workout (chest, leg, arms, cardio, etc.)
	private int workoutLength;		//Length of the workout in minutes
	private String dateCreated;		//Date workout was created
	private int totalVolume;		//Total volume of the workout
	private ArrayList<Exercise> exercises = new ArrayList<Exercise>();  //ArrayList of exercise that comprise workout
	
	//Empty constructor
	public Workout() {
		this.dateCreated = getDateString();
		
	}
	
	//Default constructor
	public Workout(String focus, int workoutLength) {
		this.focus = focus;
		this.workoutLength = workoutLength;
		this.dateCreated = getDateString();
		this.exercises = new ArrayList<Exercise>();
		this.totalVolume = getTotalVolume();
	}
	
	public void setFocus(String focus) {
		this.focus = focus;
	}
	
	public String getFocus() {
		return this.focus;
	}
	
	public void setWorkoutLength(int workoutLength) {
		this.workoutLength = workoutLength;
	}
	
	public int getWorkoutLength() {
		return this.workoutLength;
	}
	
	public String getDateCreated(){
		return this.dateCreated;
	}
	
	public void addExercise(Exercise exercise) {
		exercises.add(exercise);
	}
	
	public void removeExercise(Exercise exercise) {
		exercises.remove(exercise);
	}
	
	public ArrayList<Exercise> getExercises() {
		return exercises;
	}
	
	public int getTotalVolume() {
		int totalVol = 0;
		for (int i = 0; i < exercises.size(); i++) {
			totalVol += exercises.get(i).getVolume();
		}
		return totalVol;
	}
	/**
	 * Returns a string representation that is used in the tableview
	 * @return
	 */
	public String getDateString() {
		Calendar cal = new GregorianCalendar();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; //For some reason, Calendar.MONTH returns one less than it should.
		int day = cal.get(Calendar.DATE);
		return month + "/" + day + "/" + year;
	}
}
