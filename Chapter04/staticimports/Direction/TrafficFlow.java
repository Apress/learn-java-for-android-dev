// TrafficFlow.java

public class TrafficFlow implements Directions
{
   public static void main(String[] args)
   {
      showDirection((int)(Math.random()*4));
   }
   private static void showDirection(int dir)
   {
      switch (dir)
      {
         case NORTH: System.out.println("Moving north"); break;
         case SOUTH: System.out.println("Moving south"); break;
         case EAST : System.out.println("Moving east"); break;
         case WEST : System.out.println("Moving west");
      }
   }
}
