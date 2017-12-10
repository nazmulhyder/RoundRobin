package round_robin;


public class Process {
    int id;
    int arrivalTime;
    int counter;
    int duration;
    GlobalTimer globalTimer;


    public Process(int id,int arrivalTime, int duration, GlobalTimer globalTimer){
        this.id=id;
        this.arrivalTime=arrivalTime;
        this.duration=duration;
        this.globalTimer = globalTimer;
        this.counter = 0;

    }

    public void runProcess(){

        for(; counter<duration && globalTimer.time < globalTimer.allotedTime ; counter++){
            System.out.println("My process ID: "+id);
            System.out.println("Global time: "+globalTimer.time);
            globalTimer.time++;
        }

        if (counter == duration ){
            System.out.println("********Process Id: "+id + " completed its job********");

            }


    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getCounter() {
        return counter;
    }

    public GlobalTimer getGlobalTimer() {
        return globalTimer;
    }
}

