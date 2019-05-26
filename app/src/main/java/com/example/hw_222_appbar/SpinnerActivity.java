package com.example.hw_222_appbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner countriesSpinner;
    private Spinner citiesSpinner;
    private Spinner houseNumberSpinner;
    private Button showAddressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        initViews();

        showAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageToShow = countriesSpinner.getSelectedItem().toString() + " "
                        + citiesSpinner.getSelectedItem().toString() + " "
                        + houseNumberSpinner.getSelectedItem().toString();
                Toast.makeText(SpinnerActivity.this, messageToShow, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initViews() {
        countriesSpinner = findViewById(R.id.countriesSpinner);
        citiesSpinner = findViewById(R.id.citiesSpinner);
        houseNumberSpinner = findViewById(R.id.houseNumberSpinner);
        showAddressButton = findViewById(R.id.showAddress);
        initSpinnerCountries();
        initHouseNumbersSpinner();
    }

    private void initSpinnerCountries() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countriesSpinner.setAdapter(adapterCountries);

        countriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] countries = getResources().getStringArray(R.array.countries);
                initSpinnerCities(countries[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initSpinnerCities(String country) {
        ArrayAdapter<CharSequence> adapter = null;
        switch (country) {
            case "Россия":
                adapter = ArrayAdapter.createFromResource(this, R.array.r_cities,
                        android.R.layout.simple_spinner_item);
                break;
            case "Украина":
                adapter = ArrayAdapter.createFromResource(this, R.array.u_cities,
                        android.R.layout.simple_spinner_item);
                break;
            case "Белоруссия":
                adapter = ArrayAdapter.createFromResource(this, R.array.b_cities,
                        android.R.layout.simple_spinner_item);
                break;
        }
        if (adapter != null) {
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            citiesSpinner.setAdapter(adapter);
        }
    }

    private void initHouseNumbersSpinner() {
        Integer[] houseNumbers = new Integer[50];
        for (int i = 1; i <= 50; i++) {
            houseNumbers[i - 1] = i;
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, houseNumbers);
        houseNumberSpinner.setAdapter(adapter);
    }
}
