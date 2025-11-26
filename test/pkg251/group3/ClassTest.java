/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg251.group3;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class classtest {
     /**
     * Test of bookClassroom method, of class Staff.
     */
    @Test
    public void testBookClassroom() {
        //create a staff member who will make the booking
        Staff staff=new Staff("F001","staffUesr");
        //List that will store all booking
        ArrayList<Booking> bookings = new ArrayList<>();
        //creat a classroom to be booked
        ClassRoom room=new ClassRoom("G122","G",20,"regular");
        //attempt to book the classroom and get the returned booking object
        Booking result = staff.bookClassroom(room, 40, "mon", "9-10", bookings);
        //verify that exactly 1 booking has been added to the list
        assertEquals(1, bookings.size());
        //verify that the booking has the default status "pending"
        assertEquals("pending", result.getStatus());
    }

    // test of testSearchClassrooms method, of class Staff
    @Test
    public void testSearchClassrooms(){
        
        Staff staff = new Staff("R001", "Raghad");
        
         ArrayList<ClassRoom> rooms = new ArrayList();
         ArrayList<Booking> bookings = new ArrayList();
         
         //1 room available (should appear)
         ClassRoom available = new ClassRoom("S101", "S", 40, "lab");
         rooms.add(available);
         
         //2 room booked (should not appear)
         ClassRoom bookedRoom = new ClassRoom("F102", "F", 40, "lab");
         rooms.add(bookedRoom);
         // add booking for room F102
         Booking b = new Booking("F102", "R001", "Sun", "8-9", 20);
         b.approve(); // change status
         bookings.add(b);
         
         // 3 wrong type (should not appear)
         ClassRoom wrongType = new ClassRoom("G103", "G", 40, "regular");
         rooms.add(wrongType);
         
         // 4 not enough capacity (should not appear)
         ClassRoom smallRoom = new ClassRoom("G104", "G", 10, "lab");
         rooms.add(smallRoom);
         
         //call method
         ArrayList<ClassRoom> result = staff.searchClassrooms(20, "Sun", "8-9", "lab", rooms, bookings);
         
         // assert (expected room: S101 only)
         // So we check the result size is 1 and the room number is S101
         assertEquals(1, result.size());
         assertEquals("S101", result.get(0).getRoomNumber());
    }
    
    // test of testAddClassroom method, of class Admin
        @Test 
    public void testAddClassroom(){
        // Simulated user input:
        //roomNumber= A101 , foor= A ,capacity =30 , classType =lab

        String=fakeInput ="A101\nA\n30\nlab\n";
       //create scanner to use the fakeInput
        Scanner input = new Scanner(fakeInput);
        //an empty list to store classrooms
        ArrayList<ClassRoom> rooms =new ArrayList<>();
        //Admin object to call addClassroom method
        Admin admin =new Admin("A001","AdminUser");

        // call the method
        admin.addClassroom(rooms,input);
        //check that exactly one classroom was added
        assertEquals(1,rooms.size());
        //get the added classroom for further verification
        ClassRoom c=rooms.get(0);

        //ensure that all info of classroom are correctly recorded

        //room number should match
        assertEquals("A101",c.getRoomNumber());
        //floor number should match
        assertEquals("A",c.getFloorNumber());
        // capacity should match
        assertEquals(30,c.getCapacity());
        //class type should match
        assertEquals("lab",c.getClassType());
    }
    
}
