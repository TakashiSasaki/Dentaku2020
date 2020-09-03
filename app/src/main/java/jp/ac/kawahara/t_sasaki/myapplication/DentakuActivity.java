package jp.ac.kawahara.t_sasaki.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class DentakuActivity extends AppCompatActivity {

    LinearLayout buttonPadLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentaku);
        this.buttonPadLinearLayout =
                findViewById(R.id.buttonPadLinearLayout);

        for (int i = 0; i < 10; ++i) {
            Button b = new Button(this.getApplicationContext());
            buttonPadLinearLayout.addView(b);
        }
    }
}
