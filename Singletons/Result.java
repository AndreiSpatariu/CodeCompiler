package Singletons;

import Constants.Constants;
import Factory.VariableFactory;
import Variables.Variable;

/**
 * Created by Andrei Spatariu on 1/3/2017.
 */
public class Result {
    private static Result resultSingleton;

    public String stringResult;
    public double numericalResult;
    public String type;

    public static Result getInstance(){
        if(resultSingleton != null)
            return resultSingleton;

        resultSingleton = new Result();
        return resultSingleton;
    }

    public Result(){
        stringResult = new String();
        numericalResult = 0;
        type = new String();
    }

    public Result(String stringResult, double numericalResult, String type){
        this.stringResult = stringResult;
        this.numericalResult = numericalResult;
        this.type = type;
    }

    public static void resetResult(){
        Result result = Result.getInstance();

        result.stringResult = null;
        result.numericalResult = 0;
        result.type = null;
    }

    public boolean isNull(){
        return type.isEmpty();
    }

    public Variable toVariable(){
        String newString = new String();

        newString = type + " additionalValue = ";

        switch(type){
            case Constants.Types.INT:
                newString += (int)numericalResult;
                break;

            case Constants.Types.DOUBLE:
                newString += numericalResult;
                break;

            case Constants.Types.STRING:
                newString += stringResult;
                break;
        }

        return VariableFactory.getVariable(newString);
    }
}
