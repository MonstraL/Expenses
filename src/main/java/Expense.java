import java.util.Date;

public class Expense implements Comparable<Expense> {

    private Date date;
    private String currency;
    private float moneySpent;
    private String productName;

    public Expense() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return productName+" "+moneySpent+" "+currency;
    }

    public Expense(Date date, String productName, float moneySpent, String currency) {
        this.date = date;
        this.currency = currency;
        this.moneySpent = moneySpent;
        this.productName = productName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(float moneySpent) {
        this.moneySpent = moneySpent;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public int compareTo(Expense o) {
        return getDate().compareTo(o.getDate());
    }
}
