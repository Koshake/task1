package lesson7a;

import javax.swing.*;
import java.awt.*;


public class Calculate extends JFrame {

    private int firstNum;
    private int secondNum;
    private int result;
    private boolean canClear;

    private int operation;

    public Calculate() {
        setBounds(400, 300, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");

        JPanel panel = new JPanel(new BorderLayout(5,5));

        JPanel panelEdit = new JPanel(new GridLayout(2,1,2,2));
        JTextArea label = new JTextArea();
        label.setEditable(false);
        panelEdit.add(label);
        JTextArea screen = new JTextArea(2,25);
        panelEdit.add(screen);

        panel.add(panelEdit, BorderLayout.NORTH);

        setContentPane(panel);

        JPanel panelButtons = new JPanel(new GridLayout(3,3,4,4));

        JButton [] numbersButtons = new JButton[9];
        for (int i = 1; i < 10; i++) {
            JButton btn = new JButton("" + i);
            panelButtons.add(btn);

            btn.addActionListener(e->{
                if (canClear) {
                    label.setText("");
                    screen.setText("");
                    canClear = false;
                    firstNum = secondNum = 0;
                }

                label.append(btn.getText() + "");
                screen.append(btn.getText() + "");
                }
            );
        }

        panel.add(panelButtons, BorderLayout.CENTER);

        JPanel panelButtonsRight = new JPanel(new GridLayout(5,1,4,4));

        // +
        JButton plusButton = new JButton("+");
        panelButtonsRight.add(plusButton);

        plusButton.addActionListener(e-> {
            if (firstNum != 0 || screen.getText().isEmpty())
                return;
            label.append(" " + plusButton.getText() + " ");
            firstNum = Integer.parseInt(screen.getText());
            screen.setText("");
            operation = 1;
        });

        // -
        JButton minusButton = new JButton("-");
        panelButtonsRight.add(minusButton);

        minusButton.addActionListener(e->{
            if (firstNum != 0 || screen.getText().isEmpty())
                return;
            label.append(" " + minusButton.getText() + " ");
            firstNum = Integer.parseInt(screen.getText());
            screen.setText("");
            operation = 2;
            }
        );

        // *
        JButton multiplyButton = new JButton("*");
        panelButtonsRight.add(multiplyButton);

        multiplyButton.addActionListener(e->{
            if (firstNum != 0 || screen.getText().isEmpty())
                return;
            label.append(" " + multiplyButton.getText() + " ");
            firstNum = Integer.parseInt(screen.getText());
            screen.setText("");
            operation = 3;
            });

        // /
        JButton divButton = new JButton("/");
        panelButtonsRight.add(divButton);

        divButton.addActionListener(e->{
            if (firstNum != 0 || screen.getText().isEmpty())
                return;
            label.append(" " + divButton.getText() + " ");
            firstNum = Integer.parseInt(screen.getText());
            screen.setText("");
            operation = 4;
            });

        // =
        JButton equalsButton = new JButton("=");
        panelButtonsRight.add(equalsButton);

        equalsButton.addActionListener(e->{
            if(secondNum != 0 || screen.getText().isEmpty())
                return;
            label.append(" " + equalsButton.getText() + " ");
            secondNum = Integer.parseInt(screen.getText());
            switch (operation) {
                case 1:
                    result = firstNum + secondNum;
                    break;
                case 2:
                    result = firstNum - secondNum;
                    break;
                    case 3:
                    result = firstNum * secondNum;
                    break;
                case 4:
                    result = firstNum / secondNum;
                    break;
                default:

            }

            screen.setText(Integer.toString(result));
            label.append(Integer.toString(result));
            canClear = true;
            });

        panel.add(panelButtonsRight, BorderLayout.EAST);

        pack();

        setVisible(true);

    }

}
