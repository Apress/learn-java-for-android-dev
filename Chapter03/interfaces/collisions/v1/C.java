// C.java

interface A
{
   int X = 1;
   void foo();
}
interface B
{
   int X = 1;
   int foo();
}
class C implements A, B
{
   public void foo();
   public int foo() { return X; }
}