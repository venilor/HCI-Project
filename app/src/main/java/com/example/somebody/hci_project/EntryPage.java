package com.example.somebody.hci_project;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EntryPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_page);

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.GRAY);
    }

    public void startMood(View view){
        Intent intent = new Intent(this, MoodPage.class);
        startActivity(intent);
    }
}
