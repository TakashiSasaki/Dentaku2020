package jp.ac.kawahara.t_sasaki.myapplication;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonClickListener
        implements View.OnClickListener {

    final EditText operand1, operator, operand2;

    ButtonClickListener(EditText operand1,
                        EditText operator,
                        EditText operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        final String sOperator = operator.getText().toString();
        final String sOperand1 = operand1.getText().toString();
        final String sOperand2 = operand2.getText().toString();

        switch ((String) v.getTag()) {
            case "zero":
                this.inputOneNumber(0);
                break;
            case "one":
                this.inputOneNumber(1);
                break;
            case "two":
                this.inputOneNumber(2);
                break;
            case "three":
                this.inputOneNumber(3);
                break;
            case "four":
                this.inputOneNumber(4);
                break;
            case "five":
                this.inputOneNumber(5);
                break;
            case "six":
                this.inputOneNumber(6);
                break;
            case "seven":
                this.inputOneNumber(7);
                break;
            case "eight":
                this.inputOneNumber(8);
                break;
            case "nine":
                this.inputOneNumber(9);
                break;
            case "plus":
                operator.setText("+");
                break;
            case "minus":
                operator.setText("-");
                break;
            case "divide":
                operator.setText("/");
                break;
            case "multiply":
                operator.setText("*");
                break;
            case "equal":
                try {
                    switch (sOperator) {
                        case "+":
                            operatePlus();
                            break;
                        case "-":
                            operateMinus();
                            break;
                        case "/":
                            operateDivide();
                            break;
                        case "*":
                            operateMultiply();
                            break;
                    }//switch
                } catch (NumberFormatException e) {
                    Toast.makeText(v.getContext(),
                            "NumberFormatException",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                break;
        }//switch
    }//onClick

    private void inputOneNumber(final int i) {
        if (operator.getText().toString().contentEquals("")) {
            operand1.setText(operand1.getText().toString() + i);
        } else {
            operand2.setText(operand2.getText().toString() + i);
        }
    }//inputOneNumber

    private void operatePlus() {
        final double o1 = Double.parseDouble(
                operand1.getText().toString());
        final double o2 = Double.parseDouble(
                operand2.getText().toString());
        final double o3 = o1 + o2;
        operand1.setText("" + o3);
        operator.setText("");
        operand2.setText("");
    }//operatePlus

    private void operateMinus() {
        final double o1 = Double.parseDouble(
                operand1.getText().toString());
        final double o2 = Double.parseDouble(
                operand2.getText().toString());
        final double o3 = o1 - o2;
        operand1.setText("" + o3);
        operator.setText("");
        operand2.setText("");
    }//operateMinus

    private void operateDivide() {
        final double o1 = Double.parseDouble(
                operand1.getText().toString());
        final double o2 = Double.parseDouble(
                operand2.getText().toString());
        final double o3 = o1 / o2;
        operand1.setText("" + o3);
        operator.setText("");
        operand2.setText("");
    }//operateDivide

    private void operateMultiply() {
        final double o1 = Double.parseDouble(
                operand1.getText().toString());
        final double o2 = Double.parseDouble(
                operand2.getText().toString());
        final double o3 = o1 * o2;
        operand1.setText("" + o3);
        operator.setText("");
        operand2.setText("");
    }//operateMultiply

}//ButtonClickListener
