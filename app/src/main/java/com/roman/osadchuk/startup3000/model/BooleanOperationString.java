package com.roman.osadchuk.startup3000.model;

public class BooleanOperationString {
    private String value1, value2, result;

    private String[][] conjunction =
            {
                    {"-", "0", "1", "x", "!x"},
                    {"0", "0", "0", "0", "0"},
                    {"1", "0", "1", "x", "!x"},
                    {"x", "0", "x", "x", "0"},
                    {"!x", "0", "!x", "0", "!x"}
            };

    private String[][] disjunction =
            {
                    {"-", "0", "1", "x", "!x"},
                    {"0", "0", "1", "x", "!x"},
                    {"1", "1", "1", "1", "1"},
                    {"x", "x", "1", "x", "1"},
                    {"!x", "!x", "1", "1", "!x"}
            };


    private String[][] equality =
            {
                    {"-", "0", "1", "x", "!x"},
                    {"0", "1", "0", "!x", "x"},
                    {"1", "0", "1", "x", "!x"},
                    {"x", "!x", "x", "1", "0"},
                    {"!x", "x", "!x", "0", "1"}
            };


    private String[][] exclusiveOr =
            {
                    {"-", "0", "1", "x", "!x"},
                    {"0", "0", "1", "x", "!x"},
                    {"1", "1", "0", "!x", "x"},
                    {"x", "x", "!x", "0", "1"},
                    {"!x", "!x", "x", "1", "0"}
            };

    private String[][] notOr =
            {
                    {"-", "0", "1", "x", "!x"},
                    {"0", "1", "0", "!x", "x"},
                    {"1", "0", "0", "0", "0"},
                    {"x", "!x", "0", "!x", "0"},
                    {"!x", "x", "0", "0", "x"}
            };

    private String[][] notAnd =
            {
                    {"-", "0", "1", "x", "!x"},
                    {"0", "1", "1", "1", "1"},
                    {"1", "1", "0", "!x", "x"},
                    {"x", "1", "!x", "!x", "1"},
                    {"!x", "1", "x", "1", "x"}
            };

    private String[][] implication =
            {
                    {"-", "0", "1", "x", "!x"},
                    {"0", "1", "0", "!x", "x"},
                    {"1", "1", "1", "1", "1"},
                    {"x", "1", "x", "1", "x"},
                    {"!x", "1", "!x", "!x", "1"}
            };


    private String[][] converseImplication =
            {
                    {"-", "0", "1", "x", "!x"},
                    {"0", "1", "1", "1", "1"},
                    {"1", "0", "1", "x", "!x"},
                    {"x", "!x", "1", "1", "!x"},
                    {"!x", "x", "1", "x", "1"}
            };

    private String[][] notImplication =
            {
                    {"-", "0", "1", "x", "!x"},
                    {"0", "0", "1", "x", "!x"},
                    {"1", "0", "0", "0", "0"},
                    {"x", "0", "!x", "0", "!x"},
                    {"!x", "0", "x", "x", "0"}
            };

    private String[][] notConverseImplication =
            {
                    {"-", "0", "1", "x", "!x"},
                    {"0", "0", "0", "0", "0"},
                    {"1", "1", "0", "!x", "x"},
                    {"x", "x", "0", "0", "x"},
                    {"!x", "!x", "0", "!x", "0"}
            };


    public BooleanOperationString(String value1, String value2, Operation operation) {
        this.value1 = value1;
        this.value2 = value2;
        setResult(operation);
    }


    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(Operation operation) {
        switch (operation) {
            case CONJUNCTION:
                result = conjunction();
                break;
            case DISJUNCTION:
                result = disjunction();
                break;
            case EQUALITY:
                result = equality();
                break;
            case EXCLUSIVE_OR:
                result = exclusiveOr();
                break;
            case NOT_OR:
                result = notOr();
                break;
            case NOT_AND:
                result = notAnd();
                break;
            case IMPLICATION:
                result = implication();
                break;
            case CONVERSE_IMPLICATION:
                result = converseImplication();
                break;
            case NOT_IMPLICATION:
                result = notImplication();
                break;
            case NOT_CONVERSE_IMPLICATION:
                result = notConverseImplication();
                break;
            /*case NOT: result = not(); break;*/
            default:
                result = null;
        }
    }

