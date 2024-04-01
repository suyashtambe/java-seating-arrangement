import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of the SeatingArrangement interface.
 * This class generates a seating arrangement for students based on the given
 * rooms.
 */
public class ConcreteSeatingArrangement extends AbstractSeatingArrangement {

    /**
     * Generates a seating arrangement for the specified number of students in the
     * given list of rooms.
     *
     * @param numStudents The number of students to seat.
     * @param rooms       The list of rooms available for seating.
     * @return A list of Seat objects representing the seating arrangement.
     */
    protected List<Seat> generateSeating(int numStudents, List<Room> rooms) {
        List<Seat> seatingArrangement = new ArrayList<>();
        int studentsSeated = 0;

        // Iterate through each room
        for (Room room : rooms) {
            int numRows = room.getNumRows();
            int numColumns = room.getNumColumns();

            // Iterate through each row and column in the room
            for (int row = 1; row <= numRows; row++) {
                for (int column = 1; column <= numColumns; column++) {
                    // Check if there are remaining students to be seated
                    if (studentsSeated < numStudents) {
                        // Add a seat for the student
                        seatingArrangement.add(new Seat(room.getRoomNumber(), row, column));
                        studentsSeated++;
                    } else {
                        // Stop seating if all students have been seated
                        break;
                    }

                    // // Add an empty seat between students if needed
                    // if (studentsSeated < numStudents) {
                    //     column++; // Move to the next column
                    // }
                }

                // Stop seating if all students have been seated
                if (studentsSeated >= numStudents) {
                    break;
                }
            }

            // Stop seating if all students have been seated
            if (studentsSeated >= numStudents) {
                break;
            }
        }

        return seatingArrangement; // Return the seating arrangement
    }
}
