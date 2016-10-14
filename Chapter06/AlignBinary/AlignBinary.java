// AlignBinary.java

public class AlignBinary
{
   public static void main(String[] args)
   {
      System.out.println(toAlignedBinaryString(7, 8));
      System.out.println(toAlignedBinaryString(255, 16));
      System.out.println(toAlignedBinaryString(255, 7));
   }
   static String toAlignedBinaryString(int i, int numBits)
   {
      String result = Integer.toBinaryString(i);
      if (result.length() > numBits)
         return null; // cannot fit result into numBits columns
      int numLeadingZeros = numBits-result.length();
      String zerosPrefix = "";
      for (int j = 0; j < numLeadingZeros; j++)
         zerosPrefix += "0";
      return zerosPrefix + result;
   }
}
