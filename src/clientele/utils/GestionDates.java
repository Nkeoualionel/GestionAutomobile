package clientele.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GestionDates {
    private String date;
    private final String format = "dd/MM/yyyy";
    private SimpleDateFormat simpleDateFormat;

    public GestionDates(String date) {
        this.date = date;
        this.simpleDateFormat = new SimpleDateFormat(format);
    }

    public String getDate() {
        try {
            return simpleDateFormat.parse(date).toString();
        }catch (ParseException e) {
            return "Error parsing";
        }
    }
}
