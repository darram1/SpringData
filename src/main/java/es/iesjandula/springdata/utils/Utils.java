package es.iesjandula.springdata.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils
{
    public static Date convertStringToDateFormatddMMyyyy(final String dateString)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try
        {
            date = simpleDateFormat.parse(dateString);
        }
        catch (ParseException parseException)
        {
            parseException.printStackTrace();
        }

        return date;
    }
}
