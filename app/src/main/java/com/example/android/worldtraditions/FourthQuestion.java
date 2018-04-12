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

        Intent intent = getIntent();
        baseNumOfPoints = intent.getIntExtra("POINTS", 0);

        Log.i("FourthQuestion", "The num of points is " + baseNumOfPoints);

        Button next = findViewById(R.id.next_button_4);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitAnswer();

                Log.i("FourthQuestion", "The base num of points after calculating is " + baseNumOfPoints);

                Intent intent = new Intent(FourthQuestion.this, FinalActivity.class);
                intent.putExtra("POINTS", baseNumOfPoints);
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("base_num_of_points", baseNumOfPoints);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        baseNumOfPoints = savedInstanceState.getInt("base_num_of_points");
    }
}
