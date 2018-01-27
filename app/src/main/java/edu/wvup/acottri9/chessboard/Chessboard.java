package edu.wvup.acottri9.chessboard;

/**
 * The concept of a chess board.
 * Created by aaron on 1/26/2018.
 */

/*
 *
 * To look at. https://stackoverflow.com/questions/4168002/object-oriented-design-for-a-chess-game?rq=1
 */
public class Chessboard
{
    private ChessPiece[][] game;
    public static final int width = 8;
    public static final int height = 8;

    public Chessboard()
    {
        initializeBoard();
    }

    /*
     * This method should add all the pieces to the board
     */
    private void initializeBoard()
    {

    }

    public int play(int row, int col)
    {
        return 0;
    }
}
