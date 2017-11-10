package com.example.laurageerars.laurageerars_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView   WordsCount, kindOfWord;
    EditText   Placeholder;
    Button OK;
    Story madlibsstory;
    int amountOfWords;
    String placeholderfillin;
    String final_story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Getting the story
        Intent intent = getIntent();
        madlibsstory = (Story) intent.getSerializableExtra("creating_story");

        //Finding id's'
        WordsCount = findViewById(R.id.Words_Count);
        kindOfWord = findViewById(R.id.kindOfWord);
        Placeholder = findViewById(R.id.Placeholder);
        OK = findViewById(R.id.OK);

        //How many words left
        amountOfWords = madlibsstory.getPlaceholderRemainingCount();
        WordsCount.setText(amountOfWords + "word(s) left");

        //Placeholders
        placeholderfillin = madlibsstory.getNextPlaceholder();
        Placeholder.setHint(placeholderfillin);

        //Fill in what kind of word it should be (placeholder)
        kindOfWord.setText("This word is a/an " + placeholderfillin);
    }



    public void GetNextPlaceholders(View view) {
        madlibsstory.fillInPlaceholder(Placeholder.getText().toString());

        if(madlibsstory.getPlaceholderRemainingCount() != 0){
            Placeholder.setText("");
            //How many words left
            amountOfWords = madlibsstory.getPlaceholderRemainingCount();
            WordsCount.setText(amountOfWords + " word(s) left");
            //Placeholders
            placeholderfillin = madlibsstory.getNextPlaceholder();
            Placeholder.setHint(placeholderfillin);
            //Fill in what kind of word it should be (placeholder)
            kindOfWord.setText("This word is a/an " + placeholderfillin);
        }
        else{
            //final_story = madlibsstory.toString();
            Intent intent = new Intent(this, ThirdActivity.class);
            intent.putExtra("final_story", madlibsstory.toString());
            startActivity(intent);
            finish();

        }
    }
}





