// File.java

package logging;

import java.io.FileWriter;
import java.io.IOException;

class File implements Logger
{
   private final static String LINE_SEPARATOR = System.getProperty("line.separator");
   private String dstName;
   private FileWriter fw;
   File(String dstName)
   {
      this.dstName = dstName;
   }
   public boolean connect()
   {
      if (dstName == null)
         return false;
      try
      {
          fw = new FileWriter(dstName);
      }
      catch (IOException ioe)
      {
         return false;
      }
      return true;
   }
   public boolean disconnect()
   {
      if (fw == null)
         return false;
      try
      {
         fw.close();
      }
      catch (IOException ioe)
      {
         return false;
      }
      return true;
   }
   public boolean log(String msg)
   {
      if (fw == null)
          return false;
      try
      {
         fw.write(msg + LINE_SEPARATOR);
      }
      catch (IOException ioe)
      {
         return false;
      }
      return true;
   }
}
