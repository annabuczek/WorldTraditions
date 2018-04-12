package com.example.android.worldtraditions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class ThirdQuestion extends AppCompatActivity {

    int extraNumOfPoints;
    int baseNumOfPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_question);

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

        Log.i("ThirdQuestion", "The num of points is " + baseNumOfPoints);

        findViewById(R.id.next_button_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitAnswer();



                Log.i("ThirdQuestion", "The base num of points po przeliczeniu  " + baseNumOfPoints);

                Intent intent = new Intent(ThirdQuestion.this, FourthQuestion.class);
                String baseNumOfPointsString = String.valueOf(baseNumOfPoints);
                intent.putExtra("baseNumOfPointsString", baseNumOfPointsString);
                startActivity(intent);

            }
        });
    }

    public void submitAnswer() {
        baseNumOfPoints += extraNumOfPoints;
    }

    public void selectAnswer(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_1:
                if (checked) {
                    extraNumOfPoints = 0;
                }
                break;

            case R.id.radio_2:
                if (checked) {
                    extraNumOfPoints = 1;
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
