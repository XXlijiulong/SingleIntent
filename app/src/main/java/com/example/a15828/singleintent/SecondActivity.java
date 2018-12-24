package com.example.a15828.singleintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = this.findViewById(R.id.textView2);
        Intent intent = this.getIntent();
        String text_userid = intent.getStringExtra("text_userid");
        String text_userpwd = intent.getStringExtra("text_userpwd");
        tv.setText(text_userid);
    }
}
