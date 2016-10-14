// Animal.java

public abstract class Animal
{
   private String kind;
   private String appearance;
   public Animal(String kind, String appearance)
   {
      this.kind = kind;
      this.appearance = appearance;
   }
   public abstract void eat();
   public abstract void move();
   @Override
   public final String toString()
   {
      return kind + " -- " + appearance;
   }
}
