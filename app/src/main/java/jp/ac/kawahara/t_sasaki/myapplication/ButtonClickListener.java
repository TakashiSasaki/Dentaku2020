package jp.ac.kawahara.t_sasaki.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonClickListener
        implements View.OnClickListener {

    EditText operand1, operator, operand2;

    ButtonClickListener(EditText operand1,
                        EditText operator,
                        EditText operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    @Override
    public void onClick(View v) {
        switch ((String) v.getTag()) {
            case "one":
                String o = operator.getText().toString();
                if (o.contentEquals("")) {
                    String s = operand1.getText().toString();
                    operand1.setText(s + "1");
                } else {
                    String s = operand2.getText().toString();
                    operand2.setText(s + "1");
                }
                break;
            case "two":
                o = operator.getText().toString();
                if (o.contentEquals("")) {
                    String s = operand1.getText().toString();
                    operand1.setText(s + "2");
                } else {
                    String s = operand2.getText().toString();
                    operand2.setText(s + "2");
                }
                break;
            case "three":
                Toast.makeText(v.getContext(),
                        "「さん」",
                        Toast.LENGTH_SHORT).show();
                break;

            case "plus":
                operator.setText("+");
                break;

            case "equal":
                o = operator.getText().toString();
                if (o.contentEquals("+")) {
                    try {
                        double o1 = Double.parseDouble(
                                operand1.getText().toString());
                        double o2 = Double.parseDouble(
                                operand2.getText().toString());
                        double o3 = o1 + o2;
                        operand1.setText("" + o3);
                        operator.setText("");
                        operand2.setText("");
                    } catch (NumberFormatException e) {
                        Toast.makeText(v.getContext(),
                                "NumberFormatException",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                }
                break;
        }
    }
}
