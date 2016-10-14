// DumpFileInHex.java

import java.io.FileInputStream;
import java.io.IOException;

public class DumpFileInHex
{
   public static void main(String[] args) throws IOException
   {
      if (args.length != 1)
      {
         System.err.println("usage: java DumpFileInHex pathname");
         return;
      }
      FileInputStream fis = new FileInputStream(args[0]);
      StringBuffer sb = new StringBuffer();
      int offset = 0;
      int ch;
      while ((ch = fis.read()) != -1)
      {
         if ((offset % 16) == 0)
            System.out.printf("%08X ", offset);
         System.out.printf("%02X ", ch);
         if (ch < 32 || ch > 127)
            sb.append('.');
         else
            sb.append((char) ch);
         if ((++offset % 16) == 0)
         {
            System.out.println(sb.toString());
            sb.setLength(0);
         }
      }
      if (sb.length() != 0)
      {
         for (int i = 0; i < 16-sb.length(); i++)
            System.out.printf("   ");
         System.out.println(sb.toString());
      }
      fis.close();
   }
}
