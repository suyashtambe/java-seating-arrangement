import java.util.ArrayList;
import java.util.List;

/**
 * Represents a room where an exam can be conducted.
 */
public class Room {
    private int roomNumber;
    private int numRows;
    private int numColumns;
    private List<Boolean> seatAvailability;

    /**
     * Constructs a Room object with the specified parameters.
     *
     * @param roomNumber  The room number.
     * @param numRows     The number of rows in the room.
     * @param numColumns  The number of columns in each row of the room.
     */
    public Room(int roomNumber, int numRows, int numColumns) {
        this.roomNumber = roomNumber;
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.seatAvailability = new ArrayList<>();
        initializeSeats(); // Initialize the seats in the room
    }

    /**
     * Initializes the availability of seats in the room.
     * Assumes all seats are initially available.
     */
    private void initializeSeats() {
        int totalSeats = numRows * numColumns;
        for (int i = 0; i < totalSeats; i++) {
            seatAvailability.add(true);
        }
    }

    /**
     * Gets the room number.
     *
     * @return The room number.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Gets the number of rows in the room.
     *
     * @return The number of rows.
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * Gets the number of columns in each row of the room.
     *
     * @return The number of columns.
     */
    public int getNumColumns() {
        return numColumns;
    }

    /**
     * Checks if a seat at the specified row and column is available.
     *
     * @param row    The row of the seat.
     * @param column The column of the seat.
     * @return True if the seat is available, false otherwise.
     */
    public boolean isSeatAvailable(int row, int column) {
        int index = calculateIndex(row, column);
        return seatAvailability.get(index);
    }

    /**
     * Occupies a seat at the specified row and column.
     *
     * @param row    The row of the seat.
     * @param column The column of the seat.
     */
    public void occupySeat(int row, int column) {
        int index = calculateIndex(row, column);
        seatAvailability.set(index, false);
    }

    /**
     * Releases a previously occupied seat at the specified row and column.
     *
     * @param row    The row of the seat.
     * @param column The column of the seat.
     */
    public void releaseSeat(int row, int column) {
        int index = calculateIndex(row, column);
        seatAvailability.set(index, true);
    }

    /**
     * Calculates the index of the seat in the seatAvailability list based on its row and column.
     *
     * @param row    The row of the seat.
     * @param column The column of the seat.
     * @return The index of the seat in the seatAvailability list.
     */
    private int calculateIndex(int row, int column) {
        return (row - 1) * numColumns + (column - 1);
    }

    /**
     * Returns a string representation of the room.
     *
     * @return A string representing the room.
     */
    @Override
    public String toString() {
        return "Room " + roomNumber + " with " + numRows + " rows and " + numColumns + " columns";
    }
}
