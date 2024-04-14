package com.example.cronometro;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvElapsedTime;
    private Button btnStartPause;
    private Button btnReset;

    private boolean isRunning;
    private int seconds = 0;
    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            seconds++;
            int hours = seconds / 3600;
            int minutes = (seconds % 3600) / 60;
            int secs = seconds % 60;

            String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
            tvElapsedTime.setText(time);

            if (isRunning) {
                handler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvElapsedTime = findViewById(R.id.tvElapsedTime);
        btnStartPause = findViewById(R.id.btnStartPause);
        btnReset = findViewById(R.id.btnReset);

        btnStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    private void startTimer() {
        isRunning = true;
        btnStartPause.setText("Pause");
        handler.post(runnable);
    }

    private void pauseTimer() {
        isRunning = false;
        btnStartPause.setText("Start");
    }

    private void resetTimer() {
        isRunning = false;
        seconds = 0;
        tvElapsedTime.setText("00:00:00");
        btnStartPause.setText("Start");
    }
}
