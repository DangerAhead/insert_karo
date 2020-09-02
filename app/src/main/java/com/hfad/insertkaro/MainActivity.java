package com.hfad.insertkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText t1;
    EditText t2;
    Button btn;
    DatabaseReference databaseuser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseuser = FirebaseDatabase.getInstance().getReference("user");



        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmail();
            }
        });
    }

    private void addEmail(){
        String name = t1.getText().toString().trim();
        String email = t2.getText().toString().trim();
        if(!(name.isEmpty()) && !(email.isEmpty()))
        {
            String id = databaseuser.push().getKey();
            stuff Stuff = new stuff(email,name);
            databaseuser.child(id).setValue(Stuff);
            Toast.makeText(this,"User added!",Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(this,"Don't leave it blank damn it!",Toast.LENGTH_LONG).show();
        }
    }

}
















