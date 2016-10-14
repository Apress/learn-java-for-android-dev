// EnclosingClass.java

public class EnclosingClass
{
   private int i;
   private void m1()
   {
      System.out.println(i);
   }
   public class EnclosedClass
   {
      public void accessEnclosingClass()
      {
         i = 1;
         m1();
      }
   }
}
