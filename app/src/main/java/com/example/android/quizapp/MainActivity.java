package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;
    int MAX_SCORE = 5;

    CheckBox checkBoxTrue1;
    CheckBox checkBoxTrue2;
    CheckBox checkBoxFalse1;
    CheckBox checkBoxFalse2;
    CheckBox checkBoxTrue3;
    CheckBox checkBoxFalse3;
    EditText editTextDucati;
    RadioGroup radioGroupIsleOfMan;
    RadioButton radioButtonNo;
    EditText editTextMotoGuzzi;
    RadioGroup radioGroupFirstMotorcycle;
    RadioButton radioButtonLech;

    private static final String DUCATI = "ducati";
    private static final String MOTOGUZZI = "moto guzzi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeGuiElements();
    }

    protected void initializeGuiElements() {
        checkBoxTrue1 = findViewById(R.id.checkbox_one);
        checkBoxTrue2 = findViewById(R.id.checkbox_two);
        checkBoxFalse1 = findViewById(R.id.checkbox_three);
        checkBoxFalse2 = findViewById(R.id.checkbox_four);
        checkBoxTrue3 = findViewById(R.id.checkbox_five);
        checkBoxFalse3 = findViewById(R.id.checkbox_six);
        editTextDucati = findViewById(R.id.second_ducati_question);
        radioGroupIsleOfMan = findViewById(R.id.radio_group_isle_of_man);
        radioButtonNo = findViewById(R.id.no_radio_button);
        editTextMotoGuzzi = findViewById(R.id.fourth_guzzi_question);
        radioGroupFirstMotorcycle = findViewById(R.id.radio_group_first_motorcycle);
        radioButtonLech = findViewById(R.id.lech_radio_button);
    }

    public void resetScore() {
        checkBoxTrue1.setChecked(false);
        checkBoxTrue2.setChecked(false);
        checkBoxTrue3.setChecked(false);
        checkBoxFalse1.setChecked(false);
        checkBoxFalse2.setChecked(false);
        checkBoxFalse3.setChecked(false);
        radioGroupFirstMotorcycle.clearCheck();
        radioGroupIsleOfMan.clearCheck();
        editTextDucati.setText(null);
        editTextMotoGuzzi.setText(null);
        score = 0;
    }

    public void submit(final View view) throws InterruptedException {

        /**
         * 1 st answer contains 3 correct answers (1st,2nd,5th), if they selected +1 point to score
         */

        if (checkBoxFalse1.isChecked() || (checkBoxFalse2.isChecked()) || (checkBoxFalse3.isChecked())) {
            score = 0;

        } else if (checkBoxTrue1.isChecked() && (checkBoxTrue2.isChecked()) && (checkBoxTrue3.isChecked())) {
            score++;
        }

        /**
         * 2 nd answer is 'Ducati', if it's correct +1 point to score
         */

        if (editTextDucati.getText().toString().equalsIgnoreCase(DUCATI)) {
            score++;
        }

        /**
         * 3 rd answer is 'No', if it's correct +1 point to score
         */

        if (radioButtonNo.isChecked()) {
            score++;
        }

        /**
         * 4 th answer is Moto Guzzi, if it's correct +1 point to score
         */


        if (editTextMotoGuzzi.getText().toString().equalsIgnoreCase(MOTOGUZZI)) {
            score++;
        }

        /***
         * 5th aswer is 'Lech', if it's correct +1 point to score
         */

        if (radioButtonLech.isChecked()) {
            score++;
        }

        final String resultMaxScore = getString(R.string.winner_toast_label);
        final String resultBelowScore = getString(R.string.below_toast_label, score);

        /***
         * If someone get maximum points, display a toast message
         */
        if (score == MAX_SCORE) {
            Toast.makeText(this, resultMaxScore, Toast.LENGTH_LONG).show();

            resetScore();

            /***
             * If someone get <5 points, display a toast message
             */

        } else if (score < 5) {
            Toast.makeText(this, resultBelowScore, Toast.LENGTH_LONG).show();

            resetScore();
        }
    }
}
