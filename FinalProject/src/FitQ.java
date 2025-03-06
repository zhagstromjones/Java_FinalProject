import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class FitQ extends Application implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private HealthProfile profile = new HealthProfile();
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Initialize a test profile. Will be overwritten when user creates an account
		initializeProfile();
		
		VBox mainPane = new VBox();
		HBox logoPane = new HBox();
		
		Image logo = new Image("logo.png");
		ImageView logoView = new ImageView(logo);
		
		Button btProfile = new Button("Create/Edit Profile");
		Button btWorkout = new Button("Workout Journal");
		Button btDiet = new Button("Diet Journal");
		
		HBox buttonBox1 = new HBox();
		HBox buttonBox2 = new HBox();
		
		logoPane.getChildren().add(logoView);
		logoPane.setAlignment(Pos.CENTER);
		
		btProfile.setPrefHeight(50);
		btProfile.setPrefWidth(200);
		buttonBox1.getChildren().addAll(btProfile);
		buttonBox1.setAlignment(Pos.CENTER);
		buttonBox1.setPadding(new Insets(10, 10, 10, 10));
		btWorkout.setPrefHeight(50);
		btWorkout.setPrefWidth(125);
		btDiet.setPrefHeight(50);
		btDiet.setPrefWidth(125);
		buttonBox2.getChildren().addAll(btWorkout, btDiet);
		buttonBox2.setAlignment(Pos.CENTER);
		buttonBox2.setPadding(new Insets(0, 10, 10, 10));
		
		mainPane.getChildren().addAll(logoPane, buttonBox1, buttonBox2);
		
		Scene scene = new Scene(mainPane);
		primaryStage.setTitle("FitQ");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		Popup notice = new Popup();
		Label lbNotice = new Label("Please create a profile");
		notice.getContent().add(lbNotice);
		
		//Handlers
		btProfile.setOnAction(e -> windowViewProfile(profile, new Stage()));
		btWorkout.setOnAction(e -> windowWorkoutJournal(profile, new Stage()));
		btDiet.setOnAction(e -> windowDietJournal(profile, new Stage()));
		
	}
	
	protected void windowCreateNewProfile(Stage stage) {
		VBox mainPane = new VBox();
		HBox titlePane = new HBox();
		HBox box1 = new HBox();
		HBox box2 = new HBox();
		HBox box3 = new HBox();
		HBox box4 = new HBox();
		HBox box5 = new HBox();
		HBox buttonBox = new HBox();
		
		Label lbCreateNewProf = new Label("Create New Profile");
		Label lbFirstName = new Label("First Name ");
		Label lbLastName = new Label("Last Name ");
		Label lbAge = new Label("Age ");
		Label lbHeight = new Label("Height ");
		Label lbFt = new Label("ft  ");
		Label lbIn = new Label("in");
		Label lbWeight = new Label("Weight ");
		TextField tfFirstName = new TextField();
		TextField tfLastName = new TextField();
		TextField tfAge = new TextField();
		TextField tfFt = new TextField();
		TextField tfIn = new TextField();
		TextField tfWeight = new TextField();
		
		Button btCreate = new Button("Create");
		Button btCancel = new Button("Cancel");
		
		tfAge.setPrefWidth(30);
		tfFt.setPrefWidth(30);
		tfIn.setPrefWidth(30);
		tfWeight.setPrefWidth(60);
		
		final double MAX_FONT_SIZE = 30.0;
		lbCreateNewProf.setFont(new Font(MAX_FONT_SIZE));
		
		titlePane.setAlignment(Pos.CENTER);
		box1.setPrefWidth(300);
		box1.setPadding(new Insets(10, 10, 5, 10));
		box2.setPadding(new Insets(0, 10, 5, 10));
		box3.setPadding(new Insets(0, 10, 5, 10));
		box4.setPadding(new Insets(0, 10, 5, 10));
		box5.setPadding(new Insets(0, 10, 5, 10));
		buttonBox.setPadding(new Insets(0, 0, 5, 0));
		buttonBox.setAlignment(Pos.CENTER);

		btCreate.setPrefHeight(40);
		btCreate.setPrefWidth(125);
		btCancel.setPrefHeight(40);
		btCancel.setPrefWidth(125);
		
		titlePane.getChildren().add(lbCreateNewProf);
		box1.getChildren().addAll(lbFirstName, tfFirstName);
		box2.getChildren().addAll(lbLastName, tfLastName);
		box3.getChildren().addAll(lbAge, tfAge);
		box4.getChildren().addAll(lbHeight, tfFt, lbFt, tfIn, lbIn);
		box5.getChildren().addAll(lbWeight, tfWeight);
		buttonBox.getChildren().addAll(btCreate, btCancel);
		
		mainPane.getChildren().addAll(titlePane, box1, box2, box3, box4, box5, buttonBox);
		
		Scene scene = new Scene(mainPane);
		stage.setTitle("Create New Profile");
		stage.setScene(scene);
		stage.show();
		
		;
		
		//Handlers
		btCreate.setOnAction(e -> {
			try {
				profile.setFirstName(tfFirstName.getText());
				profile.setLastName(tfLastName.getText());
				profile.setAge(Integer.parseInt(tfAge.getText()));
				profile.setHeight(Integer.parseInt(tfFt.getText()), Integer.parseInt(tfIn.getText()));
				profile.setWeight(Integer.parseInt(tfWeight.getText()));
				saveUser(profile);
				stage.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		btCancel.setOnAction(e -> {
			windowViewProfile(profile, new Stage());
			stage.close();
			});
	}
	
	protected void windowViewProfile(HealthProfile profile, Stage stage) {
		VBox mainPane = new VBox();
		HBox box1 = new HBox();
		HBox box2 = new HBox();
		HBox box3 = new HBox();
		HBox box4 = new HBox();
		HBox box5 = new HBox();
		HBox box6 = new HBox();
		
		Label lbProfile = new Label("Health Profile");
		final double MAX_FONT_SIZE = 30.0;
		lbProfile.setFont(new Font(MAX_FONT_SIZE));
		
		Label lbAge = new Label("Age ");
		Label lbHeight = new Label("Height ");
		Label lbFt = new Label("ft  ");
		Label lbIn = new Label("in");
		Label lbWeight = new Label("Weight ");
		Label lbBMI = new Label("BMI ");
		
		TextField tfAge = new TextField();
		TextField tfFt = new TextField();
		TextField tfIn = new TextField();
		TextField tfWeight = new TextField();
		TextField tfBMI = new TextField();
		tfAge.setPrefWidth(30);
		tfAge.setText(Integer.toString(profile.getAge()));
		tfFt.setPrefWidth(30);
		tfFt.setText(Integer.toString(profile.getHeightFt()));
		tfIn.setPrefWidth(30);
		tfIn.setText(Integer.toString(profile.getHeightIn()));
		tfWeight.setPrefWidth(60);
		tfWeight.setText(Double.toString(profile.getWeight()));
		tfBMI.setPrefWidth(50);
		tfBMI.setText(Double.toString(profile.getBMI()));
		
		Button btCreateProfile = new Button("Create Profile");
		Button btCancel = new Button("Cancel");
		
		box1.setPrefWidth(300);
		box2.setPadding(new Insets(10, 10, 5, 75));
		box3.setPadding(new Insets(0, 10, 5, 75));
		box4.setPadding(new Insets(0, 10, 5, 75));
		box5.setPadding(new Insets(0, 10, 5, 75));
		box6.setPadding(new Insets(0, 10, 5, 0));
		
		btCreateProfile.setPrefHeight(40);
		btCreateProfile.setPrefWidth(125);
		btCancel.setPrefHeight(40);
		btCancel.setPrefWidth(125);
		
		box1.getChildren().addAll(lbProfile);
		box2.getChildren().addAll(lbAge, tfAge);
		box3.getChildren().addAll(lbHeight, tfFt, lbFt, tfIn, lbIn);
		box4.getChildren().addAll(lbWeight, tfWeight);
		box5.getChildren().addAll(lbBMI, tfBMI);
		box6.getChildren().addAll(btCreateProfile, btCancel);
		
		box1.setAlignment(Pos.CENTER);
		box2.setAlignment(Pos.CENTER_LEFT);
		box3.setAlignment(Pos.CENTER_LEFT);
		box4.setAlignment(Pos.CENTER_LEFT);
		box5.setAlignment(Pos.CENTER_LEFT);
		box6.setAlignment(Pos.CENTER);
		
		mainPane.getChildren().addAll(box1, box2, box3, box4, box5, box6);
		
		Scene scene = new Scene(mainPane);
		stage.setTitle("View/Edit Profile");
		stage.setScene(scene);
		stage.show();
		
		//Handlers
		btCreateProfile.setOnAction(e -> {
			windowCreateNewProfile(new Stage());
			stage.close();
			});
		btCancel.setOnAction(e -> stage.close());
	}
	
	protected void windowWorkoutJournal(HealthProfile profile, Stage stage) {
		VBox mainPane = new VBox();
		HBox buttonBox = new HBox();
		
		TableView<Workout> table = new TableView<Workout>();
		Button btAddWorkout = new Button("Add Workout");
		Button btRemoveWorkout = new Button("Remove Workout");
		
		ObservableList<Workout> data = FXCollections.observableArrayList();
		for (int i = 0; i < profile.getWorkouts().size(); i++) {
			data.add(profile.getWorkouts().get(i));
		}
		
		TableColumn<Workout, String> colDate = new TableColumn<Workout, String>("Date");
		TableColumn<Workout, String> colFocus = new TableColumn<Workout, String>("Focus");
		TableColumn<Workout, String> colLength = new TableColumn<Workout, String>("Length");
		TableColumn<Workout, String> colVol = new TableColumn<Workout, String>("Volume");
		TableColumn<Workout, String> colEx = new TableColumn<Workout, String>("Exercises");
		
		colDate.setCellValueFactory(new PropertyValueFactory<Workout, String>("dateCreated"));
		colFocus.setCellValueFactory(new PropertyValueFactory<Workout, String>("focus"));
		colLength.setCellValueFactory(new PropertyValueFactory<Workout, String>("workoutLength"));
		colVol.setCellValueFactory(new PropertyValueFactory<Workout, String>("totalVolume"));
		colEx.setCellValueFactory(new PropertyValueFactory<Workout, String>("exercises"));
		
		table.getColumns().addAll(colDate, colFocus, colLength, colVol, colEx);
		table.setItems(data);
		
		btAddWorkout.setPadding(new Insets(10, 10, 10, 10));
		btRemoveWorkout.setPadding(new Insets(10, 10, 10, 10));
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setPadding((new Insets(10, 10, 10, 10)));
		
		buttonBox.getChildren().addAll(btAddWorkout, btRemoveWorkout);
		mainPane.getChildren().addAll(table, buttonBox);
		
		Scene scene = new Scene(mainPane, 800, 400);
		stage.setTitle("Workouts");
		stage.setScene(scene);
		stage.show();
		
		//Handlers
		btAddWorkout.setOnAction(e -> {
			windowAddWorkout(profile, new Stage());
			stage.close();
			});
		btRemoveWorkout.setOnAction(e -> {
			Workout w = table.getSelectionModel().getSelectedItem();
			profile.removeWorkout(w);
			table.getItems().removeAll(w);
		});
	}
	
	protected void windowDietJournal(HealthProfile profile, Stage stage) {
		VBox mainPane = new VBox();
		HBox buttonBox = new HBox();
		
		TableView<Meal> table = new TableView<Meal>();
		Button btAddMeal = new Button("Add Meal");
		Button btRemoveMeal = new Button("Remove Meal");
		
		ObservableList<Meal> data = FXCollections.observableArrayList();
		for (int i = 0; i < profile.getMeals().size(); i++) {
			data.add(profile.getMeals().get(i));
		}
		
		TableColumn<Meal, String> colTOD = new TableColumn<Meal, String>("Meal TOD");
		TableColumn<Meal, String> colDate = new TableColumn<Meal, String>("Date");
		TableColumn<Meal, String> colCals = new TableColumn<Meal, String>("Cals");
		TableColumn<Meal, String> colPro = new TableColumn<Meal, String>("Pro");
		TableColumn<Meal, String> colCarb = new TableColumn<Meal, String>("Carb");
		TableColumn<Meal, String> colFat = new TableColumn<Meal, String>("Fat");
		TableColumn<Meal, String> colItems = new TableColumn<Meal, String>("Meal Items");
		
		colTOD.setCellValueFactory(new PropertyValueFactory<Meal, String>("mealTOD"));
		colDate.setCellValueFactory(new PropertyValueFactory<Meal, String>("dateCreated"));
		colCals.setCellValueFactory(new PropertyValueFactory<Meal, String>("mealCal"));
		colPro.setCellValueFactory(new PropertyValueFactory<Meal, String>("mealPro"));
		colCarb.setCellValueFactory(new PropertyValueFactory<Meal, String>("mealCarbs"));
		colFat.setCellValueFactory(new PropertyValueFactory<Meal, String>("mealFat"));
		colItems.setCellValueFactory(new PropertyValueFactory<Meal, String>("mealItems"));
		
		table.getColumns().addAll(colTOD, colDate, colCals, colPro, colCarb, colFat, colItems);
		table.setItems(data);
		
		btAddMeal.setPadding(new Insets(10, 10, 10, 10));
		btRemoveMeal.setPadding(new Insets(10, 10, 10, 10));
		buttonBox.setPadding(new Insets(10, 10, 10, 10));
		buttonBox.setAlignment(Pos.CENTER_LEFT);
		buttonBox.getChildren().addAll(btAddMeal, btRemoveMeal);
		mainPane.getChildren().addAll(table, buttonBox);
		
		Scene scene = new Scene(mainPane, 800, 400);
		stage.setTitle("Meals");
		stage.setScene(scene);
		stage.show();
		
		//Handlers
		btAddMeal.setOnAction(e -> {
			windowAddMeal(profile, new Stage());
			stage.close();
		});
		
		btRemoveMeal.setOnAction(e -> {
			Meal m = table.getSelectionModel().getSelectedItem();
			profile.removeMeal(m);
			table.getItems().removeAll(m);
		});
	}
	
	protected void windowAddMeal(HealthProfile profile, Stage stage) {
		VBox mainPane = new VBox();
		HBox titlePane = new HBox();
		HBox mealTODpane = new HBox();
		GridPane foodPane = new GridPane();
		GridPane drinkPane = new GridPane();
		HBox buttonPane = new HBox();
		
		foodPane.setPadding((new Insets(10, 10, 10, 10)));
		drinkPane.setPadding((new Insets(10, 10, 10, 10)));
		
		Label lbAddNewMeal = new Label("Add New Meal");
		final double MAX_FONT_SIZE = 30.0;
		lbAddNewMeal.setFont(new Font(MAX_FONT_SIZE));
		
		Label lbTOD = new Label("Meal Time of Day ");
		
		Label lbFoods = new Label("Foods");
		final double MAX_FONT_SIZE2 = 18.0;
		lbFoods.setFont(new Font(MAX_FONT_SIZE2));
		
		Label lbFoodName = new Label("Name");
		Label lbFoodServ = new Label("Servings");
		Label lbFoodCals = new Label("Cals");
		Label lbFoodPro = new Label("Pro");
		Label lbFoodCarb = new Label("Carb");
		Label lbFoodFat = new Label("Fat");
		
		Label lbDrinks = new Label("Drinks");
		lbDrinks.setFont(new Font(MAX_FONT_SIZE2));
		
		Label lbDrinkName = new Label("Name");
		Label lbDrinkServ = new Label("Servings");
		Label lbDrinkCals = new Label("Cals");
		Label lbDrinkPro = new Label("Pro");
		Label lbDrinkCarb = new Label("Carb");
		Label lbDrinkFat = new Label("Fat");
		
		TextField tfFoodName1 = new TextField();
		TextField tfFoodServ1 = new TextField();
		TextField tfFoodCals1 = new TextField();
		TextField tfFoodPro1 = new TextField();
		TextField tfFoodCarb1 = new TextField();
		TextField tfFoodFat1 = new TextField();
		
		TextField tfFoodName2 = new TextField();
		TextField tfFoodServ2 = new TextField();
		TextField tfFoodCals2 = new TextField();
		TextField tfFoodPro2 = new TextField();
		TextField tfFoodCarb2 = new TextField();
		TextField tfFoodFat2 = new TextField();
		
		TextField tfFoodName3 = new TextField();
		TextField tfFoodServ3 = new TextField();
		TextField tfFoodCals3 = new TextField();
		TextField tfFoodPro3 = new TextField();
		TextField tfFoodCarb3 = new TextField();
		TextField tfFoodFat3 = new TextField();
		
		TextField tfDrinkName1 = new TextField();
		TextField tfDrinkServ1 = new TextField();
		TextField tfDrinkCals1 = new TextField();
		TextField tfDrinkPro1 = new TextField();
		TextField tfDrinkCarb1 = new TextField();
		TextField tfDrinkFat1 = new TextField();
		
		TextField tfDrinkName2 = new TextField();
		TextField tfDrinkServ2 = new TextField();
		TextField tfDrinkCals2 = new TextField();
		TextField tfDrinkPro2 = new TextField();
		TextField tfDrinkCarb2 = new TextField();
		TextField tfDrinkFat2 = new TextField();
		
		Button btCreateMeal = new Button("Create Meal");
		Button btCancel = new Button("Cancel");
		
		btCreateMeal.setPadding(new Insets(10, 10, 10, 10));
		btCancel.setPadding(new Insets(10, 10, 10, 10));
		buttonPane.setPadding(new Insets(10, 10, 10, 10));
		
		titlePane.setAlignment(Pos.CENTER);
		titlePane.getChildren().add(lbAddNewMeal);
		
		tfFoodName1.setPrefColumnCount(10);
		tfFoodName2.setPrefColumnCount(10);
		tfFoodName3.setPrefColumnCount(10);
		tfDrinkName1.setPrefColumnCount(10);
		tfDrinkName2.setPrefColumnCount(10);
		
		tfFoodServ1.setPrefColumnCount(3);
		tfFoodServ2.setPrefColumnCount(3);
		tfFoodServ3.setPrefColumnCount(3);
		tfDrinkServ1.setPrefColumnCount(3);
		tfDrinkServ2.setPrefColumnCount(3);
		
		tfFoodCals1.setPrefColumnCount(3);
		tfFoodCals2.setPrefColumnCount(3);
		tfFoodCals3.setPrefColumnCount(3);
		tfDrinkCals1.setPrefColumnCount(3);
		tfDrinkCals2.setPrefColumnCount(3);
		
		tfFoodPro1.setPrefColumnCount(3);
		tfFoodPro2.setPrefColumnCount(3);
		tfFoodPro3.setPrefColumnCount(3);
		tfDrinkPro1.setPrefColumnCount(3);
		tfDrinkPro2.setPrefColumnCount(3);
		
		tfFoodCarb1.setPrefColumnCount(3);
		tfFoodCarb2.setPrefColumnCount(3);
		tfFoodCarb3.setPrefColumnCount(3);
		tfDrinkCarb1.setPrefColumnCount(3);
		tfDrinkCarb2.setPrefColumnCount(3);
		
		tfFoodFat1.setPrefColumnCount(3);
		tfFoodFat2.setPrefColumnCount(3);
		tfFoodFat3.setPrefColumnCount(3);
		tfDrinkFat1.setPrefColumnCount(3);
		tfDrinkFat2.setPrefColumnCount(3);
		
		foodPane.add(lbFoodName, 0, 0);
		foodPane.add(lbFoodServ, 1, 0);
		foodPane.add(lbFoodCals, 2, 0);
		foodPane.add(lbFoodPro, 3, 0);
		foodPane.add(lbFoodCarb, 4, 0);
		foodPane.add(lbFoodFat, 5, 0);
		foodPane.add(tfFoodName1, 0, 1);
		foodPane.add(tfFoodServ1, 1, 1);
		foodPane.add(tfFoodCals1, 2, 1);
		foodPane.add(tfFoodPro1, 3, 1);
		foodPane.add(tfFoodCarb1, 4, 1);
		foodPane.add(tfFoodFat1, 5, 1);
		foodPane.add(tfFoodName2, 0, 2);
		foodPane.add(tfFoodServ2, 1, 2);
		foodPane.add(tfFoodCals2, 2, 2);
		foodPane.add(tfFoodPro2, 3, 2);
		foodPane.add(tfFoodCarb2, 4, 2);
		foodPane.add(tfFoodFat2, 5, 2);
		foodPane.add(tfFoodName3, 0, 3);
		foodPane.add(tfFoodServ3, 1, 3);
		foodPane.add(tfFoodCals3, 2, 3);
		foodPane.add(tfFoodPro3, 3, 3);
		foodPane.add(tfFoodCarb3, 4, 3);
		foodPane.add(tfFoodFat3, 5, 3);
		
		drinkPane.add(lbDrinkName, 0, 0);
		drinkPane.add(lbDrinkServ, 1, 0);
		drinkPane.add(lbDrinkCals, 2, 0);
		drinkPane.add(lbDrinkPro, 3, 0);
		drinkPane.add(lbDrinkCarb, 4, 0);
		drinkPane.add(lbDrinkFat, 5, 0);
		
		drinkPane.add(tfDrinkName1, 0, 1);
		drinkPane.add(tfDrinkServ1, 1, 1);
		drinkPane.add(tfDrinkCals1, 2, 1);
		drinkPane.add(tfDrinkPro1, 3, 1);
		drinkPane.add(tfDrinkCarb1, 4, 1);
		drinkPane.add(tfDrinkFat1, 5, 1);
		
		drinkPane.add(tfDrinkName2, 0, 2);
		drinkPane.add(tfDrinkServ2, 1, 2);
		drinkPane.add(tfDrinkCals2, 2, 2);
		drinkPane.add(tfDrinkPro2, 3, 2);
		drinkPane.add(tfDrinkCarb2, 4, 2);
		drinkPane.add(tfDrinkFat2, 5, 2);
		
		buttonPane.getChildren().addAll(btCreateMeal, btCancel);
		
		
		//Create combo box items
		String[] cbItems = new String[4];
		cbItems[0] = "Breakfast";
		cbItems[1] = "Lunch";
		cbItems[2] = "Dinner";
		cbItems[3] = "Snack";
		ObservableList<String> olItems = FXCollections.observableArrayList(cbItems);
		
		ComboBox<String> cbMealTOD = new ComboBox<String>();
		cbMealTOD.getItems().addAll(olItems);
		cbMealTOD.setValue(cbItems[0]);
		mealTODpane.getChildren().addAll(lbTOD, cbMealTOD);
		
		
		mainPane.getChildren().addAll(titlePane, mealTODpane, lbFoods, foodPane, lbDrinks, drinkPane,
				buttonPane);
		
		Scene scene = new Scene(mainPane);
		stage.setTitle("Add Meal");
		stage.setScene(scene);
		stage.show();
		
		//Handlers
		btCreateMeal.setOnAction(e -> {
			ArrayList<Consumable> list = new ArrayList<Consumable>();
			if (tfFoodName1.getText() != "") {
				Food food1 = new Food();
				food1.setName(tfFoodName1.getText());
				food1.setServings(Double.valueOf(tfFoodServ1.getText()));
				food1.setCals(Double.valueOf(tfFoodCals1.getText()));
				food1.setFoodPro(Double.valueOf(tfFoodPro1.getText()));
				food1.setFoodCarbs(Double.valueOf(tfFoodCarb1.getText()));
				food1.setFoodFat(Double.valueOf(tfFoodFat1.getText()));
				list.add(food1);
			}
			if (tfFoodName2.getText() != "") {
				Food food2 = new Food();
				food2.setName(tfFoodName2.getText());
				food2.setServings(Double.valueOf(tfFoodServ2.getText()));
				food2.setCals(Double.valueOf(tfFoodCals2.getText()));
				food2.setFoodPro(Double.valueOf(tfFoodPro2.getText()));
				food2.setFoodCarbs(Double.valueOf(tfFoodCarb2.getText()));
				food2.setFoodFat(Double.valueOf(tfFoodFat2.getText()));
				list.add(food2);
			}
			if (tfFoodName3.getText() != "") {
				Food food3 = new Food();
				food3.setName(tfFoodName3.getText());
				food3.setServings(Double.valueOf(tfFoodServ3.getText()));
				food3.setCals(Double.valueOf(tfFoodCals3.getText()));
				food3.setFoodPro(Double.valueOf(tfFoodPro3.getText()));
				food3.setFoodCarbs(Double.valueOf(tfFoodCarb3.getText()));
				food3.setFoodFat(Double.valueOf(tfFoodFat3.getText()));
				list.add(food3);
			}
			if (tfDrinkName1.getText() != "") {
				Drink drink1 = new Drink();
				drink1.setName(tfDrinkName1.getText());
				drink1.setServings(Double.valueOf(tfDrinkServ1.getText()));
				drink1.setCals(Double.valueOf(tfDrinkCals1.getText()));
				drink1.setDrinkPro(Integer.valueOf(tfDrinkPro1.getText()));
				drink1.setCarbs(Integer.valueOf(tfDrinkCarb1.getText()));
				drink1.setFat(Integer.valueOf(tfDrinkFat1.getText()));
				list.add(drink1);
			}
			if (tfDrinkName2.getText() != "") {
				Drink drink2 = new Drink();
				drink2.setName(tfDrinkName1.getText());
				drink2.setServings(Double.valueOf(tfDrinkServ2.getText()));
				drink2.setCals(Double.valueOf(tfDrinkCals2.getText()));
				drink2.setDrinkPro(Double.valueOf(tfDrinkPro2.getText()));
				drink2.setCarbs(Double.valueOf(tfDrinkCarb2.getText()));
				drink2.setFat(Double.valueOf(tfDrinkFat2.getText()));
				list.add(drink2);
			}
			Meal meal = new Meal(cbMealTOD.getSelectionModel().getSelectedItem(), list);
			profile.addMeal(meal);
			windowDietJournal(profile, new Stage());
			try {
				saveUser(profile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			stage.close();
			
		});
		btCancel.setOnAction(e -> stage.close());
		
	}
	
	protected void windowAddWorkout(HealthProfile profile, Stage stage) {
		VBox mainPane = new VBox();
		GridPane topPane = new GridPane();
		topPane.setAlignment(Pos.CENTER);
		
		GridPane cardioPane = new GridPane();
		cardioPane.setPadding((new Insets(10, 10, 10, 10)));
		GridPane strengthPane = new GridPane();
		strengthPane.setPadding((new Insets(10, 10, 10, 10)));
		HBox buttonPane = new HBox();
		
		Label lbFocus = new Label("Focus");
		TextField tfFocus = new TextField();
		Label lbLength = new Label("Length");
		TextField tfLength = new TextField();
		
		Label lbCardioEx = new Label("Cardio Exercises");
		final double MAX_FONT_SIZE = 18.0;
		lbCardioEx.setFont(new Font(MAX_FONT_SIZE));
		
		Label lbCName = new Label("Name");
		Label lbCLength = new Label("Length");
		Label lbCalBurn = new Label("Cals burned");
		TextField tfCName1 = new TextField();
		TextField tfCLength1 = new TextField();
		TextField tfCCalBurn1 = new TextField();
		TextField tfCName2 = new TextField();
		TextField tfCLength2 = new TextField();
		TextField tfCCalBurn2 = new TextField();
		TextField tfCName3 = new TextField();
		TextField tfCLength3 = new TextField();
		TextField tfCCalBurn3 = new TextField();
		
		tfCName1.setPrefColumnCount(10);
		tfCName2.setPrefColumnCount(10);
		tfCName3.setPrefColumnCount(10);
		tfCLength1.setPrefColumnCount(3);
		tfCLength2.setPrefColumnCount(3);
		tfCLength3.setPrefColumnCount(3);
		tfCCalBurn1.setPrefColumnCount(3);
		tfCCalBurn2.setPrefColumnCount(3);
		tfCCalBurn3.setPrefColumnCount(3);
		
		Label lbStrengthEx = new Label("Strength Exercises");
		lbStrengthEx.setFont(new Font(MAX_FONT_SIZE));
		
		Label lbSName = new Label("Name");
		Label lbSets = new Label("Sets");
		Label lbReps = new Label("Reps");
		Label lbLoad = new Label("Load");
		
		TextField tfSName1 = new TextField();
		TextField tfSSets1 = new TextField();
		TextField tfSReps1 = new TextField();
		TextField tfSLoad1 = new TextField();
		TextField tfSName2 = new TextField();
		TextField tfSSets2 = new TextField();
		TextField tfSReps2 = new TextField();
		TextField tfSLoad2 = new TextField();
		TextField tfSName3 = new TextField();
		TextField tfSSets3 = new TextField();
		TextField tfSReps3 = new TextField();
		TextField tfSLoad3 = new TextField();
		
		tfSName1.setPrefColumnCount(10);
		tfSName2.setPrefColumnCount(10);
		tfSName3.setPrefColumnCount(10);
		tfSSets1.setPrefColumnCount(3);
		tfSSets2.setPrefColumnCount(3);
		tfSSets3.setPrefColumnCount(3);
		tfSReps1.setPrefColumnCount(3);
		tfSReps2.setPrefColumnCount(3);
		tfSReps3.setPrefColumnCount(3);
		tfSLoad1.setPrefColumnCount(3);
		tfSLoad2.setPrefColumnCount(3);
		tfSLoad3.setPrefColumnCount(3);
		
		Button btAddWorkout = new Button("Add Workout");
		Button btCancel = new Button("Cancel");
		
		topPane.add(lbFocus, 0, 0);
		topPane.add(tfFocus, 1, 0);
		topPane.add(lbLength, 0, 1);
		topPane.add(tfLength, 1, 1);
		
		cardioPane.add(lbCName, 0, 0);
		cardioPane.add(lbCLength, 1, 0);
		cardioPane.add(lbCalBurn, 2, 0);
		cardioPane.add(tfCName1, 0, 1);
		cardioPane.add(tfCLength1, 1, 1);
		cardioPane.add(tfCCalBurn1, 2, 1);
		cardioPane.add(tfCName2, 0, 2);
		cardioPane.add(tfCLength2, 1, 2);
		cardioPane.add(tfCCalBurn2, 2, 2);
		cardioPane.add(tfCName3, 0, 3);
		cardioPane.add(tfCLength3, 1, 3);
		cardioPane.add(tfCCalBurn3, 2, 3);
		
		strengthPane.add(lbSName, 0, 0);
		strengthPane.add(lbSets, 1, 0);
		strengthPane.add(lbReps, 2, 0);
		strengthPane.add(lbLoad, 3, 0);
		strengthPane.add(tfSName1, 0, 1);
		strengthPane.add(tfSSets1, 1, 1);
		strengthPane.add(tfSReps1, 2, 1);
		strengthPane.add(tfSLoad1, 3, 1);
		strengthPane.add(tfSName2, 0, 2);
		strengthPane.add(tfSSets2, 1, 2);
		strengthPane.add(tfSReps2, 2, 2);
		strengthPane.add(tfSLoad2, 3, 2);
		strengthPane.add(tfSName3, 0, 3);
		strengthPane.add(tfSSets3, 1, 3);
		strengthPane.add(tfSReps3, 2, 3);
		strengthPane.add(tfSLoad3, 3, 3);
		
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding((new Insets(10, 10, 10, 10)));
		btAddWorkout.setPadding(new Insets(10, 10, 10, 10));
		btCancel.setPadding(new Insets(10, 10, 10, 10));
		buttonPane.getChildren().addAll(btAddWorkout, btCancel);
		
		mainPane.getChildren().addAll(topPane, lbCardioEx, cardioPane, 
				lbStrengthEx, strengthPane, buttonPane);
		
		Scene scene = new Scene(mainPane);
		stage.setTitle("Add Workout");
		stage.setScene(scene);
		stage.show();
		
		//Handlers
		btAddWorkout.setOnAction(e -> {
			Workout workout = new Workout();
			workout.setFocus(tfFocus.getText());
			workout.setWorkoutLength(Integer.parseInt(tfLength.getText()));
			
			if (tfCName1.getText() != "") {
				CardioExercise ex1 = new CardioExercise();
				ex1.setName(tfCName1.getText());
				ex1.setLength(Integer.parseInt(tfCLength1.getText()));
				ex1.setCalBurned(Integer.parseInt(tfCCalBurn1.getText()));
				workout.addExercise(ex1);
			}
			if (tfCName2.getText() != "") {
				CardioExercise ex2 = new CardioExercise();
				ex2.setName(tfCName2.getText());
				ex2.setLength(Integer.parseInt(tfCLength2.getText()));
				ex2.setCalBurned(Integer.parseInt(tfCCalBurn2.getText()));
				workout.addExercise(ex2);
			}
			if (tfCName3.getText() != "") {
				CardioExercise ex3 = new CardioExercise();
				ex3.setName(tfCName3.getText());
				ex3.setLength(Integer.parseInt(tfCLength3.getText()));
				ex3.setCalBurned(Integer.parseInt(tfCCalBurn3.getText()));
				workout.addExercise(ex3);
			}
			if (tfCName1.getText() != "") {
				StrengthExercise ex4 = new StrengthExercise();
				ex4.setName(tfSName1.getText());
				ex4.setSets(Integer.parseInt(tfSSets1.getText()));
				ex4.setReps(Integer.parseInt(tfSReps1.getText()));
				ex4.setLoad(Integer.parseInt(tfSLoad1.getText()));
				workout.addExercise(ex4);
			}
			if (tfCName2.getText() != "") {
				StrengthExercise ex5 = new StrengthExercise();
				ex5.setName(tfSName1.getText());
				ex5.setSets(Integer.parseInt(tfSSets2.getText()));
				ex5.setReps(Integer.parseInt(tfSReps2.getText()));
				ex5.setLoad(Integer.parseInt(tfSLoad2.getText()));
				workout.addExercise(ex5);
			}
			if (tfCName3.getText() != "") {
				StrengthExercise ex6 = new StrengthExercise();
				ex6.setName(tfSName1.getText());
				ex6.setSets(Integer.parseInt(tfSSets3.getText()));
				ex6.setReps(Integer.parseInt(tfSReps3.getText()));
				ex6.setLoad(Integer.parseInt(tfSLoad3.getText()));
				workout.addExercise(ex6);
			}
			profile.addWorkout(workout);
			try {
				saveUser(profile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			windowWorkoutJournal(profile, new Stage());
			stage.close();
			
		});
		btCancel.setOnAction(e -> {
			windowWorkoutJournal(profile, new Stage());
			stage.close();
			});
		
	}
	
	protected void initializeProfile() {
		//Initialize program with test data
		profile.setFirstName("Jomby");
		profile.setLastName("McDaniels");
		profile.setAge(29);
		profile.setHeight(6, 3);
		profile.setWeight(168);
		Workout initWorkout = new Workout();
		CardioExercise running = new CardioExercise("Running", 30, 150);
		StrengthExercise chestPress = new StrengthExercise("Chest Press", 3, 8, 165);
		initWorkout.setFocus("Chest Day");
		initWorkout.setWorkoutLength(60);
		initWorkout.addExercise(running);
		initWorkout.addExercise(chestPress);
		profile.addWorkout(initWorkout);
		
		Food bacon = new Food("Bacon", 2, 7, 0, 7);
		Food eggs = new Food("Egg", 2, 6, 0, 5);
		Drink oj = new Drink("Orange Juice", 1, 2, 22, 0, 22);
		ArrayList<Consumable> foodList = new ArrayList<Consumable>();
		foodList.add(bacon);
		foodList.add(eggs);
		foodList.add(oj);
		Meal initMeal = new Meal("Breakfast", foodList);
		profile.addMeal(initMeal);
	}
	
	public static void saveUser(HealthProfile profile) throws IOException{
		String filename = profile.getFirstName() + profile.getLastName();
		
		//Creates a file object for the user
		FileOutputStream fileOut = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		
		//Serialize user information
		out.writeObject(profile);
		out.close();
		fileOut.close();
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
