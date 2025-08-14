package fa.walksets;

public class Bn implements Walkset
{
   private Integer n;

   public Integer cutN()
   {
      Integer copyOfN = n;
      n = null;
      return copyOfN;
   }

   public Integer getN()
   {
      return n;
   }

   public void setN(int n)
   {
      this.n = n;
   }

   @Override
   public void print()
   {
      System.out.println("Bn = < " + (n == null ? "" : n) + " >");
   }
}
