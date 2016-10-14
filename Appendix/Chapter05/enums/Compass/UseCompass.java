// UseCompass.java

public class UseCompass
{
   public static void main(String[] args)
   {
      int i = (int)(Math.random()*4);
      Compass[] dir = { Compass.NORTH, Compass.EAST, Compass.SOUTH, 
                       Compass.WEST };
      switch(dir[i])
      {
         case NORTH: System.out.println("heading north"); break;
         case EAST : System.out.println("heading east"); break;
         case SOUTH: System.out.println("heading south"); break;
         case WEST : System.out.println("heading west"); break;
         default   : assert false; // Should never be reached.
      }
   }
}
