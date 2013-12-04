package concurrent.k.blockqueue;

public class Dog extends Pet {
  public Dog(String name) {
    super(name);
  }

  @Override
  public void examine() {
    System.out.println("Woof!");
  }
}
