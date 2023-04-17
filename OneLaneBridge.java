import java.util.ArrayList;
public class OneLaneBridge extends Bridge{
    protected int limit = 0;
    private Object limitReached = new Object();
public void arrive(Car car) throws InterruptedException{
    synchronized(limitReached){
        while(bridge.size()>=limit||direction!=car.getDirection()){
           
            try{
                limitReached.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    
    if(bridge.size()==0){
        direction = car.getDirection();
    }
        bridge.add(car);
        car.setEntryTime(this.currentTime);
        System.out.println(this.toString());
        this.currentTime++;
    }
}
public void exit(Car car) throws InterruptedException{
    synchronized (limitReached){
         while(car.getID()!=bridge.get(0).getID()){
        try{
                limitReached.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        
    }
    bridge.remove(0);
    System.out.println(this.toString());
    if(bridge.size() ==0){
        direction = !direction;
    }
    limitReached.notifyAll();
    }
}
public String toString(){
String toString = "Bridge (dir =" + this.direction + "): " + this.bridge.toString() + "Bridge size = ";
return toString;
}
public int size(){
    return this.bridge.size();
}
public void setLimit(int limit){
    this.limit = limit;
}
}