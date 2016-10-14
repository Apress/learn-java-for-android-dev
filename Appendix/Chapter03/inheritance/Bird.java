// Bird.java

public abstract class Bird extends Animal
{
   public Bird(String kind, String appearance)
   {
      super(kind, appearance);
   }
   @Override
   public final void eat()
   {
      System.out.println("eats seeds and insects");
   }
   @Override
   public final void move()
   {
      System.out.println("flies through the air");
   }
}
