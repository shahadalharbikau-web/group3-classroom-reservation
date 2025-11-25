import java.util.*;
public class Admin{
    private String adminID;
    private String name;

    public Admin(String adminID, String name){
        this.adminID=adminID;
        this.name=name;
    }

    
    public Admin(){
        
    }


    // Method to add a new classroom
  public void addClassroom(ArrayList<ClassRoom> classrooms, Scanner input)  {
    System.out.println("\n--- Add New Classroom ---");
  // Ask for the added room number
    System.out.println("Enter room number:  ");
    String roomNumber =input.nextLine();
   // Ask for the floor
    System.out.println("Enter floor (A,B,C....): ");
    String floorNumber = input.nextLine();
     // Ask for the capacity
    System.out.println("Enter capacity: ");
    int capacity =input.nextInt();
     // Ask for the class type
    System.out.println("Enter class type (lab / regular): ");
    String classType = input.nextLine();
    //create a new classroom object
    ClassRoom c = new ClassRoom(roomNumber, floorNumber, capacity, classType);
    // Add it to the list
    classrooms.add(c);

    System.out.println("classroom added: "+ c);
  }
 
  // Method yo manage booking requests
  public void manageBookingRequests(ArrayList<Booking> bookings, Scanner input){
    System.out.println("\n--- Manage Booking Requests ");
    
    // List to store pending booking only 
    ArrayList<Booking> pending = new ArrayList<>();

   // Loop to find booking with "pending" status
    for(Booking b : bookings){
      if (b.getStatus().equals("pending")){
        // Add it to the list
        pending.add(b);
      }

    }

  // if no pending booking exit
   if(pending.isEmpty()){
    System.out.println("No pending booking requests. ");
    return;
   }

   //Display all pending bookings
   for (Booking b : pending){
     System.out.println(b.getDetails());

   }
   

   }

  }
