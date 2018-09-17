package mk2;

import java.util.LinkedList;

/**
 * @author aftab
 */
 public class SJF
{
     public void SJF()
    {
          
    }
     
     public static int returnProcess(LinkedList processes)
    {
    
         Process[] p = new Process[processes.size()];
         int minInstructions = -1;
         int minJob = -1;
         
        
         
         for (int i = 0; i < p.length; i++)
        {
             p[i] = (Process) processes.get(i);
        }
     
         if(p.length>=1)
        {
             minInstructions = p[0].getTotalInstruction();
             minJob = 0;
        }         
         
         for (int i = 0; i < p.length; i++) {
            
             if(minInstructions > p[i].getTotalInstruction())
            {
                 minInstructions = p[i].getTotalInstruction();
                 minJob = i;
            }
        }
         return minJob;
    }      
 }