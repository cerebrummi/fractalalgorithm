package fa.walksets;

import java.util.Arrays;
import java.util.LinkedList;

public class CPn implements walkset
{
   LinkedList<String> list = new LinkedList<>();
   
   public CPn()
   {
      list.add("L");
   }
   
   public void move()
   {
      String element = list.pollFirst();
      list.add(element);
   }
   
   public void copy(int n)
   {
      LinkedList<String> copiedList = new LinkedList<>();
      
      for(int i = 0; i < n; i++)
      {
         for(String element : list)
         {
            copiedList.add(element);
         }
      }
      
      list = copiedList;
   }
   
   public void change(int n)
   {
      LinkedList<String> copy = new LinkedList<>();
      for(String element: list)
      {
         copy.add(element);
      }
      int index = 1;
      for(int i = 0; i < copy.size(); i++)
      {
         if(index%n==0 && list.get(i).equals("L"))
         {
            list.set(i, "M");
         }
         index++;
      }
   }
   
   public String getLeftmostElement()
   {
      return list.getFirst();
   }

   @Override
   public void print()
   {
      System.out.println("CPn = < " + Arrays.toString(list.toArray()) + " >");
   }
}
