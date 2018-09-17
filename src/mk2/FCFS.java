package mk2;

import java.util.LinkedList;

/**
 * @author aftab
 */
public class FCFS {

    public FCFS() {

    }

    public static int returnProcess(LinkedList processes) {
        Process[] p = new Process[processes.size()];
        int runProcess = -1;

        for (int i = 0; i < p.length; i++) {
            p[i] = (Process) processes.get(i);
        }

        //System.out.println(" p lenght is "+p.length);
        if (p.length > 0) {
            int min = p[0].getIncomeTime();
            runProcess = 0;
            //System.out.println("min is "+min);

            for (int i = 0; i < p.length; i++) {
                if (p[i].getIncomeTime() < min) {
                    runProcess = i;
                }
            }
        }

        return runProcess;
    }
}
