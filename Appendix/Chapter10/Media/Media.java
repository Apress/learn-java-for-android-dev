// Media.java

/*

In 1996, Eric Kemp devised ID3, a small file format for storing metadata in
MP3 files. This metadata consisted of song title, artist, album, year,
comments, and genre; and was organized into a 128-byte block stored at the end
of the file.

The following table describes the format of ID3 version 1 (ID3v1).

Offset (decimal) Field Name      Field Size (byte)
================ ==========      =================
0                Signature (TAG) 3
3                Song title      30
33               Artist          30
63               Album           30
93               Year            4
97               Comment         30
127              Genre           1

Each field except for Genre is a string of ASCII characters. Strings are
padded on the right with zeros or spaces. An uninitialized field is equivalent
to the empty string ("").

In 1997, Michael Mutschler made a small improvement to ID3. Because the
Comment field is too small to write anything of use, he trimmed this field by
two bytes and used those bytes to store the CD track number where the song is
located.

If a track number is stored, the second-last byte of the Comment field is set
to 0 and the subsequent byte stores the track number. The resulting format is
known as ID3v1.1.

Offset (decimal) Field Name      Field Size (byte)
================ ==========      =================
0                Signature (TAG) 3
3                Song title      30
33               Artist          30
63               Album           30
93               Year            4
97               Comment         29 (last byte must be a binary 0)
126              Track (0-255)   1
127              Genre (0-255)   1  (255 means no genre)

Unlike most of the fields, Track and Genre are single-byte integer fields. The
legal values that can appear in the Genre field and their descriptions are
described in the following table:

 0 Blues          20 Alternative       40 AlternRock         60 Top 40
 1 Classic Rock   21 Ska               41 Bass               61 Christian Rap
 2 Country        22 Death Metal       42 Soul               62 Pop/Funk
 3 Dance          23 Pranks            43 Punk               63 Jungle
 4 Disco          24 Soundtrack        44 Space              64 Native American
 5 Funk           25 Euro-Techno       45 Meditative         65 Cabaret
 6 Grunge         26 Ambient           46 Instrumental Pop   66 New Wave
 7 Hip-Hop        27 Trip-Hop          47 Instrumental Rock  67 Psychedelic
 8 Jazz           28 Vocal             48 Ethnic             68 Rave
 9 Metal          29 Jazz+Funk         49 Gothic             69 Showtunes
10 New Age        30 Fusion            50 Darkwave           70 Trailer
11 Oldies         31 Trance            51 Techno-Industrial  71 Lo-Fi
12 Other          32 Classical         52 Electronic         72 Tribal
13 Pop            33 Instrumental      53 Pop-Folk           73 Acid Punk
14 R&B            34 Acid              54 Eurodance          74 Acid Jazz
15 Rap            35 House             55 Dream              75 Polka
16 Reggae         36 Game              56 Southern Rock      76 Retro
17 Rock           37 Sound Clip        57 Comedy             77 Musical
18 Techno         38 Gospel            58 Cult               78 Rock & Roll
19 Industrial     39 Noise             59 Gangsta            79 Hard Rock

WinAmp expanded this table with the following Genre codes:

80 Folk           92 Progressive Rock 104 Chamber Music     116 Ballad
81 Folk-Rock      93 Psychedelic Rock 105 Sonata            117 Power Ballad
82 National-Folk  94 Symphonic Rock   106 Symphony          118 Rhythmic Soul
83 Swing          95 Slow Rock        107 Booty Brass       119 Freestyle
84 Fast Fusion    96 Big Band         108 Primus            120 Duet
85 Bebob          97 Chorus           109 Porn Groove       121 Punk Rock
86 Latin          98 Easy Listening   110 Satire            122 Drum Solo
87 Revival        99 Acoustic         111 Slow Jam          123 A cappella
88 Celtic        100 Humour           112 Club              124 Euro-House
89 Bluegrass     101 Speech           113 Tango             125 Dance Hall
90 Avantgarde    102 Chanson          114 Samba
91 Gothic Rock   103 Opera            115 Folklore

Although there are probably additional defined codes, treat any other value
stored in the Genre field as Unknown.

To learn more about ID3 and new versions, visit the official site at id3.org.

*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Media
{
   public static class ID3
   {
      private String songTitle, artist, album, year, comment, genre;
      private int track; // -1 if track not present
      public ID3(String songTitle, String artist, String album, String year,
                 String comment, int track, String genre)
      {
         this.songTitle = songTitle;
         this.artist = artist;
         this.album = album;
         this.year = year;
         this.comment = comment;
         this.track = track;
         this.genre = genre;
      }
      String getSongTitle() { return songTitle; }
      String getArtist() { return artist; }
      String getAlbum() { return album; }
      String getYear() { return year; }
      String getComment() { return comment; }
      int getTrack() { return track; }
      String getGenre() { return genre; }
   }
   public static ID3 getID3Info(String mp3path) throws IOException
   {
      RandomAccessFile raf = null;
      try
      {
         raf = new RandomAccessFile(mp3path, "r");
         if (raf.length() < 128)
            return null; // Not MP3 file (way too small)
         raf.seek(raf.length()-128);
         byte[] buffer = new byte[128];
         raf.read(buffer);
         raf.close();
         if (buffer[0] != (byte) 'T' && buffer[1] != (byte) 'A' &&
             buffer[2] != (byte) 'G')
            return null; // No ID3 block (must start with TAG)
         String songTitle = new String(buffer, 3, 30);
         String artist = new String(buffer, 33, 30);
         String album = new String(buffer, 63, 30);
         String year = new String(buffer, 93, 4);
         String comment = new String(buffer, 97, 28);
         // buffer[126]&255 converts -128 through 127 to 0 through 255
         int track = (buffer[125] == 0) ? buffer[126]&255 : -1;
         String[] genres = new String[]
                           {
                              "Blues",
                              "Classic Rock",
                              "Country",
                              "Dance",
                              "Disco",
                              "Funk",
                              "Grunge",
                              "Hip-Hop",
                              "Jazz",
                              "Metal",
                              "New Age",
                              "Oldies",
                              "Other",
                              "Pop",
                              "R&B",
                              "Rap",
                              "Reggae",
                              "Rock",
                              "Techno",
                              "Industrial",
                              "Alternative",
                              "Ska",
                              "Death Metal",
                              "Pranks",
                              "Soundtrack",
                              "Euro-Techno",
                              "Ambient",
                              "Trip-Hop",
                              "Vocal",
                              "Jazz+Funk",
                              "Fusion",
                              "Trance",
                              "Classical",
                              "Instrumental",
                              "Acid",
                              "House",
                              "Game",
                              "Sound Clip",
                              "Gospel",
                              "Noise",
                              "AlternRock",
                              "Bass",
                              "Soul",
                              "Punk",
                              "Space",
                              "Meditative",
                              "Instrumental Pop",
                              "Instrumental Rock",
                              "Ethnic",
                              "Gothic",
                              "Darkwave",
                              "Techno-Industrial",
                              "Electronic",
                              "Pop-Folk",
                              "Eurodance",
                              "Dream",
                              "Southern Rock",
                              "Comedy",
                              "Cult",
                              "Gangsta",
                              "Top 40",
                              "Christian Rap",
                              "Pop/Funk",
                              "Jungle",
                              "Native American",
                              "Cabaret",
                              "New Wave",
                              "Psychedelic",
                              "Rave",
                              "Showtunes",
                              "Trailer",
                              "Lo-Fi",
                              "Tribal",
                              "Acid Punk",
                              "Acid Jazz",
                              "Polka",
                              "Retro",
                              "Musical",
                              "Rock & Roll",
                              "Hard Rock",
                              "Folk",
                              "Folk-Rock",
                              "National-Folk",
                              "Swing",
                              "Fast Fusion",
                              "Bebob",
                              "Latin",
                              "Revival",
                              "Celtic",
                              "Bluegrass",
                              "Avantegarde",
                              "Gothic Rock",
                              "Progressive Rock",
                              "Psychedelic Rock",
                              "Symphonic Rock",
                              "Slow Rock",
                              "Big Band",
                              "Chorus",
                              "Easy Listening",
                              "Acoustic",
                              "Humour",
                              "Speech",
                              "Chanson",
                              "Opera",
                              "Chamber Music",
                              "Sonata",
                              "Symphony",
                              "Booty Brass",
                              "Primus",
                              "Porn Groove",
                              "Satire",
                              "Slow Jam",
                              "Club",
                              "Tango",
                              "Samba",
                              "Folklore",
                              "Ballad",
                              "Power Ballad",
                              "Rhythmic Soul",
                              "Freestyle",
                              "Duet",
                              "Punk Rock",
                              "Drum Solo",
                              "A cappella",
                              "Euro-House",
                              "Dance Hall"
                           };
         assert genres.length == 126;
         String genre = (buffer[127] < 0 || buffer[127] > 125)
                        ? "Unknown" : genres[buffer[127]];
         return new ID3(songTitle, artist, album, year, comment, track, genre);
      }
      catch (IOException ioe)
      {
         if (raf != null)
            try
            {
               raf.close();
            }
            catch (IOException ioe2)
            {
               ioe2.printStackTrace();
            }
         throw ioe;
      }
   }
}
