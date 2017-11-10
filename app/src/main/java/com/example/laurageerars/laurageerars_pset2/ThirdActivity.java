package com.example.laurageerars.laurageerars_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    TextView StoryFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String madlibsstory = (String) intent.getSerializableExtra("final_story");

        StoryFinal = findViewById(R.id.StoryFinal);
        StoryFinal.setText(madlibsstory);




    }

    public void returntostart(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
