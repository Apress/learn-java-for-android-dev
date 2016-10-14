// LargeObjectDemo.java

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

class LargeObject
{
   private byte[] memory = new byte[1024*1024*50]; // 50 megabytes
}
public class LargeObjectDemo
{
   public static void main(String[] args)
   {
      ReferenceQueue<LargeObject> rq;
      rq = new ReferenceQueue<LargeObject>();
      PhantomReference<LargeObject> pr;
      pr = new PhantomReference<LargeObject>(new LargeObject(), rq);
      int counter = 0;
      int[] x;
      while (rq.poll() == null)
      {
         System.out.println("waiting for large object to be removed");
         if (counter++ == 10)
            x = new int[1024*1024];
      }
      System.out.println("large object removed");
   }
}
