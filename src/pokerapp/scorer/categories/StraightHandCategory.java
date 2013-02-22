package pokerapp.scorer.categories;

import pokerapp.Hand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 02:15
 * To change this template use File | Settings | File Templates.
 */
public class StraightHandCategory extends HandCategory {
  public StraightHandCategory(String name, int cn, Hand hand) {
    super(name, cn, hand);
  }

  @Override
  public int compareEqualCategories(HandCategory rhs) {
    // highest top ranking card wins; on tie, try next highest card & so on

    // TODO: really we need access to the sorted list of cards from the category resolver...


    return 0;  //To change body of implemented methods use File | Settings | File Templates.
  }
}
