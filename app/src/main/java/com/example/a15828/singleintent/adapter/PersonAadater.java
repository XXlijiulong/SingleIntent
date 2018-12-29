package com.example.a15828.singleintent.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a15828.singleintent.ChatActivity;
import com.example.a15828.singleintent.R;
import com.example.a15828.singleintent.ThirdActivity;
import com.example.a15828.singleintent.pojo.Person;

import java.util.List;

public class PersonAadater extends RecyclerView.Adapter<PersonAadater.ViewHolder> {
    private List<Person> mPerson;
    private Context context;
    /*
    在非activity里面使用startActivity()的方法是通过context对象
     */
    static class ViewHolder extends RecyclerView.ViewHolder{
        View personView;
        ImageView personImage;
        TextView personName;
        public ViewHolder(View view){
            super(view);
            personView = view;
            personImage = (ImageView)view.findViewById(R.id.person_image);
            personName = (TextView)view.findViewById(R.id.person_name);

        }
    }
    public PersonAadater(List<Person> personList){
        mPerson = personList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = mPerson.get(position);
        holder.personImage.setImageResource(person.getImages());
        holder.personName.setText(person.getName());

        //设置条目中的点击监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),ChatActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPerson.size();
    }


}
