package fa.walksets;

import java.util.Arrays;
import java.util.LinkedList;

import enums.Symbol;

public class CPn implements Walkset
{
   private LinkedList<Symbol> list = new LinkedList<>();
   
   public CPn()
   {
      list.add(Symbol.L);
   }
   
   public void move()
   {
      Symbol element = list.pollFirst();
      list.add(element);
   }
   
   public void copy(int n)
   {
      LinkedList<Symbol> copiedList = new LinkedList<>();
      
      for(int i = 0; i < n; i++)
      {
         for(Symbol element : list)
         {
            copiedList.add(element);
         }
      }
      
      list = copiedList;
   }
   
   public void change(int n)
   {
      LinkedList<Symbol> copy = new LinkedList<>();
      for(Symbol element: list)
      {
         copy.add(element);
      }
      int index = 1;
      for(int i = 0; i < copy.size(); i++)
      {
         if(index%n==0 && list.get(i).equals(Symbol.L))
         {
            list.set(i, Symbol.M);
         }
         index++;
      }
   }
   
   public Symbol getLeftmostElement()
   {
      return list.getFirst();
   }

   @Override
   public String toString()
   {
      return "CPn = < " + Arrays.toString(list.toArray()) + " >";
   }
}
