package com.example.administrator.toolsbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener{

    private DrawerLayout drawerLayout;
    private FloatingActionButton actionButton;
    private RecyclerView recyclerView;
    private FruitAdapter adapter;
    private List<Friut> friutList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        actionButton = (FloatingActionButton)findViewById(R.id.action_bar);
        actionButton.setOnClickListener(this);
        recyclerView = (RecyclerView)findViewById(R.id.recyle_view);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nv_view);
        navigationView.setNavigationItemSelectedListener(this);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.fish_mode_2r_nor);
        }
        initFruitList();
        adapter = new FruitAdapter(this , friutList);
        GridLayoutManager layoutManager = new GridLayoutManager(this , 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    private void initFruitList(){
        for(int i = 0; i < 3 ; i++){
            friutList.add(new Friut("baicai" , R.drawable.baicai));
            friutList.add(new Friut("bohe" , R.drawable.bohe));
            friutList.add(new Friut("caomei" , R.drawable.caomei));
            friutList.add(new Friut("chengzo" , R.drawable.chengzo));
            friutList.add(new Friut("mangguo" , R.drawable.mangguo));
            friutList.add(new Friut("ningmeng" , R.drawable.ningmeng));
            friutList.add(new Friut("niunai" , R.drawable.niunai));
            friutList.add(new Friut("pingguo" , R.drawable.pingguo));
            friutList.add(new Friut("sangshen" , R.drawable.sangshen));
            friutList.add(new Friut("shala" , R.drawable.shala));
            friutList.add(new Friut("yezi" , R.drawable.yezi));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.delete:
            case R.id.back_up:
            case R.id.set:

        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            drawerLayout.closeDrawers();
            return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == actionButton.getId()){
            Snackbar.make(v,"删除数据",Snackbar.LENGTH_LONG)
                    .setAction("撤销", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this,"撤销成功",Toast.LENGTH_LONG).show();
                        }
                    }).show();
        }
    }


}
