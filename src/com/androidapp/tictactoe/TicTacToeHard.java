package com.androidapp.tictactoe;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

import java.util.Random;

import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeHard extends Activity {
	
	 int c[][];
     int i, j, k = 0;
     Button b[][];
     TextView textView;
     AI ai;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_tic_tac_toe_hard);
		
		final Button newGameButton=(Button) findViewById(R.id.newGame);
		newGameButton.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					newGameButton.getBackground().setAlpha(100);
					break;
					
				case MotionEvent.ACTION_UP:
					newGameButton.getBackground().setAlpha(255);
					Intent intent = new Intent(TicTacToeHard.this, TicTacToeHard.class);
					startActivity(intent);
					finish();
					break;

				default:
					break;
				}
				
				return false;
			}
		});

		setBoard();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_tic_tac_toe_hard, menu);
		//return true;
		
		super.onCreateOptionsMenu(menu);
        MenuItem item = menu.add("New Game");
        return true;
	}

// Set up the game board.
private void setBoard() {
     ai = new AI();
     b = new Button[4][4];
     c = new int[4][4];


     textView = (TextView) findViewById(R.id.dialogue);


     b[1][3] = (Button) findViewById(R.id.one);
     b[1][2] = (Button) findViewById(R.id.two);
     b[1][1] = (Button) findViewById(R.id.three);


     b[2][3] = (Button) findViewById(R.id.four);
     b[2][2] = (Button) findViewById(R.id.five);
     b[2][1] = (Button) findViewById(R.id.six);


     b[3][3] = (Button) findViewById(R.id.seven);
     b[3][2] = (Button) findViewById(R.id.eight);
     b[3][1] = (Button) findViewById(R.id.nine);
    
     for (i = 1; i <= 3; i++) {
          for (j = 1; j <= 3; j++)
               c[i][j] = 2;
     }


     textView.setText("Click a button to start.");


     // add the click listeners for each button
     for (i = 1; i <= 3; i++) {
          for (j = 1; j <= 3; j++) {
               b[i][j].setOnClickListener(new MyClickListener(i, j));
               if(!b[i][j].isEnabled()) {
                    b[i][j].setText(" ");
                    b[i][j].setEnabled(true);
               }
          }
     }
}


class MyClickListener implements View.OnClickListener {
     int x;
     int y;


     public MyClickListener(int x, int y) {
          this.x = x;
          this.y = y;
     }


     public void onClick(View view) {
          if (b[x][y].isEnabled()) {
               b[x][y].setEnabled(false);
               b[x][y].setText("O");
               c[x][y] = 0;
               textView.setText("");
               if (!checkBoard()) {
                    ai.takeTurn();
               }
          }
     }
}


private class AI {
     public void takeTurn() {;
     if(c[1][1]==2 &&
               ((c[1][2]==0 && c[1][3]==0) ||
                (c[2][2]==0 && c[3][3]==0) ||
                (c[2][1]==0 && c[3][1]==0) ||
                (c[1][2]==1 && c[1][3]==1) ||
                (c[2][2]==1 && c[3][3]==1) ||
                (c[2][1]==1 && c[3][1]==1))) {
          markSquare(1,1);
     } else if (c[1][2]==2 &&
               ((c[2][2]==0 && c[3][2]==0) ||
                (c[1][1]==0 && c[1][3]==0) ||
                (c[2][2]==1 && c[3][2]==1) ||
                (c[1][1]==1 && c[1][3]==1))) {
          markSquare(1,2);
     } else if(c[1][3]==2 &&
               ((c[1][1]==0 && c[1][2]==0) ||
                (c[3][1]==0 && c[2][2]==0) ||
                (c[2][3]==0 && c[3][3]==0) ||
                (c[1][1]==1 && c[1][2]==1) ||
                (c[3][1]==1 && c[2][2]==1) ||
                (c[2][3]==1 && c[3][3]==1))) {
          markSquare(1,3);
     } else if(c[2][1]==2 &&
               ((c[2][2]==0 && c[2][3]==0) ||
                (c[1][1]==0 && c[3][1]==0) ||
                (c[2][2]==1 && c[2][3]==1) ||
                (c[1][1]==1 && c[3][1]==1))){
          markSquare(2,1);
     } else if(c[2][2]==2 &&
               ((c[1][1]==0 && c[3][3]==0) ||
                (c[1][2]==0 && c[3][2]==0) ||
                (c[3][1]==0 && c[1][3]==0) ||
                (c[2][1]==0 && c[2][3]==0) ||
                (c[1][1]==1 && c[3][3]==1) ||
                (c[1][2]==1 && c[3][2]==1) ||
                (c[3][1]==1 && c[1][3]==1) ||
                (c[2][1]==1 && c[2][3]==1))) {
          markSquare(2,2);
     } else if(c[2][3]==2 &&
               ((c[2][1]==0 && c[2][2]==0) ||
                (c[1][3]==0 && c[3][3]==0) ||
                (c[2][1]==1 && c[2][2]==1) ||
                (c[1][3]==1 && c[3][3]==1))) {
          markSquare(2,3);
     } else if(c[3][1]==2 &&
               ((c[1][1]==0 && c[2][1]==0) ||
                (c[3][2]==0 && c[3][3]==0) ||
                (c[2][2]==0 && c[1][3]==0) ||
                (c[1][1]==1 && c[2][1]==1) ||
                (c[3][2]==1 && c[3][3]==1) ||
                (c[2][2]==1 && c[1][3]==1))){
          markSquare(3,1);
     } else if(c[3][2]==2 &&
               ((c[1][2]==0 && c[2][2]==0) ||
                (c[3][1]==0 && c[3][3]==0) ||
                (c[1][2]==1 && c[2][2]==1) ||
                (c[3][1]==1 && c[3][3]==1))) {
          markSquare(3,2);
     }else if( c[3][3]==2 &&
               ((c[1][1]==0 && c[2][2]==0) ||
                (c[1][3]==0 && c[2][3]==0) ||
                (c[3][1]==0 && c[3][2]==0) ||
                (c[1][1]==1 && c[2][2]==1) ||
                (c[1][3]==1 && c[2][3]==1) ||
                (c[3][1]==1 && c[3][2]==1))) {
          markSquare(3,3);
     } else {
          Random rand = new Random();
          
          int a = rand.nextInt(4);
          int b = rand.nextInt(4);
          while(a==0 || b==0 || c[a][b]!=2) {
               a = rand.nextInt(4);
               b = rand.nextInt(4);
          }
          markSquare(a,b);
     }
}


