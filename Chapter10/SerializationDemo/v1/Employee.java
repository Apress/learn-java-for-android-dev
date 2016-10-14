// Employee.java

public class Employee implements java.io.Serializable
{
   private String name;
   private int age;
   public Employee(String name, int age)
   {
      this.name = name;
      this.age = age;
   }
   public String getName() { return name; }
   public int getAge() { return age; }
}
