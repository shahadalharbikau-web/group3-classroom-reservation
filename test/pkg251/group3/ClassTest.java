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
    
}
