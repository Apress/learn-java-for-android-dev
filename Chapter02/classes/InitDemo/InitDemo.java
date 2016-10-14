// InitDemo.java

public class InitDemo
{
   static boolean bool1;
   boolean bool2;
   static byte byte1;
   byte byte2;
   static char char1;
   char char2;
   static double double1;
   double double2;
   static float float1;
   float float2;
   static int int1;
   int int2;
   static long long1;
   long long2;
   static short short1;
   short short2;
   static String string1;
   String string2;
   static
   {
      System.out.println("[class] bool1 = " + bool1);
      System.out.println("[class] byte1 = " + byte1);
      System.out.println("[class] char1 = " + char1);
      System.out.println("[class] double1 = " + double1);
      System.out.println("[class] float1 = " + float1);
      System.out.println("[class] int1 = " + int1);
      System.out.println("[class] long1 = " + long1);
      System.out.println("[class] short1 = " + short1);
      System.out.println("[class] string1 = " + string1);
      System.out.println();
   }
   {
      System.out.println("[instance] bool2 = " + bool2);
      System.out.println("[instance] byte2 = " + byte2);
      System.out.println("[instance] char2 = " + char2);
      System.out.println("[instance] double2 = " + double2);
      System.out.println("[instance] float2 = " + float2);
      System.out.println("[instance] int2 = " + int2);
      System.out.println("[instance] long2 = " + long2);
      System.out.println("[instance] short2 = " + short2);
      System.out.println("[instance] string2 = " + string2);
      System.out.println();
   }
   static
   {
      bool1 = true;
      byte1 = 127;
      char1 = 'A';
      double1 = 1.0;
      float1 = 2.0F;
      int1 = 1000000000;
      long1 = 1000000000000L;
      short1 = 32767;
      string1 = "abc";
   }
   {
      bool2 = true;
      byte2 = 127;
      char2 = 'A';
      double2 = 1.0;
      float2 = 2.0F;
      int2 = 1000000000;
      long2 = 1000000000000L;
      short2 = 32767;
      string2 = "abc";
   }
   InitDemo()
   {
      System.out.println("InitDemo() called");
      System.out.println();
   }
   static double double3 = 10.0;
   double double4 = 10.0;
   static
   {
      System.out.println("[class] double3 = " + double3);
      System.out.println();
   }
   {
      System.out.println("[instance] double4 = " + double3);
      System.out.println();
   }
   public static void main(String[] args)
   {
      System.out.println ("main() started");
      System.out.println();
      System.out.println("[class] bool1 = " + bool1);
      System.out.println("[class] byte1 = " + byte1);
      System.out.println("[class] char1 = " + char1);
      System.out.println("[class] double1 = " + double1);
      System.out.println("[class] double3 = " + double3);
      System.out.println("[class] float1 = " + float1);
      System.out.println("[class] int1 = " + int1);
      System.out.println("[class] long1 = " + long1);
      System.out.println("[class] short1 = " + short1);
      System.out.println("[class] string1 = " + string1);
      System.out.println();
      for (int i = 0; i < 2; i++)
      {
         System.out.println("About to create InitDemo object");
         System.out.println();
         InitDemo id = new InitDemo();
         System.out.println("id created");
         System.out.println();
         System.out.println("[instance] id.bool2 = " + id.bool2);
         System.out.println("[instance] id.byte2 = " + id.byte2);
         System.out.println("[instance] id.char2 = " + id.char2);
         System.out.println("[instance] id.double2 = " + id.double2);
         System.out.println("[instance] id.double4 = " + id.double4);
         System.out.println("[instance] id.float2 = " + id.float2);
         System.out.println("[instance] id.int2 = " + id.int2);
         System.out.println("[instance] id.long2 = " + id.long2);
         System.out.println("[instance] id.short2 = " + id.short2);
         System.out.println("[instance] id.string2 = " + id.string2);
         System.out.println();
      }
   }
}
