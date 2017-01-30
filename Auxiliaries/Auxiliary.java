package Auxiliaries;

import Constants.Constants;
import Singletons.Result;

import java.util.Arrays;

/**
 * Created by Andrei Spatariu on 1/4/2017.
 */
public class Auxiliary {
    public static void deleteCharactersFromResult(double numberOfCharacters, Result result){

        if(result.type != Constants.Types.STRING){
            System.out.println("Trying to delete characters from a non-string");
            return;
        }

        double resultLength = result.stringResult.length();

        if(numberOfCharacters >= resultLength){
            result.stringResult = null;
            return;
        }

        result.stringResult = result.stringResult.substring(0, (int)(resultLength - numberOfCharacters));
    }

    public static String keepFirstCharactersFromResult(double numberOfCharacters, Result result){

        if(result.type != Constants.Types.STRING){
            System.out.println("Trying to keep characters from a non-string");
            return null;
        }

        if(numberOfCharacters > result.stringResult.length()){
            System.out.println("The number of characters that you are trying to keep is bigger than the string itself");
            return result.stringResult;
        }

        return result.stringResult.substring(0, (int)(numberOfCharacters));
    }

    public static String getInstructionType(String string){
        String[] arguments = string.split(" ");

        switch(arguments[0]){
            case Constants.Types.INT:
                return Constants.Instructions.ADD_VARIABLE;

            case Constants.Types.DOUBLE:
                return Constants.Instructions.ADD_VARIABLE;

            case Constants.Types.STRING:
                return Constants.Instructions.ADD_VARIABLE;

            case Constants.Auxiliaries.EVALUATE:
                return Constants.Instructions.EXPRESSION;
        }

        System.out.println("Instruction was not recognized");
        return null;
    }

    public static int getCorrespondingParenthesisIndex(String[] arguments, int index){
        if(!arguments[index].equals("(")) {
            System.out.println("This is not a parenthesis");
            return -1;
        }

        int numberOfAdditionalParanthesis = 0;

        for(int i = index + 1; i < arguments.length; i++){
            if(arguments[i].equals("(")){
                numberOfAdditionalParanthesis++;
                continue;
            }

            if(arguments[i].equals(")")){
                if(numberOfAdditionalParanthesis == 0)
                    return i;

                numberOfAdditionalParanthesis--;
            }
        }

        System.out.println("Failed to find corresponding parenthesis");
        return -1;
    }

    public static String[] splitStringByIndex(String[] arguments, int index){
        String leftString = new String();
        String rightString = new String();

        for(int i = 0; i < index; i++)
            leftString = leftString.concat(arguments[i] + " ");


        for(int i = index + 1; i < arguments.length; i++)
            rightString = rightString.concat(arguments[i] + " ");

        String[] result = new String[2];
        result[0] = leftString;
        result[1] = rightString;

        return result;
    }

    public static int getFirstOperandLowestPriorityIndex(String[] arguments){
        int lowestPriority = 3;
        int index = 0;

        for(int i = 0; i < arguments.length; i++){
            if(Auxiliary.isParenthesis(arguments[i])) {
                i = Auxiliary.getCorrespondingParenthesisIndex(arguments, i) - 1;
                continue;
            }

            if(Auxiliary.isOperand(arguments[i])){


                if(Priority.getPriority(arguments[i]) <= lowestPriority){
                    lowestPriority = Priority.getPriority((arguments[i]));
                    index = i;
                }
            }
        }

        //if the index is 0 then there is no operand in the expression
        return index;
    }

    private static boolean isOperand(String string){
        if(string.equals(Constants.Operations.PLUS) || string.equals(Constants.Operations.MINUS) ||
                string.equals(Constants.Operations.MULTIPLY) || string.equals(Constants.Operations.DIVIDE))
            return true;

        return false;
    }

    private static boolean isParenthesis(String string) {
        if(string.equals("("))
            return true;

        return false;
    }

    public static String[] eliminateFirstAndLastParenthesis(String[] arguments){
        if(Auxiliary.isParenthesis(arguments[0]) && Auxiliary.getCorrespondingParenthesisIndex(arguments, 0) == arguments.length - 1)
            return Arrays.copyOfRange(arguments, 1, arguments.length - 1);


        return arguments;
    }

    public static void addHashesToResult(int numberOfHashes, Result result){
        int number = -numberOfHashes;

        for(int i = 0; i < number; i++){
            result.stringResult += "#";
        }
    }

    public static double roundDouble(double value){
        return Math.round(value * 100.0) / 100.0;
    }
}
