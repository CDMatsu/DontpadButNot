package com.cesar.dontpadbutnot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private List<Tag> tags;
    private Adapter tagsAdapter;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference tagReference;

    private EditText tagEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tagEditText = findViewById(R.id.tagEditText);
        tags = new Stack<Tag>();
        tagsAdapter = new ArrayAdapter<Tag>(this, android.R.layout.simple_list_item_1,tags);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key  = tagReference.push().getKey();
                String textTag = tagEditText.getEditableText().toString();
                String text = "";

                Tag tag = new Tag(key,textTag,text);
                tagReference.child(key).setValue(tag);
                Toast.makeText(MainActivity.this, getString(R.string.tag_created), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, TagActivity.class);
                intent.putExtra("tag",key);
                startActivity(intent);
            }
        });

        setupFirebase();
    }

    private void setupFirebase(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        tagReference = firebaseDatabase.getReference("tags");
    }

}
