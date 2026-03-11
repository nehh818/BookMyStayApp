import java.util.*;

class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        int available = inventory.getRoomAvailability().get(roomType);

        if (available <= 0) {
            System.out.println("No rooms available for " + roomType);
            return;
        }

        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
        assignedRoomsByType.get(roomType).add(roomId);

        inventory.updateAvailability(roomType, available - 1);

        System.out.println("Booking confirmed for Guest: " +
                reservation.getGuestName() +
                ", Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {

        int number = 1;

        if (assignedRoomsByType.containsKey(roomType)) {
            number = assignedRoomsByType.get(roomType).size() + 1;
        }

        String roomId = roomType + "-" + number;

        while (allocatedRoomIds.contains(roomId)) {
            number++;
            roomId = roomType + "-" + number;
        }

        return roomId;
    }
}

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocator = new RoomAllocationService();

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Neha", "Single"));
        bookingQueue.add(new Reservation("Thanu", "Single"));
        bookingQueue.add(new Reservation("Arun", "Suite"));

        while (!bookingQueue.isEmpty()) {
            Reservation reservation = bookingQueue.poll();
            allocator.allocateRoom(reservation, inventory);
        }
    }
}