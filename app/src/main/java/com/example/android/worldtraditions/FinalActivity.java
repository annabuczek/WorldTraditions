package com.example.android.worldtraditions;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    int baseNumOfPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent intent = getIntent();
        baseNumOfPoints = intent.getIntExtra("POINTS", 0);

        String headerMessage = createHeaderMessage(baseNumOfPoints);
        String resultMessage = createResultMessage(baseNumOfPoints);
        displayMessage(headerMessage, resultMessage);

        findViewById(R.id.start_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FinalActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public String createHeaderMessage (int baseNumOfPoints) {

        String headerMessage;

        if (baseNumOfPoints == 4 || baseNumOfPoints == 3) {
            headerMessage = getString(R.string.max_points_message);
        }
        else if (baseNumOfPoints == 2 || baseNumOfPoints == 1) {
            headerMessage = getString(R.string.average_points_message);
        }
        else if(baseNumOfPoints == 0) {
            headerMessage = getString(R.string.zero_points_message);
        }
        else {
            headerMessage = getString(R.string.error_points_message);
        }

        return headerMessage;
    }

    public String createResultMessage (int baseNumOfPoints) {

        String resultMessage;

        if (baseNumOfPoints >= 0 && baseNumOfPoints < 6) {
            resultMessage = getString(R.string.result_message, baseNumOfPoints);
        }
        else {
            resultMessage = getString(R.string.error_result_message);
        }

        return resultMessage;
    }

    public void displayMessage(String headerMessage, String resultMessage) {
        TextView headerMessageTextView = findViewById(R.id.result_header);
        headerMessageTextView.setText(headerMessage);

        TextView resultMessageTextView = findViewById(R.id.result);
        resultMessageTextView.setText(resultMessage);
    }
}
