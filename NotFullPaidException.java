/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author Ahmed Fawzi
 */
public class NotFullPaidException extends RuntimeException {

    private final String message;
    private final double remaining;

    public NotFullPaidException(String message, double remaining) {
        this.message = message;
        this.remaining = remaining;
    }

    public double getRemaining() {
        return remaining;
    }

    @Override
    public String getMessage() {
        return message + remaining;
    }
}
