package Factory;

import Constants.Constants;
import Singletons.VariablesList;
import Variables.DoubleVar;
import Variables.IntegerVar;
import Variables.StringVar;
import Variables.Variable;

/**
 * Created by Andrei Spatariu on 1/4/2017.
 */
public class VariableFactory {

    public static Variable getVariable(String declaration){

        declaration = declaration.replaceAll("\"", "");

        String[] arguments = declaration.split(" ");
        String type = arguments[0];

        switch(type){
            case Constants.Types.INT:
                return createInteger(arguments);

            case Constants.Types.DOUBLE:
                return createDouble(arguments);

            case Constants.Types.STRING:
                return createString(arguments);
        }

        return null;
    }

    private static IntegerVar createInteger(String[] arguments){
        VariablesList variablesList = VariablesList.getInstance();

        String name = arguments[1];
        String value = arguments[3];

        IntegerVar newInteger = new IntegerVar(name, value);

        if(!name.equals("additionalValue"))
            variablesList.addVariable(newInteger);

        return newInteger;
    }

    private static DoubleVar createDouble(String[] arguments){
        VariablesList variablesList = VariablesList.getInstance();

        String name = arguments[1];
        String value = arguments[3];

        DoubleVar newDouble = new DoubleVar(name, value);

        if(!name.equals("additionalValue"))
            variablesList.addVariable(newDouble);

        return newDouble;
    }

    private static StringVar createString(String[] arguments) {
        VariablesList variablesList = VariablesList.getInstance();
        String value = new String();

        String name = arguments[1];

        if(arguments.length < 4)
            value = null;
        else
            value = arguments[3];

        StringVar newString = new StringVar(name, value);

        if(!name.equals("additionalValue"))
            variablesList.addVariable(newString);

        return newString;
    }
}
