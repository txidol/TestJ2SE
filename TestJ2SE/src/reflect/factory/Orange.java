package reflect.factory;

public class Orange implements IFruit{
	
	private String eated;
	
	@Override
	public void eat() {
		this.setEated("orange");
	}

	public void setEated(String eated) {
		this.eated = eated;
	}

	public String getEated() {
		return eated;
	}
}
