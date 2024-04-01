public class Seat {
    private int roomNumber;
    private int row;
    private int column;

    /**
     * Constructs a Seat object with the specified parameters.
     *
     * @param roomNumber The room number where the seat is located.
     * @param row        The row number of the seat.
     * @param column     The column number of the seat.
     */
    public Seat(int roomNumber, int row, int column) {
        this.roomNumber = roomNumber;
        this.row = row;
        this.column = column;
    }

    /**
     * Gets the room number of the seat.
     *
     * @return The room number.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Gets the row number of the seat.
     *
     * @return The row number.
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column number of the seat.
     *
     * @return The column number.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Returns a string representation of the seat.
     *
     * @return A string representing the seat in the format "Room X, Row Y, Seat Z".
     */
    @Override
    public String toString() {
        return "Room " + roomNumber + ", Row " + row + ", Seat " + column;
    }
}
