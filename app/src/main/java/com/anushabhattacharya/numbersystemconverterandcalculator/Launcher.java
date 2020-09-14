package com.anushabhattacharya.numbersystemconverterandcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Launcher extends AppCompatActivity {
    private Vibrator myVib;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);


        if (item.getItemId() == R.id.share){
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Check it out";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }
        if (item.getItemId()==R.id.exit){
            finish();
            System.exit(0);
        }
        return true;
    }








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);


    }

    public void openConverter(View view) {
        myVib.vibrate(40);
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);



    }

    public void openCalculator(View view) {

        myVib.vibrate(40);
            Intent i = new Intent(this,Calculator.class);
            startActivity(i);


    }


    public void openChart(View view) {
        Intent i = new Intent(this, Chart.class);
        myVib.vibrate(40);
        startActivity(i);
    }
}