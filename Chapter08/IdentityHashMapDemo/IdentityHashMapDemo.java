// IdentityHashMapDemo.java

import java.util.IdentityHashMap;
import java.util.HashMap;
import java.util.Map;

public class IdentityHashMapDemo
{
   public static void main(String[] args)
   {
      Map<Employee, String> map1 = new IdentityHashMap<Employee, String>();
      Map<Employee, String> map2 = new HashMap<Employee, String>();
      Employee e1 = new Employee("John Doe", 28);
      map1.put(e1, "SALES");
      System.out.println(map1);
      Employee e2 = new Employee("Jane Doe", 26);
      map2.put(e2, "MGMT");
      System.out.println(map2);
      System.out.println("map1 contains key e1 = " + map1.containsKey(e1));
      System.out.println("map2 contains key e2 = " + map2.containsKey(e2));
      e1.setAge(29);
      e2.setAge(27);
      System.out.println(map1);
      System.out.println(map2);
      System.out.println("map1 contains key e1 = " + map1.containsKey(e1));
      System.out.println("map2 contains key e2 = " + map2.containsKey(e2));
   }
}
class Employee
{
   private String name;
   private int age;
   Employee(String name, int age)
   {
      this.name = name;
      this.age = age;
   }
   @Override
   public boolean equals(Object o)
   {
      if (!(o instanceof Employee))
         return false;
      Employee e = (Employee) o;
      return e.name.equals(name) && e.age == age;
   }
   @Override
   public int hashCode()
   {
      int hashCode = 19;
      hashCode = hashCode*31+name.hashCode();
      hashCode = hashCode*31+age;
      return hashCode;
   }
   void setAge(int age)
   {
      this.age = age;
   }
   void setName(String name)
   {
      this.name = name;
   }
   @Override
   public String toString()
   {
      return name + " " + age;
   }
}
