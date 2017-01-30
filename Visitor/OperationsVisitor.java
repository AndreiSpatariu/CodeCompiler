package Visitor;

import Constants.Constants;
import Operations.DoubleOperations;
import Operations.IntegerOperations;
import Operations.StringOperations;
import Singletons.Result;
import Variables.DoubleVar;
import Variables.IntegerVar;
import Variables.StringVar;

/**
 * Created by Andrei Spatariu on 1/3/2017.
 */
public class OperationsVisitor implements IOperationsVisitor {

    public Result visit(IntegerVar variable, String operation, Result result){
        switch(operation){
            case Constants.Operations.PLUS:
                return IntegerOperations.add(variable, result);

            case Constants.Operations.MINUS:
                return IntegerOperations.subtract(variable, result);

            case Constants.Operations.MULTIPLY:
                return IntegerOperations.multiply(variable, result);

            case Constants.Operations.DIVIDE:
                return IntegerOperations.divide(variable, result);
        }

        return null;
    }

    public Result visit(DoubleVar variable, String operation, Result result){
        switch(operation){
            case Constants.Operations.PLUS:
                return DoubleOperations.add(variable, result);

            case Constants.Operations.MINUS:
                return DoubleOperations.subtract(variable, result);

            case Constants.Operations.MULTIPLY:
                return DoubleOperations.multiply(variable, result);

            case Constants.Operations.DIVIDE:
                return DoubleOperations.divide(variable, result);
        }

        return null;
    }

    public Result visit(StringVar variable, String operation, Result result){
        switch(operation){
            case Constants.Operations.PLUS:
                return StringOperations.add(variable, result);

            case Constants.Operations.MINUS:
                return StringOperations.subtract(variable, result);

            case Constants.Operations.MULTIPLY:
                return StringOperations.multiply(variable, result);

            case Constants.Operations.DIVIDE:
                return StringOperations.divide(variable, result);
        }

        return null;
    }
}
