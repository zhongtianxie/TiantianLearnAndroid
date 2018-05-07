package com.example.chaozhuoxzt.h5appdemo1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bt1;
    private Button bt2;
    private Context context;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);

        context = this;
        bt1 = findViewById(R.id.buttonFirst);
        bt2 = findViewById(R.id.buttonSecond);
        textView = findViewById(R.id.textView1);

        //jump by startActivity
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SActivity.class);
                startActivity(intent);
            }
        });

        //jump by startActivityForResult
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    //jump and recive return data
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1 && resultCode == 2){
            String content = data.getStringExtra("data");
            textView.setText(content);
        }
    }
}