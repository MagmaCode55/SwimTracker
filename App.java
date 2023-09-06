import java.util.*;
import java.io.*;
public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<SwimmerUser> swimmerList = new ArrayList<SwimmerUser>();
        CoachUser coach1 = new CoachUser(1, "Ajay", "Panther Creek", "Coach", swimmerList);

        Scanner kbd = new Scanner(System.in);
        int num = 0;
        int id1 = 0;
        while (num != 7) {
            System.out.println("Welcome to the Swimmer DataBase Track(Name in Progress)");
            System.out.println("\t 1. Register a Swimmer ");
            System.out.println("\t 2. Add event for a Swimmer");
            System.out.println("\t 3. Remove Swimmer");
            System.out.println("\t 4. Remove Event for one Swimmer");
            System.out.println("\t 5. Display Best 25 yard, 50 yard, 100 yard, 400 yard for each Swimmer");
            System.out.println("\t 6. Display All Swimmers ");
            System.out.println("\t 7. Exit");
            //int a = 0;
            num = kbd.nextInt();
            kbd.nextLine();

            switch (num) {
                case 1:

                    System.out.println("Registering a Swimmer: ");
                    System.out.println("Enter First and Last Name of Swimmer: ");
                    String name1 = kbd.nextLine();
                    System.out.println("Enter School Name: ");
                    String schoolname1 = kbd.nextLine();

                    coach1.addSwimmer(name1, schoolname1);
                    System.out.println("Swimmer, " + name1 + ", has been added to your account.");
                    break;
                
                case 2:
                    if(swimmerList.isEmpty()){
                        System.out.println("You have no swimmers registered in your account.");
                        break;
                    }

                    System.out.println("Adding an Event for a Swimmer: ");
                    System.out.println("Enter swimmer ID to add event to: ");
                    id1 = kbd.nextInt();
                    while(coach1.checkSwimmerId(id1) == false){
                        System.out.println("That does not exist, please enter an ID that exists:");
                        id1 = kbd.nextInt();
                    }
                    
                    kbd.nextLine();
                    System.out.println("If the swimmer did not participate in an event, please set the time as 0.0 or 0:");
                    System.out.println("Enter 25-yard time: ");
                    double _25time = kbd.nextDouble();
                    System.out.println("Enter 50-yard time: ");
                    double _50time = kbd.nextDouble();
                    System.out.println("Enter 100-yard time: ");
                    double _100time = kbd.nextDouble();
                    System.out.println("Enter 400-yard time: ");
                    double _400time = kbd.nextDouble();
                    for(int i = 0; i < swimmerList.size();i++){
                        if(id1 == swimmerList.get(i).getUserId()){
                            swimmerList.get(i).addEvent(_25time, _50time, _100time, _400time);
                        }
                    }
                    break;
                case 3:
                    if(swimmerList.isEmpty()){
                        System.out.println("You have no swimmers registered in your account.");
                        break;
                    }

                    System.out.println("Deleting a Swimmer account:");
                    System.out.println("Enter swimmer ID: ");
                    int id2 = kbd.nextInt();
                    while(coach1.checkSwimmerId(id2) == false){
                        System.out.println("That does not exist, please enter an ID that exists:");
                        id2 = kbd.nextInt();
                    }
                    coach1.deleteSwimmer(id2);
                    System.out.println("Swimmer Deleted");
                    break;
                
                case 4:
                    System.out.println("Removing an event from one swimmer:");
                    if(swimmerList.isEmpty()){
                        System.out.println("You have no swimmers registered in your account.");
                        break;
                    }

                    System.out.println("Enter swimmer ID: ");
                    int id3 = kbd.nextInt();
                    while(coach1.checkSwimmerId(id3) == false){
                        System.out.println("That does not exist, please enter an ID that exists:");
                        id3 = kbd.nextInt();
                    }

                    for(int i = 0; i< swimmerList.size();i++){
                        if(swimmerList.get(i).getUserId() == id3){
                            if(swimmerList.get(i).getSize() == 0){
                                System.out.println("There are no events registered for this swimmer.");
                                break;
                            }
                            //Add a method that prints all events available
                            System.out.println("Enter the event Id of the event to delete:");
                            int eveID1 = kbd.nextInt();
                            while(swimmerList.get(i).checkEventId(eveID1) == false){
                                System.out.println("Does event does not not exist. Please enter a different number:");
                                eveID1 = kbd.nextInt();
                            }
                            Event j = swimmerList.get(i).getOneEventInfo(eveID1); 
                            swimmerList.get(i).deleteEvent(eveID1);
                            System.out.println("Deleted Event:" + j.toString());
                        }

                        
                    }

                    break;
                
                case 5:
                    System.out.println("Displaying Best 25 Yard, 50 yard, 100 yard, and 400 yard for a Swimmer:");
                    if(swimmerList.isEmpty()){
                        System.out.println("You have no swimmers registered in your account.");
                        break;
                    }
                    coach1.printBestTimeOfEachEvent();

                    break;
                case 6:
                    System.out.println("Print all Swimmers:");
                    if(swimmerList.isEmpty()){
                        System.out.println("You have no swimmers registered in your account.");
                        break;
                    }
                    coach1.displayAllSwimmers();
                    break;
                
                case 7:
                    break;
                default:
                    System.out.println("Sorry, please enter 1, 2, 3, 4, 5, 6, or 7");
            }
        }
    }
}
