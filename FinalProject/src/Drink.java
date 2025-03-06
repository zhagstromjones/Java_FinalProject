
public class Drink extends Consumable {
	private static final long serialVersionUID = 1L;
	private double servings;		//Number of servings consumed
	private double drinkCals;		//Calories in drink
	private double drinkPro;		//Grams of protein in drink
	private double drinkCarb;		//Grams of carbs in drink
	private double drinkFat;		//Grams of fat in drink
	private double drinkSugar;		//Grams of sugar in drink
	
	public Drink() {
		
	}
	
	public Drink(String drinkName, double servings, double drinkProt, double drinkCarb, 
			double drinkFat, double drinkSugar) {
		this.setName(drinkName);
		this.servings = servings;
		this.drinkPro = drinkProt;
		this.drinkCarb = drinkCarb;
		this.drinkFat = drinkFat;
		this.drinkSugar = drinkSugar;
	}

	@Override
	public double getCals() {
		return (this.drinkCarb * 4) + (this.drinkFat * 9) + (this.drinkPro * 4);
	}
	
	public void setCals(double drinkCals) {
		this.drinkCals = drinkCals;
	}

	@Override
	public double getDrinkPro() {
		return this.drinkPro;
	}
	
	public void setDrinkPro(double drinkPro) {
		this.drinkPro = drinkPro;
	}

	@Override
	public double getDrinkCarbs() {
		return this.drinkCarb;
	}
	
	public void setCarbs(double drinkCarb) {
		this.drinkCarb = drinkCarb;
	}

	@Override
	public double getDrinkFat() {
		return this.drinkFat;
	}
	
	public void setFat(double drinkFat) {
		this.drinkFat = drinkFat;
	}
	
	public double getSugar() {
		return this.drinkSugar;
	}
	
	public void setSugar(double drinkSugar) {
		this.drinkSugar = drinkSugar;
	}
	
	@Override
	public double getServings() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setServings(double servings) {
		this.servings = servings;
	}
	
	@Override
	public String toString() {
		return this.getName() + " - " + " Calories: " + this.getCals() + " Protein: " + this.getDrinkPro() + 
				" Carbs: " + this.getDrinkCarbs() + " Fat: " + this.getDrinkFat();
	}


}
