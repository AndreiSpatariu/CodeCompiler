package Variables;

import Constants.Constants;
import Singletons.Result;
import Visitor.OperationsVisitor;

/**
 * Created by Andrei Spatariu on 1/3/2017.
 */
public class IntegerVar implements Variable{
    public int value;
    public String name;

    public Result accept(OperationsVisitor visitor, String operation, Result result){
        return visitor.visit(this, operation, result);
    }

    public IntegerVar(String name, String value){
        this.name = name;
        this.value = Integer.valueOf(value);
    }

    public DoubleVar toDoubleVar(){
        return new DoubleVar(Integer.toString(value), name);
    }

    public StringVar toStringVar(){
        return new StringVar(Integer.toString(value), name);
    }

    public Result toResult(){
        return new Result(null, (double)value, Constants.Types.INT);
    }

    public String getName(){
        return name;
    }

    public String getStringValue(){
        return Integer.toString(value);
    }

    public void setValueTo(String value){
        this.value = Integer.parseInt(value);
    }
}
