package Variables;

import Constants.Constants;
import Singletons.Result;
import Visitor.OperationsVisitor;

/**
 * Created by Andrei Spatariu on 1/3/2017.
 */
public class DoubleVar implements Variable{
    public double value;
    public String name;

    public Result accept(OperationsVisitor visitor, String operation, Result result){
        return visitor.visit(this, operation, result);
    }

    public DoubleVar(String name, String value) {
        this.value = Double.parseDouble(value);
        this.name = name;
    }

    public IntegerVar toIntegerVar(){
        return new IntegerVar(Double.toString(value), name);
    }

    public StringVar toStringVar(){
        return new StringVar(Double.toString(value), name);
    }

    public Result toResult(){
        return new Result(null, value, Constants.Types.DOUBLE);
    }

    public String getName(){
        return name;
    }

    public String getStringValue(){
        return Double.toString(value);
    }

    public void setValueTo(String value){
        this.value = Double.parseDouble(value);
    }
}
