// ImageCache.java

import java.lang.ref.SoftReference;

class Image
{
   private byte[] image;
   private Image(String name)
   {
      image = new byte[1024*100];
   }
   static Image getImage(String name)
   {
      return new Image(name);
   }
}
public class ImageCache
{
   final static int NUM_IMAGES = 200;
   @SuppressWarnings("unchecked")
   public static void main(String[] args)
   {
      String[] imageNames = new String[NUM_IMAGES];
      for (int i = 0; i < imageNames.length; i++)
         imageNames[i] = new String("image" + i + ".gif");

      SoftReference<Image>[] cache = new SoftReference[imageNames.length];
      for (int i = 0; i < cache.length; i++)
         cache[i] = new SoftReference<Image>(Image.getImage(imageNames[i]));

      for (int i = 0; i < cache.length; i++)
      {
         Image im = cache[i].get();
         if (im == null)
         {
            System.out.println(imageNames[i] + " not in cache");
            im = Image.getImage(imageNames[i]);
            cache[i] = new SoftReference<Image>(im);
         }
         System.out.println("Drawing image");
         im = null; // Remove strong reference to image.
      }
   }
}
