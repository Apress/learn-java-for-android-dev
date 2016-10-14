// ACDemo.java

interface Speakable
{
   void speak();
}
public class ACDemo
{
   public static void main(final String[] args)
   {
      new Speakable()
      {
         String msg = (args.length == 1) ? args[0] : "nothing to say";
         public void speak()
         {
            System.out.println(msg);
         }
      }
      .speak();
   }
}
