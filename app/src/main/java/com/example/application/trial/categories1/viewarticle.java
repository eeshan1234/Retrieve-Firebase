package com.example.application.trial.categories1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class viewarticle extends AppCompatActivity {
    private List<writings> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewarticle);
        final TextView tv1,tv2;

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MyAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        Intent intent=getIntent();
      //  int c=0;
       // FirebaseDatabase database=FirebaseDatabase.getInstance();
      final int z=0;
        final int pos=intent.getIntExtra("pgno",0);
        if(pos==0)

        {
            DatabaseReference reference=FirebaseDatabase.getInstance().getReference("categories");

            reference.child("inspiration").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int n=1;

                for(DataSnapshot x:dataSnapshot.getChildren()){

                    String name1= dataSnapshot.child("quotes").child("english").child(""+(n)).getValue().toString();

                    Toast.makeText(viewarticle.this, ""+name1, Toast.LENGTH_SHORT).show();
                  //  Toast.makeText(viewarticle.this, "1st pass", Toast.LENGTH_SHORT).show();

                    writings user = new writings(name1);
                    movieList.add(user);
                    n=n+1;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        }
        else if(pos==1)
        {
            DatabaseReference reference=FirebaseDatabase.getInstance().getReference("categories");
            reference.child("love").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int n=1;

                    for(DataSnapshot x:dataSnapshot.getChildren()){

                        String name1= dataSnapshot.child("quotes").child("english").child(""+(n)).getValue().toString();

                        Toast.makeText(viewarticle.this, ""+name1, Toast.LENGTH_SHORT).show();
                        //  Toast.makeText(viewarticle.this, "1st pass", Toast.LENGTH_SHORT).show();

                        writings user = new writings(name1);
                        movieList.add(user);
                        n=n+1;
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
        else if(pos==2)
        {
            DatabaseReference reference=FirebaseDatabase.getInstance().getReference("categories");
            reference.child("sad").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {  int n=1;

                    for(DataSnapshot x:dataSnapshot.getChildren()){

                        String name1= dataSnapshot.child("quotes").child("english").child(""+(n)).getValue().toString();

                        Toast.makeText(viewarticle.this, ""+name1, Toast.LENGTH_SHORT).show();
                        //  Toast.makeText(viewarticle.this, "1st pass", Toast.LENGTH_SHORT).show();

                        writings user = new writings(name1);
                        movieList.add(user);
                        n=n+1;
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
        else
        {
            DatabaseReference reference=FirebaseDatabase.getInstance().getReference("categories");
            reference.child("science fiction").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {  int n=1;

                    for(DataSnapshot x:dataSnapshot.getChildren()){

                        String name1= dataSnapshot.child("quotes").child("english").child(""+(n)).getValue().toString();

                        Toast.makeText(viewarticle.this, ""+name1, Toast.LENGTH_SHORT).show();
                        //  Toast.makeText(viewarticle.this, "1st pass", Toast.LENGTH_SHORT).show();

                        writings user = new writings(name1);
                        movieList.add(user);
                        n=n+1;
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }

    }
}
