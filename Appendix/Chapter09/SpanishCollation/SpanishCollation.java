// SpanishCollation.java

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;

import java.util.Arrays;
import java.util.Locale;

public class SpanishCollation
{
   public static void main(String[] args)
   {
      String[] words =
      {
         "ñango",   // weak
         "llamado", // called
         "lunes",   // monday
         "champán", // champagne
         "clamor",  // outcry
         "cerca",   // near
         "nombre",  // name
         "chiste",  // joke
      };
      Locale locale = new Locale("es", "");
      Collator c = Collator.getInstance(locale);
      Arrays.sort(words, c);
      for (String word: words)
         System.out.println(word);
      System.out.println();
      // Define the traditional Spanish sort rules.
      String upperNTilde = new String ("\u00D1");
      String lowerNTilde = new String ("\u00F1");
      String spanishRules = "< a,A < b,B < c,C < ch, cH, Ch, CH < d,D < e,E " +
                            "< f,F < g,G < h,H < i,I < j,J < k,K < l,L < ll, " +
                            "lL, Ll, LL < m,M < n,N < " + lowerNTilde + "," +
                            upperNTilde + " < o,O < p,P < q,Q < r,R < s,S < " +
                            "t,T < u,U < v,V < w,W < x,X < y,Y < z,Z";
      try
      {
         c = new RuleBasedCollator(spanishRules);
         Arrays.sort(words, c);
         for (String word: words)
            System.out.println(word);
      }
      catch (ParseException pe)
      {
         System.err.println(pe);
      }
   }
}
