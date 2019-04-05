
package kata1;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Kata1 {
    private static final Month [] BIRTH_MONTHS = {
        Month.JANUARY, 
        Month.FEBRUARY,
        Month.MARCH,
        Month.APRIL,
        Month.MAY,
        Month.JUNE,
        Month.JULY,
        Month.AUGUST,
        Month.SEPTEMBER,
        Month.OCTOBER,
        Month.NOVEMBER,
        Month.DECEMBER
        
    };


    public static void main(String[] args) {
        Person person = new Person("Borja", getBirthday());
        System.out.println(person.getName()+" tiene "+ person.getAge()+" años");
    }
    
    private static LocalDate getBirthday() {
        Scanner sc = new Scanner(System.in);
        int year = getYearOfBirthday(sc);
        int monthNum = getMonthOfBirthday(sc);
        int date = getDateOfBirthDay (sc, year, monthNum);
        return LocalDate.of(year, BIRTH_MONTHS[monthNum], date);
    }
    private static int getYearOfBirthday(Scanner sc) {
        System.out.println("Introduce el año en el que naciste: ");
        int year = sc.nextInt();
        while (!validYear(year)) {
            System.out.println("Introduce un año válido: ");
            year = sc.nextInt();
        }
        return year;
    }    
    
    private static int getMonthOfBirthday(Scanner sc) {
        System.out.println("Introduce el numero de mes en el que naciste: ");
        int monthNum = sc.nextInt()-1;
        while (!validMonth(monthNum)) {
            System.out.println("Introduce un mes valido: ");
            monthNum = sc.nextInt()-1;
        }     
        return monthNum;
    }
    
    private static int getDateOfBirthDay(Scanner sc, int year, int monthNum) {
        System.out.println("Introduce el dia en el que naciste: ");
        int date = sc.nextInt();
        while (!validDayOfMonth(year, monthNum, date)) {
            System.out.println("Introduce una fecha valida: ");
            date = sc.nextInt();
        }
        return date;
    }
    
    private static boolean validYear(int year) {
        return LocalDate.now().getYear() >= year;
    }

    private static boolean validMonth(int month) {
        return (month > 0 && month < 12);
    }

    private static boolean validDayOfMonth(int year, int monthNum, int date) {
        if (date < 1 || date > 31) {
            System.out.println("Los meses del día van desde el 1 al 31 como máximo");
            return false;
        }
        
        if (monthNum <= 6 && monthNum % 2 != 0 && date > 30) {
            System.out.println("El mes escogido solo tiene 30 días");
            return false;  
        }
        
        if (monthNum > 6 && monthNum % 2 == 0 && date > 30) {
            System.out.println("El mes escogido tiene como máximo 31 días");
            return false;
        }
        
        //February case
        if (monthNum == 1) {
            if (year % 4 == 0 && date > 29) {
                System.out.println("En año bisiesto, Febrero no tiene mas de 29 días");
                return false;
            } else if (date > 28) {
                System.out.println("En año no bisiesto, Febrero no tiene mas de 28 días");
                return false;
            }
        }
        return true;
    }

    

    

    
    
}
