// NullDevice.java

package logging;

class NullDevice implements Logger
{
   private String dstName;
   NullDevice(String dstName)
   {
   }
   public boolean connect()
   {
      return true;
   }
   public boolean disconnect()
   {
      return true;
   }
   public boolean log(String msg)
   {
      return true;
   }
}
