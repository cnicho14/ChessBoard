package edu.wvup.acottri9.chessboard;

import java.util.ArrayList;

/**
 * The concept of a chess board.
 * Created by aaron on 1/26/2018.
 */
public class Chessboard
{

    /**
     * The constant SIDE.
     */
    public static final int SIDE = 8;
    private ChessPiece[][] game = new ChessPiece[SIDE][SIDE];

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
        for(int z = 0; z <= SIDE - 1 ; z++)
        {
            for(int i = 0; i < 2 ; i++)
            {
                if(i == 0)
                {
                    if(z == 0 || z == SIDE - 1)
                    {
                        game[i][z] = new ChessPiece(PieceColor.Black,PieceTypes.Rook);
                    }
                    else if(z == 1 || z == SIDE - 2)
                    {
                        game[i][z] = new ChessPiece(PieceColor.Black,PieceTypes.Knight);
                    }
                    else if(z == 2 || z == 5)
                    {
                        game[i][z] = new ChessPiece(PieceColor.Black,PieceTypes.Bishop);
                    }
                    else if(z == 3)
                    {
                        game[i][z] = new ChessPiece(PieceColor.Black,PieceTypes.Queen);
                    }
                    else if(z == 4)
                    {
                        game[i][z] = new ChessPiece(PieceColor.Black,PieceTypes.King);
                    }
                }
                else if(i == 1)
                {
                    game[i][z] = new ChessPiece(PieceColor.Black,PieceTypes.Pawn);
                }


            }
        }

        for(int otherZ = 0; otherZ <= SIDE - 1 ; otherZ++)
        {
            for(int otherI = SIDE - 1; otherI > SIDE - 3 ; otherI--)
            {
                if(otherI == SIDE - 1)
                {
                    if(otherZ == 0 || otherZ == SIDE - 1)
                    {
                        game[otherI][otherZ] = new ChessPiece(PieceColor.White,PieceTypes.Rook);
                    }
                    else if(otherZ == 1 || otherZ == SIDE - 2)
                    {
                        game[otherI][otherZ] = new ChessPiece(PieceColor.White,PieceTypes.Knight);
                    }
                    else if(otherZ == 2 || otherZ == 5)
                    {
                        game[otherI][otherZ] = new ChessPiece(PieceColor.White,PieceTypes.Bishop);
                    }
                    else if(otherZ == 3)
                    {
                        game[otherI][otherZ] = new ChessPiece(PieceColor.White,PieceTypes.Queen);
                    }
                    else if(otherZ == 4)
                    {
                        game[otherI][otherZ] = new ChessPiece(PieceColor.White,PieceTypes.King);
                    }
                }
                else if(otherI == SIDE - 2)
                {
                    game[otherI][otherZ] = new ChessPiece(PieceColor.White,PieceTypes.Pawn);
                }


            }
        }
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
        if(row < 0 || col < 0)
        {
            return null;
        }
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
            else if (game[row][col].getPiece() == PieceTypes.Rook)
            {
                ArrayList<Coordinate> coordinateArrayList = new ArrayList<Coordinate>();
                boolean canMove = true;
                boolean blockedLeft = false;
                boolean blockedRight = false;
                boolean blockedUp = false;
                boolean blockedDown = false;
                int checkLeft = 1;
                int checkRight = 1;
                int checkUp = 1;
                int checkDown = 1;
                while(canMove)
                {
                    if(blockedRight == false)
                    {
                        while(row + checkLeft < Chessboard.SIDE)
                        {
                            checkLeft++;
                            if(game[row + checkLeft][col] == null)
                            {
                               coordinateArrayList.add(new Coordinate((row + checkLeft),col));
                            }
                            else
                            {
                                blockedRight = true;
                                break;
                            }
                        }
                        blockedRight = true;
                    }
                    if(blockedLeft == false)
                    {
                        while(row - checkRight > 0)
                        {
                            checkRight++;
                            if(game[row - checkRight][col ] == null)
                            {
                                coordinateArrayList.add(new Coordinate((row - checkRight),col));
                            }
                            else
                            {
                                blockedLeft = true;
                                break;
                            }
                        }
                        blockedLeft = true;
                    }
                    if(blockedUp == false)
                    {
                        while(col - checkUp > 0)
                        {
                            checkUp++;
                            if(game[row][col - checkUp] == null)
                            {
                                coordinateArrayList.add(new Coordinate((row),col - checkUp));
                            }
                            else
                            {
                                blockedUp = true;
                                break;
                            }
                        }
                        blockedUp = true;
                    }
                    if(blockedDown == false)
                    {
                        while(col + checkDown < Chessboard.SIDE)
                        {
                            checkDown++;
                            if(game[row][col + checkDown] == null)
                            {
                                coordinateArrayList.add(new Coordinate((row),col + checkDown));
                            }
                            else
                            {
                                blockedDown = true;
                                break;
                            }
                        }
                        blockedDown = true;
                    }
                    canMove = false;
                }
                return coordinateArrayList.toArray(new Coordinate[16]);
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
			else if(game[row][col].getPiece() == PieceTypes.Queen)
			{
				
			}
			else if(game[row][col].getPiece() == PieceTypes.Bishop)
			{
                ArrayList<Coordinate> coordinateArrayList = new ArrayList<Coordinate>();
				for(int i = 0; i < Chessboard.SIDE; i++)
                {
                    for(int z = 0; z < Chessboard.SIDE; i++)
                    {
                        if (game[i][z] == null) {
                            coordinateArrayList.add(new Coordinate(i, z));
                        } else {
                            break;
                        }
                    }
                }
                return coordinateArrayList.toArray(new Coordinate[64]);
			}
			else if(game[row][col].getPiece() == PieceTypes.King)
			{
				 ArrayList<Coordinate> coordinateArrayList = new ArrayList<Coordinate>();
				 if(row + 1 > Chessboard.SIDE - 1 || col + 1 > Chessboard.SIDE - 1)
                 {
                     return null;
                 }
                if(game[row + 1][col] == null)
                {
                    coordinateArrayList.add(new Coordinate(row + 1, col));
                }
                if(game[row][col + 1] == null)
                {
                    coordinateArrayList.add(new Coordinate(row + 1, col));
                }
                return coordinateArrayList.toArray(new Coordinate[8]);
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
        ChessPiece[][] chessPieces = new ChessPiece[SIDE][SIDE];
        for(int i = 0; i < SIDE - 1; i++)
        {
            for(int z = 0; z < SIDE - 1; z++)
            {
                chessPieces[i][z] = game[i][z];
            }
        }
        return chessPieces;
    }

	
	public ChessPiece getPiece(int row, int col)
	{
		return game[row][col];
	}

    public String getBoardAsString()
    {
        StringBuilder string = new StringBuilder(" \n");
        for(int row = 0; row < SIDE; row++)
        {
            for(int column = 0; column < SIDE; column++)
            {
                string.append(" ").append(game[row][column]);
            }
            string.append(" \n ");
        }
        return string.toString();
    }


    /**
     *
     *
     * @return the string form of this object
     */
    public String toString()
    {
        StringBuilder string = new StringBuilder(" \n");
        for(int row = 0; row < SIDE; row++)
        {
            for(int column = 0; column < SIDE; column++)
            {
                string.append(" ").append(game[row][column]);
                if(game[row][column] != null)
                {
                    string.append( "( " + game[row][column].getPieceColor().toString() + " )");
                }
            }
            string.append(" \n ");
        }
        return string.toString();
    }
}
