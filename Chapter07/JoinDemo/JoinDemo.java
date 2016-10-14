// JoinDemo.java

public class JoinDemo
{
   public static void main(String[] args)
   {
      Runnable r = new Runnable()
                   {
                      @Override
                      public void run()
                      {
                         System.out.println("Worker thread is simulating " +
                                            "work by sleeping for 5 seconds.");
                         try
                         {
                            Thread.sleep(5000);
                         }
                         catch (InterruptedException ie)
                         {
                         }
                         System.out.println("Worker thread is dying");
                      }
                   };
      Thread thd = new Thread(r);
      thd.start();
      System.out.println("Default main thread is doing work.");
      try
      {
         Thread.sleep(2000);
      }
      catch (InterruptedException ie)
      {
      }
      System.out.println("Default main thread has finished its work.");
      System.out.println("Default main thread is waiting for worker thread " +
                         "to die.");
      try
      {
         thd.join();
      }
      catch (InterruptedException ie)
      {
      }
      System.out.println("Main thread is dying");
   }
}
