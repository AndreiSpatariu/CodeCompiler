package Operations;

import Auxiliaries.Auxiliary;
import Constants.Constants;
import Singletons.Result;
import Variables.IntegerVar;

import java.awt.*;

/**
 * Created by Andrei Spatariu on 1/4/2017.
 */
public class IntegerOperations{

    public static Result add(IntegerVar toAdd, Result result){

        switch(result.type){
            case Constants.Types.INT:
                result.type = Constants.Types.INT;
                result.numericalResult += (double)toAdd.value;
                break;

            case Constants.Types.DOUBLE:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult += (double)toAdd.value;
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.STRING;
                result.stringResult += Integer.toString(toAdd.value);
                break;
        }

        return result;
    }

    public static Result subtract(IntegerVar toSubtract, Result result){

        switch(result.type){
            case Constants.Types.INT:
                result.type = Constants.Types.INT;
                result.numericalResult -= toSubtract.value;
                break;

            case Constants.Types.DOUBLE:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult -= toSubtract.value;
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.STRING;

                if(toSubtract.value < 0) {
                    Auxiliary.addHashesToResult(toSubtract.value, result);
                    break;
                }

                Auxiliary.deleteCharactersFromResult(toSubtract.value, result);
                break;
        }

        return result;
    }

    public static Result multiply(IntegerVar toMultiply, Result result){

        switch(result.type){
            case Constants.Types.INT:
                result.type = Constants.Types.INT;
                result.numericalResult *= toMultiply.value;
                break;

            case Constants.Types.DOUBLE:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult *= toMultiply.value;
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.STRING;
                String initialString = result.stringResult;

                for(int i = 0; i < toMultiply.value; i++)
                    result.stringResult += initialString;

                break;
        }

        return result;
    }

    public static Result divide(IntegerVar toDivide, Result result){

        switch(result.type) {
            case Constants.Types.INT:
                result.type = Constants.Types.INT;
                result.numericalResult /= toDivide.value;
                break;

            case Constants.Types.DOUBLE:
                result.type = Constants.Types.DOUBLE;
                result.numericalResult /= toDivide.value;
                break;

            case Constants.Types.STRING:
                result.type = Constants.Types.STRING;

                if(toDivide.value == 0)
                    break;

                result.stringResult = Auxiliary.keepFirstCharactersFromResult(result.stringResult.length() / toDivide.value, result);
                break;
        }

        return result;
    }
}
