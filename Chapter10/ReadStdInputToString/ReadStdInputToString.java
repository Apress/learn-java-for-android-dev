// ReadStdInputToString.java

import java.io.IOException;

public class ReadStdInputToString
{
   public static void main(String[] args) throws IOException
   {
      System.out.print("Enter some text: ");
      String text = readStdInput();
      System.out.println();
      System.out.println("You entered " + text);
   }
   static String readStdInput() throws IOException
   {
      StringBuffer input = new StringBuffer();
      int ch;
      while ((ch = System.in.read()) != '\n' && ch != -1)
      {
         if (ch != '\r' && ch != '\n')
            input.append((char) ch);
      }
      return input.toString();
   }
}
