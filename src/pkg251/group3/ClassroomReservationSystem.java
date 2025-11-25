package pkg251.group3;
import java.util.ArrayList;
import java.util.Scanner;


public class ClassroomReservationSystem {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);

       // ArrayLists for both of classrooms and bookings 
       ArrayList<ClassRoom> classrooms = new ArrayList <>();
       ArrayList<Booking> bookings = new ArrayList <>();
       // Admin object & staff object
       Admin admin = new Admin("A001","AdminUser");
       Staff staff = new Staff("S001","StaffUser");

       int choice=0;
       do {

        System.out.println("\n===== Classroom Reservation System =====");
        System.out.println("1) Admin - Add Classroom");
        System.out.println("2) Staff - Search & Book Classroom");
        System.out.println("3) Admin - Manage Booking Requests");
        System.out.println("4) Admin - View All Bookings");
        System.out.println("0) Exit");
        System.out.print("Enter choice: ");

        String line = in.nextLine();
        if (line.isEmpty()) continue;
        
        choice = Integer.parseInt(line);

        switch(choice){

                case 1:
                    // adding classrooms function for the admin 
                    admin.addClassroom(classrooms, in);
                    break;

                case 2:
                    // searching THEN booking function for the staff 
                    handleStaffSearchAndBooking(staff, classrooms, bookings, in);
                    break;

                case 3:
                    // managing booking requests that been sent by the staff for the admin function 
                    admin.manageBookingRequests(bookings, in);
                    break;

                case 4:
                    // viewing the booking requests that been sent to the admin by the admin function 
                    admin.viewAllBookings(bookings);
                    break;

                case 0:
                    // exit from the system 
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid choice.");




        }

       }while(choice !=0);

      in.close();

    }
    // ---------------------------------------------------------------------------------------------------------------------------------------
    private static void handleStaffSearchAndBooking(Staff staff, ArrayList<ClassRoom> classrooms, ArrayList<Booking> bookings,  Scanner in){

       System.out.println("\n--- Search Available Classrooms ---");

        System.out.print("Enter number of students:");
        int students = Integer.parseInt(in.nextLine());

        System.out.print("Enter day:");
        String day = in.nextLine();

        System.out.print("Enter time:");
        String time = in.nextLine();

        System.out.print("Enter class type:");
        String type = in.nextLine();

        //search for a classroom
        ArrayList<ClassRoom> available =
                staff.searchClassrooms(students, day, time, type, classrooms, bookings);

        if (available.isEmpty()) {
            System.out.println("No available classrooms found for this criteria");
            return;
        }

        System.out.println("\nAvailable classrooms:");
        for (int i = 0; i < available.size(); i++) {
            System.out.println((i + 1) + ") " + available.get(i));
        }

        System.out.print("Select classroom number to book (0 to cancel):");
        int choice = Integer.parseInt(in.nextLine());

        if (choice <= 0 || choice > available.size()) {
            System.out.println("Booking cancelled");
            return;
        }

        ClassRoom selected = available.get(choice - 1);

        // book classroom
        staff.bookClassroom(selected, students, day, time, bookings);

        
    }
    
}
