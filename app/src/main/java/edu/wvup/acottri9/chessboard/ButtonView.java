package edu.wvup.acottri9.chessboard;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

/**
 * Created by aaron on 1/30/2018.
 */
public class ButtonView extends GridLayout
{
    private int SIDE;
    private Button[][] newButtons; // These are the tiles

    /**
     * Instantiates a new Button view.
     *
     * @param context  the activity context
     * @param width    the width
     * @param newSide  the new SIDE count
     * @param listener the listener
     */
    public ButtonView(Context context, int width, int newSide, View.OnClickListener listener)
    {
        super(context);
        SIDE = newSide;
        newButtons = new Button[Chessboard.SIDE][Chessboard.SIDE];
        setColumnCount(SIDE);
        setRowCount(SIDE + 1);

        //Create the buttons and add them to this GridLayout

        for(int row = 0; row < Chessboard.SIDE; row++)
        {
            for(int col = 0; col < Chessboard.SIDE ; col++)
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

    /**
     * Sets button text.
     *
     * @param row    the row
     * @param column the column
     * @param text   the text
     */
    public void setButtonText(int row, int column, String text)
    {
        newButtons[row][column].setText(text);
    }

    /**
     * Sets button color.
     *
     * @param row    the row
     * @param column the column
     * @param color  the color
     */
    public void setButtonColor(int row, int column, int color)
    {
        newButtons[row][column].setBackgroundColor(color);
    }

    /**
     * Returns if a button is a boolean
     *
     * @param b      the button
     * @param row    the row
     * @param column the column
     * @return the boolean
     */
    public boolean isButton(Button b, int row, int column)
    {
        return b == newButtons[row][column];
    }

    /**
     * Resets buttons to the way they were at the beginning.
     */
    public void resetButtons()
    {
        for(int row = 0; row < Chessboard.SIDE - 1; row++)
        {
            for (int col = 0; col < Chessboard.SIDE - 1; col++)
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
