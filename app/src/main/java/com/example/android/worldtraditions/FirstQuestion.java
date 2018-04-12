package com.example.android.worldtraditions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

public class FirstQuestion extends AppCompatActivity {

    int baseNumOfPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_question);

        Log.i("FirstQuestion", "The num of points is " + baseNumOfPoints);

        findViewById(R.id.next_button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitAnswer();

                Log.i("FirstQuestion", "The num of points after click is " + baseNumOfPoints);

                Intent intent = new Intent(FirstQuestion.this, SecondQuestion.class);
                intent.putExtra("POINTS", baseNumOfPoints);
                startActivity(intent);

            }
        });
    }

    public void submitAnswer() {

        CheckBox firstAns = findViewById(R.id.first_answer);
        CheckBox secondAns = findViewById(R.id.second_answer);
        CheckBox thirdAns = findViewById(R.id.third_answer);
        CheckBox fourthAns = findViewById(R.id.fourth_answer);

        Boolean hasFirstAns = firstAns.isChecked();
        Boolean hasSecondAns = secondAns.isChecked();
        Boolean hasThirdAns = thirdAns.isChecked();
        Boolean hasFourthAns = fourthAns.isChecked();

        addPoints(hasFirstAns, hasSecondAns, hasThirdAns, hasFourthAns);

    }

    public void addPoints(boolean firstAns, boolean secondAns, boolean thirdAns, boolean fourthAns) {
        if (firstAns && secondAns && thirdAns && !fourthAns) {
            baseNumOfPoints = 1;
        }
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
