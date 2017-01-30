package Variables;

import Constants.Constants;
import Singletons.Result;
import Visitor.OperationsVisitor;

/**
 * Created by Andrei Spatariu on 1/3/2017.
 */
public class StringVar implements Variable{
    public String value;
    public String name;

    public Result accept(OperationsVisitor visitor, String operation, Result result){
        return visitor.visit(this, operation, result);
    }

    public StringVar(String name, String value){
        this.value = value;
        this.name = name;
    }

    public IntegerVar toIntegerVar(){
        return new IntegerVar(value, name);
    }

    public DoubleVar toDoubleVar(){
        return new DoubleVar(value, name);
    }

    public Result toResult(){
        return new Result(value, 0, Constants.Types.STRING);
    }

    public String getName(){
        return name;
    }

    public String getStringValue(){
        return value;
    }

    public void setValueTo(String value){
        this.value = value;
    }
}
