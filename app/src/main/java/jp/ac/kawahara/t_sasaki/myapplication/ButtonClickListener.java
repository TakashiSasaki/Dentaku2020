package jp.ac.kawahara.t_sasaki.myapplication;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class ButtonClickListener
        implements View.OnClickListener {

    final TextView operand1, operator, operand2;

    ButtonClickListener(TextView operand1,
                        TextView operator,
                        TextView operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        final String sOperator = operator.getText().toString();
        //final String sOperand1 = operand1.getText().toString();
        //final String sOperand2 = operand2.getText().toString();

        switch ((String) v.getTag()) {
            case "zero":
                this.inputOneNumber('0');
                break;
            case "one":
                this.inputOneNumber('1');
                break;
            case "two":
                this.inputOneNumber('2');
                break;
            case "three":
                this.inputOneNumber('3');
                break;
            case "four":
                this.inputOneNumber('4');
                break;
            case "five":
                this.inputOneNumber('5');
                break;
            case "six":
                this.inputOneNumber('6');
                break;
            case "seven":
                this.inputOneNumber('7');
                break;
            case "eight":
                this.inputOneNumber('8');
                break;
            case "nine":
                this.inputOneNumber('9');
                break;
            case "dot":
                this.inputOneNumber('.');
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
                    final double o1 = Double.parseDouble(
                            operand1.getText().toString());
                    final double o2 = Double.parseDouble(
                            operand2.getText().toString());
                    switch (sOperator) {
                        case "+":
                            operatePlus(o1, o2);
                            break;
                        case "-":
                            operateMinus(o1, o2);
                            break;
                        case "/":
                            operateDivide(o1, o2);
                            break;
                        case "*":
                            operateMultiply(o1, o2);
                            break;
                    }//switch
                } catch (NumberFormatException e) {
                    Toast.makeText(v.getContext(),
                            e.getMessage(),
                            Toast.LENGTH_SHORT)
                            .show();
                } catch (RuntimeException e) {
                    Toast.makeText(v.getContext(),
                            e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case "allclear":
                operand1.setText("");
                operator.setText("");
                operand2.setText("");
                break;
            case "clear":
                if (!operand2.getText().toString().contentEquals("")) {
                    operand2.setText("");
                } else if (!operator.getText().toString().contentEquals("")) {
                    operator.setText("");
                } else if (!operand1.getText().toString().contentEquals("")) {
                    operand1.setText("");
                }
                break;
            case "delete":
                if (!operand2.getText().toString().contentEquals("")) {
                    operand2.setText(
                            operand2.getText().toString().substring(
                                    0,
                                    operand2.getText().length() - 1));
                } else if (!operator.getText().toString().contentEquals("")) {
                    operator.setText("");
                } else if (!operand1.getText().toString().contentEquals("")) {
                    operand1.setText(
                            operand1.getText().toString().substring(
                                    0,
                                    operand1.getText().length() - 1));
                }
                break;
            case "sign":
                if (!operand2.getText().toString().contentEquals("")) {
                    if (operand2.getText().toString().substring(0, 1).contentEquals("-")) {
                        operand2.setText(operand2.getText().toString().substring(
                                1,
                                operand2.getText().toString().length()));
                    } else {
                        operand2.setText(String.format(Locale.US,
                                "%c%s",
                                '-',
                                operand2.getText().toString()
                        ));
                    }
                } else if (!operand1.getText().toString().contentEquals("")) {
                    if (operand1.getText().toString().substring(0, 1).contentEquals("-")) {
                        operand1.setText(operand1.getText().toString().substring(
                                1,
                                operand1.getText().toString().length()));
                    } else {
                        operand1.setText(String.format(Locale.US,
                                "%c%s",
                                '-',
                                operand1.getText().toString()
                        ));
                    }
                }
                break;
            default:
        }//switch
    }//onClick

    private void inputOneNumber(final char i) {
        if (operator.getText().toString().contentEquals(""))
            operand1.setText(
                    String.format(Locale.US,
                            "%s%c",
                            operand1.getText().toString(), i));
        else
            operand2.setText(
                    String.format(Locale.US,
                            "%s%c",
                            operand2.getText().toString(), i));

    }//inputOneNumber

    private void operatePlus(final double o1, final double o2) {
        operand1.setText(String.format(Locale.US, "%f", (o1 + o2)));
        operator.setText("");
        operand2.setText("");
    }//operatePlus

    private void operateMinus(final double o1, final double o2) {
        operand1.setText(String.format(Locale.US, "%f", o1 - o2));
        operator.setText("");
        operand2.setText("");
    }//operateMinus

    private void operateDivide(final double o1, final double o2) {
        final double result = o1 / o2;
        if (!Double.isFinite(result)) {
            throw new RuntimeException("not a finite number");
        }
        operand1.setText(String.format(Locale.US, "%f", o1 / o2));
        operator.setText("");
        operand2.setText("");
    }//operateDivide

    private void operateMultiply(final double o1, final double o2) {
        operand1.setText(String.format(Locale.US, "%f", o1 * o2));
        operator.setText("");
        operand2.setText("");
    }//operateMultiply

}//ButtonClickListener
