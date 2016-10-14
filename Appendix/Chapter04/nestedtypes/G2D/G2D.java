// G2D.java

public class G2D
{
   private Matrix xform;
   public G2D()
   {
      xform = new Matrix();
      xform.a = 1.0;
      xform.e = 1.0;
      xform.i = 1.0;
   }
   private class Matrix
   {
      double a, b, c;
      double d, e, f;
      double g, h, i;
   }
}
