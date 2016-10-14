// TwoDArray.java

public class TwoDArray
{
   public static void main(String[] args)
   {
      // Create the row array.
      double[][] temperatures = new double[3][]; // Note the extra empty pair of brackets.
      // Create a column array for each row.
      for (int row = 0; row < temperatures.length; row++)
         temperatures[row] = new double[2]; // 2 columns per row
      // Initialize the two-dimensional array.
      for (int row = 0; row < temperatures.length; row++)
         for (int col = 0; col < temperatures[row].length; col++)
            temperatures[row][col] = Math.round(Math.random()*100);
      // Output the two-dimensional array.
      for (int row = 0; row < temperatures.length; row++)
      {
         for (int col = 0; col < temperatures[row].length; col++)
            System.out.print(temperatures[row][col] + " ");
         System.out.println();
      }
   }
}
