// ToDoList.java

public class ToDoList
{
   private ToDoArray toDoArray;
   private int index = 0;
   public ToDoList()
   {
      toDoArray = new ToDoArray(2);
   }
   public boolean hasMoreElements()
   {
      return index < toDoArray.size();
   }
   public ToDo nextElement()
   {
      return toDoArray.get(index++);
   }
   public void add(ToDo item)
   {
      toDoArray.add(item);
   }
   private class ToDoArray
   {
      private ToDo[] toDoArray;
      private int index = 0;
      ToDoArray(int initSize)
      {
         toDoArray = new ToDo[initSize];
      }
      void add(ToDo item)
      {
         if (index >= toDoArray.length)
         {
            ToDo[] temp = new ToDo[toDoArray.length*2];
            for (int i = 0; i < toDoArray.length; i++)
               temp[i] = toDoArray[i];
            toDoArray = temp;
         }
         toDoArray[index++] = item;
      }
      ToDo get(int i)
      {
         return toDoArray[i];
      }
      int size()
      {
         return index;
      }
   }
}
