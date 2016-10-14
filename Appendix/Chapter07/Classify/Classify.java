// Classify.java

public class Classify
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java Classify pkgAndTypeName");
         return;
      }
      try
      {
         Class<?> clazz = Class.forName(args[0]);
         if (clazz.isAnnotation())
            System.out.println("Annotation");
         else
         if (clazz.isEnum())
            System.out.println("Enum");
         else
         if (clazz.isInterface())
            System.out.println("Interface");
         else
            System.out.println("Class");
      }
      catch (ClassNotFoundException cnfe)
      {
         System.err.println("could not locate " + args[0]);
      }
   }
}
