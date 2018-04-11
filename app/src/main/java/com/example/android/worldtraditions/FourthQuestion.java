package com.example.android.worldtraditions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FourthQuestion extends AppCompatActivity {

    int baseNumOfPoints;
    int extraNumOfPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_question);

        String baseNumOfPointsString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                baseNumOfPointsString = null;
            } else {
                baseNumOfPointsString = extras.getString("baseNumOfPointsString");
            }
        } else {
            baseNumOfPointsString = (String) savedInstanceState.getSerializable("baseNumOfPointsString");
        }

        baseNumOfPoints = Integer.parseInt(baseNumOfPointsString);

        Log.i("FourthQuestion", "The num of points is " + baseNumOfPoints);

        Button next = findViewById(R.id.next_button_4);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitAnswer();

                Log.i("FourthQuestion", "The base num of extra points   " + extraNumOfPoints);
                Log.i("FourthQuestion", "The base num of points po przeliczeniu  " + baseNumOfPoints);

                Intent intent = new Intent(FourthQuestion.this, FinalActivity.class);
                String baseNumOfPointsString = String.valueOf(baseNumOfPoints);
                intent.putExtra("baseNumOfPointsString", baseNumOfPointsString);
                startActivity(intent);

            }
        });
    }

    public void submitAnswer() {

        String correctAnswer1 = "spain";
        String correctAnswer2 = "Spain";
        EditText answer = findViewById(R.id.answer_edit_text);

        String answerString = answer.getText().toString();

        if (answerString.equals(correctAnswer1) || answerString.equals(correctAnswer2)) {
            extraNumOfPoints = 1;
        }
        else {
            extraNumOfPoints = 0;
        }

        baseNumOfPoints += extraNumOfPoints;
    }
}
