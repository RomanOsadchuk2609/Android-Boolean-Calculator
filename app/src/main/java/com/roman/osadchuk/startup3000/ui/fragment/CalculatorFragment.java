package com.roman.osadchuk.startup3000.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.roman.osadchuk.startup3000.R;
import com.roman.osadchuk.startup3000.model.BooleanOperation;
import com.roman.osadchuk.startup3000.model.LastSign;
import com.roman.osadchuk.startup3000.model.Operation;

import java.util.Stack;

public class CalculatorFragment extends Fragment {

    private Button buttonConjunction, buttonDisjunction, buttonEquality, buttonExclusiveOr, buttonNotOr,
        buttonNotAnd, buttonImplication, buttonConverseImplication, buttonNotImplication,
        buttonNotConverseImplication, buttonNot, buttonTrue, buttonFalse, buttonNull, buttonEquals,
        buttonLeftBracket, buttonRightBracket, buttonClearLastSign, buttonClearAll;

    private TextView currentExpressionTV, historyTV;

    private boolean isLastSignOperation=true, isLastSignValue=false, isLastSignBracket=false;

    private LastSign lastSign;

    private Stack<Integer> lastSignLengthStack = new Stack<>();
    private int lastSignLength=0;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    public static CalculatorFragment newInstance() {
        CalculatorFragment fragment = new CalculatorFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lastSignLengthStack.push(0);

        currentExpressionTV = view.findViewById(R.id.currentExpressionTV);
        historyTV = view.findViewById(R.id.historyTV);
        historyTV.setText("");
        clearExpression();

        buttonConjunction = view.findViewById(R.id.buttonConjunction);
        buttonDisjunction = view.findViewById(R.id.buttonDisjunction);
        buttonEquality = view.findViewById(R.id.buttonEquality);
        buttonExclusiveOr = view.findViewById(R.id.buttonExclusiveOr);
        buttonNotOr = view.findViewById(R.id.buttonNotOr);
        buttonNotAnd = view.findViewById(R.id.buttonNotAnd);
        buttonImplication = view.findViewById(R.id.buttonImplication);
        buttonConverseImplication = view.findViewById(R.id.buttonConverseImplication);
        buttonNotImplication = view.findViewById(R.id.buttonNotImplication);
        buttonNotConverseImplication = view.findViewById(R.id.buttonNotConverseImplication);
        buttonNot = view.findViewById(R.id.buttonNot);
        buttonTrue = view.findViewById(R.id.buttonTrue);
        buttonFalse = view.findViewById(R.id.buttonFalse);
        buttonNull = view.findViewById(R.id.buttonNull);
        buttonEquals = view.findViewById(R.id.buttonEquals);
        buttonLeftBracket = view.findViewById(R.id.buttonLeftBracket);
        buttonRightBracket = view.findViewById(R.id.buttonRightBracket);
        buttonClearLastSign = view.findViewById(R.id.buttonClearLastSign);
        buttonClearAll = view.findViewById(R.id.buttonClearAll);

        buttonConjunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonConjunction.getText().toString(),false,true,false,false);
            }
        });

        buttonDisjunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonDisjunction.getText().toString(),false,true,false,false);
            }
        });

        buttonEquality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonEquality.getText().toString(),false,true,false,false);
            }
        });

        buttonExclusiveOr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonExclusiveOr.getText().toString(),false,true,false,false);
            }
        });

        buttonNotOr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonNotOr.getText().toString(),false,true,false,false);
            }
        });

        buttonNotAnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonNotAnd.getText().toString(),false,true,false,false);
            }
        });

        buttonImplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonImplication.getText().toString(),false,true,false,false);
            }
        });

        buttonConverseImplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonConverseImplication.getText().toString(),false,true,false,false);
            }
        });


        buttonNotImplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonNotImplication.getText().toString(),false,true,false,false);
            }
        });

        buttonNotConverseImplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonNotConverseImplication.getText().toString(),false,true,false,false);
            }
        });

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonTrue.getText().toString(),true,false,false,false);
            }
        });

        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonFalse.getText().toString(),true,false,false,false);
            }
        });

        buttonNull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonNull.getText().toString(),true,false,false,false);
            }
        });

        buttonLeftBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonLeftBracket.getText().toString(),false,false,true,false);
            }
        });

        buttonRightBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSign(buttonRightBracket.getText().toString(),false,false,false,true);
            }
        });

        buttonClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearExpression();
            }
        });

        buttonClearLastSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearLastSign();
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBrackets();
            }
        });

    }

    private void checkBrackets(){
        String expression = currentExpressionTV.getText().toString();
        char[] signs = expression.toCharArray();
        int amountOfLeftBrackets=0, amountofRightBrackets=0;
        for (int i=0; i<signs.length; i++){
            if (signs[i]=='(') amountOfLeftBrackets++;
            if (signs[i]==')') amountofRightBrackets++;
        }

        if (amountOfLeftBrackets>amountofRightBrackets){
            Toast.makeText(getContext(),"Right bracket expected!",Toast.LENGTH_SHORT).show();
        }
        else if (amountOfLeftBrackets<amountofRightBrackets){
            Toast.makeText(getContext(),"Too many right brackets!",Toast.LENGTH_SHORT).show();
        }
        else if (amountOfLeftBrackets==amountofRightBrackets){
            parseExpression(currentExpressionTV.getText().toString());
        }
    }

    private void parseExpression(String expression){
        char[] signs = expression.toCharArray();
        int startIndex=0, endIndex=0;

        if (expression.contains("(")){
            for (int i=0; i<signs.length; i++){
                if (signs[i]=='(') startIndex=i;
                if (signs[i]==')') {
                    endIndex=i;
                    break;
                }
            }

            String expressionInBrackets = expression.substring(startIndex+1, endIndex);
            String result = getResult(expressionInBrackets);
            expression = expression.replace(expression.substring(startIndex,endIndex+1),result);
            parseExpression(expression);
        }
        else {
            String result = getResult(expression);
            if (historyTV.getText().toString().isEmpty()){
                historyTV.setText(currentExpressionTV.getText()+" = "+result);
            }
            else {
                historyTV.setText(historyTV.getText()+"\n"+currentExpressionTV.getText()+" = "+result);
            }
            //clearExpression();
            currentExpressionTV.setText(result);
            //defineLastSign(currentExpressionTV.getText().toString());
        }

    }

    private String lastResult="";

    private String getResult(String expression){
        String result = expression;
        lastResult = result;
        if (expression.contains(buttonConjunction.getText().toString())){
            Boolean value1 = null, value2 = null;
            int startIndex=0, endIndex=0;

            startIndex = expression.indexOf(buttonConjunction.getText().toString())-1;
            endIndex = expression.indexOf(buttonConjunction.getText().toString())
                    + buttonConjunction.getText().toString().length();

            char v1 = expression.charAt(startIndex);
            char v2 = expression.charAt(endIndex);

            if (v1=='1') value1 = true;
            else if (v1=='0') value1 = false;

            if (v2=='1') value2 = true;
            else if (v2=='0') value2 = false;

            BooleanOperation booleanOperation = new BooleanOperation(value1,value2,Operation.CONJUNCTION);
            Boolean booleanResult = booleanOperation.getResult();

            if (booleanResult==null) result = "x";
            else if (booleanResult) result = "1";
            else result = "0";

            lastResult = result;
            expression = expression.replace(expression.substring(startIndex,endIndex+1),result);

            if (expression.length()>1){
                getResult(expression);
            }

        }
        else if (expression.contains(buttonNotOr.getText().toString())){
            Boolean value1 = null, value2 = null;
            int startIndex=0, endIndex=0;

            startIndex = expression.indexOf(buttonNotOr.getText().toString())-1;
            endIndex = expression.indexOf(buttonNotOr.getText().toString())
                    + buttonNotOr.getText().toString().length();

            char v1 = expression.charAt(startIndex);
            char v2 = expression.charAt(endIndex);

            if (v1=='1') value1 = true;
            else if (v1=='0') value1 = false;

            if (v2=='1') value2 = true;
            else if (v2=='0') value2 = false;

            BooleanOperation booleanOperation = new BooleanOperation(value1,value2,Operation.NOT_OR);
            Boolean booleanResult = booleanOperation.getResult();

            if (booleanResult==null) result = "x";
            else if (booleanResult) result = "1";
            else result = "0";

            lastResult = result;
            expression = expression.replace(expression.substring(startIndex,endIndex+1),result);

            if (expression.length()>1){
                getResult(expression);
            }

        }
        else if (expression.contains(buttonNotAnd.getText().toString())){
            Boolean value1 = null, value2 = null;
            int startIndex=0, endIndex=0;

            startIndex = expression.indexOf(buttonNotAnd.getText().toString())-1;
            endIndex = expression.indexOf(buttonNotAnd.getText().toString())
                    + buttonNotAnd.getText().toString().length();

            char v1 = expression.charAt(startIndex);
            char v2 = expression.charAt(endIndex);

            if (v1=='1') value1 = true;
            else if (v1=='0') value1 = false;

            if (v2=='1') value2 = true;
            else if (v2=='0') value2 = false;

            BooleanOperation booleanOperation = new BooleanOperation(value1,value2,Operation.NOT_AND);
            Boolean booleanResult = booleanOperation.getResult();

            if (booleanResult==null) result = "x";
            else if (booleanResult) result = "1";
            else result = "0";

            lastResult = result;
            expression = expression.replace(expression.substring(startIndex,endIndex+1),result);

            if (expression.length()>1){
                getResult(expression);
            }

        }
        else if (expression.contains(buttonDisjunction.getText().toString())){
            Boolean value1 = null, value2 = null;
            int startIndex=0, endIndex=0;

            startIndex = expression.indexOf(buttonDisjunction.getText().toString())-1;
            endIndex = expression.indexOf(buttonDisjunction.getText().toString())
                    + buttonDisjunction.getText().toString().length();

            char v1 = expression.charAt(startIndex);
            char v2 = expression.charAt(endIndex);

            if (v1=='1') value1 = true;
            else if (v1=='0') value1 = false;

            if (v2=='1') value2 = true;
            else if (v2=='0') value2 = false;

            BooleanOperation booleanOperation = new BooleanOperation(value1,value2,Operation.DISJUNCTION);
            Boolean booleanResult = booleanOperation.getResult();

            if (booleanResult==null) result = "x";
            else if (booleanResult) result = "1";
            else result = "0";

            lastResult = result;
            expression = expression.replace(expression.substring(startIndex,endIndex+1),result);

            if (expression.length()>1){
                getResult(expression);
            }

        }
        else if (expression.contains(buttonNotImplication.getText().toString())){
            Boolean value1 = null, value2 = null;
            int startIndex=0, endIndex=0;

            startIndex = expression.indexOf(buttonNotImplication.getText().toString())-1;
            endIndex = expression.indexOf(buttonNotImplication.getText().toString())
                    + buttonNotImplication.getText().toString().length();

            char v1 = expression.charAt(startIndex);
            char v2 = expression.charAt(endIndex);

            if (v1=='1') value1 = true;
            else if (v1=='0') value1 = false;

            if (v2=='1') value2 = true;
            else if (v2=='0') value2 = false;

            BooleanOperation booleanOperation = new BooleanOperation(value1,value2,Operation.NOT_IMPLICATION);
            Boolean booleanResult = booleanOperation.getResult();

            if (booleanResult==null) result = "x";
            else if (booleanResult) result = "1";
            else result = "0";

            lastResult = result;
            expression = expression.replace(expression.substring(startIndex,endIndex+1),result);

            if (expression.length()>1){
                getResult(expression);
            }

        }
        else if (expression.contains(buttonImplication.getText().toString())){
            Boolean value1 = null, value2 = null;
            int startIndex=0, endIndex=0;

            startIndex = expression.indexOf(buttonImplication.getText().toString())-1;
            endIndex = expression.indexOf(buttonImplication.getText().toString())
                    + buttonImplication.getText().toString().length();

            char v1 = expression.charAt(startIndex);
            char v2 = expression.charAt(endIndex);

            if (v1=='1') value1 = true;
            else if (v1=='0') value1 = false;

            if (v2=='1') value2 = true;
            else if (v2=='0') value2 = false;

            BooleanOperation booleanOperation = new BooleanOperation(value1,value2,Operation.IMPLICATION);
            Boolean booleanResult = booleanOperation.getResult();

            if (booleanResult==null) result = "x";
            else if (booleanResult) result = "1";
            else result = "0";

            lastResult = result;
            expression = expression.replace(expression.substring(startIndex,endIndex+1),result);

            if (expression.length()>1){
                getResult(expression);
            }

        }
        else if (expression.contains(buttonNotConverseImplication.getText().toString())){
            Boolean value1 = null, value2 = null;
            int startIndex=0, endIndex=0;

            startIndex = expression.indexOf(buttonNotConverseImplication.getText().toString())-1;
            endIndex = expression.indexOf(buttonNotConverseImplication.getText().toString())
                    + buttonNotConverseImplication.getText().toString().length();

            char v1 = expression.charAt(startIndex);
            char v2 = expression.charAt(endIndex);

            if (v1=='1') value1 = true;
            else if (v1=='0') value1 = false;

            if (v2=='1') value2 = true;
            else if (v2=='0') value2 = false;

            BooleanOperation booleanOperation = new BooleanOperation(value1,value2,Operation.NOT_CONVERSE_IMPLICATION);
            Boolean booleanResult = booleanOperation.getResult();

            if (booleanResult==null) result = "x";
            else if (booleanResult) result = "1";
            else result = "0";

            lastResult = result;
            expression = expression.replace(expression.substring(startIndex,endIndex+1),result);

            if (expression.length()>1){
                getResult(expression);
            }

        }
        else if (expression.contains(buttonConverseImplication.getText().toString())){
            Boolean value1 = null, value2 = null;
            int startIndex=0, endIndex=0;

            startIndex = expression.indexOf(buttonConverseImplication.getText().toString())-1;
            endIndex = expression.indexOf(buttonConverseImplication.getText().toString())
                    + buttonConverseImplication.getText().toString().length();

            char v1 = expression.charAt(startIndex);
            char v2 = expression.charAt(endIndex);

            if (v1=='1') value1 = true;
            else if (v1=='0') value1 = false;

            if (v2=='1') value2 = true;
            else if (v2=='0') value2 = false;

            BooleanOperation booleanOperation = new BooleanOperation(value1,value2,Operation.CONVERSE_IMPLICATION);
            Boolean booleanResult = booleanOperation.getResult();

            if (booleanResult==null) result = "x";
            else if (booleanResult) result = "1";
            else result = "0";

            lastResult = result;
            expression = expression.replace(expression.substring(startIndex,endIndex+1),result);

            if (expression.length()>1){
                getResult(expression);
            }

        }
        else if (expression.contains(buttonExclusiveOr.getText().toString())){
            Boolean value1 = null, value2 = null;
            int startIndex=0, endIndex=0;

            startIndex = expression.indexOf(buttonExclusiveOr.getText().toString())-1;
            endIndex = expression.indexOf(buttonExclusiveOr.getText().toString())
                    + buttonExclusiveOr.getText().toString().length();

            char v1 = expression.charAt(startIndex);
            char v2 = expression.charAt(endIndex);

            if (v1=='1') value1 = true;
            else if (v1=='0') value1 = false;

            if (v2=='1') value2 = true;
            else if (v2=='0') value2 = false;

            BooleanOperation booleanOperation = new BooleanOperation(value1,value2,Operation.EXCLUSIVE_OR);
            Boolean booleanResult = booleanOperation.getResult();

            if (booleanResult==null) result = "x";
            else if (booleanResult) result = "1";
            else result = "0";

            lastResult = result;
            expression = expression.replace(expression.substring(startIndex,endIndex+1),result);

            if (expression.length()>1){
                getResult(expression);
            }

        }
        else if (expression.contains(buttonEquality.getText().toString())){
            Boolean value1 = null, value2 = null;
            int startIndex=0, endIndex=0;

            startIndex = expression.indexOf(buttonEquality.getText().toString())-1;
            endIndex = expression.indexOf(buttonEquality.getText().toString())
                    + buttonEquality.getText().toString().length();

            char v1 = expression.charAt(startIndex);
            char v2 = expression.charAt(endIndex);

            if (v1=='1') value1 = true;
            else if (v1=='0') value1 = false;

            if (v2=='1') value2 = true;
            else if (v2=='0') value2 = false;

            BooleanOperation booleanOperation = new BooleanOperation(value1,value2,Operation.EQUALITY);
            Boolean booleanResult = booleanOperation.getResult();

            if (booleanResult==null) result = "x";
            else if (booleanResult) result = "1";
            else result = "0";

            lastResult = result;
            expression = expression.replace(expression.substring(startIndex,endIndex+1),result);

            if (expression.length()>1){
                getResult(expression);
            }

        }
        return lastResult;
    }

    private void clearExpression(){
        currentExpressionTV.setText("");
        lastSign = null;
        lastSignLength = 0;
        lastSignLengthStack.clear();
        lastSignLengthStack.push(lastSignLength);
    }

    private void clearLastSign(){
        if (currentExpressionTV!=null && !currentExpressionTV.getText().toString().isEmpty()){

            String currentExpression = currentExpressionTV.getText().toString();
            lastSignLength = lastSignLengthStack.pop();
            currentExpression = currentExpression.substring(0,currentExpression.length()-lastSignLength);
            currentExpressionTV.setText(currentExpression);
            if (!currentExpression.isEmpty()){
                defineLastSign(currentExpression);
            }
            else {
                lastSign = null;
                lastSignLength = 0;
                lastSignLengthStack.clear();
                lastSignLengthStack.push(lastSignLength);
            }
        }
    }

    private void defineLastSign(String currentExpression){
        if (currentExpression!=null && !currentExpression.isEmpty()){

            lastSignLength = lastSignLengthStack.peek();
            String lastSign = currentExpression.substring(currentExpression.length()-lastSignLength,currentExpression.length());

            if (lastSign.equals("1") || lastSign.equals("0") || lastSign.equals("x") || lastSign.equals("X")){
                this.lastSign = LastSign.VALUE;
            }
            else if (lastSign.equals("(")){
                this.lastSign = LastSign.LEFT_BRACKET;
            }
            else if (lastSign.equals(")")){
                this.lastSign = LastSign.RIGHT_BRACKET;
            }
            else {
                this.lastSign = LastSign.OPERATION;
            }
        }
    }

    private void addSign(String sign, boolean isValue, boolean isOperation, boolean isLeftBracket, boolean isRightBracket){
        if (lastSign==null && (isValue || isLeftBracket)){
            currentExpressionTV.setText(sign);
            lastSignLength = sign.length();
            lastSignLengthStack.push(sign.length());
            defineLastSign(currentExpressionTV.getText().toString());
        }
        else if (lastSign!=null){
            switch (lastSign){
                case VALUE:
                    if (isValue){
                        clearLastSign();
                        currentExpressionTV.setText(currentExpressionTV.getText()+sign);
                        lastSignLength = sign.length();
                        lastSignLengthStack.push(sign.length());
                        defineLastSign(currentExpressionTV.getText().toString());
                    }
                    else if (isOperation || isRightBracket){
                        currentExpressionTV.setText(currentExpressionTV.getText()+sign);
                        lastSignLength = sign.length();
                        lastSignLengthStack.push(sign.length());
                        defineLastSign(currentExpressionTV.getText().toString());
                    }
                    break;

                case OPERATION:
                    if (isOperation){
                        clearLastSign();
                        currentExpressionTV.setText(currentExpressionTV.getText()+sign);
                        lastSignLength = sign.length();
                        lastSignLengthStack.push(sign.length());
                        defineLastSign(currentExpressionTV.getText().toString());
                    }
                    else if (isValue || isLeftBracket){
                        currentExpressionTV.setText(currentExpressionTV.getText()+sign);
                        lastSignLength = sign.length();
                        lastSignLengthStack.push(sign.length());
                        defineLastSign(currentExpressionTV.getText().toString());
                    }
                    break;

                case LEFT_BRACKET:
                    if (isLeftBracket){
                        //clearLastSign();
                        currentExpressionTV.setText(currentExpressionTV.getText()+sign);
                        lastSignLength = sign.length();
                        lastSignLengthStack.push(sign.length());
                        defineLastSign(currentExpressionTV.getText().toString());
                    }
                    else if (isValue){
                        currentExpressionTV.setText(currentExpressionTV.getText()+sign);
                        lastSignLength = sign.length();
                        lastSignLengthStack.push(sign.length());
                        defineLastSign(currentExpressionTV.getText().toString());
                    }
                    break;

                case RIGHT_BRACKET:
                    if (isRightBracket){
                        //clearLastSign();
                        currentExpressionTV.setText(currentExpressionTV.getText()+sign);
                        lastSignLength = sign.length();
                        lastSignLengthStack.push(sign.length());
                        defineLastSign(currentExpressionTV.getText().toString());
                    }
                    else if (isOperation){
                        currentExpressionTV.setText(currentExpressionTV.getText()+sign);
                        lastSignLength = sign.length();
                        lastSignLengthStack.push(sign.length());
                        defineLastSign(currentExpressionTV.getText().toString());
                    }
                    break;
            }
        }
    }
}
