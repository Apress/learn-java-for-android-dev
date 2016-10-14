// TestMedia.java

import java.io.IOException;

public class TestMedia
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java TestMedia mp3path");
         return;
      }
      try
      {
         Media.ID3 id3Info = Media.getID3Info(args[0]);
         if (id3Info == null)
         {
            System.err.printf("%s not MP3 or has no ID3 block%n", args[0]);
            return;
         }
         System.out.println("Song title = " + id3Info.getSongTitle());
         System.out.println("Artist = " + id3Info.getArtist());
         System.out.println("Album = " + id3Info.getAlbum());
         System.out.println("Year = " + id3Info.getYear());
         System.out.println("Comment = " +id3Info.getComment());
         System.out.println("Track = " + id3Info.getTrack());
         System.out.println("Genre = " + id3Info.getGenre());
      }
      catch (IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
}
