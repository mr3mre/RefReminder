/*
 * TimePassed class
 * @author Eren
 * @version 1.0
 * 02/08/2021
 */

package Logic;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Calculate the number of days that have passed since the last login
 * @author Eren
 * @date 31.07.2021
 */
public class TimePassed {

    /**
     * Returns the current date
     *
     * @return Current date as yy-MM-dd format
     */
    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat( "yy-MM-dd" );

        return formatter.format(date);
    }

    /**
     * Returns the number of days that have passed since the last login
     *
     * @return Number of days since the last login to application
     * @throws IOException
     * @throws ParseException
     */
    public static long getDifferenceInDays() throws IOException, ParseException {
        Scanner inputFile = new Scanner( new File("date.txt" ) );
        String line;

        // If there is login prior, gets current date
        if ( !inputFile.hasNextLine() ) {
            line = getCurrentDate();
        }
        else {
            line = inputFile.nextLine();
        }

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        Date d1 = sdf.parse(line);

        String date = getCurrentDate();
        Date d2 = sdf.parse( date );

        // Calculates the difference as days
        long difference_In_Time = d2.getTime() - d1.getTime();
        long differenceDays = difference_In_Time / ( 1000 * 60 * 60 * 24 );

        // Changes the last login date
        FileWriter fw = new FileWriter ("date.txt" );
        PrintWriter pw = new PrintWriter ( fw );

        pw.println( date );
        pw.close();

        return differenceDays;
    }

    /**
     * Main method to test the class
     *
     * @param args Command line arguments
     * @throws IOException
     * @throws ParseException
     */
    public static void main( String[] args) throws IOException, ParseException {
        System.out.println( getDifferenceInDays() );
    }
}
