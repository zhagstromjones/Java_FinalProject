
public class TestClass {

	public static void main(String[] args) {
		
		//Create a test HealthProfile
		HealthProfile profile = new HealthProfile("Jomby", "McDaniels", 29, 6, 1, 168.0);
		
		//Create new exercises and a new Workout
		Exercise benchPress = new StrengthExercise("Bench Press", 3, 10, 165);
		Exercise cableFly = new StrengthExercise("Cable Fly", 3, 12, 40);
		Exercise jogging = new CardioExercise("Jogging", 30, 200);
		
		Workout chestDay = new Workout("Chest Day", 60);
		
		//Add exercises to chestDay Workout
		chestDay.addExercise(benchPress);
		chestDay.addExercise(cableFly);
		chestDay.addExercise(jogging);
		
		System.out.println("----------Workout log-----------");
		//Output toString methods for exercises
		for (int i = 0; i < chestDay.getExercises().size(); i++) {
			System.out.println(chestDay.getExercises().get(i).toString());
		}
		//Output total volume of chestDay
		System.out.println("Total volume: " + chestDay.getTotalVolume());
		
		//Create new Consumables and a new Meal
		Food bacon = new Food("Bacon", 2.0, 12.0, 0.6, 12.0);
		Food egg = new Food("Egg", 1.8, 6, 0, 5);
		Food engMuffin = new Food("English Muffin", 2.0, 4, 25, 1);
		Drink oj = new Drink("Orange Juice", 4.0, 2, 25.5, 0, 13);
		
		Meal breakfast = new Meal();
		
		//Add Consumables to breakfast Meal
		breakfast.addMealItem(bacon);
		breakfast.addMealItem(egg);
		breakfast.addMealItem(engMuffin);
		breakfast.addMealItem(oj);
		
		System.out.println("----------Diet journal----------");
		for (int i = 0; i <breakfast.getMealItems().size(); i++) 
			System.out.println(breakfast.getMealItems().get(i).toString());
		System.out.println("Total meal nutrition: " + "Cals: " + breakfast.getMealCal() + 
				" Protein: " + breakfast.getMealPro() + " Carbs: " + breakfast.getMealCarbs() + 
				" Fats: " + breakfast.getMealFat());
		System.out.println("-----------------------------------");
		
		//Add Workout and Meal to HealthProfile
		profile.addMeal(breakfast);
		profile.addWorkout(chestDay);
		
		//Display complete profile
		System.out.println("Health profile for " + profile.getFirstName() + " " + profile.getLastName());
		System.out.println("Age: " + profile.getAge() + "    Height: " + profile.getHeightFt() + "'"
				+ profile.getHeightIn() + "\"   Weight: " + profile.getWeight());
		System.out.printf("BMI: %.2f", profile.getBMI());
		System.out.println("\nMeals entered: " + profile.getMeals().size());
		System.out.println("Workouts entered: " + profile.getWorkouts().size());
		
	}

}
