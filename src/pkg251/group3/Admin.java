package pkg251.group3;
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
    input.nextLine();
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
    //admin will choose ID of the booking he/she want to change the statues of 
        System.out.println("Enter booking ID to manage ( or 0 to exit):");
        int id= input.nextInt();
        if(id == 0){
            return;
        }
        //this method will search for the booking object required by its id
        Booking selected=null;
        for(Booking b:pending){
            if(b.getBookingID()==id){
                selected=b;
                break;
            }
        }
    //if selected object dosent exist thin it will notify admin    
    if(selected==null){
        System.out.println("Booking ID not found");
        
    }
    //will take admin input of approve or regect the booking object
    else{
        System.out.print("if Approve enter (A) || Reject enter (R)?");
        String choice=input.nextLine();
        //change status of the selected booking object based on admin choice (approve)
        if(choice.equals("A")||choice.equals("a")){
            selected.approve();
            System.out.println("Booking rejected");
            
        }
        //change status of the selected booking object based on admin choice (approve)
        else if(choice.equals(choice.equals("R")||choice.equals("r"))){
          selected.reject();
          System.out.println("Booking rejected");
          
        } 
        //if admin entered string other than R or A 
        else{
            System.out.println("Invalid choice");
          }
    
    }
  }
     //this method will loop through Bookings arraylist and displaye it to admin
     public void viewAllBookings(ArrayList<Booking>bookings){
      System.out.println("--- All Bookings ---");
      //if booking array was empty it will display a meassage to admin
      if(bookings.isEmpty()){
          System.out.println("No bookings in the system");
      }
      //if booking arraylist is not empty print booking objects details
      else{
          for(Booking b:bookings){
              System.out.println(b);
          }
      }
     
    

   }


  }
