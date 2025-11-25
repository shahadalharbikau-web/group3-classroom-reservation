public class Booking{

    private static int counter =1;
    private int bookingID;
    private int numberOfStudents;
    private String roomNumber;
    private String staffID;
    private String day;
    private String time;
    private  String status; //aprrove or reject 
    
    //constructor take parameters and assign them to variables
    public Booking(String roomNumber,String staffID,String day, String time,int numberOfStudents){
        this.bookingID=counter++; //generate unique booking id
        this.roomNumber=roomNumber;
        this.dtaffID=staffID;
        this.day=day;
        this.time=time;
        this.numberOfStudents=numberOfStudents;
        this.status="pending"; //defult booking status
    }
    //  Getter methods
    public int getbookingID(){return bookingID;}
    public String getroomNummber(){return roomNumber;}
    public String getstaffID(){return staffID;}
    public String getday(){return day;}
    public String gettime(){ return time;}
    public int getnumberOfStudents(){return numberOfStudents;}
    public String getstatus(){return status;}




}
