
public class Food extends Consumable {
	private static final long serialVersionUID = 1L;
	private double servings;		//Number of servings
	private double foodCals;			//Number of calories
	private double foodPro;			//Grams of protein
	private double foodCarb;		//Grams of carbs
	private double foodFat;			//Grams of fat
	
	//Empty constructor
	Food(){
		
	}
	
	//Default constructor
	Food(String foodName, double servings, double foodProt, double foodCarb, double foodFat){
		this.setName(foodName);
		this.servings = servings;
		this.foodPro = foodProt;
		this.foodCarb = foodCarb;
		this.foodFat = foodFat;
		this.foodCals = getCals();
	}
	
	public void setCals(double cals) {
		this.foodCals = cals;
	}
	
	//Calculate calories from nutritional properties
	@Override
	public double getCals() {
		return servings * ((this.foodCarb * 4) + (this.foodFat * 9) + (this.foodPro * 4));
	}
	
	public void setFoodPro(double foodProt) {
		this.foodPro = foodProt;
	}
	
	@Override
	public double getDrinkPro() {
		return this.foodPro;
	}
	
	public void setFoodCarbs(double foodCarb) {
		this.foodCarb = foodCarb;
	}
	
	@Override
	public double getDrinkCarbs() {
		return this.foodCarb;
	}
	
	public void setFoodFat(double foodFat) {
		this.foodFat = foodFat;
	}
	
	@Override
	public double getDrinkFat() {
		return this.foodFat;
	}
	
	public void setServings(double servings) {
		this.servings = servings;
	}
	
	@Override
	public double getServings() {
		return servings;
	}
	
	@Override
	public String toString() {
		return this.getName() + " - " + " Calories: " + this.getCals() + " Protein: " + this.getDrinkPro() + 
				" Carbs: " + this.getDrinkCarbs() + " Fat: " + this.getDrinkFat();
	}
	
}
