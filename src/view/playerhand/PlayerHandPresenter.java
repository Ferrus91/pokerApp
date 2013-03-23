package view.playerhand;

import pokerapp.Card;
import pokerapp.Dealer;
import pokerapp.Hand;
import pokerapp.console.Player;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import view.Displayable;

import javax.swing.*;
import java.io.IOException;

/**
 * PlayerHand presenter MVP pattern: presenter will communicate actions from and to view
 *
 * @author Tony
 */
public class PlayerHandPresenter implements PlayerHandViewActionListener, Displayable {

  private final PlayerHandView plHandView;
  private Player player;
  private Hand hand;

  private final Dealer dealer;

  public PlayerHandPresenter(PlayerHandView plHandView, Dealer dealer) {
    this.plHandView = plHandView;
    this.plHandView.addListener(this);
    this.dealer = dealer;
  }


  public void init(Player player, Hand hand) throws FormatStringException, IOException, IllegalFormatCodeException {
    this.player = player;
    this.hand = hand;
    this.plHandView.setHand(hand);
  }

  public void onHold() {
    JOptionPane.showMessageDialog(getView(), "Hold command activated");
  }

  public void onExchange() {
    for (Card card : plHandView.getSelectedCards()) {
      Card newCard = dealer.exchangeCard(hand, card);
    }
    // TODO: fix nasty hack
    try {
      plHandView.setHand(hand);
    } catch (Exception e) {
      // TODO: argh!
    }
  }

  @Override
  public JComponent getView() {
    return plHandView.getView();
  }
}

