// SystemTasks.java

public class SystemTasks
{
   public static void main(String[] args)
   {
      int[] grades = { 86, 92, 78, 65, 52, 43, 72, 98, 81 };
      int[] gradesBackup = new int[grades.length];
      System.arraycopy(grades, 0, gradesBackup, 0, grades.length);
      for (int i = 0; i < gradesBackup.length; i++)
         System.out.println(gradesBackup[i]);
      System.out.println("Current time: " + System.currentTimeMillis());
      String[] propNames =
      {
         "java.vendor.url",
         "java.class.path",
         "user.home",
         "java.class.version",
         "os.version",
         "java.vendor",
         "user.dir",
         "user.timezone",
         "path.separator",
         "os.name",
         "os.arch",
         "line.separator",
         "file.separator",
         "user.name",
         "java.version",
         "java.home"
      };
      for (int i = 0; i < propNames.length; i++)
         System.out.println(propNames[i] + ": " +
                            System.getProperty(propNames[i]));
   }
}
