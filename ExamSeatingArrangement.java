import java.util.*;

/**
 * Main class for managing exam seating arrangement.
 */
public class ExamSeatingArrangement {
    public static void main(String[] args) throws ClassCapacityExceededException {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input: number of students and available rooms
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        List<Room> rooms = new ArrayList<>();
        System.out.print("Enter the number of available rooms: ");
        int numRooms = scanner.nextInt();
        for (int i = 0; i < numRooms; i++) {
            System.out.println("Room " + (i + 1) + ":");
            System.out.print("  Enter the number of rows: ");
            int numRows = scanner.nextInt();
            System.out.print("  Enter the number of columns per row: ");
            int numColumns = scanner.nextInt();
            rooms.add(new Room(i + 1, numRows, numColumns));
        }

        scanner.close();

        try {
            // Check if the number of students exceeds the total capacity of available rooms
            if (isCapacityExceeded(numStudents, rooms)) {
                throw new ClassCapacityExceededException("Number of students exceeds class capacity.");
            }
            // Generate seating arrangement
            SeatingArrangement seatingArrangement = new ConcreteSeatingArrangement();
            List<Seat> seats = seatingArrangement.arrangeSeats(numStudents, rooms);
            // Display seating arrangement
            System.out.println("Seating Arrangement for " + numStudents + " students:");
            printSeatingArrangement(seats, rooms);
        } catch (ClassCapacityExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Checks if the number of students exceeds the total capacity of available rooms.
     *
     * @param numStudents The number of students.
     * @param rooms       The list of available rooms.
     * @return True if the number of students exceeds the total capacity, false otherwise.
     */
    private static boolean isCapacityExceeded(int numStudents, List<Room> rooms) {
        int totalSeats = 0;
        for (Room room : rooms) {
            totalSeats += room.getNumRows() * room.getNumColumns();
        }
        return numStudents > totalSeats;
    }

    /**
     * Prints the seating arrangement for each room.
     *
     * @param seatingArrangement The list of Seat objects representing the seating arrangement.
     * @param rooms              The list of Room objects representing the available rooms.
     */
    private static void printSeatingArrangement(List<Seat> seatingArrangement, List<Room> rooms) {
        // Group seats by room
        Map<Integer, List<Seat>> seatsByRoom = new HashMap<>();
        for (Seat seat : seatingArrangement) {
            seatsByRoom.computeIfAbsent(seat.getRoomNumber(), k -> new ArrayList<>()).add(seat);
        }

        // Print seating arrangement for each room
        for (Room room : rooms) {
            List<Seat> seatsInRoom = seatsByRoom.getOrDefault(room.getRoomNumber(), Collections.emptyList());
            System.out.println("Room " + room.getRoomNumber() + " - Total Students: " + seatsInRoom.size());
            for (Seat seat : seatsInRoom) {
                System.out.println("  Student seated at: " + seat);
            }
        }
    }
}
