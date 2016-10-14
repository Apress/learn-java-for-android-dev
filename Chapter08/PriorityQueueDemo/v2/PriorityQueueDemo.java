// PriorityQueueDemo.java

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo
{
   final static int NELEM = 15;
   public static void main(String[] args)
   {
      Comparator<Integer> cmp;
      cmp = new Comparator<Integer>()
            {
               public int compare(Integer e1, Integer e2)
               {
                  return e2-e1;
               }
            };
      Queue<Integer> qi = new PriorityQueue<Integer>(NELEM, cmp);
      for (int i = 0; i < NELEM; i++)
         qi.add((int) (Math.random()*100));
      while (!qi.isEmpty())
         System.out.print(qi.poll() + " ");
      System.out.println();
   }
}
