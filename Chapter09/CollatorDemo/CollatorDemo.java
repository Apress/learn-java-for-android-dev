// CollatorDemo.java

import java.text.Collator;

import java.util.Arrays;
import java.util.Locale;

public class CollatorDemo
{
   public static void main(String[] args)
   {
      Collator en_USCollator = Collator.getInstance(Locale.US);
      Collator fr_FRCollator = Collator.getInstance(Locale.FRANCE);
      String[] words =
      {
         "côte", "coté", "côté", "cote"
      };
      Arrays.sort(words, en_USCollator);
      for (String word: words)
         System.out.println(word);
      System.out.println();
      Arrays.sort(words, fr_FRCollator);
      for (String word: words)
         System.out.println(word);
   }
}
