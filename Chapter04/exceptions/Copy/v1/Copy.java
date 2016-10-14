// Copy.java

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Copy
{
   public static void main(String[] args)
   {
      if (args.length != 2)
      {
         System.err.println("usage: java Copy srcfile dstfile");
         return;
      }
      FileInputStream fis = null;
      try
      {
         fis = new FileInputStream(args[0]);
         FileOutputStream fos = null;
         try
         {
            fos = new FileOutputStream(args[1]);
            int b; // I chose b instead of byte because byte is a reserved word.
            while ((b = fis.read()) != -1)
               fos.write(b);
         }
         catch (FileNotFoundException fnfe)
         {
            String msg = args[1] + " could not be created, possibly because " +
                         "it might be a directory";
            System.err.println(msg);
         }
         catch (IOException ioe)
         {
            String msg = args[0] + " could not be read, or " + args[1] +
                         " could not be written";
            System.err.println(msg);
         }
         finally
         {
            if (fos != null)
               try
               {
                  fos.close();
               }
               catch (IOException ioe)
               {
                  System.err.println("unable to close " + args[1]);
               }
         }
      }
      catch (FileNotFoundException fnfe)
      {
         String msg = args[0] + " could not be found or might be a directory";
         System.err.println(msg);
      }
      finally
      {
         if (fis != null)
            try
            {
               fis.close();
            }
            catch (IOException ioe)
            {
               System.err.println("unable to close " + args[0]);
            }
      }
   }
}
