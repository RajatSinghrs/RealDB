package com.example.realtdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3;
Button b1;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        b1=(Button)findViewById(R.id.b1);
        firebaseDatabase=FirebaseDatabase.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference=firebaseDatabase.getReference("users");
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if (s1.isEmpty()){
                    e1.setError("File name");
                    return;
                }
                if (s2.isEmpty()){
                    e2.setError("Fill Email");
                    return;
                }
                else
                {
                    if(s3.length()!=10){
                        e3.setError("Enter Correct Number");
                        return;
                    }
                    else
                    {
                        Users users=new Users(s1,s2,s3);
                        databaseReference.child(s3).setValue(users);
                    }

                }
            }
        });
    }
}