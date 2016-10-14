// TestLogger.java

import logging.*;

public class TestLogger
{
   public static void main(String[] args)
   {
      try
      {
         Logger logger = LoggerFactory.newLogger(LoggerFactory.CONSOLE);
         logger.connect();
         logger.log("test message #1");
         logger.disconnect();
      }
      catch (CannotConnectException cce)
      {
         System.err.println("cannot connect to console-based logger");
      }
      catch (NotConnectedException nce)
      {
         System.err.println("not connected to console-based logger");
      }

      try
      {
         Logger logger = LoggerFactory.newLogger(LoggerFactory.FILE, "x.txt");
         logger.connect();
         logger.log("test message #2");
         logger.disconnect();
      }
      catch (CannotConnectException cce)
      {
         System.err.println("cannot connect to file-based logger");
      }
      catch (NotConnectedException nce)
      {
         System.err.println("not connected to file-based logger");
      }
   
      try
      {
         Logger logger = LoggerFactory.newLogger(LoggerFactory.FILE);
         logger.connect();
         logger.log("test message #3");
         logger.disconnect();
      }
      catch (CannotConnectException cce)
      {
         System.err.println("cannot connect to file-based logger");
      }
      catch (NotConnectedException nce)
      {
         System.err.println("not connected to file-based logger");
      }
   }
}
