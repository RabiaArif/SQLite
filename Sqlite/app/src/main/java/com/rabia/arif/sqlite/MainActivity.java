package com.rabia.arif.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonView;
    EditText editName, editAge;
    Switch switchIsActive;
    ListView listViewDetail;
    ArrayAdapter<CustomerModel> arrayAdapter;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd= findViewById(R.id.buttonAdd);
        buttonView=findViewById(R.id.buttonView);
        editName=findViewById(R.id.editName);
        editAge=findViewById(R.id.editTextNumber);
        switchIsActive=findViewById(R.id.switch1);
        listViewDetail=findViewById(R.id.listViewDetails);

        RefreshData();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            CustomerModel customerModel;

            @Override
            public void onClick(View v) {
                try {
                    customerModel = new CustomerModel(editName.getText().toString(), Integer.parseInt(editAge.getText().toString()), switchIsActive.isChecked(), 1);

//                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                boolean b = dbHelper.addCustomer(customerModel);
                RefreshData();
//                customerModel= new CustomerModel(editName.getText().toString(),Integer.parseInt(editAge.getText().toString()),switchIsActive.isChecked(),1);
//                Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RefreshData();
                //   Toast.makeText(MainActivity.this, allCustomer.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }

    private void RefreshData() {
        dbHelper = new DBHelper(MainActivity.this);
        List<CustomerModel> allCustomer = dbHelper.getAllRecord();
        arrayAdapter= new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1,allCustomer);
        listViewDetail.setAdapter(arrayAdapter);
    }
}