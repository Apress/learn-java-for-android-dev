// LoggingApptCalendar.java

public class LoggingApptCalendar extends ApptCalendar
{
   // A constructor is not necessary because the Java compiler will add a
   // noargument constructor that calls the superclass's noargument
   // constructor by default.
   @Override public void addAppt(Appt appt)
   {
      Logger.log(appt.toString());
      super.addAppt(appt);
   }
   @Override public void addAppts(Appt[] appts)
   {
      for (int i = 0; i < appts.length; i++)
         Logger.log(appts[i].toString());
      super.addAppts(appts);
   }
   public static void main(String[] args)
   {
      LoggingApptCalendar lapptc = new LoggingApptCalendar();
      lapptc.addAppts(new Appt[] {new Appt(), new Appt(), new Appt()});
   }
}
