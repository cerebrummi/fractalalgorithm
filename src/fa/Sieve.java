package fa;

import java.util.ArrayList;
import java.util.Arrays;

public class Sieve
{
   private Integer size;
   private final ArrayList<Integer> lEnvelopes;
   
   public Sieve(int size)
   {
      lEnvelopes = new ArrayList<>(size);
      this.size = size;
   }
   
   public void addLEnvelope(int l)
   {
      lEnvelopes.add(l);
   }

   public Integer getSize()
   {
      return size;
   }

   public ArrayList<Integer> getlEnvelopes()
   {
      return lEnvelopes;
   }
   
   @Override
   public String toString()
   {
      return "sieve size = " + size + " L-envelopes: " + Arrays.toString(lEnvelopes.toArray());
   }
}
