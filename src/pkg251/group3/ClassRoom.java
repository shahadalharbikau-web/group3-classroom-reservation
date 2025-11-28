package pkg251.group3;
public class ClassRoom {

    private String roomNumber;
    private String floorNumber;  
    private int capacity;
    private String classType;   
    private boolean isActive;   

    public ClassRoom(String roomNumber, String floorNumber, int capacity, String classType) {
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.classType = classType;
        this.isActive = true;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getClassType() {
        return classType;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
public String toString() {
    return "Room: " + roomNumber +
           " | Floor: " + floorNumber +
           " | Capacity: " + capacity +
           " | Type: " + classType;
}
}