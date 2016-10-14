// LoggerFactory.java

package logging;

public abstract class LoggerFactory
{
   public final static int CONSOLE = 0;
   public final static int FILE = 1;
   public static Logger newLogger(int dstType, String...dstName)
   {
      switch (dstType)
      {
         case CONSOLE: return new Console(dstName.length == 0 ? null
                                                              : dstName[0]);
         case FILE   : return new File(dstName.length == 0 ? null
                                                           : dstName[0]);
         default     : return null;
      }
   }
}
