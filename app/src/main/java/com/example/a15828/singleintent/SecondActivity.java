package com.example.a15828.singleintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a15828.singleintent.adapter.PersonAdapter;
import com.example.a15828.singleintent.pojo.Person;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private TextView tv;
    private int imageResId;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        List<Person> personList = new ArrayList<>();
        personList = getPerson();//初始化数据
        PersonAdapter adapter = new PersonAdapter(SecondActivity.this,R.layout.person_item,personList);
        ListView listView =(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
    private void addPerson(List<Person> list, int image, String name, String content) {
        Person person = new Person(image,name, content);
        list.add(person);
    }

    private List<Person> getPerson() {
        List<Person> personList = new ArrayList<>();
        addPerson(personList,R.drawable.news5,"等下。时光请等一下","时隔14年后，奥林匹克再次进入北京时间。");
        addPerson(personList,R.drawable.news6,"三宿打印社","时隔14年后，奥林匹克再次进入北京时间。");
        addPerson(personList,R.drawable.news7,"三宿零食铺","时隔14年后，奥林匹克再次进入北京时间。");
        return personList;
    }
}
