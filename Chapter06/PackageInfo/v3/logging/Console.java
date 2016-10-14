// Console.java

package logging;

class Console implements Logger
{
   private String dstName;
   Console(String dstName)
   {
      this.dstName = dstName;
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
      System.out.println(msg);
      return true;
   }
}
