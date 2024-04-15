package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method generates a random number between 0 and 1000
	 * @return
	 */

	public int getRandomNo()
	{
		Random ran=new Random();
		int random=ran.nextInt(1000);
		return random;

	}
	/**
	 * this method generates system date and time in string form
	 * @return
	 */
	public String getSystemDate()
	{
		Date dt=new Date();
		String date=dt.toString();
		return date;
	}
	
	/**
	 * this method generates system date and time in "yyyy-MM-dd HH-mm-ss" format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date dt=new Date();
		String sysDate = dateFormat.format(dt);
		return sysDate;
	}

}
