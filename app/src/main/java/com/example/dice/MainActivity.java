package com.example.dice;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat; // for edge-to-edge optional

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Optional: enable edge-to-edge look (if you want). Requires androidx.core
        WindowCompat.setDecorFitsSystemWindows(getWindow(), true); // simple safe default
        setContentView(R.layout.activity_main);

        // find views by id
        Button rollButton = findViewById(R.id.Roll_btn);
        final ImageView leftDice = findViewById(R.id.image_leftDice);
        final ImageView rightDice = findViewById(R.id.image_RightDice);

        // array of dice drawables (six faces)
        final int[] diceArray = {
                R.drawable.dice_1,
                R.drawable.dice_4,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_5,
                R.drawable.dice_6
        };

        // set click listener on the button
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Roll button clicked!");
                Random rand = new Random();

                int number1 = rand.nextInt(6); // returns 0..5
                Log.d(TAG, "left dice random index: " + number1);
                leftDice.setImageResource(diceArray[number1]);

                int number2 = rand.nextInt(6); // 0..5
                Log.d(TAG, "right dice random index: " + number2);
                rightDice.setImageResource(diceArray[number2]);
            }
        });
    }
}
