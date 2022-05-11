package com.example.droidcafe;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    String cake = "You don't choose cake";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        findViewById(R.id.btnImplicitIntent).setOnClickListener(view -> {


//            1
//            Uri webpage = Uri.parse("https://www.youtube.com/");
//            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//            startActivity(intent);

//            2
//            Uri addressUri = Uri.parse("geo:0,0?q=" + location);
//            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//            startActivity(intent);

 //           3
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("share_text_with")
                    .setText("abc")
                    .startChooser();


//            String tel = "tel:0123456789";
//            Uri url =Uri.parse(tel);
//            startActivity(new Intent(Intent.ACTION_DIAL,url));
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.content_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void orderCake(View view) {
        switch (view.getId()) {
            case R.id.donut:
                Toast.makeText(this, R.string.donut_order_message, Toast.LENGTH_SHORT).show();
                cake = getString(R.string.donut_order_message);
                break;
            case R.id.froyo:
                Toast.makeText(this, R.string.froyo_order_message, Toast.LENGTH_SHORT).show();
                cake = getString(R.string.froyo_order_message);
                break;
            case R.id.ice_cream:
                Toast.makeText(this, R.string.ice_cream_order_message, Toast.LENGTH_SHORT).show();
                cake = getString(R.string.ice_cream_order_message);
                break;
            default:
                break;
        }
    }

    public void ClickCart(View view) {
        Intent i = new Intent(getApplicationContext(), OrderActivity.class);
        i.putExtra("cake", cake);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                displayToast(getString(R.string.action_order_message));
                DatePickerDialog dialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
                }, 2202, 5, 10);
                dialog.show();
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                AlertDialog.Builder log = new AlertDialog.Builder(this);
                log.setIcon(R.drawable.donut_circle);
                log.setTitle("AlertLog");
                log.setMessage("this is dialog");
                log.setPositiveButton("OK", (AlertDialog, which) -> {
                    Toast.makeText(getApplicationContext(), "Pressed OK", Toast.LENGTH_SHORT).show();
                    finish();
                });
                log.setNegativeButton("Cancel", (AlertDialog, which) -> {
                    // User cancelled the dialog.
                    Toast.makeText(getApplicationContext(), "Pressed Cancel", Toast.LENGTH_SHORT).show();
                    finish();
                });
                log.setInverseBackgroundForced(true);
                log.create().show();
                return true;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                TimePickerDialog timePickerDialog = new TimePickerDialog(this, (hourOfDay, minute, is24HoursView) -> {
                }, 11, 20, true);
                timePickerDialog.show();
                return true;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

//echo "# Droid-Cafe-Desserts" >> README.md
//git init
//git add README.md
//git commit -m "first commit"
//git branch -M main
//git remote add origin https://github.com/SonHoang1002/Droid-Cafe-Desserts.git
//git push -u origin main