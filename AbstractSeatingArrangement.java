import java.util.List;

/**
 * An abstract class representing a seating arrangement strategy.
 */
public abstract class AbstractSeatingArrangement implements SeatingArrangement {
    
    /**
     * Generates a seating arrangement based on the given parameters.
     *
     * @param numStudents The number of students to seat.
     * @param rooms The list of rooms available for seating.
    
     */
    protected abstract List<Seat> generateSeating(int numStudents, List<Room> rooms);

    /**
     * Arranges seats for the given number of students in the provided rooms.
     * Delegates the seat arrangement to the generateSeating method implemented
     * by concrete subclasses.
     *
     * @param numStudents The number of students to seat.
     * @param rooms The list of rooms available for seating.
     
     */
    @Override
    public List<Seat> arrangeSeats(int numStudents, List<Room> rooms) {
        return generateSeating(numStudents, rooms);
    }
}
