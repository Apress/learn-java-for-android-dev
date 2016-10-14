// ToDoList.java

public class ToDoList
{
   private ToDo[] toDoList;
   private int index = 0;
   public ToDoList(int size)
   {
      toDoList = new ToDo[size];
   }
   public Iterator iterator()
   {
      class Iter implements Iterator
      {
         int index = 0;
         public boolean hasMoreElements()
         {
            return index < toDoList.length;
         }
         public Object nextElement()
         {
            return toDoList[index++];
         }
      }
      return new Iter();
   }
   public void add(ToDo item)
   {
      toDoList[index++] = item;
   }
}
