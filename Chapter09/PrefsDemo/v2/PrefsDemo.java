// PrefsDemo.java

import java.util.prefs.Preferences;

public class PrefsDemo
{
   public static void main(String[] args)
   {
      Preferences prefs = Preferences.userNodeForPackage(PrefsDemo.class);
      prefs.put("SearchEngineURL", "http://www.google.com");
      System.out.println(prefs.get("SearchEngineURL", "http://www.bing.com"));
   }
}
