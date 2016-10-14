// C.java

class A
{
}
class B extends A
{
   void d() {}
}
class C
{
   public static void main(String[] args)
   {
      A a = new A();
      B b = (B) a;
      b.d();
   }
}
