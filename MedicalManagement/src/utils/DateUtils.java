package utils;


public class DateUtils {
    public static java.sql.Date convertUtilDate2SqlDate(java.util.Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
}
