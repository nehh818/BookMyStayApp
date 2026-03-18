import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AddOnService {


    private String serviceName;
    private double cost;
    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }
}

class AddOnServiceManager {

    private Map<String, List<AddOnService>> servicesByReservation;
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }
    public void addService(String reservationId, AddOnService service) {
        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());
        servicesByReservation.get(reservationId).add(service);
    }

    public double calculateTotalServiceCost(String reservationId) {
        double total = 0.0;
        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services != null) {
            for (AddOnService service : services) {
                total += service.getCost();
            }
        }

        return total;
    }

    public void displayServices(String reservationId) {
        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No add-on services selected for reservation ID: " + reservationId);
            return;
        }

        System.out.println("Selected add-on services for reservation ID: " + reservationId);
        for (AddOnService service : services) {
            System.out.println("- " + service.getServiceName() + " : Rs. " + service.getCost());
        }
    }
}


public class BookMyStayApp{

    public static void main(String[] args) {
        String reservationId = "RES101";

        AddOnService Dinner = new AddOnService("Dinner", 500.0);
        AddOnService spa = new AddOnService("Spa", 1500.0);
        AddOnService Sauna = new AddOnService("Sauna", 00.0);

        AddOnServiceManager manager = new AddOnServiceManager();

        manager.addService(reservationId, Dinner);
        manager.addService(reservationId, spa);
        manager.addService(reservationId, Sauna);

        System.out.println("===== Book My Stay App =====");
        System.out.println("Use Case 7: Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println();

        manager.displayServices(reservationId);
        System.out.println();

        double totalCost = manager.calculateTotalServiceCost(reservationId);
        System.out.println("Total additional service cost: Rs. " + totalCost);
        System.out.println("Core booking and inventory remain unchanged.");
    }
}