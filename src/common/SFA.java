package common;

import fa.walksets.APn;
import fa.walksets.An;
import fa.walksets.BPn;
import fa.walksets.Bn;
import fa.walksets.CPn;
import fa.walksets.Cn;

public class SFA
{
   // production line one
   An walksetAn = new An();
   Bn walksetBn = new Bn();
   Cn walksetCn = new Cn();

   // production line two
   APn walksetAPn = new APn();
   BPn walksetBPn = new BPn();
   CPn walksetCPn = new CPn();

   public SFA()
   {
      // starting state
      checkStartingState();
      printWalksets();
   }
   

   public void step()
   {
      System.out.println("========== step start ==========");
      // update walkset An
      if(walksetBn.getN()!= null)
      {
         walksetAn.addElement(walksetBn.cutN());
      }
      
      // update walkset Bn
      walksetBn.setN(walksetCn.cutLeftmostElement());
      
      // update walkset Cn
      // has already taken place during update Bn
      
      // update walkset APn
      if(walksetBPn.getN()!= null)
      {
         walksetAPn.addElement(walksetBPn.cutN());
      }
      
      // update walksetBPn
      walksetBPn.setN(walksetCPn.getLeftmostElement());
      
      // find wether n in Bn is prime
      if(walksetBn.getN() == 1)
      {
         walksetBPn.setN("1");
      }
      else
      {
         if(walksetBPn.getN().equals("L"))
         {
            walksetBPn.setN("P");
         }
      }
      
      // update walksetCPn
      walksetCPn.move();
      if(walksetBPn.getN().equals("P"))
      {
         walksetCPn.copy(walksetBn.getN());
         walksetCPn.change(walksetBn.getN());
      }
      
      printWalksets();
      System.out.println("========== step end ===========");
   }

   private void printWalksets()
   {
      walksetAn.print();
      walksetAPn.print();
      
      walksetBn.print();
      walksetBPn.print();
      
      walksetCn.print();
      walksetCPn.print();
   }


   private boolean checkStartingState()
   {
      if(!walksetAn.getList().isEmpty())
      {
         System.out.println("Error in starting state of An");
         return false;
      }
      
      if(walksetBn.cutN()!= null)
      {
         System.out.println("Error in starting state of Bn");
         return false;
      }
      
      if(walksetCn.getLeftmostElement() != 1)
      {
         System.out.println("Error in starting state of Cn");
         return false;
      }

      if(!walksetAPn.getList().isEmpty())
      {
         System.out.println("Error in starting state of APn");
         return false;
      }
      
      if(walksetBPn.getN()!= null)
      {
         System.out.println("Error in starting state of BPn");
         return false;
      }
      
      if(!walksetCPn.getLeftmostElement().equals("L"))
      {
         System.out.println("Error in starting state of CPn");
         return false;
      }
      
      return true;
   }

}
