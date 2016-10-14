// Circle.java

public class Circle
{
   final static int NROWS = 22;
   final static int NCOLS = 22;
   final static double RADIUS = 10.0;
   public static void main(String[] args)
   {
      // Create the screen array for storing the cardioid image.
      char[][] screen = new char[NROWS][];
      for (int row = 0; row < NROWS; row++)
         screen[row] = new char[NCOLS];

      // Initialize the screen array to space characters.
      for (int col = 0; col < NCOLS; col++)
         screen[0][col] = ' ';
      for (int row = 1; row < NROWS; row++)
         System.arraycopy(screen[0], 0, screen[row], 0, NCOLS);

      // Create the circle shape.
      for (int angle = 0; angle < 360; angle++)
      {
         int x = (int)(RADIUS*Math.cos(Math.toRadians(angle)))+NCOLS/2;
         int y = (int)(RADIUS*Math.sin(Math.toRadians(angle)))+NROWS/2;
         screen[y][x] = '*';
      }

      // Output the screen array.
      for (int row = 0; row < NROWS; row++)
         System.out.println(screen[row]);
   }
}
