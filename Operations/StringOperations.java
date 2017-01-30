package Operations;

import Auxiliaries.Auxiliary;
import Constants.Constants;
import Singletons.Result;
import Variables.StringVar;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by Andrei Spatariu on 1/4/2017.
 */
public class StringOperations {
    public static Result add(StringVar toAdd, Result result){

        switch(result.type){
            case Constants.Types.INT:
                result.type = Constants.Types.STRING;
                result.stringResult = Double.toString(result.numericalResult);
                result.numericalResult = 0;
                result.stringResult += toAdd.value;
                break;

            case Constants.Types.DOUBLE:
                result.type = Constants.Types.STRING;
                result.stringResult = Double.toString(result.numericalResult);
                result.numericalResult = 0;
                result.stringResult += toAdd.value;
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.STRING;
                result.stringResult += toAdd.value;
                break;
        }

        return result;
    }

    public static Result subtract(StringVar toSubtract, Result result){

        switch(result.type){
            case Constants.Types.INT:
                result.type = Constants.Types.INT;
                result.numericalResult -= toSubtract.value.length();
                result.stringResult = null;
                break;

            case Constants.Types.DOUBLE:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult -= toSubtract.value.length();
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.INT;
                result.numericalResult = result.stringResult.length() - toSubtract.value.length();
                result.stringResult = null;
                break;
        }

        return result;
    }

    public static Result multiply(StringVar toMultiply, Result result) {
        String initialString = toMultiply.value;

        switch (result.type) {
            case Constants.Types.INT:
                result.type = Constants.Types.STRING;

                if(result.numericalResult < 0) {
                    Result auxiliaryResult = toMultiply.toResult();
                    Auxiliary.addHashesToResult((int) result.numericalResult, auxiliaryResult);
                    result = auxiliaryResult;
                    break;
                }

                for(int i = 0; i < result.numericalResult; i++)
                    result.stringResult += initialString;

                result.numericalResult = 0;
                break;

            case Constants.Types.DOUBLE:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult *= toMultiply.value.length();
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.INT;
                result.numericalResult = result.stringResult.length() * toMultiply.value.length();
                result.stringResult = null;
                break;
        }

        return result;
    }

    public static Result divide(StringVar toDivide, Result result){
        double stringLength = toDivide.value.length();

        switch(result.type) {
            case Constants.Types.INT:
                result.numericalResult /= stringLength;
                break;

            case Constants.Types.DOUBLE:
                result.numericalResult /= stringLength;
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.INT;
                result.numericalResult = result.stringResult.length() / stringLength;
                result.stringResult = null;
                break;
        }

        return result;
    }
}
