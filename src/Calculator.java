import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subtractButton, multiplyButton, divideButton;
    JButton decimalButton, equButton, delButton, clrButton;

    JPanel jp;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;


        for(int i = 0; i<8; i++ ){
           functionButtons[i].addActionListener(this);
           functionButtons[i].setFont(myFont);
           functionButtons[i].setFocusable(false);

        }

        for(int i = 0; i<10; i++ ){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(250, 430, 145, 50);


        jp = new JPanel();
        jp.setBounds(50, 100, 300, 300);
        jp.setLayout(new GridLayout(4, 4, 10, 10));

        jp.add(numberButtons[1]);
        jp.add(numberButtons[2]);
        jp.add(numberButtons[3]);
        jp.add(addButton);
        jp.add(numberButtons[4]);
        jp.add(numberButtons[5]);
        jp.add(numberButtons[6]);
        jp.add(subtractButton);
        jp.add(numberButtons[7]);
        jp.add(numberButtons[8]);
        jp.add(numberButtons[9]);
        jp.add(multiplyButton);
        jp.add(decimalButton);
        jp.add(numberButtons[0]);
        jp.add(equButton);
        jp.add(divideButton);


        frame.add(jp);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }


    public static void main(String[] args) {

        Calculator calculator = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i<10; i++ ){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decimalButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() ==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subtractButton){
            if(textField.getText().isEmpty()){
                textField.setText("-");
            }
            else{
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            }
        }
        if(e.getSource() == multiplyButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divideButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                    case '-':
                        result = num1 - num2;
                        break;
                        case '*':
                            result = num1 * num2;
                            break;
                            case '/':
                                result = num1 / num2;
                                break;

            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String str = textField.getText();
            textField.setText("");
            for(int i = 0; i<str.length()-1; i++ ){
                textField.setText(textField.getText()+str.charAt(i));
            }
        }
    }
}
