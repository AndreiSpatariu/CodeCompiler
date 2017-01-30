package Auxiliaries;

import Constants.Constants;

/**
 * Created by Andrei Spatariu on 12/28/2016.
 */
public class Priority {
    public static int getPriority(String operand) {
        switch(operand) {
            case Constants.Operations.PLUS:
                return 1;
            case Constants.Operations.MINUS:
                return 1;
            case Constants.Operations.MULTIPLY:
                return 2;
            case Constants.Operations.DIVIDE:
                return 2;
        }

        return 0;
    }
}
