package round_robin;

public class GlobalTimer {

    int time;
    int allotedTime;

    public GlobalTimer(int initialTime){
        this.allotedTime = 0;
        this.time=initialTime;
    }

    public void allotTime(int x){
        this.allotedTime=this.time+x;
    }

}
