// Rectangle.java

public abstract class Rectangle
{
   public abstract double getX();
   public abstract double getY();
   public abstract double getWidth();
   public abstract double getHeight();
   public static class Double extends Rectangle
   {
      private double x, y, width, height;
      public Double(double x, double y, double width, double height)
      {
         this.x = x;
         this.y = y;
         this.width = width;
         this.height = height;
      }
      public double getX() { return x; }
      public double getY() { return y; }
      public double getWidth() { return width; }
      public double getHeight() { return height; }
   }
   public static class Float extends Rectangle
   {
      private float x, y, width, height;
      public Float(float x, float y, float width, float height)
      {
         this.x = x;
         this.y = y;
         this.width = width;
         this.height = height;
      }
      public double getX() { return x; }
      public double getY() { return y; }
      public double getWidth() { return width; }
      public double getHeight() { return height; }
   }
   // Prevent subclassing. Use the type-specific Double and Float
   // implementation subclass classes to instantiate.
   private Rectangle() {}
   public boolean contains(double x, double y)
   {
      return (x >= getX() && x < getX()+getWidth()) &&
             (y >= getY() && y < getY()+getHeight());
   }
}
