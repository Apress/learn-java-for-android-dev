// InvalidMediaFormatException.java

package media;

public class InvalidMediaFormatException extends Exception
{
   private String expectedFormat;
   private String existingFormat;
   public InvalidMediaFormatException(String expectedFormat,
                                      String existingFormat)
   {
      super("Expected format: " + expectedFormat + ", Existing format: " +
            existingFormat);
      this.expectedFormat = expectedFormat;
      this.existingFormat = existingFormat;
   }
   public String getExpectedFormat()
   {
      return expectedFormat;
   }
   public String getExistingFormat()
   {
      return existingFormat;
   }
}
