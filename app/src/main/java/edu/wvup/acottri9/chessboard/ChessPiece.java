package edu.wvup.acottri9.chessboard;

/**
 * A class designed to represent the concept of a chess piece.
 * Created by aaron on 1/27/2018.
 */
public class ChessPiece
{
    private Color color;
    private PieceTypes piece;
    private Coordinate pos;

    /**
     * Instantiates a new generic Chess piece.
     */
    public ChessPiece()
    {

    }

    /**
     * Instantiates a new Chess piece with a color and type.
     *
     * @param color the color
     * @param piece the piece
     */
    public ChessPiece(Color color, PieceTypes piece)
    {
        this.color = color;
        this.piece = piece;
    }

    /**
     * Gets the color of the chess piece.
     *
     * @return the color
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * Gets the piece type.
     *
     * @return the piece
     */
    public PieceTypes getPiece()
    {
        return piece;
    }

    public Coordinate getPos()
    {
        return pos;
    }

    public void setPos(Coordinate pos)
    {
        this.pos = pos;
    }

    public String toString()
    {
        if(piece == PieceTypes.Pawn)
        {
            return "P";
        }
        else if(piece == PieceTypes.Rook)
        {
            return "R";
        }
        else if(piece == PieceTypes.Knight)
        {
            return "K";
        }
        else if(piece == PieceTypes.Bishop)
        {
            return "B";
        }
        else if(piece == PieceTypes.Queen)
        {
            return "Q";
        }
        else if(piece == PieceTypes.King)
        {
            return "KG";
        }
        else
        {
            return piece.toString();
        }
    }
}
