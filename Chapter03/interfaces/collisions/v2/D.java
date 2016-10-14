// D.java

interface A
{
   int X = 1;
}
interface B
{
   double X = 2.0;
}
interface C extends A, B
{
}
class D implements C
{
   public void output()
   {
      System.out.println(X); // Which X is accessed?
   }
}