
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileIO {

    private File file = new File("./db.txt");

    public FileIO() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public List findExpenses(String... strings){
        while (strings.)
    }*/

    private Date findDate(String string){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Pattern p = Pattern.compile("\\d\\d\\d\\d-\\d\\d-\\d\\d");
        Matcher m = p.matcher(string);
        Date tempDate = null;
        if(m.find())
        {
            try {
                tempDate = format.parse(m.group());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return tempDate;
    }

    public String addExpenseEntry(Expense expense){
        return null;
    }

    public List getListOfExpenses(){

        List<Expense> expenses = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String sCurrentLine;
            Date tempDate = null;

            while ((sCurrentLine = br.readLine()) != null) {
                if((findDate(sCurrentLine))!=null){
                    tempDate = findDate(sCurrentLine);
                    String expenseData = br.readLine();

                    Expense expense = new Expense();
                    expense.setDate(findDate(sCurrentLine));
                    expense.setProductName(expenseData.split("[0-9]")[0]);
                    expenseData = expenseData.substring(expense.getProductName().length(), expenseData.length());
                    expense.setMoneySpent(Float.valueOf(expenseData.substring(0, expenseData.indexOf(" "))));
                    expense.setCurrency(expenseData.substring(expenseData.indexOf(" "), expenseData.length()));

                   expenses.add(expense);
                }
                else if(!sCurrentLine.isEmpty()){
                    Expense expense = new Expense();
                    expense.setDate(tempDate);
                    expense.setProductName(sCurrentLine.split("[0-9]")[0]);
                    sCurrentLine = sCurrentLine.substring(expense.getProductName().length(), sCurrentLine.length());
                    expense.setMoneySpent(Float.valueOf(sCurrentLine.substring(0, sCurrentLine.indexOf(" "))));
                    expense.setCurrency(sCurrentLine.substring(sCurrentLine.indexOf(" "), sCurrentLine.length()));

                    expenses.add(expense);
                }
            }

            Collections.sort(expenses);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return expenses;
    }

    public String clearExpensesByDate(Date date){
        return null;
    }

    public String getTotalByCurrency(String currency){
        return null;
    }

}
