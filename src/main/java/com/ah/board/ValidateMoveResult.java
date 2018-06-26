package com.ah.board;

/**
 * Created by Arlind Hoxha on 6/24/2018.
 */
public class ValidateMoveResult {

    private boolean isValid;
    private boolean isPassant;

    public ValidateMoveResult(boolean isValid, boolean isPassant) {
        this.isValid = isValid;
        this.isPassant = isPassant;
    }

    public boolean isValid() {
        return isValid;
    }

    public boolean isPassant() {
        return isPassant;
    }
}
