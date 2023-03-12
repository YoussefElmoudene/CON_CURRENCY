package com.example.myfirstappinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Button convertBtn;
    EditText amount;
    EditText text1;
    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);
        convertBtn = (Button) findViewById(R.id.convert_btn);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<>();
        categories.add("MAD");
        categories.add("EUR");
        categories.add("USD");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // On selecting a spinner item
                String item = parentView.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parentView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total1;
                double total2;
                System.out.println("clicked");
                amount = (EditText) findViewById(R.id.amount);
                text1 = (EditText) findViewById(R.id.first_text);
                text2 = (EditText) findViewById(R.id.second_text);
                double ammount = Double.parseDouble(amount.getText().toString());

                if (spinner.getSelectedItem().toString().equals("USD")) {
                    total1 = ammount * 10.46;
                    total2 = ammount * 0.95;

                    text1.setText(new DecimalFormat("##.##").format(total1) + " MAD");
                    text2.setText(new DecimalFormat("##.##").format(total2) + " EURO");
                } else if (spinner.getSelectedItem().toString().equals("MAD")) {
                    total1 = ammount * 0.096;
                    total2 = ammount * 0.091;

                    text1.setText(new DecimalFormat("##.##").format(total1) + " USD");
                    text2.setText(new DecimalFormat("##.##").format(total2) + " EURO");
                } else {
                    total1 = ammount * 1.05;
                    total2 = ammount * 11.02;

                    text1.setText(new DecimalFormat("##.##").format(total1) + " USD");
                    text2.setText(new DecimalFormat("##.##").format(total2) + " MAD");
                }
            }
        });
    }


}