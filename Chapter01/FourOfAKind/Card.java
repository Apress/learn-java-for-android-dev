// Card.java

/**
 *  Simulating a playing card.
 *
 *  @author Jeff Friesen
 */
public enum Card
{
   ACE_OF_CLUBS(Suit.CLUBS, Rank.ACE),
   TWO_OF_CLUBS(Suit.CLUBS, Rank.TWO),
   THREE_OF_CLUBS(Suit.CLUBS, Rank.THREE),
   FOUR_OF_CLUBS(Suit.CLUBS, Rank.FOUR),
   FIVE_OF_CLUBS(Suit.CLUBS, Rank.FIVE),
   SIX_OF_CLUBS(Suit.CLUBS, Rank.SIX),
   SEVEN_OF_CLUBS(Suit.CLUBS, Rank.SEVEN),
   EIGHT_OF_CLUBS(Suit.CLUBS, Rank.EIGHT),
   NINE_OF_CLUBS(Suit.CLUBS, Rank.NINE),
   TEN_OF_CLUBS(Suit.CLUBS, Rank.TEN),
   JACK_OF_CLUBS(Suit.CLUBS, Rank.JACK),
   QUEEN_OF_CLUBS(Suit.CLUBS, Rank.QUEEN),
   KING_OF_CLUBS(Suit.CLUBS, Rank.KING),
   ACE_OF_DIAMONDS(Suit.DIAMONDS, Rank.ACE),
   TWO_OF_DIAMONDS(Suit.DIAMONDS, Rank.TWO),
   THREE_OF_DIAMONDS(Suit.DIAMONDS, Rank.THREE),
   FOUR_OF_DIAMONDS(Suit.DIAMONDS, Rank.FOUR),
   FIVE_OF_DIAMONDS(Suit.DIAMONDS, Rank.FIVE),
   SIX_OF_DIAMONDS(Suit.DIAMONDS, Rank.SIX),
   SEVEN_OF_DIAMONDS(Suit.DIAMONDS, Rank.SEVEN),
   EIGHT_OF_DIAMONDS(Suit.DIAMONDS, Rank.EIGHT),
   NINE_OF_DIAMONDS(Suit.DIAMONDS, Rank.NINE),
   TEN_OF_DIAMONDS(Suit.DIAMONDS, Rank.TEN),
   JACK_OF_DIAMONDS(Suit.DIAMONDS, Rank.JACK),
   QUEEN_OF_DIAMONDS(Suit.DIAMONDS, Rank.QUEEN),
   KING_OF_DIAMONDS(Suit.DIAMONDS, Rank.KING),
   ACE_OF_HEARTS(Suit.HEARTS, Rank.ACE),
   TWO_OF_HEARTS(Suit.HEARTS, Rank.TWO),
   THREE_OF_HEARTS(Suit.HEARTS, Rank.THREE),
   FOUR_OF_HEARTS(Suit.HEARTS, Rank.FOUR),
   FIVE_OF_HEARTS(Suit.HEARTS, Rank.FIVE),
   SIX_OF_HEARTS(Suit.HEARTS, Rank.SIX),
   SEVEN_OF_HEARTS(Suit.HEARTS, Rank.SEVEN),
   EIGHT_OF_HEARTS(Suit.HEARTS, Rank.EIGHT),
   NINE_OF_HEARTS(Suit.HEARTS, Rank.NINE),
   TEN_OF_HEARTS(Suit.HEARTS, Rank.TEN),
   JACK_OF_HEARTS(Suit.HEARTS, Rank.JACK),
   QUEEN_OF_HEARTS(Suit.HEARTS, Rank.QUEEN),
   KING_OF_HEARTS(Suit.HEARTS, Rank.KING),
   ACE_OF_SPADES(Suit.SPADES, Rank.ACE),
   TWO_OF_SPADES(Suit.SPADES, Rank.TWO),
   THREE_OF_SPADES(Suit.SPADES, Rank.THREE),
   FOUR_OF_SPADES(Suit.SPADES, Rank.FOUR),
   FIVE_OF_SPADES(Suit.SPADES, Rank.FIVE),
   SIX_OF_SPADES(Suit.SPADES, Rank.SIX),
   SEVEN_OF_SPADES(Suit.SPADES, Rank.SEVEN),
   EIGHT_OF_SPADES(Suit.SPADES, Rank.EIGHT),
   NINE_OF_SPADES(Suit.SPADES, Rank.NINE),
   TEN_OF_SPADES(Suit.SPADES, Rank.TEN),
   JACK_OF_SPADES(Suit.SPADES, Rank.JACK),
   QUEEN_OF_SPADES(Suit.SPADES, Rank.QUEEN),
   KING_OF_SPADES(Suit.SPADES, Rank.KING);

   private Suit suit;
   /**
    *  Return <code>Card</code>'s suit.
    *
    *  @return <code>CLUBS</code>, <code>DIAMONDS</code>, <code>HEARTS</code>,
    *  or <code>SPADES</code>
    */
   public Suit suit() { return suit; }
   private Rank rank;
   /**
    *  Return <code>Card</code>'s rank.
    *
    *  @return <code>ACE</code>, <code>TWO</code>, <code>THREE</code>,
    *  <code>FOUR</code>, <code>FIVE</code>, <code>SIX</code>,
    *  <code>SEVEN</code>, <code>EIGHT</code>, <code>NINE</code>,
    *  <code>TEN</code>, <code>JACK</code>, <code>QUEEN</code>,
    *  <code>KING</code>.
    */
   public Rank rank() { return rank; }
   Card(Suit suit, Rank rank)
   {
      this.suit = suit;
      this.rank = rank;
   }
   /**
    *  A card's suit is its membership.
    *
    *  @author Jeff Friesen
    */
   public enum Suit
   {
      CLUBS, DIAMONDS, HEARTS, SPADES
   }
   /**
    *  A card's rank is its integer value.
    *
    *  @author Jeff Friesen
    */
   public enum Rank
   {
      ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN,
      KING
   }
}
