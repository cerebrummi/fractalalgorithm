package fa.walksets;

import enums.Symbol;

public class BPn implements Walkset
{
   private Symbol n;

   public Symbol getN()
   {
      return n;
   }

   public void setN(Symbol n)
   {
      this.n = n;
   }

   public Symbol cutN()
   {
      Symbol copyOfN = n;
      n = null;
      return copyOfN;
   }

   @Override
   public String toString()
   {
      return "BPn = < " + (n == null ? "" : n.name()) + " >";
   }
}
