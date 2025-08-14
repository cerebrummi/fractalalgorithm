package fa.walksets;

import java.util.ArrayList;
import java.util.StringJoiner;

public class An implements Walkset
{
   private ArrayList<Integer> list = new ArrayList<>();

   public void addElement(int n)
   {
      list.add(n);
   }

   public ArrayList<Integer> getList()
   {
      return list;
   }

   @Override
   public void print()
   {
      String start = "An < ";
      StringJoiner joiner = new StringJoiner(",");
      for (int element : list)
      {
         joiner.add(String.valueOf(element));
      }
      String end = " >";
      System.out.println(start + joiner.toString() + end);
   }
}
