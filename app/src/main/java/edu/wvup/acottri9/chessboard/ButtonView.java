package edu.wvup.acottri9.chessboard;

import android.content.Context;
import android.graphics.*;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

/**
 * Created by aaron on 1/30/2018.
 */

public class ButtonView extends GridLayout
{
    private int side;
    private Button[][] newButtons; // These are the tiles

    public ButtonView(Context context, int width, int newSide, View.OnClickListener listener)
    {
        super(context);
        side = newSide;
        setColumnCount(side);
        setRowCount(side);

        //Create the buttons and add them to this GridLayout
        newButtons = new Button[Chessboard.side][Chessboard.side];
        for(int row = 0; row < Chessboard.side - 1; row++)
        {
            for(int col = 0; col < Chessboard.side - 1; col++)
            {

                newButtons[row][col] = new Button(context);
                newButtons[row][col].setTextSize((int) ((width) * 0.15));
                newButtons[row][col].setTextColor(Color.RED);
                newButtons[row][col].setOnClickListener(listener);
                if(row % 2 == 0 && col % 2 == 0)
                {
                    newButtons[row][col].setBackgroundColor(Color.WHITE);
                    // Both spots are even
                }
                else if(row % 2 == 0 && col % 2 != 0)
                {
                    newButtons[row][col].setBackgroundColor(Color.BLACK);
                    // Even row, uneven column
                }
                else if(row % 2 != 0 && col % 2 == 0)
                {
                    newButtons[row][col].setBackgroundColor(Color.WHITE);
                    //Uneven row, even column
                }
                else
                {
                    newButtons[row][col].setBackgroundColor(Color.BLACK);
                    //Uneven row, uneven column
                }
                addView(newButtons[row][col],width,width);
            }
        }
    }

    public void setButtonText(int row, int column, String text)
    {
        newButtons[row][column].setText(text);
    }

    public void setButtonColor(int row, int column, int color)
    {
        newButtons[row][column].setBackgroundColor(color);
    }

    public boolean isButton(Button b, int row, int column)
    {
        return b == newButtons[row][column];
    }

    public void resetButtons()
    {
        for(int row = 0; row < Chessboard.side - 1; row++)
        {
            for (int col = 0; col < Chessboard.side - 1; col++)
            {
                if(row % 2 == 0 && col % 2 == 0)
                {
                    newButtons[row][col].setBackgroundColor(Color.WHITE);
                    // Both spots are even
                }
                else if(row % 2 == 0 && col % 2 != 0)
                {
                    newButtons[row][col].setBackgroundColor(Color.BLACK);
                    // Even row, uneven column
                }
                else if(row % 2 != 0 && col % 2 == 0)
                {
                    newButtons[row][col].setBackgroundColor(Color.WHITE);
                    //Uneven row, even column
                }
                else
                {
                    newButtons[row][col].setBackgroundColor(Color.BLACK);
                    //Uneven row, uneven column
                }
            }
        }
    }


}
