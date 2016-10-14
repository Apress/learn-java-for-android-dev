// BitSetDemo.java

import java.util.BitSet;

public class BitSetDemo
{
   public static void main(String[] args)
   {
      BitSet bs1 = new BitSet();
      bs1.set(4, true);
      bs1.set(5, true);
      bs1.set(9, true);
      bs1.set(10, true);
      BitSet bsTemp = (BitSet) bs1.clone();
      dumpBitset("        ", bs1);
      BitSet bs2 = new BitSet();
      bs2.set(4, true);
      bs2.set(6, true);
      bs2.set(7, true);
      bs2.set(9, true);
      dumpBitset("        ", bs2);
      bs1.and(bs2);
      dumpSeparator(Math.min(bs1.size(), 16));
      dumpBitset("AND (&) ", bs1);
      System.out.println();
      bs1 = bsTemp;
      dumpBitset("        ", bs1);
      dumpBitset("        ", bs2);
      bsTemp = (BitSet) bs1.clone();
      bs1.or(bs2);
      dumpSeparator(Math.min(bs1.size(), 16));
      dumpBitset("OR (|)  ", bs1);
      System.out.println();
      bs1 = bsTemp;
      dumpBitset("        ", bs1);
      dumpBitset("        ", bs2);
      bsTemp = (BitSet) bs1.clone();
      bs1.xor(bs2);
      dumpSeparator(Math.min(bs1.size(), 16));
      dumpBitset("XOR (^) ", bs1);
   }
   static void dumpBitset(String preamble, BitSet bs)
   {
      System.out.print(preamble);
      for (int i = 0; i < Math.min(bs.size(), 16); i++)
         System.out.print(bs.get(i) ? "1" : "0");
      System.out.print("  size(" + bs.size() + "), length(" + bs.length() + ")");
      System.out.println();
   }
   static void dumpSeparator(int len)
   {
      System.out.print("        ");
      for (int i = 0; i < len; i++)
         System.out.print("-");
      System.out.println();
   }
}
