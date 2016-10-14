// CopyList.java

import java.util.ArrayList;
import java.util.List;

public class CopyList
{
   public static void main(String[] args)
   {
      List<String> ls1 = new ArrayList<String>();
      ls1.add("first");
      ls1.add("second");
      ls1.add("third");
      List<String> ls2 = new ArrayList<String>();
      copyList(ls1, ls2);
   }
   static void copyList(List<? extends String> list1, List<? super String> list2)
   {
      for (int i = 0; i < list1.size(); i++)
         list2.add(list1.get(i));
   }
}
