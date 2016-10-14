// Graphics.java

interface Drawable
{
   int RED = 1;   // For simplicity, integer constants are used. These constants are
   int GREEN = 2; // not that descriptive, as you will see.
   int BLUE = 3;
   int BLACK = 4;
   void draw(int color);
}
class Point implements Drawable
{
   private int x, y;
   Point(int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   int getX()
   {
      return x;
   }
   int getY()
   {
      return y;
   }
   @Override public String toString()
   {
      return "(" + x + ", " + y + ")";
   }
   @Override public void draw(int color)
   {
      System.out.println("Point drawn at " + toString () + " in color " + color);
   }
}
class Circle extends Point implements Drawable
{
   private int radius;
   Circle(int x, int y, int radius)
   {
      super(x, y);
      this.radius = radius;
   }
   int getRadius()
   {
      return radius;
   }
   @Override public String toString()
   {
      return "" + radius;
   }
   @Override public void draw(int color)
   {
      System.out.println("Circle drawn at " + super.toString() +
                         " with radius " + toString() + " in color " + color);
   }
}
class Graphics
{
   public static void main(String[] args)
   {
      Drawable[] drawables = new Drawable[] {new Point(10, 20), new Circle(10, 20, 30)};
      for (int i = 0; i < drawables.length; i++)
         drawables[i].draw(Drawable.RED);
   }
}
