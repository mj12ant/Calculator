import javax.swing.*;
import java.awt.*;

/**
 * Created by vladimir on 27.06.17.
 */
public class Calculator
{
    private JPanel windowContent;
    private JTextField displayField;
    private JButton[] buttons;
    private String[] buttonNames;

    private GridBagLayout bagLayout;
    private GridBagConstraints constraints;

    Calculator()
    {
        //Buttons
        buttonNames = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "=",
                "+", "-", "*", "/"};
        buttons = new JButton[buttonNames.length];
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(buttonNames[i]);
        }

        windowContent = new JPanel();
        bagLayout = new GridBagLayout();
        windowContent.setLayout(bagLayout);
        constraints = new GridBagConstraints();

        //Add display field
        displayField = new JTextField();
        addComponent(windowContent, displayField, 0, 0, 1, 4);

        //Add first buttons row
        addComponent(windowContent, buttons[1], 0, 1, 1, 1);
        addComponent(windowContent, buttons[2], 1, 1, 1, 1);
        addComponent(windowContent, buttons[3], 2, 1, 1, 1);
        addComponent(windowContent, buttons[12], 3, 1, 1, 1);

        //Add second buttons row
        addComponent(windowContent, buttons[4], 0, 2, 1, 1);
        addComponent(windowContent, buttons[5], 1, 2, 1, 1);
        addComponent(windowContent, buttons[6], 2, 2, 1, 1);
        addComponent(windowContent, buttons[13], 3, 2, 1, 1);

        //Add third buttons row
        addComponent(windowContent, buttons[7], 0, 3, 1, 1);
        addComponent(windowContent, buttons[8], 1, 3, 1, 1);
        addComponent(windowContent, buttons[9], 2, 3, 1, 1);
        addComponent(windowContent, buttons[14], 3, 3, 1, 1);

        //Add fourth buttons row
        addComponent(windowContent, buttons[0], 0, 4, 1, 1);
        addComponent(windowContent, buttons[10], 1, 4, 1, 1);
        addComponent(windowContent, buttons[11], 2, 4, 1, 1);
        addComponent(windowContent, buttons[15], 3, 4, 1, 1);

        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void addComponent(Container container, Component component, int column, int row, int height, int width){
        //Set GridBagLayout constraints
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridheight = height;
        constraints.gridwidth = width;
        constraints.fill = constraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = constraints.CENTER;

        bagLayout.setConstraints(component, constraints);
        container.add(component);
    }
    public static void main(String[] args) {
        new Calculator();
    }
}