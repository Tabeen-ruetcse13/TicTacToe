package com.androidapp.tictactoe;

import android.net.Uri;
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

public class Credit extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_credit);
		
final Button goButton = (Button) findViewById(R.id.goButton);
		
		goButton.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					goButton.getBackground().setAlpha(100);
					break;
					
				case MotionEvent.ACTION_UP:
					goButton.getBackground().setAlpha(255);
					
					Uri uri = Uri.parse("https://www.facebook.com/profile.php?id=100010070198864"); // missing 'http://' will cause crashed
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					startActivity(intent);
					
					//Intent intent = new Intent(WelcomePageActivity.this, DocumentActivity.class);
					//startActivity(intent);
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
		getMenuInflater().inflate(R.menu.activity_credit, menu);
		return true;
	}

}
