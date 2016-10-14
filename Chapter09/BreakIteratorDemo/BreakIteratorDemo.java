// BreakIteratorDemo.java

import java.text.BreakIterator;

import java.util.Locale;

public class BreakIteratorDemo
{
   public static void main(String[] args)
   {
      BreakIterator bi = BreakIterator.getCharacterInstance(Locale.US);
      bi.setText("JAVA");
      dumpPositions(bi);
      bi = BreakIterator.getCharacterInstance(new Locale("ar", "SA"));
      bi.setText("\u0631\u0641\u0651");
      dumpPositions(bi);
   }
   static void dumpPositions(BreakIterator bi)
   {
      int boundary = bi.first();
      while (boundary != BreakIterator.DONE)
      {
         System.out.print(boundary + " ");
         boundary = bi.next();
      }
      System.out.println();
   }
}
