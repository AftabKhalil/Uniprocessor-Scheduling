package mk2;

import static mk2.MK2.mk2;

/**
 * @author aftab
 */

 public class Process
{

     private int processId;
     private int totalInstructions;
     private int instructionsExecuted;
     private int incomeQuantum;
     private int startQuantum;
     private boolean isExecuted;
     private boolean isStarted;
     private int exitTime;
     
     public Process(int totalInstructions, int incomeQuantum)
    {   
         mk2.pc.increaseProcesses();
         this.processId = mk2.pc.getTotalProcessesNo();
         System.out.println("The process id is "+mk2.pc.getTotalProcessesNo());
         this.totalInstructions = totalInstructions;
         this.incomeQuantum = incomeQuantum;
         this.isStarted = false;
         
         startQuantum = -1;
         instructionsExecuted = 0;
    }
     
     public void ExecuteInstruction()
    {
         this.instructionsExecuted++;
         if(this.instructionsExecuted == this.totalInstructions)
        {
             this.isExecuted = true;
        }
    }
     
     public boolean isExecuted()
    {
         return this.isExecuted;
    }
     
     public void startExecution(int startQuantum)
    {
         this.startQuantum = startQuantum;
         this.isStarted = true;
    }
     public boolean isStarted()
    {
         return this.isStarted;
    }
     public int getIncomeTime()
    {
         return this.incomeQuantum;
    }
     public int getProcessId()
    {
         return this.processId;
    }
     public int getStartQuantum()
    {
         return this.startQuantum;
    }

     int getTotalInstruction()
    {
        return this.totalInstructions;
    }

    public int getExecutedInstructions()
    {
        return this.instructionsExecuted;
    }
    
    public int getRemainingInstructions()
   {
        return this.totalInstructions - this.instructionsExecuted;
   }

     public int getWaitTime()
    {
        return mk2.processor.currentQuantum - this.incomeQuantum;
    }
     
     public int getResponseRatio()
    {
         return (this.getWaitTime()+this.getTotalInstruction())/this.getTotalInstruction();
    }

     public void setExitTime(int endQuantum) {
        this.exitTime = endQuantum;
    }
    
     public int getExitTime()
    {
         return this.exitTime;
    }
}