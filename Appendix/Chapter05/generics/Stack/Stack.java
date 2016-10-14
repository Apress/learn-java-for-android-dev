// Stack.java

class StackEmptyException extends Exception
{
}
class StackFullException extends Exception
{
}
public class Stack<E>
{
   private E[] elements;
   private int top;
   @SuppressWarnings("unchecked")
   public Stack(int size)
   {
      elements = (E[]) new Object[size];
      top = -1;
   }
   public void push(E element) throws StackFullException
   {
      if (top == elements.length-1)
         throw new StackFullException();
      elements[++top] = element;
   }
   E pop() throws StackEmptyException
   {
      if (isEmpty())
         throw new StackEmptyException();
      return elements[top--];
   }
   public boolean isEmpty()
   {
      return top == -1;
   }
   public static void main(String[] args)
      throws StackFullException, StackEmptyException
   {
      Stack<String> stack = new Stack<String>(5);
      assert stack.isEmpty();
      stack.push("A");
      stack.push("B");
      stack.push("C");
      stack.push("D");
      stack.push("E");
      // Uncomment the following line to generate a StackFullException.
      //stack.push("F");
      while (!stack.isEmpty())
         System.out.println(stack.pop());
      // Uncomment the following line to generate a StackEmptyException.
      //stack.pop();
      assert stack.isEmpty();
   }
}
