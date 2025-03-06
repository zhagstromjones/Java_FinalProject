import java.io.Serializable;

public abstract class Consumable implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;					//Name of consumable
	private java.util.Date dateCreated;		//Date of creation
	
	protected Consumable() {
		
	}
	
	protected Consumable(String name, double servings, java.util.Date dateCreated) {
		this.name = name;
		this.dateCreated = dateCreated;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public java.util.Date getDateCreated(){
		return this.dateCreated;
	}
	
	public abstract double getCals();
	
	public abstract double getDrinkPro();
	
	public abstract double getDrinkCarbs();
	
	public abstract double getDrinkFat();
	
	public abstract double getServings();
}
