package com.example.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class Activity_game extends AppCompatActivity {

    TextView txt, count, timeG;
    Button btnYes, btnNo, btnEnd;
    ArrayList<Integer> array = new ArrayList<>();
    int guessInd, cnt, A, B;
    long beforeB;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btnYes = findViewById(R.id.btnY);
        btnNo = findViewById(R.id.btnN);
        btnEnd = findViewById(R.id.btnMyNum);
        txt = findViewById(R.id.txtAsk);
        count = findViewById(R.id.cntTry);
        timeG = findViewById(R.id.timeTry);
        Intent i = getIntent();
        array = i.getIntegerArrayListExtra("mass");
        A = 0;
        B = (array != null ? array.size() : 0) - 1;
        guessInd = random(A, B);
        beforeB = System.currentTimeMillis();
        txt.setText("Ваше число больше: " + array.get(guessInd) + "?");
    }

    public int random(int a, int b) {
        return (int) (a + Math.random() * (b - a));
    }

    @SuppressLint("SetTextI18n")
    public void clickYorN(View v) {

        if (v.getId() == R.id.btnY) {
            cnt += 1;
            A = guessInd + 1;
            guessInd = random(A, B);
            txt.setText("Ваше число больше: " + array.get(guessInd) + "?");
        }

        if (v.getId() == R.id.btnN) {
            cnt += 1;
            B = guessInd - 1;
            guessInd = random(A, B);
            txt.setText("Ваше число больше: " + array.get(guessInd) + "?");
        }

        if (v.getId() == R.id.btnMyNum) {
            btnYes.setClickable(false);
            btnNo.setClickable(false);
            btnEnd.setClickable(false);
            txt.setText("Да, число " + array.get(guessInd) + " было загадано мной!");
            count.setText("Количество попыток: " + cnt);
            long afterB = System.currentTimeMillis();
            timeG.setText("Время угадывания телефоном = " + (((afterB - beforeB) % 60000) / 1000) + " секунд.");
        }


    }

}

