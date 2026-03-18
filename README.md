# BookMyStayApp
======
# UC1-WelcomeMessage
# Implemented the main application entry point using the main method.
# Displayed a welcome message with the application name and version.
# Demonstrated basic Core Java concepts like class structure and console output.
# Ensured successful compilation and execution with a clear startup flow.
======
# UC2-RoomTypesAndAvailability
# Room objects representing different room types are created.
# Availability for each room type is stored using simple variables.
# Room details and availability information are printed to the console.
======
# UC3-CentralizedRoomandInventoryManagement
# The system initializes the inventory component.
# Room types are registered with their available counts.
# Availability is stored and retrieved from a centralized HashMap.
# Updates to availability are performed through controlled methods.
# The current inventory state is displayed when requested.
======
# UC4-RoomSearchAvailability
# Guest initiates a room search request.
# The system retrieves availability data from the inventory.
# Unavailable room types are filtered out.
# Available room types and their details are displayed.
# System state remains unchanged.
======
# UC5-BookingRequest
# Guest submits a booking request
# The request is added to the booking queue.
# Requests are stored in arrival order.
# Queued requests wait for processing by the allocation system.
# No inventory mutation occurs at this stage.
======
# UC6-RoomReservationAllocation
# Booking request is dequeued from the request queue.
# The system checks availability for the requested room type.
# A unique room ID is generated and assigned.
# The room ID is recorded to prevent reuse.
# Inventory count is decremented immediately.
# Reservation is confirmed.
======
# UC7-AddOnService
# Allow multiple services to be attached to a single reservation.
# Store selected services using a reservation-to-services mapping.
# Calculate total additional cost for selected services.
# Ensure add-on logic does not modify booking or inventory state.
# Support easy addition of new service types.
======
# UC8-BookingHistory
# Store each confirmed reservation in booking history.
# Maintain bookings in the order they are confirmed.
# Allow retrieval of stored reservations for review.
# Generate summary reports from booking history.
# Ensure reporting does not modify stored booking data.
======
# UC9-ErrorHandlingAndValidation
# Validate room types before processing bookings.
# Prevent inventory from reaching invalid or negative values.
# Throw and handle custom exceptions for invalid scenarios.
# Display clear and informative failure messages.
# Ensure the system remains stable after errors.
======
# UC10-CancellationAndInventoryRollback
# Allow cancellation of confirmed bookings only.
# Validate reservation existence before performing rollback.
# Release allocated room IDs back to the availability pool.
# Restore inventory counts accurately and immediately.
# Prevent cancellation of non-existent or already cancelled bookings.
======
# UC11-ConcurrentBooking
# Simulate multiple booking requests occurring at the same time.
# Use shared data structures for booking requests and inventory.
# Ensure inventory updates are performed in a thread-safe manner.
# Prevent double allocation under concurrent execution.
# Maintain consistent system state under load.
======