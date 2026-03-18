import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class RoomInventory {
    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
    }

    public void addRoomType(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    public void incrementRoom(String roomType) {
        if (roomAvailability.containsKey(roomType)) {
            roomAvailability.put(roomType, roomAvailability.get(roomType) + 1);
        }
    }

    public int getAvailableRooms(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }
}

class CancellationService {

    private Stack<String> releasedRoomIds;
    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Invalid cancellation. Reservation ID not found.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);
        releasedRoomIds.push(reservationId);
        inventory.incrementRoom(roomType);
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    public void showRollbackHistory() {
        System.out.println();
        System.out.println("Rollback History (Most Recent First):");

        if (releasedRoomIds.isEmpty()) {
            System.out.println("No cancellations recorded.");
            return;
        }

        for (int i = releasedRoomIds.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.get(i));
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 5);
        inventory.addRoomType("Double", 3);
        inventory.addRoomType("Suite", 2);

        CancellationService cancellationService = new CancellationService();

        cancellationService.registerBooking("Single-1", "Single");

        System.out.println("Booking Cancellation");
        cancellationService.cancelBooking("Single-1", inventory);
        cancellationService.showRollbackHistory();

        System.out.println();
        System.out.println("Updated Single Room Availability: " + inventory.getAvailableRooms("Single"));
    }
}