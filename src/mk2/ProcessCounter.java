package mk2;

/**
 * @author aftab
 */

 public class ProcessCounter
{
     int totalProcess;
 
     public ProcessCounter()
    {
         totalProcess = -1;
    }
    
     public void increaseProcesses()
    {
         this.totalProcess++;
    }
     
     public int getTotalProcessesNo()
    {
         return this.totalProcess;
    }
     
     public void resetCounter()
    {
         this.totalProcess = -1;
    }
}