package com.example.sherlock;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class TwoActivity extends Activity {

	public final static String THIEF = "";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twoactivity);
    }


    public void onRadioClick(View v) {
    	Intent answerInent = new Intent();

    	switch (v.getId()) {
    	case R.id.radioDog:
    		answerInent.putExtra(THIEF, "������ ����");
    		break;
    	case R.id.radioCrow:
    		answerInent.putExtra(THIEF, "������");
    		break;
    	case R.id.radioCat:
    		answerInent.putExtra(THIEF, "������ �������������");
    		break;
    		
    	default:
    		break;
    	}

    	setResult(RESULT_OK, answerInent);
    	finish();
    }
    
}