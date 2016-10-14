// RearrangeText.java

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RearrangeText
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java RearrangeText text");
         return;
      }
      try
      {
         Pattern p = Pattern.compile("(.*), (.*)");
         Matcher m = p.matcher(args[0]);
         if (m.matches())
            System.out.println(m.group(2)+" " + m.group(1));
      }
      catch (PatternSyntaxException pse)
      {
         System.err.println(pse);
      }
   }
}
