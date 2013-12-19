package com.example.sherlock;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	public TextView tvInfo;
	static final private int CHOOSE_THIEF = 0;
	public Button newbut;
	public LinearLayout myLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);       
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        myLayout = (LinearLayout) findViewById(R.id.LinearLayout1);
        newbut = new Button(this);
        newbut.setText("Наказать Падлу");
        LayoutParams  newparams= new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
        newbut.setLayoutParams(newparams);
        View.OnClickListener newlistener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent newIntent = new Intent(MainActivity.this,
		    			Nakazanie.class);
		    	startActivity(newIntent);
			}
		};
		newbut.setOnClickListener(newlistener);
    }
    
    public void onClick(View v) {
    	Intent questionIntent = new Intent(MainActivity.this,
    			TwoActivity.class);
    	startActivityForResult(questionIntent, CHOOSE_THIEF);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) 
    {
    	super.onActivityResult(requestCode, resultCode, data);

    	if (requestCode == CHOOSE_THIEF) 
    	{
    		if (resultCode == RESULT_OK) 
    		{
    			String thiefname = data.getStringExtra(TwoActivity.THIEF);
    			tvInfo.setText(thiefname);
    			myLayout.addView(newbut);
    		}
    		else 
    		{
    			tvInfo.setText("");
    		}
    	}
    }
    
}
