import java.util.*;

public class SwimmerUser extends User {
    
    public ArrayList<Event> events = new ArrayList<Event>();
    //public static int newEventCounter = 1;
    int newEventCount = 1;
    public SwimmerUser(int userNum, String name, String schoolName, String userType, ArrayList<Event> events){
        super(userNum, name, schoolName, userType);
        this.events = events;
    }
    /*
    private static int getEventCounter() {
        return newEventCounter;
    }
    
    private static void addEventCounter() {
        newEventCounter++;
    }
    */
    
    
    public void addEvent(double _25yard, double _50yard, double _100yard, double _400yard){
        
        Event newEvent = new Event(newEventCount, _25yard, _50yard, _100yard, _400yard);
        events.add(newEvent);
        newEventCount++;
        System.out.println(newEventCount);
        //addEventCounter();
    }

    public void deleteEvent(int id){
        for(int i = 0; i < events.size();i++){
            if(events.get(i).getEventId() == id){
                events.remove(i);
            }
        }
    }


    public Event getOneEventInfo(int id){
        
        for(int i = 0; i < events.size();i++){
            if(events.get(i).getEventId() == id){
                return events.get(i);
            }
        }
        return(null);
    }

    public double getBest25Time(){
        double shortestime = 90000;
        for(int i = 0; i < events.size();i++){
            if(events.get(i).get25yardTime() < shortestime){
                shortestime = events.get(i).get25yardTime();
            }
        }
        return shortestime;
    }

    public double getBest50Time(){
        double shortestime = 90000;
        for(int i = 0; i < events.size();i++){
            if(events.get(i).get50yardTime() < shortestime){
                shortestime = events.get(i).get50yardTime();
            }
        }
        return shortestime;
    }

    public double getBest100Time(){
        double shortestime = 90000;
        for(int i = 0; i < events.size();i++){
            if(events.get(i).get100yardTime() < shortestime){
                shortestime = events.get(i).get100yardTime();
            }
        }
        return shortestime;
    }

    public double getBest400Time(){
        double shortestime = 90000.0;
        for(int i = 0; i < events.size();i++){
            //System.out.println(events.get(i).get400yardTime());
            if(events.get(i).get400yardTime() < shortestime){
                
                shortestime = events.get(i).get400yardTime();
            }
        }
        return shortestime;
    }

    public void displayAllEvents(){
        System.out.println(events.toString());
    }

    public int getSize(){
        return events.size();
    }

    public boolean checkEventId(int id){
        for(int i = 0; i < events.size(); i++){
            if(id != events.get(i).getEventId()){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nEvents: " + events.toString();
    }
    
    public static void main(String[] args){
        ArrayList<Event> eventss = new ArrayList<Event>();
        SwimmerUser swimmer1 = new SwimmerUser(0, "Vishag", "PantherCreek", "Swimmer", eventss);
        swimmer1.addEvent(18.23, 23.5, 49.45, 160.33);
        swimmer1.addEvent(19.23, 25.5, 75.45, 200.33);
        swimmer1.getOneEventInfo(1);
        System.out.println("||||||||||||||||||||||");
        System.out.println(swimmer1.toString());
        System.out.println(swimmer1.getBest25Time());
        System.out.println(swimmer1.getBest50Time());
        System.out.println(swimmer1.getBest100Time());
        System.out.println(swimmer1.getBest400Time());
    }
}

