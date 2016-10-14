// ExploreType.java

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ExploreType
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java ExploreType pkgAndTypeName");
         return;
      }
      try
      {
         Class<?> clazz = Class.forName(args[0]);
         System.out.println("NAME: " + clazz.getName());
         System.out.println("PACKAGE: " + clazz.getPackage().getName());
         System.out.println("FIELDS");
         Field[] fields = clazz.getDeclaredFields();
         for (int i = 0; i < fields.length; i++)
            System.out.println(fields[i]);
         System.out.println("CONSTRUCTORS");
         Constructor[] constructors = clazz.getDeclaredConstructors();
         for (int i = 0; i < constructors.length; i++)
            System.out.println(constructors[i]);
         System.out.println("METHODS");
         Method[] methods = clazz.getDeclaredMethods();
         for (int i = 0; i < methods.length; i++)
            System.out.println(methods[i]);
      }
      catch (ClassNotFoundException cnfe)
      {
         System.err.println("could not locate " + args[0]);
      }
   }
}
