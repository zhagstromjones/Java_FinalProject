import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Meal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String mealTOD;						//Meal time-of-day
	private String dateCreated;					//Date meals was created
	private ArrayList<Consumable> mealItems;	//Items that comprise the meal
	private double mealCal;						//Total number of calories in meal
	private double mealPro;						//Total grams of protein in meal
	private double mealCarbs;					//Total grams of carbs in meal
	private double mealFat;						//Total grams of fat in meal
	
	//Empty constructor
	public Meal() {
		this.mealItems = new ArrayList<Consumable>();
	}
	
	//Default constructor
	public Meal(String mealTOD, ArrayList<Consumable> mealItems) {
		this.mealTOD = mealTOD;
		this.dateCreated = getDateString();
		this.mealItems = new ArrayList<Consumable>(mealItems);
		this.mealCal = getMealCal();
	}
	
	public String getDateCreated(){
		return dateCreated;
	}
	
	public void setDateCreated() {
		this.dateCreated = getDateString();
	}
	
	public String getMealTOD() {
		return mealTOD;
	}
	
	public void setMealTOD(String mealTOD) {
		this.mealTOD = mealTOD;
	}
	
	public ArrayList<Consumable> getMealItems() {
		return this.mealItems;
	}
	
	public void addMealItem(Consumable mealItem) {
		this.mealItems.add(mealItem);
	}
	
	public void removeMealItem(Consumable mealItem) {
		this.mealItems.remove(mealItem);
	}
	
	public void setMealCal(double mealCal) {
		this.mealCal = mealCal;
	}
	
	public double getMealCal() {
		double mealCal = 0;
		for (int i = 0; i < mealItems.size(); i++) {
			mealCal += mealItems.get(i).getCals();
		}
		return mealCal;
	}
	
	public void setMealPro(double mealPro) {
		this.mealPro = mealPro;
	}
	
	public double getMealPro() {
		double mealPro = 0;
		for (int i = 0; i < mealItems.size(); i++) {
			mealPro += mealItems.get(i).getDrinkPro();
		}
		return mealPro;
	}
	
	public void setMealCarbs(double mealCarbs) {
		this.mealCarbs = mealCarbs;
	}
	
	public double getMealCarbs() {
		double mealCarbs = 0;
		for (int i = 0; i < mealItems.size(); i++) {
			mealCarbs += mealItems.get(i).getDrinkCarbs();
		}
		return mealCarbs;
	}
	
	public void setMealFat(double mealFat) {
		this.mealFat = mealFat;
	}
	
	public double getMealFat() {
		double mealFat = 0;
		for (int i = 0; i < mealItems.size(); i++) {
			mealFat += mealItems.get(i).getDrinkFat();
		}
		return mealFat;
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
