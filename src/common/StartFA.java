package common;

public class StartFA
{
   public static void main(String[] args)
   {
      SFA sfa = new SFA();
      
      for( int i = 0 ; i < 8; i++)
      {
         System.out.println("========== step start ==========");
         sfa.step();
         System.out.println("========== step end ===========");
      }
   }
}

