package com.roman.osadchuk.startup3000.model;

public class BooleanOperation {

    private Boolean value1;
    private Boolean value2;
    private Boolean result;

    public BooleanOperation(Boolean value1, Boolean value2, Operation operation) {
        this.value1 = value1;
        this.value2 = value2;
        setResult(operation);
    }

    public Boolean getValue1() {
        return value1;
    }

    public void setValue1(Boolean value1) {
        this.value1 = value1;
    }

    public Boolean getValue2() {
        return value2;
    }

    public void setValue2(Boolean value2) {
        this.value2 = value2;
    }

    public void setResult(Operation operation) {
        switch (operation){
            case CONJUNCTION: result = conjunction(); break;
            case DISJUNCTION: result = disjunction(); break;
            case EQUALITY: result = equality(); break;
            case EXCLUSIVE_OR: result = exclusiveOr(); break;
            case NOT_OR: result = notOr(); break;
            case NOT_AND: result = notAnd(); break;
            case IMPLICATION: result = implication(); break;
            case CONVERSE_IMPLICATION: result = converseImplication(); break;
            case NOT_IMPLICATION: result = notImplication(); break;
            case NOT_CONVERSE_IMPLICATION: result = notConverseImplication(); break;
            case NOT: result = not(); break;
            /*case 10: result = repeatTheFirstArgument(); break;
            case 11: result = repeatTheSecondArgument(); break;
            case 12: result = notTheFirstArgument(); break;
            case 13: result = notTheSecondArgument(); break;
            case 14: result = constTrue(); break;
            case 15: result = constFalse(); break;*/
            default: result =  null;
        }
    }

    public Boolean getResult() {
        return result;
    }

    public Boolean not(){
        return value1==null ? null : !value1;
    }

    //0
    public Boolean conjunction(){
        Boolean result = null;

        if (value1!=null && value2!=null)
            result = value1 && value2;
        else if(value1!=null && value1==false)
            result = false;
        else if(value2!=null && value2==false)
            result = false;

        value1 = result;
        value2 = null;

        return result;
    }
    //1
    public Boolean disjunction(){
        Boolean result = null;
        if (value1!=null&&value2!=null)
            result = value1||value2;
        else if(value1!=null && value1==true)
            result = true;
        else if(value2!=null && value2==true)
            result = true;

        value1 = result;
        value2 = null;
        return result;
    }
    //2
    public Boolean equality(){
        Boolean result =null;
        if (value1!=null&&value2!=null)
            result = (value1&&value2)||(!value1&&!value2);
        value1 = result;
        value2 = null;
        return result;
    }
    //3
    public Boolean exclusiveOr(){
        Boolean result =null;
        if (value1!=null&&value2!=null)
            result =  (value1||value2)&&(!value1||!value2);
        value1 = result;
        value2 = null;
        return result;
    }
    //4
    public Boolean notOr(){// |v
        //boolean result = (!value1&&!value2);
        Boolean result =null;
        if (value1!=null&&value2!=null)
            result = !(value1||value2);
        else if((value1!=null && value1==true) || (value2!=null && value2==true))
            result =  false;
        value1 = result;
        value2 = null;
        return result;
    }
    //5
    public Boolean notAnd(){// |
        //boolean result = (!value1||!value2);
        Boolean result =null;
        if (value1!=null&&value2!=null)
            result = !(value1&&value2);
        else if((value1!=null && value1==false) || (value2!=null && value2==false))
            result =  true;
        value1 = result;
        value2 = null;
        return result;
    }
    //6
    public Boolean implication(){// value1 -> value2 імплікація
        Boolean result = null;
        if (value1!=null && value2!=null)
            result = !value1||value2;

        else if((value1!=null && value1==false)){
            result = true;
        }
        else if((value2!=null && value2==true)){
            result = true;
        }

        value1 = result;
        value2 = null;
        return result;
    }
    //7
    public Boolean converseImplication(){// value1 <- value2 обернена імплікація
        Boolean result =null;
        if (value1!=null && value2!=null){
            result = value1||!value2;
        }
        else if((value2!=null && value2==false)){
            result = true;
        }
        else if((value1!=null && value1==true)){
            result = true;
        }
        value1 = result;
        value2 = null;
        return result;
    }
    //8
    public Boolean notImplication(){// value1 !-> value2 заперечення імплікації
        Boolean result = null;
        if (value1!=null && value2!=null){
            result = !(!value1||value2);
        }
        else if((value1!=null && value1==false)){
            result = false;
        }
        else if((value2!=null && value2==true)){
            result = false;
        }

        value1 = result;
        value2 = null;
        return result;
    }
    //9
    public Boolean notConverseImplication(){// value1 !<- value2 заперечення оберненої імплікації
        Boolean result=null;
        if (value1!=null && value2!=null){
            result = !(value1||!value2);
        }
        else if((value2!=null && value2==false)){
            result = false;
        }
        else if((value1!=null && value1==true))
            result = false;

        value1 = result;
        value2 = null;
        return result;
    }
    //10
    public Boolean repeatTheFirstArgument(){
        value2 = null;
        return value1;
    }
    //11
    public Boolean repeatTheSecondArgument(){
        Boolean result = value2;
        value1 = result;
        value2 = null;
        return result;
    }
    //12
    public Boolean notTheFirstArgument(){
        Boolean result = null;
        if (value1 != null) {
            result=!value1;
        }
        value1 = result;
        value2 = null;
        return result;
    }
    //13
    public Boolean notTheSecondArgument(){
        Boolean result = null;
        if (value2 != null)
            result=!value2;

        value1 = result;
        value2 = null;
        return result;
    }
    //14
    public Boolean constTrue(){
        value1 = true;
        value2 = null;
        return true;
    }
    //15
    public Boolean constFalse(){

        value1 = false;
        value2 = null;
        return false;
    }
}
