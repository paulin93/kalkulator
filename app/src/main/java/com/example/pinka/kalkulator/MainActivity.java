package com.example.pinka.kalkulator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1= (Button)findViewById(R.id.buttondodawanie);
        Button b2= (Button)findViewById(R.id.buttonOdejmowanie);

        b1.setOnClickListener(onClickListener);
        b2.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), KalkulatorActivity.class);

            Button klikniety = (Button)v;
            if(klikniety.getId() == R.id.buttondodawanie){
                intent.putExtra("Dzialanie", "+");
            }
            else if(klikniety.getId() == R.id.buttonOdejmowanie){
                intent.putExtra("Dzialanie", "-");
            }

            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}
