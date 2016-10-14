// ListResourceBundleDemo.java

import java.awt.EventQueue;
import java.awt.Image;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ListResourceBundleDemo
{
   public static void main(String[] args)
   {
      Locale l = Locale.CANADA;
      if (args.length == 2)
         l = new Locale(args[0], args[1]);
      final ResourceBundle resources = ResourceBundle.getBundle("flags", l);
      Runnable r = new Runnable()
                   {
                      public void run()
                      {
                         Image image = (Image) resources.getObject("flag");
                         String msg = resources.getString("msg");
                         String title = resources.getString("title");
                         ImageIcon ii = new ImageIcon(image);
                         JOptionPane.showMessageDialog(null,
                                                       msg,
                                                       title,
                                                       JOptionPane.PLAIN_MESSAGE,
                                                       ii);
                      }
                   };
      EventQueue.invokeLater(r);
   }
}
