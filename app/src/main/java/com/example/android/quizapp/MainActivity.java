package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    CheckBox checkBoxOne;
    CheckBox checkBoxTwo;
    CheckBox checkBoxThree;
    CheckBox checkBoxFour;
    CheckBox checkBoxFive;
    CheckBox checkBoxSix;
    EditText editTextDucati;
    RadioButton radioButtonNo;
    EditText editTextMotoGuzzi;
    RadioButton radioButtonLech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxOne = findViewById(R.id.checkbox_one);
        checkBoxTwo = findViewById(R.id.checkbox_two);
        checkBoxThree = findViewById(R.id.checkbox_three);
        checkBoxFour = findViewById(R.id.checkbox_four);
        checkBoxFive = findViewById(R.id.checkbox_five);
        checkBoxSix = findViewById(R.id.checkbox_six);
        editTextDucati = findViewById(R.id.second_ducati_question);
        radioButtonNo = findViewById(R.id.no_radio_button);
        editTextMotoGuzzi = findViewById(R.id.fourth_guzzi_question);
        radioButtonLech = findViewById(R.id.lech_radio_button);
    }

    //Method used when button Submit is clicked

    public void Submit(View view) {

        //1st answer contains 3 incorrect answers (3rd,4th,6th), if they selected 0 point to score
        if (checkBoxThree.isChecked() || (checkBoxFour.isChecked()) || (checkBoxSix.isChecked())) {
            score += 0;

            //1st answer contains 3 correct answers (1st,2nd,5th), if they selected +1 point to score

        } else if (checkBoxOne.isChecked() && (checkBoxTwo.isChecked()) && (checkBoxFive.isChecked())) {
            score += 1;
        }

        //2nd answer is 'Ducati', if it's correct +1 point to score
        if (editTextDucati.getText().toString().equalsIgnoreCase("ducati")) {
            score += 1;
        }

        // 3rd answer is 'No', if it's correct +1 point to score
        if (radioButtonNo.isChecked()) {
            score += 1;
        }

        // 4th answer is Moto Guzzi, if it's correct +1 point to score

        if (editTextMotoGuzzi.getText().toString().equalsIgnoreCase("moto guzzi")) {
            score += 1;
        }

        //5th aswer is 'Lech', if it's correct +1 point to score
        // 3rd answer is 'No', if it's correct +1 point to score
        if (radioButtonLech.isChecked()) {
            score += 1;
        }

        if (score == 5) {
            //If someone get maximum points, display a toast message
            Context context = getApplicationContext();
            CharSequence text = "You scored " + score + "/5 \nCongratulation, you're 100% a motorcyclist!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }

        if (score < 5) {
            //If someone get <5 points, display a toast message
            Context context = getApplicationContext();
            CharSequence text = "You scored " + score + "/5 \nIt was close. Try again!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }

        // New activity with 3 seconds of delay
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        }, 3000);

    }
}
