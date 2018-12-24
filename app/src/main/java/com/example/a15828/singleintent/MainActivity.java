package com.example.a15828.singleintent;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText input1;
    private  EditText input2;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 = this.findViewById(R.id.login_edit_userName);
        input2 = this.findViewById(R.id.login_edit_password);
        submit = this.findViewById(R.id.login_but_landing);
        submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login_but_landing:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String a = input1.getText().toString();
                String b = input2.getText().toString();
                intent.putExtra("text_userid", a);
                intent.putExtra("text_userpwd",b);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
