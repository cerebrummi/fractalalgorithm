package common;

public class StartSieves
{

   public static void main(String[] args)
   {
      SFA sfa = new SFA();
      System.out.println(sfa.getCurrentSieve());
      
      for( int i = 0 ; i < 8; i++)
      {
         sfa.step();
         if(sfa.isCurrentBnPrime())
         {
            System.out.println(sfa.getCurrentSieve());
         }
      }
   }

}
