// SerializationDemo.java

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.StringTokenizer;

class SerializableStringTokenizer extends StringTokenizer
   implements Serializable
{
   SerializableStringTokenizer(String str)
   {
      super(str);
   }
   SerializableStringTokenizer(String str, String delim)
   {
      super(str, delim);
   }
   SerializableStringTokenizer(String str, String delim,
                                      boolean returnDelims)
   {
      super(str, delim, returnDelims);
   }
}
public class SerializationDemo
{
   public static void main(String[] args)
   {
      try
      {
         SerializableStringTokenizer sst;
         sst = new SerializableStringTokenizer("The quick brown fox");
         System.out.println("Number of tokens = " + sst.countTokens());
         System.out.println("First token = " + sst.nextToken());
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(baos);
         oos.writeObject(sst);
         oos.close();
         System.out.println("sst object written to byte array");
         ByteArrayInputStream bais;
         bais = new ByteArrayInputStream(baos.toByteArray());
         ObjectInputStream ois = new ObjectInputStream(bais);
         Object o = ois.readObject();
         System.out.println("sst object read from byte array");
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
