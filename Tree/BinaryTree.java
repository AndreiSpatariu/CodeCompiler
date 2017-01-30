package Tree;

import Constants.Constants;
import Singletons.Result;

import java.io.PrintWriter;

/**
 * Created by Andrei Spatariu on 12/28/2016.
 */
public class BinaryTree {
    private static BinaryTree binaryTree;
    public Node actualTree;

    public static BinaryTree getInstance(){
        if(binaryTree != null)
            return binaryTree;

        binaryTree = new BinaryTree();

        return binaryTree;
    }

    public BinaryTree(){
        actualTree = new Node();
    }

    public static void deleteTree(){
        binaryTree = null;
    }

    public void printEvaluationResult(PrintWriter writer){
        Result result = actualTree.evaluate();

        switch(result.type){
            case Constants.Types.STRING:
                writer.println(result.stringResult);
                return;

            case Constants.Types.INT:
                writer.println((int)result.numericalResult);
                return;

            case Constants.Types.DOUBLE:
                writer.println(result.numericalResult);
                return;
        }
    }
}
