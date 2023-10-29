package com.ben.tekrarmyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {


    private static final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
    }

    public void RollDice(View view) {
        String info = view.getContentDescription().toString();
        String face = info.split(" ")[1];
        int face_count = Integer.parseInt(face);
        int result = Roll(face_count);
        Toast.makeText(this, String.valueOf(result), Toast.LENGTH_SHORT).show();

    }

    private int Roll(int face_count) {
        return random.nextInt(face_count) + 1;
    }
}