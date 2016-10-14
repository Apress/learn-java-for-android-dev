// NumberFormatDemo.java

import java.text.NumberFormat;

import java.util.Locale;

public class NumberFormatDemo
{
   public static void main(String[] args)
   {
      System.out.println("Unformatted: " + 9875432.25);
      formatCurrencies(Locale.US, 98765432.25);
      formatCurrencies(Locale.FRANCE, 98765432.25);
      formatCurrencies(Locale.GERMANY, 98765432.25);
      System.out.println();
      System.out.println("Unformatted: " + 123456789.0);
      formatIntegers(Locale.US, 123456789.0);
      formatIntegers(Locale.FRANCE, 123456789.0);
      formatIntegers(Locale.GERMANY, 123456789.0);
      System.out.println();
      System.out.println("Unformatted: " + 6751.326);
      formatNumbers(Locale.US, 6751.326);
      formatNumbers(Locale.FRANCE, 6751.326);
      formatNumbers(Locale.GERMANY, 6751.326);
      System.out.println();
      System.out.println("Unformatted: " + 0.85);
      formatPercentages(Locale.US, 0.85);
      formatPercentages(Locale.FRANCE, 0.85);
      formatPercentages(Locale.GERMANY, 0.85);
   }
   static void formatCurrencies(Locale locale, double amount)
   {
      NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
      System.out.println(locale + ": " + nf.format(amount));
   }
   static void formatIntegers(Locale locale, double amount)
   {
      NumberFormat nf = NumberFormat.getIntegerInstance(locale);
      System.out.println(locale + " : " + nf.format(amount));
   }
   static void formatNumbers(Locale locale, double amount)
   {
      NumberFormat nf = NumberFormat.getNumberInstance(locale);
      System.out.println(locale + ": " + nf.format(amount));
   }
   static void formatPercentages(Locale locale, double amount)
   {
      NumberFormat nf = NumberFormat.getPercentInstance(locale);
      System.out.println(locale + ": " + nf.format(amount));
   }
}
