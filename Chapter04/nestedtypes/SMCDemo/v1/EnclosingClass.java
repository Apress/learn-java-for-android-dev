// EnclosingClass.java

public class EnclosingClass
{
   private static int i;
   private static void m1()
   {
      System.out.println(i);
   }
   public static void m2()
   {
      EnclosedClass.accessEnclosingClass();
   }
   public static class EnclosedClass
   {
      public static void accessEnclosingClass()
      {
         i = 1;
         m1();
      }
      public void accessEnclosingClass2()
      {
         m2();
      }
   }
}
