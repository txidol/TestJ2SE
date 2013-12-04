package reflect.classdemo;

public class Person implements Info{
	private String name;
	private int age;
	
	public Person(){
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "ĞÕÃû£º" + this.name + "£¬ÄêÁä£º" + this.age;
	}

	@Override
	public String sayHello() {
		return "hello";
	}

	public String say(String name , int age) {
		return name  + " " +  age;
	}
	
}
