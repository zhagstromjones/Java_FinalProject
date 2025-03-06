
public class CardioExercise extends Exercise{
	private static final long serialVersionUID = 1L;
	private int length;
	private int calBurned;
	
	public CardioExercise() {
		
	}
	
	public CardioExercise(String name, int length, int calBurned) {
		this.setName(name);
		this.length = length;
		this.calBurned = calBurned;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void setCalBurned(int calBurned) {
		this.calBurned = calBurned;
	}
	
	public int getCalBurned() {
		return this.calBurned;
	}
	
	@Override
	public double getVolume() {
		return calBurned * 100 / length;
	}
	
	@Override
	public String toString() {
		return this.getName() + " - " + "Length: " + this.getLength() + " Calories burned: " + this.getCalBurned();
	}
}
