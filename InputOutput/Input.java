package InputOutput;

import Auxiliaries.Auxiliary;
import Constants.Constants;
import Factory.VariableFactory;
import Singletons.VariablesList;
import Tree.BinaryTree;
import Variables.Variable;

import java.io.PrintWriter;

/**
 * Created by Andrei Spatariu on 1/4/2017.
 */
public class Input {

    public static void ReadLine(String string, PrintWriter writer){

        String instructionType = Auxiliary.getInstructionType(string);

        switch(instructionType){
            case Constants.Instructions.ADD_VARIABLE:
                VariablesList variablesList = VariablesList.getInstance();
                Variable variable = VariableFactory.getVariable(string);

                variablesList.addVariable(variable);
                return;

            case Constants.Instructions.EXPRESSION:
                BinaryTree.deleteTree();
                BinaryTree tree = BinaryTree.getInstance();

                //remove the "eval" part of the string
                string = string.substring(5);

                tree.actualTree.add(string);

                tree.printEvaluationResult(writer);
                return;
        }
    }
}
