package com.rabia.arif.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonView;
    EditText editName, editAge;
    Switch switchIsActive;
    ListView listViewDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd= findViewById(R.id.buttonAdd);
        buttonView=findViewById(R.id.buttonView);
        editName=findViewById(R.id.editTextName);
        editAge=findViewById(R.id.editTextNumber);
        switchIsActive=findViewById(R.id.Switch);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            CustomerModel customerModel;

            @Override
            public void onClick(View v) {
                customerModel= new CustomerModel(editName.getText().toString(),Integer.parseInt(editAge.getText().toString()),switchIsActive.isChecked(),1);
                Toast.makeText(MainActivity.this, "Add Record button clicked...", Toast.LENGTH_SHORT).show();
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "View Record button clicked...", Toast.LENGTH_SHORT).show();
            }
        });


    }
}