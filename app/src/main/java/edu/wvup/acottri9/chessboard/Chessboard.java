package edu.wvup.acottri9.chessboard;

import java.util.ArrayList;

/**
 * The concept of a chess board.
 * Created by aaron on 1/26/2018.
 */

/*
 *
 *
 */
public class Chessboard
{

    public static final int width = 7;
    public static final int height = 7;
    private ChessPiece[][] game = new ChessPiece[width][height];
    public Chessboard()
    {
        initializeBoard();
    }

    /**
     * This method should add all the pieces to the board
     */
    private void initializeBoard()
    {
        for(int i = 0; i < PieceTypes.values().length - 1 ; i++)
        {
            for(int z = 0; z < 2 ; z++)
            {
                game[i][z] = new ChessPiece(Color.White,PieceTypes.values()[i]);
            }
        }

        for(int blackI = 0; blackI < PieceTypes.values().length - 1; blackI++)
        {
            for(int blackZ = height - 1; blackZ > height - 2; blackZ--)
            {
                game[blackI][blackZ] = new ChessPiece(Color.Black,PieceTypes.values()[blackI]);
            }
        }
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
                ArrayList<Coordinate> coordinateArrayList = new ArrayList<Coordinate>();
                boolean canMove = true;
                //int checkLeft = 1;
                //int checkRight = 1;
                //Check horizontal
                //while(canMove)
               // {
                   // if()
                //}
            }
        }
        return null;
    }

    public ChessPiece[][] getCurrentGame()
    {
        ChessPiece[][] chessPieces = new ChessPiece[width][height];
        for(int i = 0; i < width - 1; i++)
        {
            for(int z = 0; z < height - 1; z++)
            {
                chessPieces[i][z] = game[i][z];
            }
        }
        return chessPieces;
    }


    public String result()
    {
        return "";
    }
}
