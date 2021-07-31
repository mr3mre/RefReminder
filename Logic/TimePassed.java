package Logic;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import java.util.Scanner;

public class TimePassed {

    public String getCurrentDate() {
        Clock obj = Clock.systemUTC();
        String[] dateParts = obj.instant().toString().split( "T" );
        String date = dateParts[0];

        return date;
    }

    public long getDifferenceInDays() throws IOException, ParseException {
        Scanner inputFile = new Scanner(new File("date.txt"));
        String line = inputFile.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(line);

        String date = getCurrentDate();
        Date d2 = sdf.parse(date);

        long difference_In_Time = d2.getTime() - d1.getTime();
        long differenceDays = difference_In_Time / (1000 * 60 * 60 * 24);

        FileWriter fw = new FileWriter ("date.txt");
        PrintWriter pw = new PrintWriter (fw);

        pw.println( date );
        pw.close();

        return differenceDays;
    }
}
