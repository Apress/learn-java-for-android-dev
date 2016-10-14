// InvoiceCalc.java

import java.text.NumberFormat;

class InvoiceCalc
{
   final static double DISCOUNT_PERCENT = 0.1; // 10%
   final static double TAX_PERCENT = 0.05; // 5%
   public static void main(String[] args)
   {
      double invoiceSubtotal = 285.36;
      double discount = invoiceSubtotal*DISCOUNT_PERCENT;
      double subtotalBeforeTax = invoiceSubtotal-discount;
      double salesTax = subtotalBeforeTax*TAX_PERCENT;
      double invoiceTotal = subtotalBeforeTax+salesTax;
      NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
      System.out.println("Subtotal: " + currencyFormat.format(invoiceSubtotal));
      System.out.println("Discount: " + currencyFormat.format(discount));
      System.out.println("SubTotal after discount: " +
                         currencyFormat.format(subtotalBeforeTax));
      System.out.println("Sales Tax: " + currencyFormat.format(salesTax));
      System.out.println("Total: " + currencyFormat.format(invoiceTotal));
   }
}
