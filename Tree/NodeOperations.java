package Tree;

import Singletons.Result;
import Visitor.OperationsVisitor;

/**
 * Created by Andrei Spatariu on 1/8/2017.
 */
public class NodeOperations {
    public static Result bothOperators(Node leftNode, Node rightNode, String operation){
        if(leftNode.currentResult.isNull())
            leftNode.currentResult = leftNode.evaluate();

        if(rightNode.currentResult.isNull())
            rightNode.currentResult = rightNode.evaluate();

        OperationsVisitor operationsVisitor = new OperationsVisitor();

        return rightNode.toVariable().accept(operationsVisitor, operation, leftNode.currentResult);
    }

    public static Result leftOperatorRightVariable(Node leftNode, Node rightNode, String operation){
        if(leftNode.currentResult.isNull())
            leftNode.currentResult = leftNode.evaluate();

        OperationsVisitor operationsVisitor = new OperationsVisitor();

        return rightNode.toVariable().accept(operationsVisitor, operation, leftNode.currentResult);
    }

    public static Result leftVariableRightOperator(Node leftNode, Node rightNode, String operation){
        if(rightNode.currentResult.isNull())
            rightNode.currentResult = rightNode.evaluate();

        OperationsVisitor operationsVisitor = new OperationsVisitor();

        return rightNode.toVariable().accept(operationsVisitor, operation, leftNode.currentResult);
    }

    public static Result bothVariables(Node leftNode, Node rightNode, String operation){
        OperationsVisitor operationsVisitor = new OperationsVisitor();

        return rightNode.toVariable().accept(operationsVisitor, operation, leftNode.currentResult);
    }
}
