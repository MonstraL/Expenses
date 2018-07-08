
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileIO {

    private File file = new File("./db.txt");
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public FileIO() {
        try {

            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printAllData() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static Date findDate(String string){
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

    public void addExpenseEntry(Expense expense){
        try {
            List<String> lines = Files.readAllLines(Paths.get("./db.txt"), StandardCharsets.UTF_8);
            Iterator iterator = lines.iterator();
            int counter = 0, lineNumber = -1;
            while (iterator.hasNext()&&lineNumber==-1){
                String line = (String) iterator.next();
                if(line.equals(format.format(expense.getDate()))){
                    while (iterator.hasNext()&&!((String) iterator.next()).isEmpty())
                        counter++;
                    lineNumber = counter;
                }
                counter++;
            }

            if(lineNumber!=-1){
                lines.add(lineNumber, expense.toString());
            }
            else{
                lines.add("");
                lines.add(format.format(expense.getDate()));
                lines.add(expense.toString());
            }

            Files.write(Paths.get("./db.txt"), lines, StandardCharsets.UTF_8);

            printAllData();

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void clearExpensesByDate(Date date) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("./db.txt"), StandardCharsets.UTF_8);
            Iterator iterator = lines.iterator();
            while (iterator.hasNext()){
                String line = (String) iterator.next();
                if(line.equals(format.format(date))){
                    iterator.remove();
                    while (iterator.hasNext()&&!((String) iterator.next()).isEmpty())
                        iterator.remove();
                    if(iterator.hasNext())
                        iterator.remove();
                }
            }

            Files.write(Paths.get("./db.txt"), lines, StandardCharsets.UTF_8);

            printAllData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTotalByCurrency(String currency){
        return null;
    }

}
