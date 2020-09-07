package jp.ac.kawahara.t_sasaki.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;

public class DentakuActivity extends AppCompatActivity {


    LinearLayout buttonPadLinearLayout;

    final String[] buttonTexts =
            {"", "", "", "÷",
                    "7", "8", "9", "×",
                    "4", "5", "6", "-",
                    "1", "2", "3", "+",
                    "±", "0", ".", "="
            };

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentaku);
        this.buttonPadLinearLayout =
                findViewById(R.id.buttonPadLinearLayout);

        //LinearLayoutとButtonをforループで生成して追加する
        for (int i = 0; i < 5; ++i) {
            final LinearLayout newLL = new LinearLayout(getApplicationContext());
            newLL.setBackgroundColor(Color.YELLOW);
            final ViewGroup.LayoutParams newLP = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            newLL.setOrientation(LinearLayout.HORIZONTAL);

            for (int j = 0; j < 4; ++j) {
                final Button b = new Button(this.getApplicationContext());
                //b.setText(i + "," + j);
                b.setText(buttonTexts[i * 4 + j]);
                final LinearLayout.LayoutParams lllp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                newLL.addView(b, lllp);
            }//for j
            buttonPadLinearLayout.addView(newLL, newLP);
        }//for i
    }
}//DentakuActivity
