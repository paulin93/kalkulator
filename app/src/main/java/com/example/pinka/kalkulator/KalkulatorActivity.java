package com.example.pinka.kalkulator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class KalkulatorActivity extends ActionBarActivity {

    private EditText Scr; //miejsce wyswietlenia
    private float NumberBf;
    private String Operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
        Scr = (EditText)findViewById(R.id.editText);

        Operation = getIntent().getStringExtra("Dzialanie");
        Button buttonDzialanie = (Button)findViewById(R.id.buttonDzialanie);
        buttonDzialanie.setText(Operation);

        int idList[] = {R.id.button0, R.id.button, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9, R.id.buttonDot, R.id.buttonEq, R.id.buttonC, R.id.buttonDzialanie
        };

        for(int id : idList){
            Button b = (Button)findViewById(id);
            b.setOnClickListener(onClickListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kalkulator, menu);
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

    public void mMath() {
        NumberBf = Float.parseFloat(Scr.getText().toString()); //zapisuje wynik
        Scr.setText("0"); // czysci ekran
    }

    public void getKeyboard(String str){
        String ScrCurrent = Scr.getText().toString();
        if(ScrCurrent.equals("0"))
            ScrCurrent = "";
        ScrCurrent += str;
        Scr.setText(ScrCurrent);
    }

    public void mResult(){
        float NumAf = Float.parseFloat(Scr.getText().toString());
        float result = 0;
        if(Operation.equals("+")){
            result = NumAf + NumberBf;
        }
        else if (Operation.equals("-")) {
            result = NumberBf - NumAf;
        }
        Scr.setText(String.valueOf(result));
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonC: //kasuje ekran
                    Scr.setText("0");
                    NumberBf = 0;
                    break;
                case R.id.buttonDzialanie: //dzialanie
                    mMath();
                    break;
                case R.id.buttonEq: //równa się
                    mResult();
                    break;
                default:
                    String numb = ((Button) v).getText().toString();
                    getKeyboard(numb);
                    break;
            }
        }
    };
}
