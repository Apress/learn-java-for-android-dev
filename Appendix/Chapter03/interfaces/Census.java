// Census.java

public class Census
{
   public final static int SIZE = 4;
   private String[] IDs;
   private int[] counts;
   public Census()
   {
      IDs = new String[SIZE];
      counts = new int[SIZE];
   }
   public String get(int index)
   {
      return IDs[index] + " " + counts[index];
   }
   public void update(String ID)
   {
      for (int i = 0; i < IDs.length; i++)
      {
         // If ID not already stored in the IDs array (which is indicated by
         // the first null entry that is found), store ID in this array, and
         // also assign 1 to the associated element in the counts array, to 
         // initialize the census for that ID.
         if (IDs[i] == null)
         {
            IDs[i] = ID;
            counts[i] = 1;
            return;
         }

         // If a matching ID is found, increment the associated element in
         // the counts array to update the census for that ID.
         if (IDs[i].equals(ID))
         {
            counts[i]++;
            return;
         }
      }
   }
}
