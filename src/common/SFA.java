package common;

import java.util.List;

import enums.Symbol;
import fa.Sieve;
import fa.walksets.APn;
import fa.walksets.An;
import fa.walksets.BPn;
import fa.walksets.Bn;
import fa.walksets.CPn;
import fa.walksets.Cn;

public class SFA
{
   // production line one
   private An walksetAn = new An();
   private Bn walksetBn = new Bn();
   private Cn walksetCn = new Cn();

   // production line two
   private APn walksetAPn = new APn();
   private BPn walksetBPn = new BPn();
   private CPn walksetCPn = new CPn();

   public SFA()
   {
      // starting state
      checkStartingState();
   }
   

   public void step()
   {
      
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
         walksetBPn.setN(Symbol.ONE);
      }
      else
      {
         if(walksetBPn.getN().equals(Symbol.L))
         {
            walksetBPn.setN(Symbol.P);
         }
      }
      
      // update walksetCPn
      walksetCPn.move();
      if(walksetBPn.getN().equals(Symbol.P))
      {
         walksetCPn.copy(walksetBn.getN());
         walksetCPn.change(walksetBn.getN());
      }
   }
   
   public boolean isCurrentBnPrime()
   {
      return walksetBPn.getN().equals(Symbol.P);
   }

   public void printWalksets()
   {
      System.out.println(walksetAn);
      System.out.println(walksetAPn);
      
      System.out.println(walksetBn);
      System.out.println(walksetBPn);
      
      System.out.println(walksetCn);
      System.out.println(walksetCPn);
   }

   public Sieve getCurrentSieve()
   {
      Sieve sieve = new Sieve(walksetCPn.getCurrentSize());
      List<Symbol> listCPn = walksetCPn.getList();
      
      int index = walksetCn.getLeftmostElement();
      for(Symbol element : listCPn)
      {
         if(element.equals(Symbol.L))
         {
            sieve.addLEnvelope(index);
         }
         index++;
      }
      
      return sieve;
   }

   private boolean checkStartingState()
   {
      if(!walksetAn.getList().isEmpty())
      {
         System.out.println("Error in starting state of An");
         return false;
      }
      
      if(walksetBn.getN()!= null)
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
      
      if(!walksetCPn.getLeftmostElement().equals(Symbol.L))
      {
         System.out.println("Error in starting state of CPn");
         return false;
      }
      
      return true;
   }

}
