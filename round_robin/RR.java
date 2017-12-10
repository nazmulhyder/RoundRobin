package round_robin;

import java.util.ArrayDeque;
public class  RR{

    /**
     *  Created by nazmulhyder on 10/12/17
     */

    static ArrayDeque <Process> processQueue = new ArrayDeque<Process>();
    static ArrayDeque <Process> readyQueue = new ArrayDeque<Process>();
    static GlobalTimer globalTimer = new GlobalTimer(0);

    public static void main(String[] args) {

        processQueue.add(new Process(1,0,3,globalTimer));
        processQueue.add(new Process(2,0,5,globalTimer));
        processQueue.add(new Process(3,0,6,globalTimer));
        processQueue.add(new Process(4,0,4,globalTimer));

        while(!readyQueue.isEmpty() || !processQueue.isEmpty()){

                if (checkNewProcessArrieve()){

                    while (!processQueue.isEmpty() && processQueue.element().getArrivalTime() < globalTimer.time){

                        readyQueue.add(processQueue.poll());
                    }


                }

                if (!readyQueue.isEmpty())

                   runProcessInCpu();
                else {

                    System.out.println("no process is in the ready queue!");
                    System.out.println("Global Time : "+globalTimer.time);
                    globalTimer.time++;
                }
            }





        }

        public static boolean checkNewProcessArrieve(){

        if (!processQueue.isEmpty()){
            if (processQueue.element().getArrivalTime() < globalTimer.time )
            return true;

    }

    return false;
    }



    public static void runProcessInCpu(){

        Process process = readyQueue.poll();
        globalTimer.allotTime(2);
        process.runProcess();
        if (process.counter< process.duration){
            readyQueue.add(process);

        }
    }

}
