package fa.walksets;

public class Cn implements walkset
{
   int leftmostElement = 1;

   public int cutLeftmostElement()
   {
      return leftmostElement++;
   }
   
   public int getLeftmostElement()
   {
      return leftmostElement;
   }

   @Override
   public void print()
   {
      System.out.println("Cn = < " + leftmostElement + ", ... infinity >");
   }
}