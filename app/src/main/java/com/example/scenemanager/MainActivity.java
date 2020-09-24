package com.example.scenemanager;

import androidx.appcompat.app.AppCompatActivity;
import com.unity3d.player.UnityPlayerActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView txt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button  btn  =  findViewById(R.id.btn) ;
        Button  btn2  =  findViewById(R.id.btn1) ;
       // Button btn3  =  findViewById(R.id.btn2) ;
        Button seen1 = findViewById(R.id.seen1) ;
        Button seen2  =  findViewById(R.id.seen2) ;
        Button seen3  =  findViewById(R.id.seen3) ;
        txt  =  findViewById(R.id.txt) ;
        seen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheScene("seen1");

            }
        });
        seen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheScene("seen2");
            }
        });
        seen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTheScene("seen3");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This is a Toast", Toast.LENGTH_SHORT).show();
                Intent  i  =  new Intent(MainActivity.this ,UnityPlayerActivity.class) ;
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sharedPreferenceName = MainActivity.this.getPackageName() + ".v2.playerprefs";
                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(sharedPreferenceName, MODE_PRIVATE);;
                String scene  =  sharedPreferences.getString("seenID" , "seen1") ;
                Toast.makeText(MainActivity.this, "Vaule of Score is : "  + scene, Toast.LENGTH_LONG).show();
            }
        });


    }

    public void setTheScene(String scene)
    {
        String sharedPreferenceName = MainActivity.this.getPackageName() + ".v2.playerprefs";
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(sharedPreferenceName, MODE_PRIVATE);;
        SharedPreferences.Editor    editor    =  sharedPreferences.edit() ;
        editor.putString("seenID"  , scene) ;
        editor.commit() ;
        txt.setText("YOU HAVE SELECTED " + scene );
    }
}