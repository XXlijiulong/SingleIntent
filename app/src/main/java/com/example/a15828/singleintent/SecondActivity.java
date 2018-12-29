package com.example.a15828.singleintent;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.a15828.singleintent.adapter.PersonAadater;
import com.example.a15828.singleintent.adapter.PersonAdapter;
import com.example.a15828.singleintent.pojo.Person;

import java.util.ArrayList;
import java.util.List;

import static android.support.design.widget.TabLayout.MODE_FIXED;
import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_RIPPLE;

public class SecondActivity extends AppCompatActivity{
    private TextView tv;
    private int imageResId;
    private View view;
    private TextView textView;
    private Context context;
    private DrawerLayout drawerLayout;
    private List<Person> personList = new ArrayList<>();
    BottomNavigationBar bottomNavigationBar;
    /*
    setContentView这个方法一定要在findViewById方法之前，不然就会出错：
     */
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        if(Build.VERSION.SDK_INT >=21){
//            View descorView = getWindow().getDecorView();
//            descorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//            );
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }


        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_home);
        }
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                return true;
            }
        });
        personList = getPerson();//初始化数据
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PersonAadater adapter = new PersonAadater(personList);
//        PersonAdapter adapter = new PersonAdapter(SecondActivity.this,R.layout.person_item,personList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottomNavigationBar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.dx,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.txl,"通讯录"))
                .addItem(new BottomNavigationItem(R.drawable.fx,"发现"))
                .setFirstSelectedPosition(0) //设置默认选中位置
                .initialise();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }



    }


