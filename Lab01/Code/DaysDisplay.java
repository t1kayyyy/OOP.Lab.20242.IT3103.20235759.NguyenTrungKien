import java.util.Scanner;
public class DaysDisplay {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String month;
        int year, day;

        System.out.print("Enter month: ");
        month = keyboard.next();
        System.out.print("Enter year: ");
        year = keyboard.nextInt();
        
        if(year < 0){
            System.out.println("Invalid year");
            System.exit(0);
        }

        month = month.toLowerCase();
        switch (month) {
            case "1": case "january": case "jan.": case "jan":
            case "3": case "march": case "mar.": case "mar":
            case "5": case "may":
            case "7": case "july": case "jul":
            case "8": case "august": case "aug.": case "aug":
            case "10": case "october": case "oct.": case "oct":
            case "12": case "december": case "dec.": case "dec":
                day = 31; break;
            case "4": case "april": case "apr.": case "apr":
            case "6": case "june": case "jun":
            case "9": case "september": case "sep.": case "sep":
            case "11": case "november": case "nov.": case "nov":
                day = 30; break;
            case "2": case "february": case "feb.": case "feb":
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                day = 29; break;
                } 
                else {
                    day = 28; break;
                }
            default:
                day = -1; break;
        }

        if (day > 0) {
            System.out.println("Number of days: " + day);
        } else {
            System.out.println("Invalid month");
        }

        keyboard.close();
    }
}