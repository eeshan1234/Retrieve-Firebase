package com.example.application.trial.categories1;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button button;
    Adapter adapter;
    List<model> models;
    Integer[] colors=null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();
    private DrawerLayout drawer;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        button=findViewById(R.id.btnread);
        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        nv = (NavigationView)findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                Toast.makeText(MainActivity.this, "ID1= " + id, Toast.LENGTH_LONG).show();
                switch (id) {
                    case R.id.nav_message:
                        //logic
                        break;
                    case R.id.nav_chat:
                        //logic
                        break;
                    case R.id.nav_profile:
                        //logic
                        break;
                    case R.id.nav_share:
                        //logic
                        break;
                    case R.id.nav_send:
                        //logic
                    default:
                        return true;
                }
                return true;
            }
        });


        BottomNavigationView bottomnav=findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_cont,new HomeFragment()).commit();
        models =new ArrayList<>();
        models.add(new model(R.drawable.inspiration,"inspiration","Grow Inspired",0));
        models.add(new model(R.drawable.love,"love","A bliss feeling",1));
        models.add(new model(R.drawable.sad,"sad","Life shows its ways",2));
        models.add(new model(R.drawable.science,"science Fiction","Innovate with science",3));

        adapter=new Adapter(models,this);

        viewPager =findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);
        Integer[] colors_temp={
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
        };
        colors=colors_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (i<(adapter.getCount()-1)&&i<(colors.length-1)){
                    viewPager.setBackgroundColor(
                            (Integer)argbEvaluator.evaluate(
                                    v,
                                    colors[i],
                                    colors[i+1]
                            )
                    );
                    //Toast.makeText(MainActivity.this, "i "+i+" v "+v+" il"+i1, Toast.LENGTH_SHORT).show();
                }
                else {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(final int i) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in=new Intent(MainActivity.this,viewarticle.class);
                        in.putExtra("pgno",i);
                        startActivity(in);
                    }
                });
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedfragment = null;
                    switch (menuItem.getItemId())
                    {
                        case R.id.home:
                            selectedfragment = new HomeFragment();
                            break;
                        case R.id.star:
                            selectedfragment = new StarFragment();
                            break;
                        case R.id.notification:
                            selectedfragment = new NotificationFragment();
                            break;
                        case R.id.info:
                            selectedfragment = new InfoFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_cont,selectedfragment).commit();
                    return true;
                }
            };
}