   /* public Boolean not(){
        return value1==null ? null : !value1;
    }*/

    //0
    public String conjunction() {
        int index1 = 1, index2 = 1;
        for (int i = 1; i < conjunction.length; i++) {
            if (conjunction[i][0].equals(value2)) index1 = i;
            if (conjunction[0][i].equals(value1)) index2 = i;
        }
        return conjunction[index1][index2];
    }

    //1
    public String disjunction() {
        int index1 = 1, index2 = 1;
        for (int i = 1; i < disjunction.length; i++) {
            if (disjunction[i][0].equals(value2)) index1 = i;
            if (disjunction[0][i].equals(value1)) index2 = i;
        }
        return disjunction[index1][index2];
    }

    //2
    public String equality() {
        int index1 = 1, index2 = 1;
        for (int i = 1; i < equality.length; i++) {
            if (equality[i][0].equals(value2)) index1 = i;
            if (equality[0][i].equals(value1)) index2 = i;
        }
        return equality[index1][index2];
    }

    //3
    public String exclusiveOr() {
        int index1 = 1, index2 = 1;
        for (int i = 1; i < exclusiveOr.length; i++) {
            if (exclusiveOr[i][0].equals(value2)) index1 = i;
            if (exclusiveOr[0][i].equals(value1)) index2 = i;
        }
        return exclusiveOr[index1][index2];
    }

    //4
    public String notOr() {// |v
        int index1 = 1, index2 = 1;
        for (int i = 1; i < notOr.length; i++) {
            if (notOr[i][0].equals(value2)) index1 = i;
            if (notOr[0][i].equals(value1)) index2 = i;
        }
        return notOr[index1][index2];
    }

    //5
    public String notAnd() {// |
        int index1 = 1, index2 = 1;
        for (int i = 1; i < notAnd.length; i++) {
            if (notAnd[i][0].equals(value2)) index1 = i;
            if (notAnd[0][i].equals(value1)) index2 = i;
        }
        return notAnd[index1][index2];
    }

    //6
    public String implication() {// value1 -> value2 імплікація
        int index1 = 1, index2 = 1;
        for (int i = 1; i < implication.length; i++) {
            if (implication[i][0].equals(value2)) index1 = i;
            if (implication[0][i].equals(value1)) index2 = i;
        }
        return implication[index1][index2];
    }

    //7
    public String converseImplication() {// value1 <- value2 обернена імплікація

        int index1 = 1, index2 = 1;
        for (int i = 1; i < converseImplication.length; i++) {
            if (converseImplication[i][0].equals(value2)) index1 = i;
            if (converseImplication[0][i].equals(value1)) index2 = i;
        }
        return converseImplication[index1][index2];
    }

    //8
    public String notImplication() {// value1 !-> value2 заперечення імплікації

        int index1 = 1, index2 = 1;
        for (int i = 1; i < notImplication.length; i++) {
            if (notImplication[i][0].equals(value2)) index1 = i;
            if (notImplication[0][i].equals(value1)) index2 = i;
        }
        return notImplication[index1][index2];
    }

    //9
    public String notConverseImplication() {// value1 !<- value2 заперечення оберненої імплікації

        int index1 = 1, index2 = 1;
        for (int i = 1; i < notConverseImplication.length; i++) {
            if (notConverseImplication[i][0].equals(value2)) index1 = i;
            if (notConverseImplication[0][i].equals(value1)) index2 = i;
        }
        return notConverseImplication[index1][index2];
    }

}
