package mk2;

import java.util.LinkedList;

/**
 * @author aftab
 */
 public class SRT
{
     public SRT()
    {
          
    }
     
     public static int returnProcess(LinkedList processes)
    {
         Process[] p = new Process[processes.size()];
        // System.out.println("Searching shortestt job in "+p.length);
         int shortestJob=-1;
         int shortestInstructions=-1;

         for (int i = 0; i < p.length; i++)
        {
             p[i] = (Process) processes.get(i);
        }
         
         if(p.length>=1)
        {
             shortestInstructions = p[0].getRemainingInstructions();
             shortestJob = 0;
        }
         
         for (int i = 0; i < p.length; i++)
        {
            // System.out.println("p["+i+"] has rmainig ins = "+p[i].getRemainingInstructions());
             if(shortestInstructions > p[i].getRemainingInstructions())
             {
                 shortestInstructions = p[i].getRemainingInstructions();
                 shortestJob = i;
             }
        }
        // System.out.println("\nI am retumning job no "+shortestJob);
         return shortestJob;
    }
}