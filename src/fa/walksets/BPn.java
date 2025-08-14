package fa.walksets;

public class BPn implements walkset
{
   String n;

   public String getN()
   {
      return n;
   }

   public void setN(String n)
   {
      this.n = n;
   }

   public String cutN()
   {
      String copyOfN = n;
      n = null;
      return copyOfN;
   }

   @Override
   public void print()
   {
      System.out.println("BPn = < " + n + " >");
   }
}
