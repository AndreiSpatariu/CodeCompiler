package Operations;

import Auxiliaries.Auxiliary;
import Constants.Constants;
import Singletons.Result;
import Variables.DoubleVar;

/**
 * Created by Andrei Spatariu on 1/4/2017.
 */
public class DoubleOperations {
    public static Result add(DoubleVar toAdd, Result result){

        switch(result.type){
            case Constants.Types.INT:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult += toAdd.value;
                break;

            case Constants.Types.DOUBLE:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult += toAdd.value;
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.STRING;
                result.stringResult += Double.toString(toAdd.value);
                break;
        }

        return result;
    }

    public static Result subtract(DoubleVar toSubtract, Result result){

        switch(result.type){
            case Constants.Types.INT:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult -= toSubtract.value;
                break;

            case Constants.Types.DOUBLE:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult -= toSubtract.value;
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult = result.stringResult.length() - toSubtract.value;
                result.stringResult = null;
                break;
        }

        return result;
    }

    public static Result multiply(DoubleVar toMultiply, Result result){

        switch(result.type){
            case Constants.Types.INT:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult *= toMultiply.value;
                break;

            case Constants.Types.DOUBLE:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult *= toMultiply.value;
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult = result.stringResult.length() * toMultiply.value;
                result.stringResult = null;
                break;
        }

        return result;
    }

    public static Result divide(DoubleVar toDivide, Result result){

        switch(result.type) {
            case Constants.Types.INT:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult /= toDivide.value;
                break;

            case Constants.Types.DOUBLE:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult /= toDivide.value;
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult = result.stringResult.length() / toDivide.value;
                result.stringResult = null;
                break;
        }

        return result;
    }
}
