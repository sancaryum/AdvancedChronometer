package com.example.advancedchronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numberText;
    Button startButton;
    int number;
    Intent i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        numberText = findViewById(R.id.editText);
        i1 = new Intent (getApplicationContext(), Main2Activity.class);
        number = 0;

    }

    public void start(View v){

        try{
            number = Integer.parseInt(numberText.getText().toString());

            i1.putExtra("numberValue", number);
            startActivity(i1);

        }catch (Exception e){
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
        }


        }






}
