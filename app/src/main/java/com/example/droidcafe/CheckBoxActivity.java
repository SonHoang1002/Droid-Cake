package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private String mes = " You click ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        findViewById(R.id.btnCheckBox).setOnClickListener(view->{
            displayToast(mes);
        });
    }

    public void SendMessage(View view) {
        displayToast(mes);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void Checkbox(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox1:
                if (checked)
                    mes += " checkBox1";
                break;
            case R.id.checkBox2:
                if (checked)
                    mes += " checkBox2";
                break;
            case R.id.checkBox3:
                if (checked)
                    mes += " checkBox3";
                break;
            case R.id.checkBox4:
                if (checked)
                    mes += " checkBox4";
                break;
            case R.id.checkBox5:
                if (checked)
                    mes += " checkBox5";
                break;
            default:

                break;
        }

    }
}