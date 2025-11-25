import java.util.ArrayList;

public class Staff {

    private String staffID;
    private String name;

    public Staff(String staffID, String name){
        this.staffID = staffID;
        this.name = name;
    }

    public String getStaffID(){
        return staffID;
    }

    // search Classroom method 
    public ArrayList<ClassRoom> searchClassrooms(int students, String day, String time, String classType, ArrayList<ClassRoom> classrooms, ArrayList<Booking> bookings){
        // store all classroom that match the requirements 
        ArrayList<ClassRoom> result = new ArrayList<>();
        
        // loop through all classrooms list
        for (int i = 0; i < classRooms.size(); i++) {

            ClassRoom c = classRooms.get(i);// current classroom

            // Check the conditions for the classroom:
            // Capacity is enough for the number of students and Classroom type matches what the user selected (lab/regular) and the classroom is active in the system
            boolean basicMatch = c.getCapacity() >= students && c.getClassType().equalsIgnoreCase(classType) && c.isActive();

            // if the classroom doesn't match , skip it 
            if (!basicMatch){
                continue;
            }

            // check if the classroom is free at the selected day and time
            boolean isFree = true;
            // loop through all bookings to see if this room is already booked
            for (int j = 0; j < bookings.size(); j++) {
                Booking b = bookings.get(j);

                // Check if this booking matches the same room, same day/time, and is still active
                boolean sameBooking = b.getRoomNumber().equals(c.getRoomNumber()) && b.getDay().equalsIgnoreCase(day) && b.getTime().equalsIgnoreCase(time);

                boolean activeStatus = !b.getStatus().equals("cancelled") && !b.getStatus().equals("rejected");

                // if all match , room is already booked at this time
                if(sameBooking && activeStatus){
                    isFree = false; // make room as not available
                    break;
                }

                // if room is free after checking all bookings
                if(isFree){
                    result.add(c); // add it to the result list
                }
            }
         }
         return result;
        } 
    }
//core function: Book class room
//creat a new booking request with status "pending"
public Booking ClassRoom(Classroom c,int students,String day,String time,ArrayIndexOutOfBoundsException<Booking>bookings){
    booking b=new Booking(c.getRoomNumber(),staffID,day,time,students);
    // Add booking to the list
    bookings.add(b); 
    System.out.println("Booking created with status PENDING :" +b.getDetails());
    return b;
}
//---------------------------------------------------------------------------------
//view my Booking 
// shows booking  history of this specific staff member only
 public void viewMyBooking(ArrayList<booking> bookings){
    System.out.println("\n--- Booking history for"+name+"---");
     for(Booking b: bookings){
        if (b.getStaffID().equals(StaffID)){
            System.out.println(b.getDetails());
        }  
        }
     }
     
 }