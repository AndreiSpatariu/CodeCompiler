package Visitor;

import Singletons.Result;
import Variables.DoubleVar;
import Variables.IntegerVar;
import Variables.StringVar;

/**
 * Created by Andrei Spatariu on 1/3/2017.
 */
public interface IOperationsVisitor {
    Result visit(IntegerVar variable, String operation, Result result);
    Result visit(DoubleVar variable, String operation, Result result);
    Result visit(StringVar variable, String operation, Result result);
}
