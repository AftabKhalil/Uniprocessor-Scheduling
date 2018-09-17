package mk2;

import java.util.LinkedList;

/**
 * @author aftab
 */
 public class HRRN
{
     public HRRN()
    {
          
    }
    
     public static int returnProcess(LinkedList processes)
    {
         Process[] p = new Process[processes.size()];
         int maxHRR = -1;
         int maxJob = -1;
         
         for (int i = 0; i < p.length; i++)
        {
             p[i] = (Process) processes.get(i);
        }
         
         if(p.length>=1)
        {
             maxHRR = p[0].getResponseRatio();
             maxJob = 0;
        }
         
         for (int i = 0; i < p.length; i++)
        {
             if(maxHRR < p[i].getResponseRatio())
            {
                 maxHRR = p[i].getResponseRatio();
                 maxJob = i;
            }
        }
         
         return maxJob;
    }
}