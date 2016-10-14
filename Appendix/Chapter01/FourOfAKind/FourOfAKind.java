// FourOfAKind.java

/**
 *  <code>FourOfAKind</code> implements a card game that is played between two
 *  players: one human player and the computer. You play this game with a
 *  standard 52-card deck and attempt to beat the computer by being the first
 *  player to put down four cards that have the same rank (four aces, for
 *  example), and win.
 *
 *  @author Jeff Friesen
 *  @version 1.0
 */
public class FourOfAKind
{
   /**
    *  Human player
    */
   final static int HUMAN = 0;
   /**
    *  Computer player
    */
   final static int COMPUTER = 1;
   /**
    *  Application entry point.
    *
    *  @param args array of command-line arguments passed to this method
    */
   public static void main(String[] args)
   {
      System.out.println("Welcome to Four of a Kind!");
      Deck deck = new Deck(); // Deck automatically shuffled
      DiscardPile discardPile = new DiscardPile();
      Card hCard;
      Card cCard;
      while (true)
      {
         hCard = deck.deal();
         cCard = deck.deal();
         if (hCard.rank() != cCard.rank())
            break;
         deck.putBack(hCard);
         deck.putBack(cCard);
         deck.shuffle(); // prevent pathological case where every successive 
      }                  // pair of cards have the same rank
      int curPlayer = HUMAN;
      if (cCard.rank().ordinal() > hCard.rank().ordinal())
         curPlayer = COMPUTER;
      deck.putBack(hCard);
      hCard = null;
      deck.putBack(cCard);
      cCard = null;
      Card[] hCards = new Card[4];
      Card[] cCards = new Card[4];
      if (curPlayer == HUMAN)
         for (int i = 0; i < 4; i++)
         {
            cCards[i] = deck.deal();
            hCards[i] = deck.deal();
         }
      else
         for (int i = 0; i < 4; i++)
         {
            hCards[i] = deck.deal();
            cCards[i] = deck.deal();
         }
      while (true)
      {
         if (curPlayer == HUMAN)
         {
            showHeldCards(hCards);
            if (discardPile.topCard() != null)
            {
               System.out.println("Discard pile top card: " +
                                  discardPile.topCard());
               System.out.println();
            }
            int choice = 0;
            while (choice < 'A' || choice > 'D')
            {
               choice = prompt("Which card do you want to throw away (A, B, " +
                               "C, D)? ");
               switch (choice)
               {
                  case 'a': choice = 'A'; break;
                  case 'b': choice = 'B'; break;
                  case 'c': choice = 'C'; break;
                  case 'd': choice = 'D';
               }
            }
            Card card = null;
            if (discardPile.topCard() != null)
            {
               int dest = 0;
               while (dest != 'D' && dest != 'P')
               {
                  dest = prompt("Pick up top card from deck or discard pile " +
                                "(D, P)? ");
                  switch (dest)
                  {
                     case 'd': dest = 'D';
                     case 'p': dest = 'P';
                  }
               }
               card = (dest == 'D') ? deck.deal() : discardPile.getTopCard();
            }
            else
               card = deck.deal();
            discardPile.setTopCard(hCards[choice-'A']);
            hCards[choice-'A'] = card;
            card = null;
            if (isFourOfAKind(hCards))
            {
               System.out.println();
               System.out.println("Human wins!");
               System.out.println();
               putDown("Human's cards:", hCards);
               System.out.println();
               putDown("Computer's cards:", cCards);
               return; // Exit application by returning from main()
            }
            curPlayer = COMPUTER;
         }
         else
         {
            int choice = leastDesirableCard(cCards);
            discardPile.setTopCard(cCards[choice]);
            cCards[choice] = deck.deal();
            if (isFourOfAKind(cCards))
            {
               System.out.println();
               System.out.println("Computer wins!");
               System.out.println();
               putDown("Computer's cards:", cCards);
               return; // Exit application by returning from main()
            }
            curPlayer = HUMAN;
         }
         if (deck.isEmpty())
         {
            while (discardPile.topCard() != null)
               deck.putBack(discardPile.getTopCard());
            deck.shuffle();
         }
      }
   }
   /**
    *  Determine if the <code>Card</code> objects passed to this method all
    *  have the same rank.
    *
    *  @param cards array of <code>Card</code> objects passed to this method
    *
    *  @return true if all <code>Card</code> objects have the same rank;
    *  otherwise, false
    */
   static boolean isFourOfAKind(Card[] cards)
   {
      for (int i = 1; i < cards.length; i++)
         if (cards[i].rank() != cards[0].rank())
            return false;
      return true;
   }
   /**
    *  Identify one of the <code>Card</code> objects that is passed to this
    *  method as the least desirable <code>Card</code> object to hold onto.
    *
    *  @param cards array of <code>Card</code> objects passed to this method
    *
    *  @return 0-based rank (ace is 0, king is 13) of least desirable card
    */
   static int leastDesirableCard(Card[] cards)
   {
      int[] rankCounts = new int[13];
      for (int i = 0; i < cards.length; i++)
         rankCounts[cards[i].rank().ordinal()]++;
      int minCount = Integer.MAX_VALUE;
      int minIndex = -1;
      for (int i = 0; i < rankCounts.length; i++)
         if (rankCounts[i] < minCount && rankCounts[i] != 0)
         {
            minCount = rankCounts[i];
            minIndex = i;
         }
      for (int i = 0; i < cards.length; i++)
         if (cards[i].rank().ordinal() == minIndex)
            return i;
      return 0; // Needed to satisfy compiler (should never be executed)
   }
   /**
    *  Prompt the human player to enter a character.
    *
    *  @param msg message to be displayed to human player
    *
    *  @return integer value of character entered by user.
    */
   static int prompt(String msg)
   {
      System.out.print(msg);
      try
      {
         int ch = System.in.read();
         // Erase all subsequent characters including terminating \n newline
         // so that they do not affect a subsequent call to prompt().
         while (System.in.read() != '\n');
         return ch;
      }
      catch (java.io.IOException ioe)
      {
      }
      return 0;
   }
   /**
    *  Display a message followed by all cards held by player. This output
    *  simulates putting down held cards.
    *
    *  @param msg message to be displayed to human player
    *  @param cards array of <code>Card</code> objects to be identified
    */
   static void putDown(String msg, Card[] cards)
   {
      System.out.println(msg);
      for (int i = 0; i < cards.length; i++)
         System.out.println(cards[i]);
   }
   /**
    *  Identify the cards being held via their <code>Card</code> objects on
    *  separate lines. Prefix each line with an uppercase letter starting with
    *  <code>A</code>.
    *
    *  @param cards array of <code>Card</code> objects to be identified
    */
   static void showHeldCards(Card[] cards)
   {
      System.out.println();
      System.out.println("Held cards:");
      for (int i = 0; i < cards.length; i++)
         if (cards[i] != null)
            System.out.println((char) ('A'+i) + ". " + cards[i]);
      System.out.println();
   }
}
