// Graphics.java

class Point
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
   void draw()
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
class Graphics
{
   public static void main(String[] args)
   {
      Point[] points = new Point[] {new Point(10, 20), new Circle(10, 20, 30)};
      for (int i = 0; i < points.length; i++)
         points[i].draw();
   }
}
