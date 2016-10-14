// FindAll.java

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FindAll
{
   static Matcher m;
   public static void main(String[] args)
   {
      if (args.length == 0 || args.length > 2)
      {
         System.err.println("usage: java FindAll regex [pathname]");
         return;
      }
      try
      {
         Pattern p = Pattern.compile(args[0]);
         m = p.matcher("");
         String cwd = System.getProperty("user.dir");
         findAll(new File(args.length == 2 ? args[1] : cwd), p);
      }
      catch (PatternSyntaxException pse)
      {
         pse.printStackTrace();
      }
   }
   static void findAll(File file, Pattern p)
   {
      if (!file.isDirectory())
      {
         System.err.println(file + " is not a directory");
         return;
      }
      File[] files = file.listFiles();
      if (files == null)
      {
         System.err.println("unable to access " + file + "'s contents");
         return;
      }
      for (int i = 0; i < files.length; i++)
         if (files[i].isDirectory())
            findAll(files[i], p);
         else
         if (find(files[i].getPath(), p))
            System.out.println(files[i].getPath());
   }
   static boolean find(String pathname, Pattern p)
   {
      BufferedReader br = null;
      try
      {
         FileReader fr = new FileReader(pathname);
         br = new BufferedReader(fr);
         String line;
         while ((line = br.readLine()) != null)
         {
            m.reset(line);
            if (m.find())
               return true;
         }
      }
      catch (IOException ioe)
      {
         ioe.printStackTrace();
      }
      finally
      {
         if (br != null)
            try
            {
               br.close();
            }
            catch (IOException ioe)
            {
               ioe.printStackTrace();
            }
      }
      return false;
   }
}
