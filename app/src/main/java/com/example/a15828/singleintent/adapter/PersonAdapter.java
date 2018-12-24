package com.example.a15828.singleintent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a15828.singleintent.R;
import com.example.a15828.singleintent.pojo.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {
    private int resourceId;
    public PersonAdapter(Context content, int imageResorceId, List<Person> objects){
        super(content,imageResorceId,objects);
        resourceId = imageResorceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Person person = getItem(position);//获取当前实例
        View view  = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
//        List<ImageView> images = new ArrayList<>();
        ImageView personImage = (ImageView)view.findViewById(R.id.person_image);
        TextView personName = (TextView)view.findViewById(R.id.person_name);
        personImage.setImageResource(person.getImages());
//        ((ImageView) view.findViewById(R.id.news_image)).setImageResource(imageResId);
        personName.setText(person.getName());
        return view;
    }
}
