// SwitchOnString.java

// This application requires Java version 7.

public class SwitchOnString
{
   public static void main(String[] args)
   {
      for (int i = 0; i < args.length; i++)
         switch (args[i])
         {
            case "-v":
            case "-V": System.out.println("version 1.0");
                       break;
            default  : showUsage();
         }
   }
   static void showUsage()
   {
      System.err.println("usage: java SwitchOnString [-v | -V]");
   }
}
