package com.example.laurageerars.laurageerars_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Story madlibsstory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //all textfiles in a list for randomly select story
        List<String> list = new ArrayList<String>();
        list.add("madlib0_simple.txt");
        list.add("madlib1_tarzan.txt");
        list.add("madlib2_university.txt");
        list.add("madlib3_clothes.txt");
        list.add("madlib4_dance.txt");

        //random select story
        Random randomizer = new Random();
        String randomfile = list.get(randomizer.nextInt(list.size()));

        //InputStream madlibsstory = getStory(randomfile);
        try {

            InputStream finalstory = getAssets().open(randomfile);
            madlibsstory = new Story(finalstory);
        }
        catch (IOException e) {
            return;

        }

    }


    public void goToSecond(View view) {
        //try{
        //InputStream stream = getAssets().open("madlib0_simple.txt");
        //madlibsstory = new Story(stream);
        //}catch(IOException e){return;}


        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("creating_story", madlibsstory);
        startActivity(intent);

    }


}

