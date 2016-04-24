package com.alanpasi.apsbulletmuzzleenergy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    EditText editNum1;
    EditText editNum2;
    TextView editNum3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView energyResult = (TextView) findViewById(R.id.textViewLblResult);

        energyResult.setOnClickListener(this);

        editNum1 = (EditText) findViewById(R.id.editTextBulletWeight);
        editNum2 = (EditText) findViewById(R.id.editTextBulletVelocity);
        editNum3 = (EditText) findViewById(R.id.editTextResult);
    }

// Method when tap on Muzzle Energy text
// https://en.wikipedia.org/wiki/Muzzle_energy
    @Override
    public void onClick(View v) {

        double num1 = Double.parseDouble(editNum1.getText().toString());
        double num2 = Double.parseDouble(editNum2.getText().toString());
        double result = ((1d/2d) * (num1 * (num2 * num2))) * (1d/(7000d * 32.13d));
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        editNum3.setText(decimalFormat.format(result));

    }
}
