import java.util.*;

public class CoachUser extends User{
    
    public ArrayList<SwimmerUser> swimmers = new ArrayList<SwimmerUser>();
    
    public static int newSwimmerCounter = 1;

    public CoachUser(int userNum, String name, String schoolName, String userType, ArrayList<SwimmerUser> swimmers){
        super(userNum, name, schoolName, userType);
        this.swimmers = swimmers;
    }
    
    private static int getSwimmerCounter(){
        return newSwimmerCounter;
    }

    private static void addSwimmerCounter() {
        newSwimmerCounter++;
    }

    public boolean checkSwimmerId(int id){
        for(int i = 0; i < swimmers.size(); i++){
            if(id != swimmers.get(i).getUserId()){
                return false;
            }
        }
        return true;
    }

    public void addSwimmer(String name, String schoolName){
        ArrayList<Event> tempEvents = new ArrayList<>();
        SwimmerUser swimmer = new SwimmerUser(getSwimmerCounter(), name, schoolName, "Swimmer", tempEvents);
        swimmers.add(swimmer);
        addSwimmerCounter();
    }

    public void deleteSwimmer(int id){
        for(int i = 0; i < swimmers.size();i++){
            if(swimmers.get(i).getUserId() == id){
                swimmers.remove(i);
            }
        }
    }

    public void displayAllSwimmers(){
        for(int i = 0; i < swimmers.size();i++){
            
            System.out.println(swimmers.get(i).toString());
        }
    }

    
    
    public void printBestTimeOfEachEvent(){
        double key1;
        double key2;
        double key3;
        double key4;
        System.out.println("Name | 25 Yard | 50 Yard | 100 Yard | 400 Yard |  ");
        for(int i = 0; i < swimmers.size();i++){
            
            key1 = swimmers.get(i).getBest25Time();
            key2 = swimmers.get(i).getBest50Time();
            key3 = swimmers.get(i).getBest100Time();
            key4 = swimmers.get(i).getBest400Time();
            if(swimmers.get(i).events.isEmpty()){
                System.out.println("Swimmer has no events.");
            }
            else{
                System.out.println(swimmers.get(i).getName() + " | " + key1 + " | " + key2 + " | " + key3 + " | " + key4 + " |");
            }
            
            
        }
    }

    @Override
    public String toString(){
        return super.toString();
    }

    public static void main(String[] args){
        ArrayList<SwimmerUser> swimmerss = new ArrayList<SwimmerUser>();
        CoachUser coach1 = new CoachUser(1, "Ron", "PantherCreek", "Coach", swimmerss);
        coach1.addSwimmer("Vishag", "PantherCreek");
        coach1.addSwimmer("Koonj", "PantherCreek");
        swimmerss.get(0).addEvent(23.34, 50, 70, 100);
        swimmerss.get(0).addEvent(30, 60, 78, 90);
        swimmerss.get(1).addEvent(23.34, 50, 70, 100);
        swimmerss.get(1).addEvent(15, 33, 44, 50);
        swimmerss.get(1).addEvent(45, 20, 45, 45);
        System.out.println(coach1.toString());
        System.out.println("|||");
        coach1.displayAllSwimmers();
        System.out.println("///");
        coach1.printBestTimeOfEachEvent();
    }
}
