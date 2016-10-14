// StubFinder.java

import java.lang.reflect.*;

public class StubFinder
{
   public static void main(String[] args) throws Exception
   {
      if (args.length != 1)
      {
         System.err.println("usage: java StubFinder classfile");
         return;
      }
      Method[] methods = Class.forName(args[0]).getMethods();
      for (int i = 0; i < methods.length; i++)
         if (methods[i].isAnnotationPresent(Stub.class))
         {
            Stub stub = methods[i].getAnnotation(Stub.class);
            String[] components = stub.value().split(",");
            System.out.println("Stub ID = " + components[0]);
            System.out.println("Stub Date = " + components[1]);
            System.out.println("Stub Developer = " + components[2]);
            System.out.println();
         }
   }
}
