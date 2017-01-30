package Tree;

import Auxiliaries.Auxiliary;
import Constants.Constants;
import Singletons.Result;
import Singletons.VariablesList;
import Variables.Variable;
import Visitor.OperationsVisitor;
import com.sun.corba.se.impl.orbutil.closure.Constant;

/**
 * Created by Andrei Spatariu on 1/5/2017.
 */
public class Node {
    public String name;
    public String nodeType;
    public Result currentResult;
    public String operationType;
    public Node[] sons;

    public Node(){
        sons = new Node[2];
        currentResult = new Result();
    }

    public void add(String expression){
        String[] arguments = expression.split(" ");

        while(arguments[0].equals("(") && Auxiliary.getCorrespondingParenthesisIndex(arguments, 0) == arguments.length - 1)
            arguments = Auxiliary.eliminateFirstAndLastParenthesis(arguments);

        int index = Auxiliary.getFirstOperandLowestPriorityIndex(arguments);

        if(index == 0){
            //this means that there are no more operands in the expression, only a variable name

            name = arguments[0].replaceAll(" ", "");
            nodeType = Constants.NodeTypes.VARIABLE;

            VariablesList variablesList = VariablesList.getInstance();

            currentResult = variablesList.getVariable(name).toResult();

            return;
        }

        String[] newExpressions = Auxiliary.splitStringByIndex(arguments, index);

        name = arguments[index];
        nodeType = Constants.NodeTypes.OPERATOR;

        operationType = arguments[index];

        sons[0] = new Node();
        sons[1] = new Node();

        sons[0].add(newExpressions[0]);
        sons[1].add(newExpressions[1]);
    }

    public Variable toVariable(){
        switch(nodeType){
            case Constants.NodeTypes.OPERATOR:
                return currentResult.toVariable();

            case Constants.NodeTypes.VARIABLE:
                VariablesList variablesList = VariablesList.getInstance();
                return variablesList.getVariable(name);
        }

        return null;
    }

    public Result evaluate(){
        Node leftNode = sons[0];
        Node rightNode = sons[1];
        NodeOperations nodeOperations = new NodeOperations();

        if(leftNode.nodeType.equals(Constants.NodeTypes.OPERATOR) &&
                rightNode.nodeType.equals(Constants.NodeTypes.OPERATOR))
            return nodeOperations.bothOperators(leftNode, rightNode, operationType);

        if(leftNode.nodeType.equals(Constants.NodeTypes.OPERATOR) &&
            rightNode.nodeType.equals(Constants.NodeTypes.VARIABLE))
            return nodeOperations.leftOperatorRightVariable(leftNode, rightNode, operationType);

        if(leftNode.nodeType.equals(Constants.NodeTypes.VARIABLE) &&
                rightNode.nodeType.equals(Constants.NodeTypes.OPERATOR))
            return nodeOperations.leftVariableRightOperator(leftNode, rightNode, operationType);

        if(leftNode.nodeType.equals(Constants.NodeTypes.VARIABLE) &&
                rightNode.nodeType.equals(Constants.NodeTypes.VARIABLE))
            return nodeOperations.bothVariables(leftNode, rightNode, operationType);

        return null;
    }
}
