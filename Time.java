/*
 * AP CS MOOC
 * Term 2 - Assignment 1: Time
 * A class which represents the time of day in hours and seconds.
 */


public class Time implements Comparable
{
     private int hour;
     private int minute;     
     
     /* Complete required constructors and methods here */
     
     /*
      *Default constructor that sets time to 1200.  
      */ 
     public Time()
     {
     hour = 12;
     minute = 0;
     }
     
     /*
      * If h is between 1 and 23 inclusive, set the hour to h. 
      * Otherwise, set the hour to 0. If m is between 0 and 59 inclusive, 
      * set the minutes to m. Otherwise, set the minutes to 0. 
      */ 
     public Time(int h, int m)
     {
       if (h >= 0 && h <= 23)
        hour = h;
       else
        hour = 0;
       if (m >= 0 && h <= 59)
        minute = m;
       else
        minute = 0;
     }
     
     /* Returns the time as a String of length 4 in the format: 0819. 
      * Notice that if the hour or minute is one digit, it should 
      * print a zero first. For example, 6 should print as 06.
     */
     public String toString()
     {
       if ((hour >= 0 && hour <= 9) && !(minute >= 0 && minute <=9))
        return "0" + hour + minute;
       else if (!(hour >= 0 && hour <= 9) && (minute >= 0 && minute <=9))
        return "" + hour + "0" + minute;
       else if ((hour >= 0 && hour <= 9) && (minute >= 0 && minute <=9))
        return "0" + hour + "0" + minute;
       else
        return "" + hour + minute;
        
     }
     
     /*
      * Returns the time as a String converted from military time 
      * to standard time. For example, 0545 becomes 5:45 am and 
      * 1306 becomes 1:06 pm.
      */ 
     public String convert()
     {
      if (hour >= 13 && hour <= 23)
      {
       if (minute >=0 && minute <= 9)
        return "" + (hour-12) + ":" + "0" + minute + " pm";
       else
        return "" + (hour-12) + ":" + minute + " pm";
      }
      else if (hour == 0)
      {
       if (minute >=0 && minute <= 9)
        return "" + "12" + ":" + "0" + minute + " am";
       else
        return "" + "12" + ":" + minute + " am";
      }
      else if (hour == 12)
      {
       if (minute >=0 && minute <= 9)
        return "" + "12" + ":" + "0" + minute + " pm";
       else
        return "" + "12" + ":" + minute + " pm";
      }
      else
      {
       if (minute >=0 && minute <= 9)
        return "" + hour + ":" + "0" + minute + " am";
       else
        return "" + hour + ":" + minute + " am";
      }
     }
     
    /*
     * Advances the time by one minute. 
     * Remember that 60 minutes = 1 hour. 
     * Therefore, if your time was 0359, and you add one minute, 
     * it becomes 0400. 2359 should increment to 0000.
     */ 
    public void increment()
    {
     if (hour == 23 && minute == 59)
     {
      hour = 0;
      minute = 0;
     }
     else if (minute == 59)
     {
      hour++;
      minute = 0;
     }
     else
      minute++;
    }
    
    public int compareTo(Object other)
    {
  Time t = (Time) other;
     if (this.hour < t.hour)
   return -1;
     else if (this.hour > t.hour)
      return 1;
     else
     {
      if (this.minute < t.minute)
       return -1;
      else if (this.minute == t.minute)
       return 0;
      else
       return 1;
     }
    }

 public String difference(Time t) {
  String s = "null";
  int h = 0;
  int m = 0;
  if (this.compareTo(t) == 0) // works
  {
   m = 0;
   h = 0;
  }
  else if (this.compareTo(t) == 1)
  {
   h = this.hour - t.hour;
   if (h > 0)
   {
    if (this.minute == t.minute)
     m = 0;
    else if (this.minute < t.minute)
    {
     m = this.minute + (60 - t.minute);
     h--;
    }
    else if (this.minute > t.minute)
     m = this.minute - t.minute;
   }
   else
   {
    m = this.minute - t.minute;
   }
  }
  else if (this.compareTo(t) == -1)
  {
   h = t.hour - this.hour;
   if (h < 0)
   {
    if (t.minute == this.minute)
     m = 0;
    else if (t.minute < this.minute)
    {
     m = t.minute + (60 - this.minute);
     h--;
    }
    else if (t.minute > this.minute)
     m = t.minute - this.minute;
   }
   else
   {
    m = t.minute - this.minute;
   }
  }
  if ((h >= 0 && h <= 9) && !(m >= 0 && m <=9))
   s = "0" + h + ":" + m;
     else if (!(h >= 0 && h <= 9) && (m >= 0 && m <=9))
      s = "" + h + ":" +  "0" + m;
     else if ((h >= 0 && h <= 9) && (m >= 0 && m <=9))
      s = "0" + h + ":" + "0" + m;
     else
      s = "" + h + ":" + m;
  return "Time difference: " + s;
 }
    
}