     private void markSquare(int x, int y) {
          b[x][y].setEnabled(false);
          b[x][y].setText("X");
          c[x][y] = 1;
          checkBoard();
     }
}


// check the board to see if someone has won
private boolean checkBoard() {
     boolean gameOver = false;
     if ((c[1][1] == 0 && c[2][2] == 0 && c[3][3] == 0)
               || (c[1][3] == 0 && c[2][2] == 0 && c[3][1] == 0)
               || (c[1][2] == 0 && c[2][2] == 0 && c[3][2] == 0)
               || (c[1][3] == 0 && c[2][3] == 0 && c[3][3] == 0)
               || (c[1][1] == 0 && c[1][2] == 0 && c[1][3] == 0)
               || (c[2][1] == 0 && c[2][2] == 0 && c[2][3] == 0)
               || (c[3][1] == 0 && c[3][2] == 0 && c[3][3] == 0)
               || (c[1][1] == 0 && c[2][1] == 0 && c[3][1] == 0)) {
          textView.setText("Game over. You win!");
          for (i = 1; i <= 3; i++) {
              for (j = 1; j <= 3; j++) {
                        b[i][j].setEnabled(false);
                   }
              }
          gameOver = true;
     } else if ((c[1][1] == 1 && c[2][2] == 1 && c[3][3] == 1)
               || (c[1][3] == 1 && c[2][2] == 1 && c[3][1] == 1)
               || (c[1][2] == 1 && c[2][2] == 1 && c[3][2] == 1)
               || (c[1][3] == 1 && c[2][3] == 1 && c[3][3] == 1)
               || (c[1][1] == 1 && c[1][2] == 1 && c[1][3] == 1)
               || (c[2][1] == 1 && c[2][2] == 1 && c[2][3] == 1)
               || (c[3][1] == 1 && c[3][2] == 1 && c[3][3] == 1)
               || (c[1][1] == 1 && c[2][1] == 1 && c[3][1] == 1)) {
          textView.setText("Game over. You lost!");
          for (i = 1; i <= 3; i++) {
              for (j = 1; j <= 3; j++) {
                        b[i][j].setEnabled(false);
                   }
              }
          gameOver = true;
     } else {
          boolean empty = false;
          for(i=1; i<=3; i++) {
               for(j=1; j<=3; j++) {
                    if(c[i][j]==2) {
                         empty = true;
                         break;
                    }
               }
          }
          if(!empty) {
               gameOver = true;
               textView.setText("Game over. It's a draw!");
               for (i = 1; i <= 3; i++) {
                   for (j = 1; j <= 3; j++) {
                             b[i][j].setEnabled(false);
                        }
                   }
          }
     }
     return gameOver;
}
}

