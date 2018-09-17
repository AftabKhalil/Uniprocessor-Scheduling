package mk2;

import java.util.LinkedList;

/**
 * @author aftab
 */
 
 public class Calculator
{
     public void Calculator()
    {
         
    }
     
     static String calculate(LinkedList processes)
    {        
         int t = processes.size();
         if(t==0)
        {
            return "";
        }
         
         String Return = "";
         
         Process[] p = new Process[t];
         int TurnAround;
         float avgTT = 0;
         int WaitTime;
         float avgW = 0;
         float Utilization, avgU = 0;
         
         for (int i = 0; i < p.length; i++)
        {
             p[i] = (Process) processes.get(i);
        }
         //.out.println("\t\tP_Id\tArrival Time\tService Time\tStart Time\tExit Time\tTurnAround\tWait Time\tUtilization");
         Return = Return.concat("\t\tP_Id\tArrival Time\tService Time\tStart Time\tExit Time\tTurnAround\tWait Time\tUtilization\n");
         for (int i = 0; i < p.length; i++)
        {
             TurnAround = p[i].getExitTime()- p[i].getIncomeTime();
             avgTT = avgTT + TurnAround;
             WaitTime = p[i].getStartQuantum()- p[i].getIncomeTime();
             avgW = avgW + WaitTime;
             Utilization = (float) p[i].getTotalInstruction()/TurnAround;
             avgU = avgU + Utilization;
             //System.out.println("\t\t"+p[i].getProcessId()+"\t"+p[i].getIncomeTime()+"\t\t"+p[i].getTotalInstruction()+"\t\t"+p[i].getStartQuantum()+"\t\t"+p[i].getExitTime()+"\t\t"+TurnAround+"\t\t"+WaitTime+"\t\t"+Utilization);
        
             Return = Return.concat("\t\t"+p[i].getProcessId()+"\t"+p[i].getIncomeTime()+"\t"+p[i].getTotalInstruction()+"\t"+p[i].getStartQuantum()+"\t"+p[i].getExitTime()+"\t"+TurnAround+"\t"+WaitTime+"\t"+Utilization+"\n");
        }
         avgTT = (float)avgTT/t;
         avgW  = (float)avgW/t;
         avgU  = (float)avgU/t;
         
         //System.out.println("Averrage:\t\t\t\t\t\t\t\t\t\t"+String.format("%.2f", avgTT)+"\t\t"+String.format("%.2f", avgW)+"\t\t"+String.format("%.2f", avgU));
         Return = Return.concat("Averrage:\t\t\t\t\t\t\t"+String.format("%.2f", avgTT)+"\t"+String.format("%.2f", avgW)+"\t"+String.format("%.2f", avgU));
         
        // System.out.println(Return);
         return Return;
    
    }
}