package com.alanpasi.apsbulletmuzzleenergy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    EditText etBulletWeight;
    EditText etBulletVelocity;
    EditText etBulletEnergy;

    TextView lblMass;
    TextView lblVelocity;
    TextView lblEnergy;

    boolean imperialSystemSelected = true;
    boolean internationalSystemSelected = false;

    RadioButton imperialUnitSystem;
    RadioButton internationalUnitSystem;

    double ACCELERATION_DUE_TO_GRAVITY = 7000d;
    double FOOT_POUND_FORCE = (1d/(ACCELERATION_DUE_TO_GRAVITY * 32.13d));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBulletWeight = (EditText) findViewById(R.id.editTextBulletWeight);
        etBulletVelocity = (EditText) findViewById(R.id.editTextBulletVelocity);
        etBulletEnergy = (EditText) findViewById(R.id.editTextResult);

        lblMass = (TextView) findViewById(R.id.textViewLblBulletWeight);
        lblVelocity = (TextView) findViewById(R.id.textViewLblBulletVelocity);
        lblEnergy = (TextView) findViewById(R.id.textViewLblResult);

        etBulletWeight.addTextChangedListener(watch);
        etBulletVelocity.addTextChangedListener(watch);

        imperialUnitSystem = (RadioButton) findViewById(R.id.rbSistemaImperial);
        internationalUnitSystem = (RadioButton) findViewById(R.id.rbSistemaInternational);
    }

    public void SelectSystemUnit(View view) {
        switch (view.getId()) {
            case R.id.rbSistemaImperial:
//                Toast.makeText(getApplicationContext(), "Imperial", Toast.LENGTH_LONG).show();
                lblMass.setText(R.string.lbl_BulletWeight);
                lblVelocity.setText(R.string.lbl_BulletVelocity);
                lblEnergy.setText(R.string.lbl_Result);
                imperialSystemSelected = true;
                internationalSystemSelected = false;
                break;
            case R.id.rbSistemaInternational:
//                Toast.makeText(getApplicationContext(), "International", Toast.LENGTH_LONG).show();
                lblMass.setText(R.string.lbl_BulletWeightInternational);
                lblVelocity.setText(R.string.lbl_BulletVelocityInternacional);
                lblEnergy.setText(R.string.lbl_ResultInternational);
                internationalSystemSelected = true;
                imperialSystemSelected = false;
                break;
        }
    }

// Method when input text
// https://en.wikipedia.org/wiki/Muzzle_energy

    TextWatcher watch = new TextWatcher(){
        @Override
        public void afterTextChanged(Editable arg0) {
            // TODO Auto-generated method stub
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence s, int a, int b, int c) {
            // TODO Auto-generated method stub
            if (etBulletWeight.getText().toString().length() > 0
                    && etBulletVelocity.getText().toString().length() > 0
                    && imperialSystemSelected) {
                ImperialCalculate();
            } else {
                if (etBulletWeight.getText().toString().length() > 0
                        && etBulletVelocity.getText().toString().length() > 0
                        && internationalSystemSelected) {
                    InternationalCalculate();
                }
            }
        }};

    public void ImperialCalculate() {
        double bulletWeight = Double.parseDouble(etBulletWeight.getText().toString());
        double bulletVelocity = Double.parseDouble(etBulletVelocity.getText().toString());
        double bulletEnergy = ((1d/2d) * (bulletWeight * (bulletVelocity * bulletVelocity))) * FOOT_POUND_FORCE;

        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        etBulletEnergy.setText(decimalFormat.format(bulletEnergy));

//        etBulletWeight.setText(decimalFormat.format(bulletWeight));
//        etBulletVelocity.setText(decimalFormat.format(bulletVelocity));
    }

    public void InternationalCalculate() {
        double bulletWeight = Double.parseDouble(etBulletWeight.getText().toString());
        double bulletVelocity = Double.parseDouble(etBulletVelocity.getText().toString());
        double bulletEnergy = ((1d/2d) * (bulletWeight * (bulletVelocity * bulletVelocity)));

        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        etBulletEnergy.setText(decimalFormat.format(bulletEnergy));

//        etBulletWeight.setText(decimalFormat.format(bulletWeight));
//        etBulletVelocity.setText(decimalFormat.format(bulletVelocity));
    }
}
