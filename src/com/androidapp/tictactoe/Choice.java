package com.androidapp.tictactoe;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class Choice extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_choice);
		
		final Button easyButton=(Button) findViewById(R.id.easyButton);
		final Button mediumButton=(Button) findViewById(R.id.mediumButton);
		final Button hardButton=(Button) findViewById(R.id.hardButton);
		
		
		easyButton.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					easyButton.getBackground().setAlpha(100);
					break;
					
				case MotionEvent.ACTION_UP:
					easyButton.getBackground().setAlpha(255);	
					Intent intent = new Intent(Choice.this, TicTacToeEasy.class);
					startActivity(intent);
					break;

				default:
					break;
				}
				
				return false;
			}
		});
		
		mediumButton.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					mediumButton.getBackground().setAlpha(100);
					break;
					
				case MotionEvent.ACTION_UP:
					mediumButton.getBackground().setAlpha(255);	
					Intent intent = new Intent(Choice.this, TicTacToeActivity.class);
					startActivity(intent);
					break;

				default:
					break;
				}
				
				return false;
			}
		});
		
		hardButton.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					hardButton.getBackground().setAlpha(100);
					break;
					
				case MotionEvent.ACTION_UP:
					easyButton.getBackground().setAlpha(255);	
					Intent intent = new Intent(Choice.this, TicTacToeHard.class);
					startActivity(intent);
					break;

				default:
					break;
				}
				
				return false;
			}
		});
		

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_choice, menu);
		return true;
	}

}
