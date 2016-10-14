// ReificationDemo.java

class Point
{
   int x, y;
}
class ColoredPoint extends Point
{
   int color;
}
public class ReificationDemo
{
   public static void main(String[] args)
   {
      ColoredPoint[] cptArray = new ColoredPoint[1];
      Point[] ptArray = cptArray;
      ptArray[0] = new Point();
   }
}
