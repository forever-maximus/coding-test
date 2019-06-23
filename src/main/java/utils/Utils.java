package utils;

public class Utils {
	
	/**
	 * Converts the seconds away from UTC zero into the UTC offset in (+/-)HH:mm format
	 * @param secondsFromUTC How far in seconds from UTC zero
	 * @return UTC offset in format (+/-)HH:mm
	 */
	public static String getUtcTimezoneOffset(int secondsFromUTC) {
		int mins = (secondsFromUTC % 3600) / 60;
		int hours = secondsFromUTC / 3600;
		String sign = hours >= 0 ? "+" : "-";
		String zone = String.format("%s%02d:%02d", sign, Math.abs(hours), Math.abs(mins));
		return zone;
	}
	
}
