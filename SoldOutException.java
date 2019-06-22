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
public class SoldOutException extends RuntimeException {

    private final String message;

    public SoldOutException(String string) {
        this.message = string;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
