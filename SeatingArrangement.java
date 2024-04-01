/**
 * Interface for defining a seating arrangement for students in exam rooms.
 */

import java.util.List;

public interface SeatingArrangement {
    List<Seat> arrangeSeats(int numStudents, List<Room> rooms);
}
