// CustomClassAndSortedSet.java

import java.util.SortedSet;
import java.util.TreeSet;

public class CustomClassAndSortedSet
{
   public static void main(String[] args)
   {
      SortedSet<Employee> sse = new TreeSet<Employee>();
      sse.add(new Employee("Sally Doe"));
      sse.add(new Employee("Bob Doe")); // ClassCastException thrown here
      sse.add(new Employee("John Doe"));
      System.out.println(sse);
   }
}
class Employee
{
   private String name;
   Employee(String name)
   {
      this.name = name;
   }
   @Override
   public String toString()
   {
      return name;
   }
}
