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

    RadioButton imperialUnitSystem;
    RadioButton internacionalUnitSystem;

    double ACCELERATION_DUE_TO_GRAVITY = 7000d;
    double FOOT_POUND_FORCE = (1d/(ACCELERATION_DUE_TO_GRAVITY * 32.13d));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBulletWeight = (EditText) findViewById(R.id.editTextBulletWeight);
        etBulletVelocity = (EditText) findViewById(R.id.editTextBulletVelocity);
        etBulletEnergy = (EditText) findViewById(R.id.editTextResult);

        etBulletWeight.addTextChangedListener(watch);
        etBulletVelocity.addTextChangedListener(watch);

        imperialUnitSystem = (RadioButton) findViewById(R.id.rbSistemaImperial);
        internacionalUnitSystem = (RadioButton) findViewById(R.id.rbSistemaInternacional);
    }

    public void SelectSystemUnit(View view) {
        switch (view.getId()) {
            case R.id.rbSistemaImperial:
                Toast.makeText(getApplicationContext(), "Imperial", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbSistemaInternacional:
                Toast.makeText(getApplicationContext(), "Internacional", Toast.LENGTH_LONG).show();
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
            if (etBulletWeight.getText().toString().length() > 0 && etBulletVelocity.getText().toString().length() > 0) {
                double bulletWeight = Double.parseDouble(etBulletWeight.getText().toString());
                double bulletVelocity = Double.parseDouble(etBulletVelocity.getText().toString());
                double bulletEnergy = ((1d/2d) * (bulletWeight * (bulletVelocity * bulletVelocity))) * FOOT_POUND_FORCE;

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                etBulletEnergy.setText(decimalFormat.format(bulletEnergy));
            }

//            output.setText(s);
//            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
//            if(a == 9){
//                Toast.makeText(getApplicationContext(), "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
//            }
        }};

}
