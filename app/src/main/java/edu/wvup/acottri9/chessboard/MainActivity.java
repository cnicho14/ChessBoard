package edu.wvup.acottri9.chessboard;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity
{
    private Chessboard chessGame;
    private ButtonView buttonView;

    private int width;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        chessGame = new Chessboard();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        ButtonHandler bh = new ButtonHandler();

        buttonView = new ButtonView(this,width/Chessboard.side,Chessboard.side,bh);
        buildButtonText();
        buttonView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                revert();
            }
        });

        setContentView(buttonView);
    }

    /**
     * Sets the button text
     */
    public void buildButtonText()
    {

        //Create the buttons and add them to the gridLayout
         ChessPiece[][] start = chessGame.getCurrentGame();
        for(int row = 0; row < Chessboard.side - 1; row++)
        {
            for (int col = 0; col < Chessboard.side - 1; col++)
            {
                if(start[row][col] != null)
                {
                    buttonView.setButtonText(row,col,start[row][col].toString());
                }
            }
        }
    }

    /**
     * Revert.
     */
    public void revert()
    {
        buttonView.resetButtons();
    }

    /**
     * Update.
     *
     * @param row the row
     * @param col the col
     */
    public void update(int row, int col)
    {
        /*
        *Click test code
        Log.w("MainActivity","Inside update: " + row + " ," + col);
        newButtons[row][col].setText("X");
        */


    }


    private class ButtonHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {
            for(int row = 0; row < Chessboard.side - 1 ; row++)
            {
                for(int column = 0; column < Chessboard.side - 1; column++)
                {
                    if(buttonView.isButton((Button)view,row,column))
                    {
                        try
                        {
                            Coordinate[] play = chessGame.play(row,column);
                            buttonView.setButtonColor(row,column, Color.GREEN);

                            if(play == null)
                            {
                                return;
                            }
                            for(Coordinate coordinate : play)
                            {
                                buttonView.setButtonColor(coordinate.getX(),coordinate.getY(),Color.GREEN);
                            }
                        }
                        catch(IllegalArgumentException exp)
                        {
                            Context context = getApplicationContext();
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, " " + exp.getMessage(), duration);
                            toast.show();
                        }
                    }
                }
            }
        }
    }
}
