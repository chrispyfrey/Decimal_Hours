package com.chrisfrey.decimalhourscalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText startTimeEditText;
    private EditText endTimeEditText;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTimeEditText = findViewById(R.id.startTimeEditText);
        endTimeEditText = findViewById(R.id.endTimeEditText);
        resultTextView = findViewById(R.id.resultTimeTextView);
        calculateButton = findViewById(R.id.calculateButton);
    }

    public void calcButtonOnClick(View view) {
        String startTimeStr = this.startTimeEditText.getText().toString().trim();
        String endTimeStr = this.endTimeEditText.getText().toString().trim();

        if (startTimeStr.length() > 0 && endTimeStr.length() > 0) {
            int startTime = Integer.parseInt(startTimeStr);
            int endTime = Integer.parseInt(endTimeStr);

            if (endTime > startTime && (startTime % 100) < 60 && (endTime % 100) < 60) {
                int startHours = startTime / 100;
                int endHours = endTime / 100;
                int startMinutes = startTime % 100;
                int endMinutes = endTime % 100;
                int totStartMinutes = (startHours * 60) + startMinutes;
                int totEndMinutes = (endHours * 60) + endMinutes;
                int elapsedMinutes = totEndMinutes - totStartMinutes;
                double decTime = elapsedMinutes / 60.0;
                this.resultTextView.setText(String.format("%.2f", decTime));

            } else {
                this.resultTextView.setText("Check Input");
            }
        } else {
            this.resultTextView.setText("Check Input");
        }
    }
}