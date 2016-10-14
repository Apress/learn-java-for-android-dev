// JavaQuiz.java

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaQuiz
{
   static QuizEntry[] quizEntries =
   {
      new QuizEntry("What was Java's original name?",
                    new String[] { "Oak", "Duke", "J", "None of the above" },
                    'A'),
      new QuizEntry("Which of the following reserved words is also a literal?",
                    new String[] { "for", "long", "true", "enum" },
                    'C'),
      new QuizEntry("The conditional operator (?:) resembles which statement?",
                    new String[] { "switch", "if-else", "if", "while" },
                    'B')
   };
   public static void main(String[] args)
   {
      // Populate the quiz list.      
      List<QuizEntry> quiz = new ArrayList<QuizEntry>();
      for (QuizEntry entry: quizEntries)
         quiz.add(entry);
      // Perform the quiz.
      System.out.println("Java Quiz");
      System.out.println("---------\n");
      Iterator<QuizEntry> iter = quiz.iterator();
      while (iter.hasNext())
      {
         QuizEntry qe = iter.next();
         System.out.println(qe.getQuestion());
         String[] choices = qe.getChoices();
         for (int i = 0; i < choices.length; i++)
            System.out.println("  " + (char) ('A'+i) + ": " + choices[i]);
         int choice = -1;
         while (choice < 'A' || choice > 'A'+choices.length)
         {
            System.out.print("Enter choice letter: ");
            try
            {
               choice = System.in.read();
               // Remove trailing characters up to and including the newline
               // to avoid having these characters automatically returned in
               // subsequent System.in.read() method calls.
               while (System.in.read() != '\n');
               choice = Character.toUpperCase((char) choice);
            }
            catch (java.io.IOException ioe)
            {
            }
         }
         if (choice == qe.getAnswer())
            System.out.println("You are correct!\n");
         else
            System.out.println("You are not correct!\n");
      }
   }
}
