/**
 * Created by vladimir on 19.07.17.
 */
class CalculatorModel {

    private Double firstNum;
    private Double secondNum;
    private char action;

    CalculatorModel() {
        firstNum = null;
        secondNum = null;
    }

    boolean isFirstNumNull() {
        return firstNum == null;
    }

    void setFirstNum(String val) {
        firstNum = Double.parseDouble(val);
    }

    void setSecondNum(String val) {
        secondNum = Double.parseDouble(val);
    }

    void setAction(char action) {
        this.action = action;
    }

    double getResult() {
        switch (action) {
            case '+': return firstNum + secondNum;
            case '-': return firstNum - secondNum;
            case '*': return firstNum * secondNum;
            case '/': return firstNum / secondNum;
            default: return firstNum;
        }
    }
}
