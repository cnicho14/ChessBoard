package edu.wvup.acottri9.chessboard;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
        Log.w("MainActivity",chessGame.toString());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        ButtonHandler bh = new ButtonHandler();

        buttonView = new ButtonView(this,(int)Math.floor(width/Chessboard.SIDE), Chessboard.SIDE,bh);
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
     * Sets the button`s text
     */
    public void buildButtonText()
    {

        //Create the buttons and add them to the gridLayout

        //String[] startString = chessGame.getBoardAsString().split("\n");

        for(int row = 0; row < Chessboard.SIDE; row++)
        {
            for (int col = 0; col < Chessboard.SIDE; col++)
            {
                if(chessGame.getPiece(row,col) != null)
                {
                    buttonView.setButtonText(row,col,chessGame.getPiece(row,col).toString());
                }
                else
                {
                    buttonView.setButtonText(row,col,"");
                }
            }
        }
    }

    /**
     * Reverts the buttons to normal.
     */
    public void revert()
    {
        buttonView.resetButtons();
    }

    private class ButtonHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {
            for(int row = 0; row < Chessboard.SIDE - 1 ; row++)
            {
                for(int column = 0; column < Chessboard.SIDE - 1; column++)
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
