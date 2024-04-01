/**
 * Custom exception class representing an exception thrown when the class capacity is exceeded.
 */
public class ClassCapacityExceededException extends Exception {

    /**
     * Constructs a new ClassCapacityExceededException with the specified detail message.
     *
     * @param message The detail message.
     */
    public ClassCapacityExceededException(String message) {
        super(message);
    }
}
