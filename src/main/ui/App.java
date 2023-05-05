package main.ui;

import main.exceptions.UserAlreadyExistsException;
import main.model.*;
import main.exceptions.InvalidPriceRangeException;

import java.util.Scanner;

public class App {
    private Scanner input;
    private Account account;
    private Earning earning;
    private Expense expense;
    private User selectedUser;
    private UserDatabase userDatabase;

    boolean keepRunning;

    // EFFECTS: Starts the costControl application
    public App() {
        init();
        loginOrRegisterPrompt();

        while (keepRunning) {
            displayMainMenu();

            String command;
            command = input.next();

            processCommand(command);
        }

        System.out.println("Goodbye!");
    }

    // EFFECT: Displays the prompt for the user to login or register
    private void loginOrRegisterPrompt() {
        System.out.println("Hello, click 1 to login and 2 to register.");
        String command = input.next();
        processLoginOrRegisterCommand(command);
    }

    // EFFECTS: Processes the command from the loginOrRegisterPrompt method
    private void processLoginOrRegisterCommand(String command) {
        if (command.equals("1")) {
            loginUser();
        } else if (command.equals("2")) {
            registerUser();
        }
    }

    // EFFECTS: Registers a new user in userDatabase
    private void registerUser() {
        System.out.println("Welcome to the register menu");
        String username = askUsername();
        String password = askPassword();

        try {
            userDatabase.addUser(new User(username, password));
        } catch (UserAlreadyExistsException e) {
            System.out.println("Try again!");
            registerUser();
        }

        System.out.println("You are now required to login.");
        loginUser();
    }

    // EFFECTS: Asks the end-user to input a password.
    private String askPassword() {
        System.out.println("Enter the password: ");
        String password = input.next();
        return password;
    }

    // EFFECTS: Asks the end-user to input a username
    private String askUsername() {
        System.out.println("Enter the username: ");
        String username = input.next();
        return username;
    }

    // EFFECTS: Logs the user in if exist in userDatabase
    private void loginUser() {
        System.out.println("Welcome to the login menu");
        String username = askUsername();
        String password = askPassword();

        selectedUser = new User(username, password);

        if (userDatabase.authenticateUser(selectedUser)) {
            account = selectedUser.getAccount();
            return;
        }

        System.out.println("Please try again!");
        loginUser();


    }

    // MODIFIES: this
    // EFFECT: initializes the private fields of app
    private void init() {
        userDatabase = userDatabase.getInstance();
        input = new Scanner(System.in);
        keepRunning = true;
    }

    private void processCommand(String command) {
        if (command.equals("0")) {
            keepRunning = false;
        } else if (command.equals("1")) {
            processAddExpense();
        } else if (command.equals("2")) {
            processAddEarning();
        }  else if (command.equals("3")) {
            account.displayExpenses();
        } else if (command.equals("4")) {
            account.displayEarnings();
        } else {
            System.out.println("Invalid input, try again");
            command = input.next();
            processCommand(command);
        }
    }


    // MODIFIES: this
    // EFFECTS: adds a new earning as given to account
    private void processAddEarning() {
        createEarning();
        account.addEarning(earning);
        System.out.println("Successfully added earning");
    }

    // MODIFIES: this
    // EFFECTS: Creates a new earning object from user end
    private void createEarning() {
        System.out.println("Reason: ");
        String reason = input.next();

        System.out.println("Amount: ");
        int price = Integer.parseInt(input.next());

        try {
            earning = new Earning(reason, price);
        } catch (InvalidPriceRangeException e) {
            System.out.println("Try again!");
            createEarning();
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a new expense as given to account
    private void processAddExpense() {
        createExpense();
        account.addExpenses(expense);
        System.out.println("Expense added successfully");
    }

    // MODIFIES: this
    // EFFECTS: Creates a new expense object from user end
    private void createExpense() {
        System.out.println("Reason: ");
        String reason = input.next();

        System.out.println("Amount: ");
        int price = Integer.parseInt(input.next());

        System.out.println("Category: ");
        String category = input.next();

        try {
            expense = new Expense(reason, price, category);
        } catch (Exception e) {
            System.out.println("Try again!");
            createExpense();
        }
    }

    // EFFECTS: Displays main console menu
    private void displayMainMenu() {
        System.out.println("Welcome to Cost Control " + account.getName());
        System.out.println("To add a new expense, click 1.");
        System.out.println("To add a new earning, click 2.");
        System.out.println("To view all expenses, click 3.");
        System.out.println("To view all earnings, click 4.");
        System.out.println("To quit, click 0.");
    }

    // EFFECTS: Creates account with given name, details, etc.
    private void createAccount() {
        System.out.println("Enter the client's name: ");
        String name = input.next();
        account = new Account(name);
    }
}
