package edu.wvup.acottri9.chessboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity
{
    private Chessboard chessGame;
    private Button[][] newButtons; // These are the tiles

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        chessGame = new Chessboard();
       buildGuiByCode();
    }

    public void buildGuiByCode()
    {
        //From
        //https://stackoverflow.com/questions/4743116/get-screen-width-and-height/4744499
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        //Create the layout manager as a GridLayout
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(Chessboard.width);
        gridLayout.setRowCount(Chessboard.height);

        //Create the buttons and add them to the gridLayout
        newButtons = new Button[Chessboard.width][Chessboard.height];

        for(int row = 0; row < Chessboard.width; row++)
        {
            for(int col = 0; col < Chessboard.height; col++)
            {
                newButtons[row][col] = new Button(this);
                newButtons[row][col].setTextSize((int) ((width/ Chessboard.width) * 0.2));
                ButtonHandler bh = new ButtonHandler();
                newButtons[row][col].setOnClickListener(bh);
                /*
                * This statement set is used to determine the initial color
                * of the tile before being added to the grid
                 */
                if(row % 2 == 0 && col % 2 == 0)
                {
                    // Both spots are even
                }
                else if(row % 2 == 0 && col % 2 != 0)
                {
                    // Even row, uneven column
                }
                else if(row % 2 != 0 && col % 2 == 0)
                {
                    //Uneven row, even column
                }
                else
                {
                    //Uneven row, uneven column
                }
                // We need all the tiles to fit, so we need to divide
                gridLayout.addView(newButtons[row][col],width/ Chessboard.width,height / Chessboard.height);
            }
        }
        // Set gridLayout as the View of this Activity
        setContentView(gridLayout);

    }

    public void update(int row, int col)
    {
        /*
        *Click test code
        Log.w("MainActivity","Inside update: " + row + " ," + col);
        newButtons[row][col].setText("X");
        */
        int play = chessGame.play(row,col); // Maybe the ordinal of the piece?
        newButtons[row][col].setBackgroundColor(Color.GREEN);
    }


    public void toggleButtons(boolean enabled)
    {
        for(int row = 0; row < Chessboard.width; row++)
        {
            for(int col = 0; col < Chessboard.height; col++)
            {
                newButtons[row][col].setEnabled(enabled);
            }
        }
    }

    private class ButtonHandler implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {
            Log.w("MainActivity", " Inside onClick, v = " + view);
            for(int row = 0; row < Chessboard.width ; row++)
            {
                for(int column = 0; column < Chessboard.height; column++)
                {
                    if(view == newButtons[row][column])
                    {
                        update(row,column);
                    }
                }
            }
        }
    }
}
