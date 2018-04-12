package com.example.android.worldtraditions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class SecondQuestion extends AppCompatActivity {

    int extraNumOfPoints;
    int baseNumOfPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_question);

        Intent intent = getIntent();
        baseNumOfPoints = intent.getIntExtra("POINTS", 0);

        Log.i("SecondQuestion", "The num of points is " + baseNumOfPoints);

        findViewById(R.id.next_button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitAnswer();

                Log.i("SecondQuestion", "The base num of points after calculating is " + baseNumOfPoints);

                Intent intent = new Intent(SecondQuestion.this, ThirdQuestion.class);
                intent.putExtra("POINTS", baseNumOfPoints);
                startActivity(intent);
            }
        });

    }

    public void submitAnswer() {
        baseNumOfPoints += extraNumOfPoints;
    }

    public void checkAnswer(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_1:
                if (checked) {
                    extraNumOfPoints = 1;
                }
                break;

            case R.id.radio_2:
                if (checked) {
                    extraNumOfPoints = 0;
                }
                break;

            case R.id.radio_3:
                if (checked) {
                    extraNumOfPoints = 0;
                }
                break;

            case R.id.radio_4:
                if (checked) {
                    extraNumOfPoints = 0;
                }
                break;

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

