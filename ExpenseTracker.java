import java.util.HashMap;
import java.util.Scanner;

public class ExpenseTracker {

    private static final int LOAN = 1;
    private static final int FOOD = 2;
    private static final int INVESTMENT = 3;
    private static final int ENTERTAINMENT = 4;
    private static final int EXAM_FEES = 5;
    private static final int CREATE_NEW_CATEGORY = 6;

    private static double totalExpenses = 0;

    private HashMap<String, Double> expenses;

    public ExpenseTracker() {
        expenses = new HashMap<>();
    }

    public void addExpense(String category, double amount) {
        expenses.put(category, expenses.getOrDefault(category, 0.0) + amount);
        totalExpenses += amount;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    @Override
    public String toString() {
        return "ExpenseTracker{" +
                "expenses=" + expenses +
                ", totalExpenses=" + totalExpenses +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ExpenseTracker expenseTracker = new ExpenseTracker();

        while (true) {
            System.out.println("SELECT A CATEGORY BY NUMBER:");
            System.out.println("1. LOAN");
            System.out.println("2. FOOD");
            System.out.println("3. INVESTMENT");
            System.out.println("4. ENTERTAINMENT");
            System.out.println("5. EXAM FEES");
            System.out.println("6. CREATE A NEW CATEGORY");

            int category = scanner.nextInt();

            switch (category) {
                case CREATE_NEW_CATEGORY:
                    expenseTracker.createNewCategory(scanner);
                    break;
                case LOAN:
                    expenseTracker.addExpense("LOAN", scanner);
                    break;
                case FOOD:
                    expenseTracker.addExpense("FOOD", scanner);
                    break;
                case INVESTMENT:
                    expenseTracker.addExpense("INVESTMENT", scanner);
                    break;
                case ENTERTAINMENT:
                    expenseTracker.addExpense("ENTERTAINMENT", scanner);
                    break;
                case EXAM_FEES:
                    expenseTracker.addExpense("EXAM FEES", scanner);
                    break;
                default:
                    System.out.println("Invalid category");
            }

            System.out.println("WOULD YOU LIKE TO DO SOMETHING ELSE(Y/N)?");
            String answer = scanner.next();

            if (!answer.equalsIgnoreCase("Y")) {
                break;
            }
        }

        System.out.println(expenseTracker);
    }

    private void createNewCategory(Scanner scanner) {
        System.out.println("Enter the name of the new category: ");
        String newCategory = scanner.next();

        if (expenses.containsKey(newCategory)) {
            System.out.println("Category already exists!");
            return;
        }

        System.out.println("Enter the expense for the new category: ");
        double expense = scanner.nextDouble();

        expenses.put(newCategory, expense);
        totalExpenses += expense;

        System.out.println("New category created successfully!");
    }

    private void addExpense(String category, Scanner scanner) {
        System.out.println("Enter the expense for " + category + ": ");
        double amount = scanner.nextDouble();
        addExpense(category, amount);
    }
}