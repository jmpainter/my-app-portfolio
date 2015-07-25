package com.example.joshuapainter.myappportfolio;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(View view) {

        Button button = (Button)view;
        String buttonText = button.getText().toString().toLowerCase();

        // if this is the capstone button, just take capstone name
        if (buttonText.substring(0, 8).equals("capstone")) {
            buttonText = "capstone";
        }
        //if last four characters of the button name are " app", remove it
        if (buttonText.substring(buttonText.length() - 4, buttonText.length()).equals(" app")) {
            buttonText = buttonText.substring(0, buttonText.length() - 4);
        }
        buttonText = "This button will launch my " + buttonText + " app";
        int buttonTop = button.getTop();
        int buttonLeft = button.getLeft();

        Log.w("Button Top, Left", Integer.toString(buttonTop) + ", " + Integer.toString(buttonLeft));

        //from developer.android.com api guide
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, buttonText, duration);
        toast.setGravity(Gravity.TOP|Gravity.START, buttonLeft - 65, buttonTop + 135);
        toast.show();
    }
}
