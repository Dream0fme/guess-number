package com.example.guessnumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> mass = new ArrayList<>();
    Button btn;
    EditText numFrom, numTo;
    int a, b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnAccept);
        numFrom = findViewById(R.id.editFrom);
        numTo = findViewById(R.id.editTo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = (numFrom.getText() == null) ? 0 : Integer.parseInt(numFrom.getText().toString());
                b = (numTo.getText() == null) ? 0 : Integer.parseInt(numTo.getText().toString());
                for (int i = a; i < b; i++) {
                    mass.add(i);
                }
                //Toast.makeText(getApplicationContext(), (CharSequence) mass,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Activity_game.class);
                intent.putExtra("mass", mass);
                startActivity(intent);
            }
        });
    }
}

