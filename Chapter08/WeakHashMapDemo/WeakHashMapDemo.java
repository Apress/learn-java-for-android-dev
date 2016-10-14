// WeakHashMapDemo.java

import java.util.Map;
import java.util.WeakHashMap;

class LargeObject
{
   private byte[] memory = new byte[1024*1024*50]; // 50 megabytes
}
public class WeakHashMapDemo
{
   public static void main(String[] args)
   {
      Map<LargeObject, String> map = new WeakHashMap<LargeObject, String>();
      LargeObject lo = new LargeObject();
      map.put(lo, "Large Object");
      System.out.println(map);
      lo = null;
      while (!map.isEmpty())
      {
         System.gc();
         new LargeObject();
      }
      System.out.println(map);
   }
}
