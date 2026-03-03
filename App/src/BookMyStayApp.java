/**
 * UseCase1HotelBookingApp
 *
 * This class represents the entry point of the Book My Stay Hotel Booking System.
 * It demonstrates how a Java application starts execution using the main() method
 * and displays a welcome message along with application details.
 *
 * The purpose of this use case is to establish a predictable application startup
 * behavior and reinforce core Java fundamentals.
 *
 * @author Neha
 * @version 1.0
 */
public class BookMyStayApp {
    public static void main(String[] args) {

        String appName = "Book My Stay - Hotel Booking Management System";
        String version = "Version 1.0";

        // Welcome Message Output
        System.out.println("==============================================");
        System.out.println("        Welcome to " + appName);
        System.out.println("                 " + version);
        System.out.println("==============================================");
        System.out.println("Application started successfully.");
        System.out.println("Thank you for using Book My Stay!");
    }
}