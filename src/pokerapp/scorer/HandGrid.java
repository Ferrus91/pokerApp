package pokerapp.scorer;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.utils.Constants;

/**
 *
 * @author Ari
 *
 * represents the hand as a matrix
 */
public class HandGrid {

  private Hand hand;

  public int[][] matrix = new int[Constants.NUM_SUITS + 1][Constants.HIST_SIZE];

  public HandGrid(Hand other_hand) {
    this.hand = other_hand;

    for (Card c : hand) {
      ++matrix[c.getSuit().getNumber()][c.getRank().getNumber()];
    }
  }
}
