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
    public String getRoomNummber(){return roomNumber;}
    public String getStaffID(){return staffID;}
    public String getDay(){return day;}
    public String getTime(){ return time;}
    public int getNumberOfStudents(){return numberOfStudents;}
    public String getStatus(){return status;}




}
