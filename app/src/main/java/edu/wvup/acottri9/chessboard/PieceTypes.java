package edu.wvup.acottri9.chessboard;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by aaron on 1/26/2018.
 */

public enum PieceTypes
{
    King, Queen, Pawn, Rook, Bishop, Knight;
    // Used https://stackoverflow.com/questions/609860/convert-from-enum-ordinal-to-enum-type to get ordinals
    Collection<PieceTypes> myUmodifiableCollection = Collections.unmodifiableList(Arrays.asList(values()));
}
