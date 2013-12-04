package reflect.factory;

public class Factory {
	public static IFruit getInstance(String className) {
		IFruit fruit = null;
		if ("apple".equals(className)) {
			fruit = new Apple();
		}
		if ("orange".equals(className)) {
			fruit = new Orange();
		}
		return fruit;
	}
	
	public static IFruit getReflectInstance(String className) {
		IFruit f = null;
	
		try {
			f = (IFruit) Class.forName(PACKAGE_NAME + className ).newInstance();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return f;
	}

	private final static String PACKAGE_NAME = "reflect.factory.";
	
}
