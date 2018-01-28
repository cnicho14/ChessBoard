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

    /**
     * Returns everywhere a piece can go.
     * @param row : the row the chess piece is in
     * @param col : the column the chess piece is in
     * @return an array of indexes we can move to.
     */
    public Coordinate[] play(int row, int col)
    {
        if(game[row][col] == null)
        {
            throw new IllegalArgumentException("Cannot move a nonexistent piece.");
        }
        else
        {
            if(game[row][col].getPiece() == PieceTypes.Pawn && game[row + 1][col] == null)
            {
                Coordinate[] array = {new Coordinate(row + 1, col)};
                return array;
            }
            else if(game[row][col].getPiece() == PieceTypes.Pawn && game[row + 1][col] != null)
            {
                return null;
            }
            //I don`t remember how any other pieces move. The rest need to be added.
            if (game[row][col].getPiece() == PieceTypes.Rook)
            {
            }
        }
        return null;
    }


    public String result()
    {
        return "";
    }
}
