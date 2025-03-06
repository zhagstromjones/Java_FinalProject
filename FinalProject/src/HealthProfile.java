import java.io.Serializable;
import java.util.ArrayList;

public class HealthProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private int age;
	private int height;	//In inches
	private double weight; //In pounds
	private ArrayList<Meal> meals = new ArrayList<Meal>();
	private ArrayList<Workout> workouts = new ArrayList<Workout>();
	
	public HealthProfile() {
		
	}
	
	public HealthProfile(String firstName, String lastName, int age, 
			int ft, int in, double weight) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAge(age);
		this.setHeight(ft, in);
		this.setWeight(weight);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeightFt() {
		return height / 12;
	}
	
	public int getHeightIn() {
		return height % 12;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int ft, int in) {
		this.height = (ft * 12) + in;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getBMI() {
		double h = height * 0.0254; //1 inch = 0.0254 meters
		double w = weight * 0.4535924; //1 pound = 0.4535924 kg
		return w / (h * h);
	}
	
	public void addMeal(Meal meal) {
		this.meals.add(meal);
	}
	
	public void removeMeal(Meal meal) {
		this.meals.remove(meal);
	}
	
	public ArrayList<Meal> getMeals(){
		return meals;
	}
	
	public void addWorkout(Workout workout) {
		this.workouts.add(workout);
	}
	
	public void removeWorkout(Workout workout) {
		this.workouts.remove(workout);
	}
	
	public ArrayList<Workout> getWorkouts(){
		return workouts;
	}
}
