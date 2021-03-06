import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vladimir on 28.06.17.
 */
public class CalculatorEngine implements ActionListener{
    private Calculator parent;
    private static CalculatorModel calcModel = new CalculatorModel();

    CalculatorEngine(Calculator parent){
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //JOptionPane.showConfirmDialog(null, "Something happened...", "Just a test", JOptionPane.PLAIN_MESSAGE);
        JButton clickedButton = (JButton)e.getSource();
        String buttonName = parent.getButtonName(clickedButton);
        String displayFieldValue = parent.getDisplayValue();
        switch (buttonName){
            case "0": if (displayFieldValue.equals("0")) break;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":   if (displayFieldValue.equals("0"))
                            parent.setDisplayValue(buttonName);
                        else
                            parent.setDisplayValue(displayFieldValue + buttonName);
                        break;
            case ".":
                        if (!(parent.dotPressed)){
                            parent.setDisplayValue(displayFieldValue + buttonName);
                            parent.dotPressed = true;
                        }
                        break;
            case "C":   parent.setDisplayValue("0");
                        parent.dotPressed = false;
                        calcModel = new CalculatorModel();
                        break;
            case "+":   calcModel.setFirstNum(displayFieldValue);
                        calcModel.setAction('+');
                        parent.setDisplayValue("0");
                        parent.dotPressed = false;
                        break;
            case "-":   calcModel.setFirstNum(displayFieldValue);
                        calcModel.setAction('-');
                        parent.setDisplayValue("0");
                        parent.dotPressed = false;
                        break;
            case "*":   calcModel.setFirstNum(displayFieldValue);
                        calcModel.setAction('*');
                        parent.setDisplayValue("0");
                        parent.dotPressed = false;
                        break;
            case "/":   calcModel.setFirstNum(displayFieldValue);
                        calcModel.setAction('/');
                        parent.setDisplayValue("0");
                        parent.dotPressed = false;
                        break;
            case "=":   if(!calcModel.isFirstNumNull()) {
                            calcModel.setSecondNum(displayFieldValue);
                            parent.setDisplayValue(Double.toString(calcModel.getResult()));
                            parent.dotPressed = true;
                        }
                        break;
            case "+/-": if( Double.parseDouble(displayFieldValue) > 0)
                            parent.setDisplayValue("-" + displayFieldValue);
                        if( Double.parseDouble(displayFieldValue) < 0)
                            parent.setDisplayValue(displayFieldValue.substring(1));
                        break;
        }
    }
}
