package Singletons;

import Variables.Variable;
import java.util.ArrayList;

/**
 * Created by Andrei Spatariu on 1/4/2017.
 */
public class VariablesList {
    public ArrayList<Variable> variables;
    private static VariablesList variablesList;

    public static VariablesList getInstance(){
        if(variablesList != null)
            return variablesList;

        variablesList = new VariablesList();
        variablesList.variables = new ArrayList<Variable>();

        return variablesList;
    }

    public void addVariable(Variable variable){
        if(containsVariable(variable)){
            updateVariable(variable);
            return;
        }

        variables.add(variable);
    }

    private boolean containsVariable(Variable variable){

        for(Variable tempVariable : variables)
            if(tempVariable.getName().equals(variable.getName()))
                return true;

        return false;
    }

    private static void updateVariable(Variable variable){
        VariablesList variablesList = VariablesList.getInstance();

        for(Variable tempVariable : variablesList.variables)
            if(tempVariable.getName().equals(variable.getName())) {
                tempVariable.setValueTo(variable.getStringValue());
            }
    }

    public Variable getVariable(String name){

        for(Variable tempVariable: variables)
            if(tempVariable.getName().equals(name))
                return tempVariable;

        System.out.println("Variable should have been found but it has not been found");
        return null;
    }
}
