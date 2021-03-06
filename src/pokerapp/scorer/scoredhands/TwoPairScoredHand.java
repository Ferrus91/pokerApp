package pokerapp.scorer.scoredhands;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.domain.SameRankCards;
import pokerapp.scorer.domain.Spares;
import pokerapp.scorer.typetag.TwoPair;
import pokerapp.utils.Comparator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 06/03/13
 * Time: 01:02
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairScoredHand extends AbstractScoredHand<TwoPairScoredHand> {

  private static final int PAIR_LENGTH = 2;

  @Getter private SameRankCards highPair, lowPair;
  @Getter private Spares spares;

  public TwoPairScoredHand(int handNumber, Hand hand, SameRankCards highPair, SameRankCards lowPair, Spares spares) {
    super(handNumber, hand, new TwoPair());
    this.highPair = highPair;
    this.lowPair = lowPair;
    this.spares = spares;
  }

  protected int compareEqualCategories(TwoPairScoredHand rhs) {
    return Comparator
        .begin(highPair, rhs.highPair)
        .next(lowPair, rhs.lowPair)
        .next(spares, rhs.spares)
        .compare();
  }

  @Override
  public String getName() {
    return "Two pair";
  }

  @Override
  public Rank getHandRank() {
    return null;
  }

  @Override
  public List<Card> getRelevantCards() {
    List<Card> relevantArray = new ArrayList<Card>();
    List<SameRankCards> pairSet = new ArrayList<SameRankCards>();

    pairSet.add(lowPair);
    pairSet.add(highPair);

    for (SameRankCards pair : pairSet)
      for(int iter = 0; iter < PAIR_LENGTH; ++iter)
        relevantArray.add(pair.get(iter));
    return relevantArray;
  }
}