// Graphics.java

abstract class Shape
{
   abstract void draw();
}
class Point extends Shape
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
   @Override void draw()
   {
      System.out.println("Point drawn at " + toString ());
   }
}
class Circle extends Point
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
   @Override void draw()
   {
      System.out.println("Circle drawn at " + super.toString() +
                         " with radius " + toString());
   }
}
class Rectangle extends Shape
{
   private int x, y, width, height;
   Rectangle(int x, int y, int width, int height)
   {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
   }
   int getX()
   {
      return x;
   }
   int getY()
   {
      return y;
   }
   int getWidth()
   {
      return width;
   }
   int getHeight()
   {
      return height;
   }
   @Override public String toString()
   {
      return "(" + x + ", " + y + ") with extents (" + width + ", " + height + ")";
   }
   @Override void draw()
   {
      System.out.println("Rectangle drawn at " + toString());
   }
}
class Graphics
{
   public static void main(String[] args)
   {
      Shape[] shapes = new Shape[] {new Point(10, 20), new Circle(10, 20, 30),
                                    new Rectangle(20, 30, 15, 25)};
      for (int i = 0; i < shapes.length; i++)
         shapes[i].draw();
   }
}
