package com.example.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	EditText editText1, EditText2;
	Button Button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.editText1);
        EditText2 = (EditText) findViewById(R.id.editText2);
        Button1 = (Button) findViewById(R.id.button1);
		TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker1);
		timePicker.setOnTimeChangedListener((OnTimeChangedListener) this);
		timePicker.setCurrentHour(13);
		timePicker.setCurrentMinute(30);
		timePicker.setIs24HourView(true);
	}

    public void Calc(View view){
    	double height = Double.parseDouble(editText1.getText().toString())/100;
    	double weight = Double.parseDouble(EditText2.getText().toString());
    	double BMI = weight / (height * height);
    	
    	TextView textView1 = (TextView) findViewById(R.id.textView1);
    	textView1.setText(String.valueOf(BMI));
    }
     
	public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
		Toast.makeText(this, arg1+":"+arg2, Toast.LENGTH_LONG).show();
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
