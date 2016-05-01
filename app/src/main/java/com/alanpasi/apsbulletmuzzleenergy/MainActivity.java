package com.alanpasi.apsbulletmuzzleenergy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    EditText etBulletWeight;
    EditText etBulletVelocity;
    EditText etBulletEnergy;

    final double ACCELERATION_DUE_TO_GRAVITY = 7000d;
    final double FOOT_POUND_FORCE = (1d/(ACCELERATION_DUE_TO_GRAVITY * 32.13d));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView energyResult = (TextView) findViewById(R.id.textViewLblResult);

        energyResult.setOnClickListener(this);

        etBulletWeight = (EditText) findViewById(R.id.editTextBulletWeight);
        etBulletVelocity = (EditText) findViewById(R.id.editTextBulletVelocity);
        etBulletEnergy = (EditText) findViewById(R.id.editTextResult);
    }

// Method when tap on Muzzle Energy text
// https://en.wikipedia.org/wiki/Muzzle_energy
    @Override
    public void onClick(View v) {


        if (etBulletWeight.getText().toString().length() > 0 && etBulletVelocity.getText().toString().length() > 0) {
            double bulletWeight = Double.parseDouble(etBulletWeight.getText().toString());
            double bulletVelocity = Double.parseDouble(etBulletVelocity.getText().toString());
            double bulletEnergy = ((1d/2d) * (bulletWeight * (bulletVelocity * bulletVelocity))) * FOOT_POUND_FORCE;

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            etBulletEnergy.setText(decimalFormat.format(bulletEnergy));
        }

    }
}
