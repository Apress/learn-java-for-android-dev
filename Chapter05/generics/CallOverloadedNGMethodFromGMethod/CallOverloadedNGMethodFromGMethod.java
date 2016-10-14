// CallOverloadedNGMethodFromGMethod.java

import java.util.Date;

public class CallOverloadedNGMethodFromGMethod
{
   public static void someOverloadedMethod(Object o)
   {
      System.out.println("call to someOverloadedMethod(Object o)");
   }
   public static void someOverloadedMethod(Date d)
   {
      System.out.println("call to someOverloadedMethod(Date d)");
   }
   public static <T> void methodCaller(T t)
   {
      someOverloadedMethod(t);
   }
   public static void main(String[] args)
   {
      methodCaller(new Date());      
   }
}
