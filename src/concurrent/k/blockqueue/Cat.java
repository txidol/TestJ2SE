package concurrent.k.blockqueue;

public class Cat extends Pet {
  public Cat(String name) {
    super(name);
  }

  public void examine() {
    System.out.println("Meow!");
  }
}