// SerializationDemo.java

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.StringTokenizer;

class SerializableStringTokenizer implements Serializable
{
   private StringTokenizer st;
   private String str, delim;
   private boolean returnDelims;
   SerializableStringTokenizer(String str)
   {
      this(str, null, false);
   }
   SerializableStringTokenizer(String str, String delim)
   {
      this(str, delim, false);
   }
   SerializableStringTokenizer(String str, String delim,
                                      boolean returnDelims)
   {
      this.str = str;
      this.delim = delim;
      this.returnDelims = returnDelims;
      st = new StringTokenizer(str, delim, returnDelims);
   }
   private void writeObject(ObjectOutputStream oos) throws IOException
   {
      oos.writeUTF(str);
      oos.writeUTF(delim);
      oos.writeBoolean(returnDelims);
   }
   private void readObject(ObjectInputStream ois)
      throws ClassNotFoundException, IOException
   {
      str = ois.readUTF();
      delim = ois.readUTF();
      returnDelims = ois.readBoolean();
      st = new StringTokenizer(str, delim, returnDelims);
   }
   public int countTokens()
   {
      return st.countTokens();
   }
   public String nextToken()
   {
      return st.nextToken();
   }
}
public class SerializationDemo
{
   public static void main(String[] args)
   {
      try
      {
         SerializableStringTokenizer sst;
         sst = new SerializableStringTokenizer("A,B,C,D", ",", true);
         System.out.println("Number of tokens = " + sst.countTokens());
         System.out.println("First token = " + sst.nextToken());
         System.out.println("Second token = " + sst.nextToken());
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(baos);
         oos.writeObject(sst);
         oos.close();
         System.out.println("sst object written to byte array");
         ByteArrayInputStream bais;
         bais = new ByteArrayInputStream(baos.toByteArray());
         ObjectInputStream ois = new ObjectInputStream(bais);
         sst = (SerializableStringTokenizer) ois.readObject();
         System.out.println("sst object read from byte array");
         System.out.println("Number of tokens = " + sst.countTokens());
         System.out.println("First token = " + sst.nextToken());
         System.out.println("Second token = " + sst.nextToken());
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
