package com.example.advancedchronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Handler h;
    Runnable r;
    TextView timeScreen;
    Intent receiverIntent,i2;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        timeScreen = findViewById(R.id.timeScreen);

        receiverIntent = getIntent();
        number = receiverIntent.getIntExtra("numberValue",0);


        h=new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                if(number!=0){
                    timeScreen.setText("Left: " + number);
                    number--;
                    timeScreen.setText("Left: " + number);
                }else{
                    h.removeCallbacks(r);
                    Toast.makeText(Main2Activity.this,"Time's up!", Toast.LENGTH_SHORT).show();
                }

                //1 er saniyelik gecikmelerle r runnable objesini tetikle.
                h.postDelayed(r,1000);


            }
        };
        h.post(r);





    }

    public void reset(View v){
        i2 = new Intent (getApplicationContext(), MainActivity.class);
        startActivity(i2);
    }

}
