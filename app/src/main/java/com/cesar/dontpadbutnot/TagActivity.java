package com.cesar.dontpadbutnot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TagActivity extends AppCompatActivity {

    private EditText tagEditText;
    private EditText textEditText;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference tagReference;

    private String textTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);

        tagEditText = findViewById(R.id.tagEditText);
        //textTag = getIntent().getStringExtra("tag");
        //tagEditText.setText(textTag);

        textEditText = findViewById(R.id.textEditText);
        textEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                /*String key  = getIntent().getStringExtra("tag");
                String textTag = tagEditText.getEditableText().toString();
                String text = textEditText.getText().toString();

                Tag tag = new Tag(key,textTag,text);
                tagReference.child(key).setValue(tag);*/
                            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TagActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



    private void setupFirebase(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        tagReference = firebaseDatabase.getReference("tags");
    }
}
