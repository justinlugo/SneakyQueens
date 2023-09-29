// Justin Lugo
// COP 3503, Fall 2021
import java.io.*;
import java.util.*;

public class SneakyQueens
{
  public static boolean allTheQueensAreSafe(ArrayList<String> coordinateStrings, int boardSize)
  {
    // The purpose of this function is to take in an ArrayList of coordinates and determine
    // if the Queens pieces that they represent on a grid are out of each others' line of sights.
    // To start this off, we declare / set-up the variables that we will be using.
    int i, k, currCol, currRow, maxUpDiag, maxLowDiag;
    boolean[] rows = new boolean[boardSize + 1], cols = new boolean[boardSize + 1],
      upDiag = new boolean[(boardSize * 2) + 1], lowDiag = new boolean[(boardSize * 2) + 1];

    // Now we iterate through the ArrayList to start the "Are the Queens Safe?" procedure.
    for (String coordStr: coordinateStrings)
    {
      // Our letters correlate to our columns, so we'll do those first. Should we come across a
      // number, we know that's the end of our letter part of the string, so we break there and
      // apply ASCII arithmetic to determine our rows.
      currCol = 0;
      for (i = 0; i < coordStr.length(); i++)
      {
        if (Character.isDigit(coordStr.charAt(i)))
          break;
        currCol = (currCol * 26) + (coordStr.charAt(i) - 96);
      }

      // Next we have to the rows. The integers associated to this come after the letters, so we
      // loop through said letters to skip over them and start the parsing once we get to the
      // integer values within the string, breaking the if-statement once we reach the end.
      currRow = 0;
      for (k = 0; k < coordStr.length(); k++)
      {
        if (Character.isLetter(coordStr.charAt(k)))
          continue;
        if (Character.isDigit(coordStr.charAt(k)))
          currRow = Integer.parseInt(coordStr.substring(k));
          break;
      }

      // Since we've got the current row and column values, we are able to calculate the maximum
      // diagonal range values.
      maxUpDiag =  currRow - currCol + boardSize;
      maxLowDiag = currRow + currCol;

      // Should all of the flags equal false at this point, that means that all of the Queens
      // are safe from one another, so we set the values to true, and are able to leave the
      // ArrayList for loop, unless they are not safe, in which case we switch to the else
      // statement and directly return false.
      if (cols[currCol] == false && rows[currRow] == false && upDiag[maxUpDiag] == false
        && lowDiag[maxLowDiag] == false)
        {
          cols[currCol] = true;
          rows[currRow] = true;
          upDiag[maxUpDiag] = true;
          lowDiag[maxLowDiag] = true;
        }
      else
        {
          return false;
        }
      }

    // Like the above comment mentions, if we've gotten this far, all of the Queens are safe and
    // we are good to go.
    return true;
  }

  public static double difficultyRating()
  {
    // This function returns an value representative of my feelings regarding the difficulty of the
    // assignment.
    return 3.5;
  }

  public static double hoursSpent()
  {
    // This function returns an approximate value of how long this assignment took me.
    return 7.0;
  }
}
