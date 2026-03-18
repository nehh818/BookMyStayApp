import java.util.ArrayList;
import java.util.List;

class Reservation {
    private String reservationId;
    private String guestName;

    public Reservation(String reservationId, String guestName) {
        this.reservationId = reservationId;
        this.guestName = guestName;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }
}

class BookingHistory {

    private List<Reservation> confirmedReservations;

    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}

class BookingReportService {

    public void generateReport(BookingHistory history) {
        List<Reservation> reservations = history.getConfirmedReservations();

        System.out.println("===== Booking Report =====");

        if (reservations.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : reservations) {
            System.out.println("Room Type: " + r.getReservationId()
                    + " | Guest: " + r.getGuestName());
        }

        System.out.println("Total Bookings: " + reservations.size());
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        history.addReservation(new Reservation("Single room", "Neha"));
        history.addReservation(new Reservation("Double room", "Thanu"));
        history.addReservation(new Reservation("Suite room", "Dharani"));

        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}