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
        Staff staff=new Staff("F001","staffUesr");
        ArrayList<Booking> bookings = new ArrayList<>();
        ClassRoom room=new ClassRoom("G122","G",20,"regular");
        Booking result = staff.bookClassroom(room, 40, "mon", "9-10", bookings);
        assertEquals(1, bookings.size());
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
    
}
