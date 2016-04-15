package com.alanpasi.apsbulletmuzzleenergy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide labels Bullet/Velocity
        final TextView textViewLabelBullet = (TextView) findViewById(R.id.textViewLblBulletWeight);
        assert textViewLabelBullet != null;
        textViewLabelBullet.setVisibility(View.INVISIBLE);

        final TextView textViewLabelVelocity = (TextView) findViewById(R.id.textViewLblBulletVelocity);
        assert textViewLabelVelocity != null;
        textViewLabelVelocity.setVisibility(View.INVISIBLE);

        // Show Label Bullet when changed
        editText = (EditText) findViewById(R.id.editTextBulletWeight);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s == "2") {
                    textViewLabelBullet.setVisibility(View.VISIBLE);
                    // textViewLabelBullet.setVisibility(View.INVISIBLE);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing

            }
        });

        // Show Label Velocity when changed

        editText = (EditText) findViewById(R.id.editTextBulletVelocity);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textViewLabelVelocity.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing

            }
        });




        
    }
}
