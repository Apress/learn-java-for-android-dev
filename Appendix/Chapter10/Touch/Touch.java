// Touch.java

import java.io.File;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Touch
{
   public static void main(String[] args)
   {
      if (args.length != 1 && args.length != 3)
      {
         System.err.println("usage: java Touch [-d timestamp] pathname");
         return;
      }
      long time = new Date().getTime();
      if (args.length == 3)
      {
         if (args[0].equals("-d"))
         {
            try
            {
               SimpleDateFormat sdf;
               sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
               Date date = sdf.parse(args[1]);
               time = date.getTime();
            }
            catch (ParseException pe)
            {
               pe.printStackTrace();
            }
         }
         else
         {
            System.err.println("invalid option: " + args[0]);
            return;
         }
      }
      new File(args[args.length == 1 ? 0 : 2]).setLastModified(time);
   }
}
