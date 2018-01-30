package edu.wvup.acottri9.chessboard;

/**
 * A class designed to represent the concept of a chess piece.
 * Created by aaron on 1/27/2018.
 */
public class ChessPiece
{
    private PieceColor PieceColor;
    private PieceTypes piece;
    private Coordinate pos;

    /**
     * Instantiates a new generic Chess piece.
     */
    public ChessPiece()
    {

    }

    /**
     * Instantiates a new Chess piece with a PieceColor and type.
     *
     * @param PieceColor the PieceColor
     * @param piece the piece
     */
    public ChessPiece(PieceColor PieceColor, PieceTypes piece)
    {
        this.PieceColor = PieceColor;
        this.piece = piece;
    }

    /**
     * Gets the PieceColor of the chess piece.
     *
     * @return the PieceColor
     */
    public PieceColor getPieceColor()
    {
        return PieceColor;
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
