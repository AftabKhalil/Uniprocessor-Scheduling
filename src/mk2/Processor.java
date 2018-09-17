package mk2;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author aftab
 */
 public class Processor
{
     private final LinkedList processes;
     private final LinkedList processesEnd;
     public int currentQuantum;
     private final QuantumIncreaser q;
     private Process currentProcess = null;
     private int method;
     public Executer e;
     
     private static boolean firstProcessSubmitted = false; 
     
     public Processor()
    {
         this.method = 1;
         processes = new LinkedList();
         processesEnd = new LinkedList();
         currentQuantum = 0;
         e = new Executer();
         //e.executer.start();
         q = new QuantumIncreaser();  
    }
     public void setMethod(int method)
    {
         this.method = method;
    }
     
     public void addProcess(int totalInstructions)
    {
         Process p = new Process(totalInstructions,this.currentQuantum);
         processes.add(p);
         processesEnd.add(p);
         System.out.println(p);
         
         if(!firstProcessSubmitted)
        {
             e.executer.start();
             q.startQuantumIncreaser();
             Processor.firstProcessSubmitted = true;
        }
    }
     
     public String getMethod()
    {
         switch (this.method) {
             case 1:
                 return "FCFS";
             case 2:
                 return "SJF";
             case 3:
                 return "HRRN";
             default:
                 return "SRT";
         }
    }
     
     public LinkedList getAllProcesses()
    {
         return processes;
    }
     
     public Process getCurrentProcess()
    {
        if(this.currentProcess!=null)
        {
           //System.out.println("Not Null");
         return currentProcess;
        }
        else
        {
            //System.out.println("Null");
            return null;
        }
    }

     LinkedList getWholeProcesses()
    {
        return this.processesEnd;
    }

    void stopQuantum() {
        this.q.quantumIncreaser.stop();
    }
     
     public class Executer implements Runnable
    {
         public Thread executer;
         
         public Executer()
        {
             this.executer = new Thread(this);
        }
         
        @Override
         public void run()
        {
            int runProcess = -1;
            
            if(method!=4)
            {
                while(true)
                {
             
                    //System.out.println("Total Processes in rd "+processes.size());
                    switch(method)
                   {
                         case 1:
                                     runProcess = FCFS.returnProcess(processes);
                                     break;
                        case 2:
                                     runProcess = SJF.returnProcess(processes);
                                     break;
                        case 3:
                                     runProcess = HRRN.returnProcess(processes);
                               break;
                   }

                     currentProcess = null;                
                     if(runProcess >=0 )
                    {
                         currentProcess = (Process) processes.get(runProcess);
                         // System.out.println(currentProcess.toString());

                         if(!currentProcess.isStarted())
                        {
                             currentProcess.startExecution(currentQuantum);
                        }

                         for (int i = 0; i < currentProcess.getTotalInstruction(); i++)
                        {
                             currentProcess.ExecuteInstruction();
                             processes.set(runProcess, currentProcess);
                             processesEnd.set(currentProcess.getProcessId(), currentProcess);
                             System.out.println("\nCurrent process Id : "+currentProcess.getProcessId());
                             System.out.println("Current process incomeTime : "+currentProcess.getIncomeTime());
                             System.out.println("Current process startTime : "+currentProcess.getStartQuantum());
                             System.out.println("Current process remaining instruction : "+currentProcess.getRemainingInstructions());
                             System.out.println("Quantum was " + currentQuantum+"\n");

                             try {
                                 Thread.sleep(1000);
                             } catch (InterruptedException ex) {
                                 Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                             }
                        }

                         if(currentProcess.isExecuted())
                        {
                             processes.remove(runProcess);
                             
                             currentProcess.setExitTime(currentQuantum);
                             processesEnd.set(currentProcess.getProcessId(), currentProcess);
                        }                         
                    }
                     else
                    {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
             else
            {
                 while(true)
                {
                     runProcess = SRT.returnProcess(processes);
                     //System.out.println("I got "+runProcess);
                     currentProcess = null;
                     
                     if(runProcess >=0)
                    {
                         currentProcess = (Process) processes.get(runProcess);
                         // System.out.println(currentProcess.toString());

                         if(!currentProcess.isStarted())
                        {
                             currentProcess.startExecution(currentQuantum);
                        }
                         
                         currentProcess.ExecuteInstruction();
                         processes.set(runProcess, currentProcess);
                         processesEnd.set(currentProcess.getProcessId(), currentProcess);
                         System.out.println("\nCurrent process Id : "+currentProcess.getProcessId());
                         System.out.println("Current process incomeTime : "+currentProcess.getIncomeTime());
                         System.out.println("Current process startTime : "+currentProcess.getStartQuantum());
                         System.out.println("Current process remaining instruction : "+currentProcess.getRemainingInstructions());
                         System.out.println("Quantum was " + currentQuantum+"\n");
                         
                         if(currentProcess.isExecuted())
                        {
                             processes.remove(runProcess);
                             currentProcess.setExitTime(currentQuantum);
                             processesEnd.set(currentProcess.getProcessId(), currentProcess);
                        }
                         
                         try {
                             Thread.sleep(1000);
                         } catch (InterruptedException ex) {
                             Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    }
                     else
                    {
                         try {
                             Thread.sleep(100);
                         } catch (InterruptedException ex) {
                             Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                         }
                    }
                }
            }
        }
    }
     
     private void increaseQuantum()
    {
         this.currentQuantum++;
    }
     
     public class QuantumIncreaser implements Runnable
    {
          private final Thread quantumIncreaser;
          
         public QuantumIncreaser()
        {
             quantumIncreaser = new Thread(this);
        }
         
         public void startQuantumIncreaser()
        {
             quantumIncreaser.start();
        }

         @Override
         public void run()
        {
             while(true)
            {
                 try
                {
                     Thread.sleep(999);
                }
                 catch (InterruptedException ex)
                {
                     JOptionPane.showMessageDialog(null, ex);
                }
                 increaseQuantum();
            }
        } 
    }
}