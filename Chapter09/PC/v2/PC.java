// PC.java

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PC
{
   public static void main(String[] args)
   {
      final Lock lock = new ReentrantLock();
      final BlockingQueue<Character> bq;
      bq = new ArrayBlockingQueue<Character>(26);
      final ExecutorService executor = Executors.newFixedThreadPool(2);
      Runnable producer;
      producer = new Runnable()
                 {
                    public void run()
                    {
                       for (char ch = 'A'; ch <= 'Z'; ch++)
                       {
                          try
                          {
                             lock.lock();
                             try
                             {
                                while (!bq.offer(ch))
                                {
                                   lock.unlock();
                                   Thread.sleep(50);
                                   lock.lock();
                                }
                                System.out.println(ch + " produced by producer.");
                             }
                             catch (InterruptedException ie)
                             {
                                assert false;
                             }
                          }
                          finally
                          {
                             lock.unlock();
                          }
                       }
                    }
                 };
      executor.execute(producer);
      Runnable consumer;
      consumer = new Runnable()
                 {
                    public void run()
                    {
                       char ch = '\0';
                       do
                       {
                          try
                          {
                             lock.lock();
                             try
                             {
                                Character c;
                                while ((c = bq.poll()) == null)
                                {
                                   lock.unlock();
                                   Thread.sleep(50);
                                   lock.lock();
                                }
                                ch = c; // unboxing behind the scenes
                                System.out.println(ch + " consumed by consumer.");
                             }
                             catch (InterruptedException ie)
                             {
                                assert false;
                             }
                          }
                          finally
                          {
                             lock.unlock();
                          }
                       }
                       while (ch != 'Z');
                       executor.shutdownNow();
                    }
                 };
      executor.execute(consumer);
   }
}
