package com.example.application.trial.categories1;


import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<model> models;
    private LayoutInflater layoutinflater;
    private Context context;

    public Adapter(List<model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container,int position){
        layoutinflater =LayoutInflater.from(context);
        View view=layoutinflater.inflate(R.layout.item,container,false);
       // Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
        ImageView imageView;
        TextView title,desc;
        Intent intent=new Intent(context,MainActivity.class);
        intent.putExtra("pos",position);
        imageView=view.findViewById(R.id.image);
        title=view.findViewById(R.id.tite);
        desc=view.findViewById(R.id.desc);
        int pos;
        pos=models.get(position).getPos();
        //Toast.makeText(context, ""+pos, Toast.LENGTH_SHORT).show();
        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container,int position,@NonNull Object object){
        container.removeView((View)object);
    }
}