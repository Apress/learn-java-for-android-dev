// FailedInitialization.java

public class FailedInitialization
{
   static
   {
      someMethod(null);
   }
   public static void someMethod(String s)
   {
      int len = s.length(); // s contains null
      System.out.println(s + "'s length is " + len + " characters");
   }
}
