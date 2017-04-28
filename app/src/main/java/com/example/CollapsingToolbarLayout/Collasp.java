package com.example.CollapsingToolbarLayout;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.toolsbar.R;

public class Collasp extends AppCompatActivity {

    public static final String Friut_NAME = "NAME";
    public static final String Friut_Image_id = "ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collasp);
        String fruit_name = getIntent().getStringExtra(Friut_NAME);
        int fruit_ID = getIntent().getIntExtra(Friut_Image_id , 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collaps_toolbar);
        ImageView imageView = (ImageView) findViewById(R.id.title_img);
        TextView textView = (TextView) findViewById(R.id.content);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null ){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(fruit_name);
        Glide.with(this).load(fruit_ID).into(imageView);
        String content = setContentText(fruit_name);
        textView.setText(content);
    }


    private String setContentText(String text){
        StringBuffer buffer =  new StringBuffer();
        for(int i = 0 ; i < 500 ; i++){
            buffer.append(text);
        }
        return  buffer.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
