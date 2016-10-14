// LoggingApptCalendar.java

public class LoggingApptCalendar
{
   private ApptCalendar apptCal;
   public LoggingApptCalendar(ApptCalendar apptCal)
   {
      this.apptCal = apptCal;
   }
   public void addAppt(Appt appt)
   {
      Logger.log(appt.toString());
      apptCal.addAppt(appt);
   }
   public void addAppts(Appt[] appts)
   {
      for (int i = 0; i < appts.length; i++)
         Logger.log(appts[i].toString());
      apptCal.addAppts(appts);
   }
   public static void main(String[] args)
   {
      LoggingApptCalendar lapptc = new LoggingApptCalendar(new ApptCalendar());
      lapptc.addAppts(new Appt[] {new Appt(), new Appt(), new Appt()});
   }
}
