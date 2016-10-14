// Archive.java

import java.io.IOException;

import java.util.jar.JarFile;

import java.util.zip.ZipFile;

class Zip
{
   ZipFile getArchive(String name) throws IOException
   {
      System.out.println("Returning ZipFile instance using " + name);
      return new ZipFile(name); // ZipFile is located in the java.util.zip package
   }
}
class Jar extends Zip
{
   @Override JarFile getArchive(String name) throws IOException
   {
      System.out.println("Returning JarFile instance using " + name);
      return new JarFile(name); // JarFile is located in the java.util.jar package
   }
}
class Archive
{
   public static void main(String[] args) throws IOException
   {
      if (args.length == 2 && args[0].equals("-zip"))
      {
         ZipFile zf = new Zip().getArchive(args[1]);
      }
      else
      if (args.length == 2 && args[0].equals("-jar"))
      {
         JarFile jf = new Jar().getArchive(args[1]);
      }
   }
}
