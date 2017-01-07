package hsh.master.exercise.str.exceptions;

public class NotEnoughSeatsException extends ArithmeticException {
    public NotEnoughSeatsException(int availableSeats, int seatsBooked) {
        super("You tried to book " + seatsBooked + " seats, but only " + availableSeats + " were available");
    }
}
