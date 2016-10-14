// TypeSafety.java

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Employee
{
   private String name;
   Employee(String name)
   {
      this.name = name;
   }
   String getName()
   {
      return name;
   }
}
public class TypeSafety
{
   public static void main(String[] args)
   {
      List employees = new ArrayList();
      employees.add(new Employee("John Doe"));
      employees.add(new Employee("Jane Doe"));
      employees.add("Doe Doe");
      Iterator iter = employees.iterator();
      while (iter.hasNext())
      {
         Employee emp = (Employee) iter.next();
         System.out.println(emp.getName());
      }
   }
}
