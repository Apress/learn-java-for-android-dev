// Converter.java

import java.io.FileNotFoundException;
import java.io.IOException;

import media.InvalidMediaFormatException;
import media.Media;

public class Converter
{
   public static void main(String[] args)
   {
      if (args.length != 2)
      {
         System.err.println("usage: java Converter srcfile dstfile");
         return;
      }
      try
      {
         Media.convert(args[0], args[1]);
      }
      catch (InvalidMediaFormatException imfe)
      {
         System.out.println("Unable to convert " + args[0] + " to " + args[1]);
         System.out.println("Expecting " + args[0] + " to conform to " +
                            imfe.getExpectedFormat() + " format.");
         System.out.println("However, " + args[0] + " conformed to " +
                            imfe.getExistingFormat() + " format.");
      }
      catch (FileNotFoundException fnfe)
      {
      }
      catch (IOException ioe)
      {
      }
   }
}
