package com.example.maftuna.vote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    String[] drinkNames={"Coca cola", "fanta", "Sprite", "Water", "Choy"};
String[] foodNames={"Fried potatoes", "Seafood", "Rice", "Pasta", "Osh" };
    Button vote;
    EditText nameF, nameL;
    RadioButton button1, button2;
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
        spin.setOnItemSelectedListener(this);

        Spinner spinner = (Spinner) findViewById(R.id.second_spinner);
        spinner.setOnItemSelectedListener(this);

        nameF = (EditText) findViewById(R.id.editText1);
        nameL = (EditText) findViewById(R.id.editText2);
        vote = (Button) findViewById(R.id.button);
        String selectedSuperStar;
        button1 = (RadioButton) findViewById(R.id.radio_button_1);
        button2 = (RadioButton) findViewById(R.id.radio_button_2);


        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,drinkNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter adapt = new ArrayAdapter(this,android.R.layout.simple_spinner_item,foodNames);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(adapter);
        spinner.setAdapter(adapt);

        vote.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (nameF.getText().toString().isEmpty() || nameL.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter the Data", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Name -  " + nameF.getText().toString() +
                            " \n" + "Password -  " + nameL.getText().toString(), Toast.LENGTH_SHORT).show();
                }


                if (button1.isChecked()) {
                    selected = button1.getText().toString();
                } else if (button2.isChecked()) {
                    selected = button2.getText().toString();
                    Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_LONG).show(); // print the value of selected super star
                }
            }
        });





    }



    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), drinkNames[position], Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), foodNames[position], Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }




}
