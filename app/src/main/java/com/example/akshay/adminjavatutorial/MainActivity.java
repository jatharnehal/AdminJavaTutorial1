package com.example.akshay.adminjavatutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText)findViewById(R.id.key);
        t2=(EditText)findViewById(R.id.topic);
        btn=(Button)findViewById(R.id.addbtn);
        btn.setOnClickListener(new  View.OnClickListener()
                               {
                                           @Override
                                           public void onClick(View view)
                                           {
                                               String key,topic;
                                               key=t1.getText().toString();
                                               topic=t2.getText().toString();
                                               FirebaseDatabase database = FirebaseDatabase.getInstance();
                                               DatabaseReference myRef = database.getReference(key);
                                               myRef.setValue(topic);
                                               Toast.makeText(MainActivity.this, "Topic is Add Sucessfully", Toast.LENGTH_SHORT).show();
                                               t1.setText("");
                                               t2.setText("");
                                           }
                               });

    }
}
