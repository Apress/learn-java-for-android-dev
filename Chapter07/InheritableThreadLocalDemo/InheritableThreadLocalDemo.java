// InheritableThreadLocalDemo.java

public class InheritableThreadLocalDemo
{
   private static volatile InheritableThreadLocal<Integer> intVal =
     new InheritableThreadLocal<Integer>();
   public static void main(String[] args)
   {
      Runnable rP = new Runnable()
                    {
                       @Override
                       public void run()
                       {
                          intVal.set(new Integer(10));
                          Runnable rC = new Runnable()
                                        {
                                           public void run()
                                           {
                                              Thread thd;
                                              thd = Thread.currentThread();
                                              String name = thd.getName();
                                              System.out.println(name + " " +
                                                                 intVal.get());
                                           }
                                        };
                          Thread thdChild = new Thread(rC);
                          thdChild.setName("Child");
                          thdChild.start();
                       }
                    };
      new Thread(rP).start();
   }
}
