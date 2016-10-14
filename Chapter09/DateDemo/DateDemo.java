// DateDemo.java

import java.util.Date;

class DateDemo
{
   public static void main(String[] args)
   {
      Date now = new Date();
      System.out.println(now);
      Date later = new Date(now.getTime()+86400);
      System.out.println(later);
      System.out.println(now.after(later));
      System.out.println(now.before(later));
   }
}
