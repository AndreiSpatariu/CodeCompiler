package Variables;

import Singletons.Result;
import Visitor.OperationsVisitor;

/**
 * Created by Andrei Spatariu on 12/28/2016.
 */
public interface Variable{
    Result accept(OperationsVisitor visitor, String operation, Result result);
    Result toResult();
    String getName();
    String getStringValue();
    void setValueTo(String value);
}
