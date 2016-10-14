// PipedStreamsDemo.java

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedInputStream;

public class PipedStreamsDemo
{
   public static void main(String[] args) throws IOException
   {
      final PipedOutputStream pos = new PipedOutputStream();
      final PipedInputStream pis = new PipedInputStream(pos);
      Runnable senderTask = new Runnable()
                            {
                              final static int LIMIT = 10;
                              public void run()
                              {
                                 try
                                 {
                                    for (int i = 0 ; i < LIMIT; i++)
                                       pos.write((byte)(Math.random()*256));
                                 }
                                 catch (IOException ioe)
                                 {
                                    ioe.printStackTrace();
                                 }
                                 finally
                                 {
                                    try
                                    {
                                       pos.close();
                                    }
                                    catch (IOException ioe)
                                    {
                                       ioe.printStackTrace();
                                    }
                                 }
                              }
                            };
      Runnable receiverTask = new Runnable()
                              {
                                 public void run()
                                 {
                                    try
                                    {
                                       int b;
                                       while ((b = pis.read()) != -1)
                                          System.out.println(b);
                                    }
                                    catch (IOException ioe)
                                    {
                                       ioe.printStackTrace();
                                    }
                                    finally
                                    {
                                       try
                                       {
                                          pis.close();
                                       }
                                       catch (IOException ioe)
                                       {
                                          ioe.printStackTrace();
                                       }
                                    }
                                 }
                              };
      Thread sender = new Thread(senderTask);
      Thread receiver = new Thread(receiverTask);
      sender.start();
      receiver.start();
   }
}
