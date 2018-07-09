package com.quizzapp.butterknife;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    // @BindView(R.id.button51)
    CheckBox mCheckBox1;
    // @BindView(R.id.button52)
    CheckBox mCheckBox2;
    // @BindView(R.id.button53)
    CheckBox mCheckBox3;
    //@BindView(R.id.edit_text_q4)
    EditText mEditTextQ4;

    @BindView(R.id.radiogroup1)
    RadioGroup mRadioGroup1;
    @BindView(R.id.radiogroup2)
    RadioGroup mRadioGroup2;
    @BindView(R.id.radiogroup3)
    RadioGroup mRadioGroup3;
    private int score1, score2, score3, score4, score5, totalScore;
    private boolean checked1, checked2, checked3;
    private String answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckBox1 = findViewById(R.id.button51);
        mCheckBox2 = findViewById(R.id.button52);
        mCheckBox3 = findViewById(R.id.button53);
        mEditTextQ4 = findViewById(R.id.edit_text_q4);
        totalScore =0;
    }

    
    public void onCheckedQuestion1(View view) {
        checked1 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button11:
                if (checked1) {
                    score1 = 0;
                    break;
                }
            case R.id.button12:
                if (checked1) {
                    score1 = 20;
                    break;
                }
            case R.id.button13:
                if (checked1) {
                    score1 = 0;
                    break;
                }
        }
    }


    public void onCheckedQuestion2(View view) {
        checked2 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button21:
                if (checked2) {
                    score2 = 20;
                    break;
                }
            case R.id.button22:
                if (checked2) {
                    score2 = 0;
                    break;
                }
            case R.id.button23:
                if (checked2) {
                    score2 = 0;
                    break;
                }
        }
    }


    public void onCheckedQuestion3(View view) {


       checked3 = ((RadioButton) view).isChecked();
      switch (view.getId()) {
            case R.id.button31:
                if (checked3) {
                    score3 = 0;
                    break;
            }
          case R.id.button32:
              if (checked3) {
                   score3 = 0;
                   break;
              }
          case R.id.button33:
              if (checked3) {
                  score3 = 20;
                  break;
              }
       }
   }

    // This code is for button five.

    public void onCheckedQuestion5(View view) {


        // this is the correct option.
        if (mCheckBox1.isChecked() && mCheckBox2.isChecked() && mCheckBox3.isChecked()) {
            score5 = 30;

        }
        if (mCheckBox1.isChecked() && !mCheckBox2.isChecked() && !mCheckBox3.isChecked()) {
            score5 = -10;
        }
        if (mCheckBox1.isChecked() && mCheckBox2.isChecked() && !mCheckBox3.isChecked()) {
            score5 = 10;
        }
        if (!mCheckBox1.isChecked() && !mCheckBox2.isChecked() && !mCheckBox3.isChecked()) {
            score5=0;
        }
        if (mCheckBox1.isChecked() && mCheckBox2.isChecked() && !mCheckBox3.isChecked()) {
            score5=10;
        }
        if (mCheckBox1.isChecked() && !mCheckBox2.isChecked() && !mCheckBox3.isChecked()) {
            score5= -10;
        }
        if (!mCheckBox1.isChecked() && mCheckBox2.isChecked() && !mCheckBox3.isChecked()) {
            score5=-10;
        }
        if (mCheckBox1.isChecked() && !mCheckBox2.isChecked() && mCheckBox3.isChecked()) {
            score5= 10;
        }
    }

    // This code is for button Submit.

    public void clickSubmit(View view) {
        answer4 = mEditTextQ4.getText().toString();

        if (checked1 && checked2 && checked3 && !answer4.equals(" ") ){

            if (answer4.toLowerCase().equals("sebastian thrun"))
                score4 = 20;
            else
                score4 = 0;

              totalScore = score1 + score2 + score3 + score4 + score5;
            String answer = getString(R.string.your_score_is) + "  " + totalScore;

            // This code is to toast the score value.

            Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();

            // This code will share the score

            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "my score is : " + totalScore);
            shareIntent.setType("text/plan");
            startActivity(shareIntent);

        } else {
            Context context = getApplicationContext();
            String text = getString(R.string.make_sure_answer_questions);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
