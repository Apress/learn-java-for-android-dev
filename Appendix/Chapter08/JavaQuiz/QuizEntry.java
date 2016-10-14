// QuizEntry.java

class QuizEntry
{
   private String question;
   private String[] choices;
   private char answer;
   QuizEntry(String question, String[] choices, char answer)
   {
      this.question = question;
      this.choices = choices;
      this.answer = answer;
   }
   String[] getChoices()
   {
      // Demonstrate returning a copy of the choices array to prevent clients
      // from directly manipulating (and possibly screwing up) the internal
      // choices array.
      String[] temp = new String[choices.length];
      System.arraycopy(choices, 0, temp, 0, choices.length);
      return temp;
   }
   String getQuestion()
   {
      return question;
   }
   char getAnswer()
   {
      return answer;
   }
}
