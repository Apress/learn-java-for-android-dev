// PropertyResourceBundleDemo.java

import java.util.ResourceBundle;

public class PropertyResourceBundleDemo
{
   public static void main(String[] args)
   {
      ResourceBundle resources = ResourceBundle.getBundle("game");
      System.out.println("elevator = " + resources.getString("elevator"));
   }
}
