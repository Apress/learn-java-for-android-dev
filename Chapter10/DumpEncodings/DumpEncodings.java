// DumpEncodings.java

import java.nio.charset.Charset;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

public class DumpEncodings
{
   public static void main(String[] args)
   {
      System.out.println("Default file encoding = " +
                         System.getProperty("file.encoding"));
      SortedMap<String, Charset> map = Charset.availableCharsets();
      Set<String> keys = map.keySet();
      System.out.println("==============================================" +
                         "=======");
      System.out.printf("%-20s %-20s %-5s%n", "Canonical name",
                        "Display name", "Encode?");
      System.out.println("==============================================" +
                         "=======");
      Iterator<String> iter = keys.iterator();
      while (iter.hasNext())
      {
         String canonicalName = iter.next();
         Charset charset = map.get(canonicalName);
         String displayName = charset.displayName();
         boolean canEncode = charset.canEncode();
         System.out.printf("%-20s %-20s %-5b%n", canonicalName,
                           displayName, canEncode);
         Set<String> aliases = charset.aliases();
         Iterator<String> iter2 = aliases.iterator();
         System.out.println("ALIASES");
         while (iter2.hasNext())
            System.out.println("- " + iter2.next());
         System.out.println("----------------------------------------------" +
                            "-------");
      }
   }
}
