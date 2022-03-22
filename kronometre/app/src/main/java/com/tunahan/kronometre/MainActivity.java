package com.tunahan.kronometre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button buton;
    Handler hendl;
    Runnable ranable;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView3);
       buton=findViewById(R.id.button);
        number=0;

    }

    public void basla(View view){

        hendl = new Handler();
        ranable = new Runnable() {
            @Override
            public void run() {
                textView.setText("time :"+number);
                number++;
                textView.setText("time :"+number);
                hendl.postDelayed(ranable,1000);
            }
        };

hendl.post(ranable);
buton.setEnabled(false);



    }
public void dur(View view){
    buton.setEnabled(true);
    number = 0;
    hendl.removeCallbacks(ranable);
    textView.setText("Time: " + number);


}


}