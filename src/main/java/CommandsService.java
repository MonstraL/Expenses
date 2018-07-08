import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommandsService {

    private static void listOutput(List<Expense> expenses) {
        Iterator iterator = expenses.iterator();

        Date dateCompare = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");

        while (iterator.hasNext()){
            Expense expense = (Expense) iterator.next();
            if(!expense.getDate().equals(dateCompare)){
                dateCompare = expense.getDate();
                System.out.println("\n"+formatter.format(dateCompare));
            }
            System.out.println(expense.toString());
        }
    }

    private static void input(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = " ";
        FileIO fileIO = new FileIO();
        while(!line.equals("exit")){
            try {
                System.out.println("Personal expenses management console application");
                line = reader.readLine();
                if(!line.contains(" ")&&line.equals("list")){
                    List expenses = fileIO.getListOfExpenses();
                    listOutput(expenses);
                }
                else
                switch (line.substring(0, line.indexOf(' '))){
                    case "exit":
                        break;

                    case "add":

                        break;

                    case "clear":
                        break;

                        case "total":
                            break;

                            default:
                                System.out.println("No such command, try again");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        input();
    }
}
