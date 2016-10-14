// PackageInfo.java

public class PackageInfo
{
   public static void main(String[] args)
   {
      if (args.length == 0)
      {
         System.err.println("usage: java PackageInfo packageName [version] [class]");
         return;
      }
      if (args.length == 3)
      try
      {
         Class.forName(args[2]);
      }
      catch (ClassNotFoundException cnfe)
      {
         System.err.println("cannot load " + args[2]);
         return;
      }
      Package pkg = Package.getPackage(args[0]);
      if (pkg == null)
      {
         System.err.println(args[0] + " not found");
         return;
      }
      System.out.println("Name: " + pkg.getName());
      System.out.println("Implementation title: " +
                         pkg.getImplementationTitle());
      System.out.println("Implementation vendor: " +
                         pkg.getImplementationVendor());
      System.out.println("Implementation version: " +
                         pkg.getImplementationVersion());
      System.out.println("Specification title: " +
                         pkg.getSpecificationTitle());
      System.out.println("Specification vendor: " +
                         pkg.getSpecificationVendor());
      System.out.println("Specification version: " +
                         pkg.getSpecificationVersion());
      System.out.println("Sealed: " + pkg.isSealed());
      if (args.length > 1)
         System.out.println("Compatible with " + args[1] + ": " +
                            pkg.isCompatibleWith(args[1]));
   }
}
