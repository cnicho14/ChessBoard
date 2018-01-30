package edu.wvup.acottri9.chessboard;

import java.util.ArrayList;

/**
 * The concept of a chess board.
 * Created by aaron on 1/26/2018.
 */
public class Chessboard
{

    /**
     * The constant side.
     */
    public static final int side = 7;
    private ChessPiece[][] game = new ChessPiece[side][side];

    /**
     * Instantiates a new Chessboard.
     */
    public Chessboard()
    {
        initializeBoard();
    }

    /**
     * This method should add all the pieces to the board
     */
    private void initializeBoard()
    {
        int z = 0;
        for(int i = 0; i < side - 1 ; i++)
        {
           // for(int z = 0; z < 2 ; z++)
           // {
                if(z == 0)
                {
                    if(i == 0 || i == side - 2)
                    {
                        game[i][z] = new ChessPiece(PieceColor.White,PieceTypes.Rook);
                    }
                    else if(i == 1 || i == side - 3)
                    {
                        game[i][z] = new ChessPiece(PieceColor.White,PieceTypes.Knight);
                    }
                    else if(i == 2 || i == side - 4)
                    {
                        game[i][z] = new ChessPiece(PieceColor.White,PieceTypes.Bishop);
                    }
                    else if(i == 3)
                    {
                        game[i][z] = new ChessPiece(PieceColor.White,PieceTypes.Queen);
                    }
                    else if(i == 4)
                    {
                        game[i][z] = new ChessPiece(PieceColor.White,PieceTypes.King);
                    }
                }
                else if(z == 1)
                {
                    game[i][z] = new ChessPiece(PieceColor.White,PieceTypes.Pawn);
                }


            //}
        }

        //for(int blackI = 0; blackI < PieceTypes.values().length - 1; blackI++)
        //{
        //    for(int blackZ = side - 1; blackZ > side - 2; blackZ--)
        //    {
        //        game[blackI][blackZ] = new ChessPiece(PieceColor.Black,PieceTypes.values()[blackI]);
         //   }
        //}
    }

    /**
     * Returns everywhere a piece can go.
     *
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
            if(game[row][col].getPiece() == PieceTypes.Pawn)
            {
                if(game[row + 1][col] == null)
                {
                    Coordinate[] array = {new Coordinate(row + 1, col)};
                    return array;
                }
                else if(game[row + 1][col] != null)
                {
                    return null;
                }
            }

            //I don`t remember how any other pieces move. The rest need to be added.
            else if (game[row][col].getPiece() == PieceTypes.Rook)
            {
                ArrayList<Coordinate> coordinateArrayList = new ArrayList<Coordinate>();
                boolean canMove = true;
                boolean blockedLeft = false;
                boolean blockRight = false;
                boolean blockedUp = false;
                boolean blockedDown = false;
                int checkLeft = 1;
                int checkRight = 1;
                //Check horizontal
                while(canMove)
                {
                    if(blockedLeft == false)
                    {
                        while(row - checkLeft > 0)
                        {
                            if(game[row - checkLeft][col] == null)
                            {
                               coordinateArrayList.add(new Coordinate((row - checkLeft),col));
                            }
                        }
                        blockedLeft = true;
                    }
                    canMove = false;
                }
                return coordinateArrayList.toArray(new Coordinate[coordinateArrayList.size()]);
            }
            else if(game[row][col].getPiece() == PieceTypes.Knight)
            {
                ArrayList<Coordinate> coordinateArrayList = new ArrayList<Coordinate>();
                if(game[row + 1][col + 2].getPiece() == null)
                {
                    coordinateArrayList.add(new Coordinate(row + 1, col + 2));
                }
                if(game[row + 2][col + 1].getPiece() == null)
                {
                    coordinateArrayList.add(new Coordinate(row + 2, col + 1));
                }
                return coordinateArrayList.toArray(new Coordinate[2]);
            }
        }
        return null;
    }

    /**
     * Get current game chess pieces [ ] [ ].
     *
     * @return the chess pieces [ ] [ ]
     */
    public ChessPiece[][] getCurrentGame()
    {
        ChessPiece[][] chessPieces = new ChessPiece[side][side];
        for(int i = 0; i < side - 1; i++)
        {
            for(int z = 0; z < side - 1; z++)
            {
                chessPieces[i][z] = game[i][z];
            }
        }
        return chessPieces;
    }


    /**
     *
     *
     * @return the string form of this object
     */
    public String toString()
    {
        StringBuilder string = new StringBuilder(" ");
        for(int row = 0; row < side; row++)
        {
            for(int column = 0; column < side; column++)
            {
                string.append(" ").append(game[row][column]);
            }
        }
        return string.toString();
    }
}
