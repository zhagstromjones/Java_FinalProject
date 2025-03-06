
public class StrengthExercise extends Exercise {

	private static final long serialVersionUID = 1L;
	private int sets;
	private int reps;
	private int load;
	
	//Default constructor
	public StrengthExercise() {
		
	}
	
	public StrengthExercise(String name, int sets, int reps, int load) {
		this.setName(name);
		this.sets = sets;
		this.reps = reps;
		this.load = load;
	}
	
	public void setSets(int sets) {
		this.sets = sets;
	}
	
	public int getSets() {
		return this.sets;
	}
	
	public void setReps(int reps) {
		this.reps = reps;
	}
	
	public int getReps() {
		return this.reps;
	}
	
	public void setLoad(int load) {
		this.load = load;
	}
	
	public int getLoad() {
		return this.load;
	}
	
	@Override
	public double getVolume() {
		return sets * reps * load;
	}
	
	@Override
	public String toString() {
		return this.getName() + " - " + "Sets: " + this.getSets() + 
				" Reps: " + this.getReps() + " Load: " + this.getLoad();
	}
	
}
