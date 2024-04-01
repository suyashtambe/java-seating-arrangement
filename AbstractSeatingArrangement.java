import java.util.List;

public abstract class AbstractSeatingArrangement implements SeatingArrangement {
    protected abstract List<Seat> generateSeating(int numStudents, List<Room> rooms);

    @Override
    public List<Seat> arrangeSeats(int numStudents, List<Room> rooms) {
        return generateSeating(numStudents, rooms);
    }
}
