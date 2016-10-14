// PathnameInfo.java

import java.io.File;
import java.io.IOException;

public class PathnameInfo
{
   public static void main(final String[] args) throws IOException
   {
      if (args.length != 1)
      {
         System.err.println("usage: java PathnameInfo pathname");
         return;
      }
      File file = new File(args[0]);
      System.out.println("Absolute path = " + file.getAbsolutePath());
      System.out.println("Canonical path = " + file.getCanonicalPath());
      System.out.println("Name = " + file.getName());
      System.out.println("Parent = " + file.getParent());
      System.out.println("Path = " + file.getPath());
      System.out.println("Is absolute = " + file.isAbsolute());
   }
}
