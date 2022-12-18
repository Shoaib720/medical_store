package ml.hadiya.utils;

public class DateHelper
{
	public static String formatDate(String date) 
	{
		String splittedDate = date.split(" ")[0];
		// String formattedDate = 
		// 		"20" + splittedDate.split("-")[2] + "-" +
		// 		convertMonthToNumber(splittedDate.split("-")[1]) + "-" +
		// 		splittedDate.split("-")[0];
	
		return splittedDate;// 2021-03-01
	}
	
	// private static String convertMonthToNumber(String month) {
		
		
	// 	switch(month) {
		
	// 	case "JAN": return "01";
	// 	case "FEB": return "02";
	// 	case "MAR": return "03";
	// 	case "APR": return "04";
	// 	case "MAY": return "05";
	// 	case "JUN": return "06";
	// 	case "JUL": return "07";
	// 	case "AUG": return "08";
	// 	case "SEP": return "09";
	// 	case "OCT": return "10";
	// 	case "NOV": return "11";
	// 	case "DEC": return "12";
	// 	default: return "";
		
	// 	}
		
	// }

}
