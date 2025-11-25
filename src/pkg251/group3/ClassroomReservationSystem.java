package pkg251.group3;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassroomReservationSystem {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // ArrayLists for both of classrooms and bookings
        ArrayList<ClassRoom> classrooms = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        // Admin object & staff object
        Admin admin = new Admin("A001", "AdminUser");
        Staff staff = new Staff("S001", "StaffUser");

        int mainChoice = -1;

   
        do {
            System.out.println("\n===== Welcome to Classroom Reservation System =====");
            System.out.println("1) Login as Admin");
            System.out.println("2) Login as Staff");
            System.out.println("0) Exit System");
            System.out.print("Enter choice: ");

            String line = in.nextLine();
            if (line.isEmpty()) continue;
            mainChoice = Integer.parseInt(line);

            switch (mainChoice) {

                // --------------------------------
                // ADMIN MENU
                // ----------------------------------
                case 1:
                    int adminChoice = -1;
                    do {
                        System.out.println("\n===== Admin Menu =====");
                        System.out.println("1) Add Classroom");
                        System.out.println("2) Manage Booking Requests");
                        System.out.println("3) View All Bookings");
                        System.out.println("0) Back to Main Menu");
                        System.out.print("Enter choice: ");

                        String adminLine = in.nextLine();
                        if (adminLine.isEmpty()) continue;
                        adminChoice = Integer.parseInt(adminLine);

                        switch (adminChoice) {
                            case 1:
                                                       // adding classrooms function for the admin
                                admin.addClassroom(classrooms, in);
                                break;
                            case 2:
                                                        // managing booking requests that been sent by the staff for the admin function 
                                admin.manageBookingRequests(bookings, in);
                                break;
                            case 3:
                                                         // viewing the booking requests that been sent to the admin by the admin function 
                                admin.viewAllBookings(bookings);
                                break;
                            case 0:
                                System.out.println("Returning...");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }

                    } while (adminChoice != 0);
                    break;

                // -----------------------------
                // STAFF MENU
                // ------------------------------
                case 2:
                    int staffChoice = -1;
                    do {
                        System.out.println("\n===== Staff Menu =====");
                        System.out.println("1) Search & Book Classroom");
                        System.out.println("0) Back to Main Menu");
                        System.out.print("Enter choice: ");

                        String staffLine = in.nextLine();
                        if (staffLine.isEmpty()) continue;
                        staffChoice = Integer.parseInt(staffLine);

                        switch (staffChoice) {
                            case 1:
                                                                 // searching THEN booking function for the staff
                                handleStaffSearchAndBooking(staff, classrooms, bookings, in);
                                break;
                            case 0:
                                System.out.println("Returning...");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }

                    } while (staffChoice != 0);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (mainChoice != 0);

        in.close();
    }

    
    // Staff Search & Booking (AS IT IS)
    
    private static void handleStaffSearchAndBooking(Staff staff, ArrayList<ClassRoom> classrooms, ArrayList<Booking> bookings, Scanner in) {

        System.out.println("\n--- Search Available Classrooms ---");

        System.out.print("Enter number of students:");
        int students = Integer.parseInt(in.nextLine());

        System.out.print("Enter day:");
        String day = in.nextLine();

        System.out.print("Enter time:");
        String time = in.nextLine();

        System.out.print("Enter class type:");
        String type = in.nextLine();

        // search for a classroom
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
        staff.ClassRoom(selected, students, day, time, bookings);
    }

}
