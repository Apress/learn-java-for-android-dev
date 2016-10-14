// Fish.java

public abstract class Fish extends Animal
{
   public Fish(String kind, String appearance)
   {
      super(kind, appearance);
   }
   @Override
   public final void eat()
   {
      System.out.println("eats krill, algae, and insects");
   }
   @Override
   public final void move()
   {
      System.out.println("swims through the water");
   }
}
