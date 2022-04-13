package com.example.challengehighorlow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void randomNumberGenerator() //for repeating the game
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;
    }
    public void onGuess(View view)
    {

        try {
            EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());

            if(guessedNumber < randomNumber && guessedNumber <= 20) {
                Toast.makeText(this, "Jawaban Terlalu rendah", Toast.LENGTH_SHORT).show();
            } else if(guessedNumber > randomNumber && guessedNumber <= 20) {
                Toast.makeText(this, "Jawaban Terlalu tinggi", Toast.LENGTH_SHORT).show();
            } else if (guessedNumber == randomNumber && guessedNumber <= 20)
            {
                Toast.makeText(this, "Jawaban tepat = "+randomNumber, Toast.LENGTH_SHORT).show();
                randomNumberGenerator();    //kinda recurtion !
            }
        }
        catch (Exception e) {
            Toast.makeText(this, "Isi Jawaban anda", Toast.LENGTH_SHORT).show();
        }
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;    //limit upto 20 from 1
    }
}