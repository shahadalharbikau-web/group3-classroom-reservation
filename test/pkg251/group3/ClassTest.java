/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg251.group3;
import java.util.Scanner;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class classTest {
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
       @Test
    //test case1 : verify that manageBookingRequests dosent modify any bookings that are not pending 
    public void testManageBooking_NoPending() {
        //make new admin object so we can call the manageBookingRequest
        Admin admin = new Admin("A1","Admin");
        //bookings arraylist to store the virtual booking in it and send it as parameters to the manageBookingRequests method
        ArrayList<Booking>bookings=new ArrayList<>();
        //virtual booking
        Booking b=new Booking ("A101","S001","Sun","8-9",30);
        //state booking as approved 
        b.approve();
        //add booking to the arraylist
        bookings.add(b);
        //store the statues of the booking before calling the manage method
        String statusBefore=b.getStatus();
        //empty scanner to send in parameters, its a test so we dont have to read from user
        Scanner in=new Scanner("");
        //call the manageBookingRequest and it suppose to display no pendings
        admin.manageBookingRequests(bookings, in);
        //check that it didnt change on the only booking that is approved, because changes only made if there are pending bookings
        assertEquals(statusBefore,b.getStatus());
    }
    @Test
    //test case3: check that manageBooking change statues of required booking with the given id to approve as the admin entered
    public void testManageBooking_Approve(){
        //make new admin object so we can call the manageBookingRequest
        Admin admin=new Admin("A1","Admin");
        //bookings arraylist to store the virtual booking in it and send it as parameters to the manageBookingRequests method
        ArrayList<Booking>bookings=new ArrayList<>();
        //virtual booking
        Booking b=new Booking("A102","S001","Mon","10-11",25);
        //add booking to the arraylist
        bookings.add(b);
        //get booking ID
        int id=b.getBookingID();
        //store virtual input act as the admin want to change the current booking status with the stored id, to atatus Approve
        String adminInput=id+"\nA\n";
        Scanner in=new Scanner(adminInput);
        //call the manageBookingRequests by sending arraylist, and the scanner with the virtual input
        admin.manageBookingRequests(bookings,in);
        //check if manageBookingRequests changed the status from pending to approved as entered
        assertEquals("approved",b.getStatus());
    }
    @Test
    //test case3: check that manageBooking change statues required booking with the given id to reject of the  as the admin entered
    public void testManageBooking_Reject(){
     //make new admin object so we can call the manageBookingRequest   
     Admin admin=new Admin("A1","Admin");
     //bookings arraylist to store the virtual booking in it and send it as parameters to the manageBookingRequests method
     ArrayList<Booking>bookings=new ArrayList<>();
     //virtual booking
      Booking b=new Booking("A102","S001","Mon","10-11",25);
     //add booking to the arraylist
        bookings.add(b);
      //get booking ID
         int id=b.getBookingID();
      //store virtual input act as the admin want to change the current booking status with the stored id, to atatus Reject
        String adminInput=id+"\nR\n";
        Scanner in=new Scanner(adminInput);
      //call the manageBookingRequests by sending arraylist, and the scanner with the virtual input
        admin.manageBookingRequests(bookings,in);
      //check if manageBookingRequests changed the status from pending to rejected as entered
        assertEquals("rejected",b.getStatus());
    }

    @Test
    // Testing the method of the ClassroomReservationSystem it calls handlesearchandbooking 
    public void testHandleSearchAndBooking() {
        // make a staff object who will perform the search and booking only to test
          Staff staff = new Staff("S001", "StaffUser");
        // create a list of classrooms and add one available classroom
          ArrayList<ClassRoom> rooms = new ArrayList<>();
         // make a classroom object just to test
          ClassRoom c = new ClassRoom("B201", "B", 40, "lab");
          rooms.add(c);
          // create an empty list to store bookings
          ArrayList<Booking> bookings = new ArrayList<>();
          // perform search using the staff object 
          ArrayList<ClassRoom> result = staff.searchClassrooms(20, "Sun", "8-9", "lab", rooms, bookings);
         // check that the search returned exactly 1 classroom
          assertEquals(1, result.size());
         // check that the classroom returned is the expected one
          assertEquals("B201", result.get(0).getRoomNumber());
          // book the classroom by the staff
          Booking b = staff.bookClassroom(result.get(0), 20, "Sun", "8-9", bookings);
           // verify that exactly one booking was added to the bookings list
          assertEquals(1, bookings.size());
           //make sure that the new booking has the default status "pending"
          assertEquals("pending", b.getStatus());
         }

 }
 
