package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    TextView tVOrderCake;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tVOrderCake = findViewById(R.id.tVOrderCake);
        spinner = findViewById(R.id.spinner);

        Intent i = getIntent();
        String mes = i.getStringExtra("cake");
        tVOrderCake.setText(mes);
        tVOrderCake.setTextSize(30);

        //Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.arr, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String message = adapterView.getItemAtPosition(i).toString();
                displayToast(message);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        findViewById(R.id.goToCheckBoxActivity).setOnClickListener(view->{
            startActivity(new Intent(OrderActivity.this,CheckBoxActivity.class));
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast("same_day_messenger_service");
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast("next_day_ground_delivery");
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast("pick_up");
                break;
            default:
                // Do nothing.
                break;
        }
    }




}