package fa.walksets;

import java.util.ArrayList;
import java.util.StringJoiner;

public class APn implements walkset
{
   ArrayList<String> list = new ArrayList<>();

   public void addElement(String n)
   {
      list.add(n);
   }

   public ArrayList<String> getList()
   {
      return list;
   }

   @Override
   public void print()
   {
      String start = "APn < ";
      StringJoiner joiner = new StringJoiner(",");
      for (String element : list)
      {
         joiner.add(String.valueOf(element));
      }
      String end = " >";
      System.out.println(start + joiner.toString() + end);
   }
}
