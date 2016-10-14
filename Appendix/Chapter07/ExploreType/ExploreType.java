// ExploreType.java

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
         if (clazz.isAnnotation())
            dumpAnnotation(clazz);
         else
         if (clazz.isEnum())
            dumpEnum(clazz);
         else
         if (clazz.isInterface())
            dumpInterface(clazz);
         else
            dumpClass(clazz);
      }
      catch (ClassNotFoundException cnfe)
      {
         System.err.println("could not locate " + args[0]);
      }
   }
   public static void dumpAnnotation(Class clazz)
   {
      // Left blank as an exercise for you to complete.
   }
   public static void dumpClass(Class clazz)
   {
      // Output class header.
      int modifiers = clazz.getModifiers();
      if ((modifiers & Modifier.PUBLIC) == Modifier.PUBLIC)
         System.out.print("public ");
      if ((modifiers & Modifier.ABSTRACT) == Modifier.ABSTRACT)
         System.out.print("abstract ");
      System.out.println("class " + clazz.getName());
      System.out.println("{");

      // Output fields.
      System.out.println ("   // FIELDS");
      Field[] fields = clazz.getDeclaredFields();
      for (int i = 0; i < fields.length; i++)
      {
         System.out.print("   ");
         System.out.println(fields[i]);
      }
      System.out.println();

      // Output constructors.
      System.out.println ("   // CONSTRUCTORS");
      Constructor[] constructors = clazz.getDeclaredConstructors();
      for (int i = 0; i < constructors.length; i++)
      {
         System.out.print("   ");
         System.out.println(constructors[i]);
      }
      System.out.println();

      // Output methods.
      System.out.println ("   // METHODS");
      Method[] methods = clazz.getDeclaredMethods();
      for (int i = 0; i < methods.length; i++)
      {
         System.out.print("   ");
         System.out.println(methods[i]);
      }

      // Output class trailer.
      System.out.println("}");
   }
   public static void dumpEnum(Class clazz)
   {
      // Left blank as an exercise for you to complete.
   }
   public static void dumpInterface(Class clazz)
   {
      // Left blank as an exercise for you to complete.
   }
}
