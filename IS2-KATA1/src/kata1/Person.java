
package kata1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Person {
    private final String name;
    private final LocalDate birthdate;
    // private final long MILISECONDS_PER_YEAR = (long) (1000*60*60*24*365.25);

    public Person(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    
    public int getAge () {
        LocalDate today = LocalDate.now();
        return (int) (ChronoUnit.DAYS.between(birthdate, today)/365.25);
    }
    
//    private long milisecondsToYear (long ms) {
//        return ms/MILISECONDS_PER_YEAR;
//    }
    
}
