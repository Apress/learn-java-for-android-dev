// PrefsDemo.java

package ca.mb.javajeff.examples;

import java.util.prefs.Preferences;

public class PrefsDemo
{
   public static void main(String[] args)
   {
      Preferences prefs = Preferences.systemNodeForPackage(PrefsDemo.class);
      prefs.put("version", "1.0");
      System.out.println(prefs.get("version", "unknown"));
   }
}
