import java.io.Serializable;

public abstract class Exercise implements Serializable {
	private static final long serialVersionUID = 1L;
	private String exName;			//Name of the exercise
	private java.util.Date dateCreated;
	
	public Exercise() {
		
	}
	
	public void setName(String exName) {
		this.exName = exName;
	}
	
	public String getName() {
		return this.exName;
	}
	
	public java.util.Date getDateCreated(){
		return dateCreated;
	}
	
	public abstract double getVolume();

	
}
