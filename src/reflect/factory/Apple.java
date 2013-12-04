package reflect.factory;

public class Apple implements IFruit{

	private String eated;
	
	@Override
	public void eat() {
		this.setEated("apple");
	}

	public void setEated(String eated) {
		this.eated = eated;
	}

	public String getEated() {
		return eated;
	}

}
