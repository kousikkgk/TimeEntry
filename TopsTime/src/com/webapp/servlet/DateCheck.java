package com.webapp.servlet;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateCheck 
{
	public void getDate(String oldDate) 
	{
		//String oldDate = "2019-09-24"; 

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        try{
        	/*convert String into java date format and check the date is monday or not */

               java.util.Date startDate = sdf.parse(oldDate);

               Calendar cal = Calendar.getInstance();

               cal.setTime(startDate);

               boolean monday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY;

               /*-------------------------------------------------------------------*/

              

               if (monday==true) {

                     /*Add 6 days from input date */

                     c.setTime(sdf.parse(oldDate));

                     c.add(Calendar.DAY_OF_MONTH, 6);

                     String newDate = sdf.format(c.getTime());

                     /*-----------------------------*/
  
                     /*Convert input java date into sql timeStamp */

                     java.sql.Timestamp sqlStartDate = new java.sql.Timestamp(startDate.getTime());

                     System.out.println(sqlStartDate);

                     /*-----------------------------*/
      

                     /*Convert Enddate intojava date and then convert into sql timeStamp */

                     java.util.Date endDate = sdf.parse(newDate);

                     java.sql.Timestamp sqlEndDate = new java.sql.Timestamp(endDate.getTime());

                     System.out.println(sqlEndDate);

               }

               else

               {

                     System.out.println("not Monday.....");

               }

        }catch(Exception e)

        {

               e.printStackTrace();

        }

       
	}
}
