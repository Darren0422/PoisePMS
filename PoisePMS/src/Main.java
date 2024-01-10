import java.sql.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Try and catch block related to the database connection.
        try {
            // Connect to the library_db database, via the jdbc:mysql: channel on localhost
            // (this PC)
            // Use username "otheruser", password "swordfish".
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                    "otheruser",
                    "swordfish");

            // Create a direct line to the database for running our queries
            Statement statement = connection.createStatement();

            // Various int variables to allow for the switch statements to navigate the
            // menus and its corresponding function
            Scanner scanner = new Scanner(System.in);
            int choice;

            int addChoice;
            // the .getLastIdFrom'table_name' function is called to obtain the last ID for
            // the primary key in each table (used to assist in populating the tables when
            // records are added)
            int lastProjectId = getLastIdFromProject(statement);
            int lastArchitectId = getLastIdFromArchitect(statement);
            int lastContractorId = getLastIdFromContractor(statement);
            int lastCustomerId = getLastIdFromCustomer(statement);

            int updateChoice;
            int updateProjectChoice;

            int deleteChoice;

            int searchChoice;
            int searchProjectChoice;
            int searchArchitectChoice;
            int searchContractorChoice;
            int searchCustomerChoice;

            int viewChoice;

            // Do while loop allows the user to repeatedly interact with the program until
            // they choose to exit
            do {
                // Try and catch block for handling exceptions related to user input
                // User is prompted to selecet the function they wish
                try {
                    mainMenu();
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    // Switch statement to display the various functions of the program
                    // Users enters the number of their choice
                    switch (choice) {
                        case 1:
                            addMenu();
                            addChoice = scanner.nextInt();
                            scanner.nextLine();

                            // Switch statement to display the various aspects the user can add
                            // Users enters the number of their choice
                            switch (addChoice) {
                                case 1:
                                    addProject(statement, scanner, lastProjectId);

                                    break;
                                case 2:
                                    addArchitect(statement, scanner, lastArchitectId);

                                    break;
                                case 3:
                                    addContractor(statement, scanner, lastContractorId);

                                    break;
                                case 4:
                                    addCustomer(statement, scanner, lastCustomerId);

                                    break;
                                case 0:
                                    break;

                                default:
                                    System.out.println("Invalid choice. Try again!");
                            }
                            break;

                        case 2:
                            updateMenu();
                            updateChoice = scanner.nextInt();
                            scanner.nextLine();

                            // Switch statement to display the various aspects the user can update
                            // Users enters the number of their choice
                            switch (updateChoice) {
                                case 1:
                                    updateProjectMenu();
                                    updateProjectChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    // Switch statement to display the various aspects the user can add with regards
                                    // to the project (update entire the entire project or mark the project as
                                    // completed)
                                    // Users enters the number of their choice
                                    switch (updateProjectChoice) {
                                        case 1: // Update the entire project
                                            printAllFromProject(statement);
                                            updateProject(statement, lastProjectId, scanner);

                                            break;
                                        case 2: // Mark a project as completed
                                            printAllFromProject(statement);
                                            updateProjectCompleted(statement, lastProjectId, scanner);

                                            break;

                                        case 0:
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Try again!");
                                    }

                                    break;
                                case 2:
                                    printAllFromArchitect(statement);
                                    updateArchitect(statement, lastArchitectId, scanner);

                                    break;
                                case 3:
                                    printAllFromContractor(statement);
                                    updateContractor(statement, lastContractorId, scanner);

                                    break;
                                case 4:
                                    printAllFromCustomer(statement);
                                    updateCustomer(statement, lastCustomerId, scanner);

                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("Invalid choice. Try again!");
                            }
                            break;

                        case 3:
                            deleteMenu();
                            deleteChoice = scanner.nextInt();
                            scanner.nextLine();

                            // Switch statement to display the various aspects the user can delete
                            // Users enters the number of their choice
                            switch (deleteChoice) {
                                case 1:
                                    printAllFromProject(statement);
                                    deleteProject(statement, scanner);
                                    break;
                                case 2:
                                    printAllFromArchitect(statement);
                                    deleteArchitect(statement, scanner);
                                    break;
                                case 3:
                                    printAllFromContractor(statement);
                                    deleteContractor(statement, scanner);
                                    break;
                                case 4:
                                    printAllFromCustomer(statement);
                                    deleteCustomer(statement, scanner);
                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("Invalid choice. Try again!");
                            }
                            break;

                        case 4:
                            searchMenu();
                            searchChoice = scanner.nextInt();
                            scanner.nextLine();

                            // Switch statement to display the various aspects the user can search
                            // Users enters the number of their choice
                            switch (searchChoice) {
                                case 1:
                                    searchProjectMenu();
                                    searchProjectChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    // Switch statement to display the various aspects the user can search regarding
                                    // the project (search by project ID, name, ongoing projects or projects past
                                    // the due date)
                                    // Users enters the number of their choice
                                    switch (searchProjectChoice) {
                                        case 1: // ID
                                            searchProjectID(statement, scanner);
                                            break;
                                        case 2: // Name
                                            searchProjectName(statement, scanner);
                                            break;
                                        case 3: // Project that still need to be completed
                                            searchOnGoingProject(statement, scanner);
                                            break;
                                        case 4: // Projects past the due date
                                            searchPastDueProject(statement, scanner);
                                            break;

                                        case 0:
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Try again!");
                                    }

                                    break;
                                case 2:
                                    searchArchitectMenu();
                                    searchArchitectChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    // Switch statement to display the various aspects the user can search regarding
                                    // the architect (search by ID or name)
                                    // Users enters the number of their choice
                                    switch (searchArchitectChoice) {
                                        case 1: // ID
                                            searchArchitectID(statement, scanner);
                                            break;
                                        case 2: // Name
                                            searchArchitectName(statement, scanner);
                                            break;

                                        case 0:
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Try again!");
                                    }

                                    break;
                                case 3:
                                    searchContractorMenu();
                                    searchContractorChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    // Switch statement to display the various aspects the user can search regarding
                                    // the contractor (search by ID or name)
                                    // Users enters the number of their choice
                                    switch (searchContractorChoice) {
                                        case 1: // ID
                                            searchContractorID(statement, scanner);
                                            break;
                                        case 2: // Name
                                            searchContractorName(statement, scanner);
                                            break;

                                        case 0:
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Try again!");
                                    }
                                    break;
                                case 4:
                                    searchCustomerMenu();
                                    searchCustomerChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    // Switch statement to display the various aspects the user can search regarding
                                    // the customer (search by ID or name)
                                    // Users enters the number of their choice
                                    switch (searchCustomerChoice) {
                                        case 1: // ID
                                            searchCustomerID(statement, scanner);
                                            break;
                                        case 2: // Name
                                            searchCustomerName(statement, scanner);
                                            break;

                                        case 0:
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Try again!");
                                    }
                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("Invalid choice. Try again!");
                            }
                            break;

                        case 5:
                            viewMenu();
                            viewChoice = scanner.nextInt();
                            scanner.nextLine();

                            // Switch statement to display the various aspects the user can view the records
                            // Users enters the number of their choice
                            switch (viewChoice) {
                                case 1:
                                    printAllFromProject(statement);
                                    break;
                                case 2:
                                    printAllFromArchitect(statement);
                                    break;
                                case 3:
                                    printAllFromContractor(statement);
                                    break;
                                case 4:
                                    printAllFromCustomer(statement);
                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("Invalid choice. Try again!");
                            }
                            break;

                        case 0:
                            System.out.println("Exiting...");
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }

                catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for your choice.");
                    scanner.nextLine();
                    choice = -1;
                }

            } while (choice != 0);

            // Close up our connections
            statement.close();
            connection.close();
            scanner.close();

        } catch (SQLException e) {
            System.out.println("Database connection error:");
            e.printStackTrace();

        }
    }

    /***************************************************************************************************************/
    // Menu Functions:
    /***************************************************************************************************************/

    /**
     * Prints out the main menu options
     */
    public static void mainMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add ");
        System.out.println("2. Update ");
        System.out.println("3. Delete ");
        System.out.println("4. Search ");
        System.out.println("5. View ");
        System.out.println("0. Exit");
        System.out.print("\nEnter the number of your choice: ");
    }

    /**
     * Prints out the menu for the add option
     */
    public static void addMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Project ");
        System.out.println("2. Add Architect ");
        System.out.println("3. Add Contractor ");
        System.out.println("4. Add Customer ");
        System.out.println("0. Back to Main Menu");
        System.out.print("\nEnter the number of your choice: ");
    }

    /**
     * Prints out the menu for the update option
     */
    public static void updateMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Update Project ");
        System.out.println("2. Update Architect ");
        System.out.println("3. Update Contractor ");
        System.out.println("4. Update Customer ");
        System.out.println("0. Back to Main Menu");
        System.out.print("\nEnter the number of your choice: ");
    }

    /**
     * Prints out the menu for the Update Project option
     */
    public static void updateProjectMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Update entire project ");
        System.out.println("2. Mark project as completed ");
        System.out.println("0. Back to Main Menu");
        System.out.print("\nEnter the number of your choice: ");
    }

    /**
     * Prints out the menu for the delete option
     */
    public static void deleteMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Delete Project ");
        System.out.println("2. Delete Architect ");
        System.out.println("3. Delete Contractor ");
        System.out.println("4. Delete Customer ");
        System.out.println("0. Back to Main Menu");
        System.out.print("\nEnter the number of your choice: ");
    }

    /**
     * Prints out the menu for the search option
     */
    public static void searchMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Search Project ");
        System.out.println("2. Search Architect ");
        System.out.println("3. Search Contractor ");
        System.out.println("4. Search Customer ");
        System.out.println("0. Back to Main Menu");
        System.out.print("\nEnter the number of your choice: ");
    }

    /**
     * Prints out the menu for the Search Project option
     */
    public static void searchProjectMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Search by Project ID ");
        System.out.println("2. Search by Project Name ");
        System.out.println("3. Search by ongoing Projects ");
        System.out.println("4. Search by Projects past the due date  ");
        System.out.println("0. Back to Main Menu");
        System.out.print("\nEnter the number of your choice: ");
    }

    /**
     * Prints out the menu for the Search Architect option
     */
    public static void searchArchitectMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Search by Architect ID ");
        System.out.println("2. Search by Architect Name ");
        System.out.println("0. Back to Main Menu");
        System.out.print("\nEnter the number of your choice: ");
    }

    /**
     * Prints out the menu for the Search Contractor option
     */
    public static void searchContractorMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Search by Contractor ID ");
        System.out.println("2. Search by Contractor Name ");
        System.out.println("0. Back to Main Menu");
        System.out.print("\nEnter the number of your choice: ");
    }

    /**
     * Prints out the menu for the Search Customer option
     */
    public static void searchCustomerMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Search by Customer ID ");
        System.out.println("2. Search by Customer Name ");
        System.out.println("0. Back to Main Menu");
        System.out.print("\nEnter the number of your choice: ");

    }

    /**
     * Prints out the menu for the view option
     */
    public static void viewMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. View all Projects ");
        System.out.println("2. View all Architects ");
        System.out.println("3. View all Contractors ");
        System.out.println("4. View all Customers ");
        System.out.println("0. Back to Main Menu");
        System.out.print("\nEnter the number of your choice: ");
    }

    /***************************************************************************************************************/
    // Searching Functions:
    /***************************************************************************************************************/

    /**
     * Searches for projects by project ID in the Projects table.
     *
     * @param statement The Statement to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     */
    public static void searchProjectID(Statement statement, Scanner scanner) {
        int searchID;

        System.out.print("\nEnter Project ID to search: ");
        searchID = scanner.nextInt();
        scanner.nextLine();

        try {
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM Projects WHERE project_number = '" + searchID + "'");

            boolean idFound = false;

            while (results.next()) {
                String name = results.getString("project_name");
                String type = results.getString("building_type");
                String physical_address = results.getString("physical_address");
                String erf_number = results.getString("physical_address");
                double total_fee = results.getDouble("total_fee");
                double total_amount_paid = results.getDouble("total_amount_paid");
                String deadline = results.getString("deadline");
                String Finalised = results.getString("Finalised");
                String Completion_date = results.getString("Completion_date");
                int architect_id = results.getInt("architect_id");
                int contractor_id = results.getInt("contractor_id");
                int customer_id = results.getInt("customer_id");

                System.out.println("\nProject ID: " + searchID);
                System.out.println("Project name: " + name);
                System.out.println("Project building type: " + type);
                System.out.println("Project physical address: " + physical_address);
                System.out.println("Project ERF nnumber: " + erf_number);
                System.out.println("Project total fee: " + total_fee);
                System.out.println("Project total amount paid to date: " + total_amount_paid);
                System.out.println("Project deadline: " + deadline);
                System.out.println("Project finalised: " + Finalised);
                System.out.println("Project completion date: " + Completion_date);
                System.out.println("Architect ID: " + architect_id);
                System.out.println("Contractor ID: " + contractor_id);
                System.out.println("Customer ID: " + customer_id);

                idFound = true;
            }

            if (!idFound) {
                System.out.println("\nNo Project found with the ID: " + searchID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for projects by project name in the Projects table.
     *
     * @param statement The Statement to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     */
    public static void searchProjectName(Statement statement, Scanner scanner) {
        System.out.print("\nEnter Project ID to search: ");
        String searchName = scanner.nextLine();

        try {
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM Projects WHERE project_name = '" + searchName + "'");

            boolean idFound = false;

            while (results.next()) {
                int id = results.getInt("project_number");
                String type = results.getString("building_type");
                String physical_address = results.getString("physical_address");
                String erf_number = results.getString("physical_address");
                double total_fee = results.getDouble("total_fee");
                double total_amount_paid = results.getDouble("total_amount_paid");
                String deadline = results.getString("deadline");
                String Finalised = results.getString("Finalised");
                String Completion_date = results.getString("Completion_date");
                int architect_id = results.getInt("architect_id");
                int contractor_id = results.getInt("contractor_id");
                int customer_id = results.getInt("customer_id");

                System.out.println("\nProject ID: " + id);
                System.out.println("Project name: " + searchName);
                System.out.println("Project building type: " + type);
                System.out.println("Project physical address: " + physical_address);
                System.out.println("Project ERF nnumber: " + erf_number);
                System.out.println("Project total fee: " + total_fee);
                System.out.println("Project total amount paid to date: " + total_amount_paid);
                System.out.println("Project deadline: " + deadline);
                System.out.println("Project finalised: " + Finalised);
                System.out.println("Project completion date: " + Completion_date);
                System.out.println("Architect ID: " + architect_id);
                System.out.println("Contractor ID: " + contractor_id);
                System.out.println("Customer ID: " + customer_id);

                idFound = true;
            }

            if (!idFound) {
                System.out.println("\nNo Project found with the name: " + searchName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for projects that still need to be completed from the database
     *
     * @param statement The Statement object to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException If a database access error occurs while executing the
     *                      query.
     */
    public static void searchOnGoingProject(Statement statement, Scanner scanner) {
        try {
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM Projects WHERE Finalised = false OR Finalised = 0");

            while (results.next()) {
                int id = results.getInt("project_number");
                String name = results.getString("project_name");
                String type = results.getString("building_type");
                String physical_address = results.getString("physical_address");
                String erf_number = results.getString("physical_address");
                double total_fee = results.getDouble("total_fee");
                double total_amount_paid = results.getDouble("total_amount_paid");
                String deadline = results.getString("deadline");
                String finalised = results.getBoolean("Finalised") ? "true" : "false";
                String Completion_date = results.getString("Completion_date");
                int architect_id = results.getInt("architect_id");
                int contractor_id = results.getInt("contractor_id");
                int customer_id = results.getInt("customer_id");

                System.out.println("\nProject ID: " + id);
                System.out.println("Project name: " + name);
                System.out.println("Project building type: " + type);
                System.out.println("Project physical address: " + physical_address);
                System.out.println("Project ERF nnumber: " + erf_number);
                System.out.println("Project total fee: " + total_fee);
                System.out.println("Project total amount paid to date: " + total_amount_paid);
                System.out.println("Project deadline: " + deadline);
                System.out.println("Project finalised: " + finalised);
                System.out.println("Project completion date: " + Completion_date);
                System.out.println("Architect ID: " + architect_id);
                System.out.println("Contractor ID: " + contractor_id);
                System.out.println("Customer ID: " + customer_id);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for projects with deadlines that are past the due date.
     *
     * @param statement The Statement object to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException If a database access error occurs while executing the
     *                      query.
     */
    public static void searchPastDueProject(Statement statement, Scanner scanner) {
        try {
            // LocalDate.now() returns the current date
            // Date.valueOf() is used to make a date object (yyyy-mm-dd)
            LocalDate today = LocalDate.now();
            Date currentDate = Date.valueOf(today);

            ResultSet results = statement.executeQuery(
                    "SELECT * FROM Projects WHERE deadline < '" + currentDate + "'");

            while (results.next()) {
                int id = results.getInt("project_number");
                String name = results.getString("project_name");
                String type = results.getString("building_type");
                String physical_address = results.getString("physical_address");
                String erf_number = results.getString("physical_address");
                double total_fee = results.getDouble("total_fee");
                double total_amount_paid = results.getDouble("total_amount_paid");
                String deadline = results.getString("deadline");
                String finalised = results.getBoolean("Finalised") ? "true" : "false";
                String Completion_date = results.getString("Completion_date");
                int architect_id = results.getInt("architect_id");
                int contractor_id = results.getInt("contractor_id");
                int customer_id = results.getInt("customer_id");

                System.out.println("\nProject ID: " + id);
                System.out.println("Project name: " + name);
                System.out.println("Project building type: " + type);
                System.out.println("Project physical address: " + physical_address);
                System.out.println("Project ERF nnumber: " + erf_number);
                System.out.println("Project total fee: " + total_fee);
                System.out.println("Project total amount paid to date: " + total_amount_paid);
                System.out.println("Project deadline: " + deadline);
                System.out.println("Project finalised: " + finalised);
                System.out.println("Project completion date: " + Completion_date);
                System.out.println("Architect ID: " + architect_id);
                System.out.println("Contractor ID: " + contractor_id);
                System.out.println("Customer ID: " + customer_id);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for Architect by ID in the Architect table.
     *
     * @param statement The Statement object to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     */
    public static void searchArchitectID(Statement statement, Scanner scanner) {
        int searchID;

        System.out.print("\nEnter Architect ID to search: ");
        searchID = scanner.nextInt();
        scanner.nextLine();

        try {
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM Architects WHERE architect_id = '" + searchID + "'");

            boolean idFound = false;

            while (results.next()) {
                String name = results.getString("architect_name");
                String number = results.getString("telephone_number");
                String email_address = results.getString("email_address");
                String physical_address = results.getString("physical_address");

                System.out.println("\nArchitect ID: " + searchID);
                System.out.println("Architect name: " + name);
                System.out.println("Architect telephone number: " + number);
                System.out.println("Architect email address: " + email_address);
                System.out.println("Architect physical address: " + physical_address);

                idFound = true;
            }

            if (!idFound) {
                System.out.println("\nNo Architect found with the ID: " + searchID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for Architect by name in the Architect table.
     *
     * @param statement The Statement object to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     */
    public static void searchArchitectName(Statement statement, Scanner scanner) {
        System.out.print("\nEnter Architect name to search: ");
        String searchName = scanner.nextLine();

        try {
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM Architects WHERE architect_name = '" + searchName + "'");

            boolean nameFound = false;

            while (results.next()) {
                int id = results.getInt("architect_id");
                String number = results.getString("telephone_number");
                String email_address = results.getString("email_address");
                String physical_address = results.getString("physical_address");

                System.out.println("\nArchitect ID: " + id);
                System.out.println("Architect name: " + searchName);
                System.out.println("Architect telephone number: " + number);
                System.out.println("Architect email address: " + email_address);
                System.out.println("Architect physical address: " + physical_address);

                nameFound = true;
            }

            if (!nameFound) {
                System.out.println("\nNo Architect found with the name: " + searchName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for Contractor by ID in the Contractors table.
     *
     * @param statement The Statement object to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     */
    public static void searchContractorID(Statement statement, Scanner scanner) {
        int searchID;

        System.out.print("\nEnter Contractor ID to search: ");
        searchID = scanner.nextInt();
        scanner.nextLine();

        try {
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM Contractors WHERE contractor_id = '" + searchID + "'");

            boolean idFound = false;

            while (results.next()) {
                String name = results.getString("contractor_name");
                String number = results.getString("telephone_number");
                String email_address = results.getString("email_address");
                String physical_address = results.getString("physical_address");

                System.out.println("\nContractor ID: " + searchID);
                System.out.println("Contractor name: " + name);
                System.out.println("Contractor telephone number: " + number);
                System.out.println("Contractor email address: " + email_address);
                System.out.println("Contractor physical address: " + physical_address);

                idFound = true;
            }

            if (!idFound) {
                System.out.println("\nNo Contractor found with the ID: " + searchID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for Contractor by name in the Contractors table.
     *
     * @param statement The Statement object to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     */
    public static void searchContractorName(Statement statement, Scanner scanner) {
        System.out.print("\nEnter Contractor name to search: ");
        String searchName = scanner.nextLine();

        try {
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM Contractors WHERE contractor_name = '" + searchName + "'");

            boolean nameFound = false;

            while (results.next()) {
                int id = results.getInt("contractor_id");
                String number = results.getString("telephone_number");
                String email_address = results.getString("email_address");
                String physical_address = results.getString("physical_address");

                System.out.println("\nContractor ID: " + id);
                System.out.println("Contractor name: " + searchName);
                System.out.println("Contractor telephone number: " + number);
                System.out.println("Contractor email address: " + email_address);
                System.out.println("Contractor physical address: " + physical_address);

                nameFound = true;
            }

            if (!nameFound) {
                System.out.println("\nNo Contractor found with the name: " + searchName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for customers by ID in the Customers table.
     *
     * @param statement The Statement object to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     */
    public static void searchCustomerID(Statement statement, Scanner scanner) {
        int searchID;

        System.out.print("\nEnter Customer ID to search: ");
        searchID = scanner.nextInt();
        scanner.nextLine();

        try {
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM Customers WHERE customer_id = '" + searchID + "'");

            boolean idFound = false;

            while (results.next()) {
                String name = results.getString("customer_name");
                String number = results.getString("telephone_number");
                String email_address = results.getString("email_address");
                String physical_address = results.getString("physical_address");

                System.out.println("\nCustomer ID: " + searchID);
                System.out.println("Customer name: " + name);
                System.out.println("Customer telephone number: " + number);
                System.out.println("Customer email address: " + email_address);
                System.out.println("Customer physical address: " + physical_address);

                idFound = true;
            }

            if (!idFound) {
                System.out.println("\nNo Customer found with the ID: " + searchID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for customers by name in the Customers table.
     *
     * @param statement The Statement object to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     */
    public static void searchCustomerName(Statement statement, Scanner scanner) {
        System.out.print("\nEnter Customer name to search: ");
        String searchName = scanner.nextLine();

        try {
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM Customers WHERE customer_name = '" + searchName + "'");

            boolean nameFound = false;

            while (results.next()) {
                int id = results.getInt("customer_id");
                String number = results.getString("telephone_number");
                String email_address = results.getString("email_address");
                String physical_address = results.getString("physical_address");

                System.out.println("\nCustomer ID: " + id);
                System.out.println("Customer name: " + searchName);
                System.out.println("Customer telephone number: " + number);
                System.out.println("Customer email address: " + email_address);
                System.out.println("Customer physical address: " + physical_address);

                nameFound = true;
            }

            if (!nameFound) {
                System.out.println("\nNo Customer found with the name: " + searchName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***************************************************************************************************************/
    // Updating Functions:
    /***************************************************************************************************************/

    /**
     * Marks an existing project as completed in the Projects table.
     *
     * @param statement     The Statement to execute the SQL query.
     * @param lastProjectId The ID of the last project in the database.
     * @param scanner       The Scanner object to read user input.
     * @throws InputMismatchException
     */
    public static void updateProjectCompleted(Statement statement, int lastProjectId, Scanner scanner) {
        try {
            System.out.print("\nWhich Project would you like to mark as completed? Enter the Project ID: ");

            int toUpdate = -1;
            boolean validInputToUpdate = false;

            // While loop so that a valid input is added for the ID (its an integer)
            while (!validInputToUpdate) {
                try {
                    toUpdate = scanner.nextInt();
                    scanner.nextLine();

                    // Checks if its a value within a range of tables id's
                    if (toUpdate > 0 && toUpdate <= lastProjectId) {
                        validInputToUpdate = true;
                    } else {
                        System.out.println("Invalid Project ID. Please enter a valid Project ID.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Project ID.");
                    scanner.nextLine();
                }
            }

            int finalisedInt = 1;
            String completion_Date = null;

            System.out.print("\nEnter the project completion date (YYYY-MM-DD): ");
            completion_Date = scanner.nextLine();

            int rowsAffected = statement.executeUpdate(
                    "UPDATE Projects " +
                            "SET Finalised = '" + finalisedInt + "', " +
                            "Completion_date = '" + completion_Date + "' " +
                            "WHERE project_number = " + toUpdate);

            System.out.println("Query complete, " + rowsAffected + " row updated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the information of an existing project in the Projects table.
     *
     * @param statement     The Statement to execute the SQL query.
     * @param lastProjectId The ID of the last project in the database.
     * @param scanner       The Scanner object to read user input.
     * @throws InputMismatchException
     */
    public static void updateProject(Statement statement, int lastProjectId, Scanner scanner) {
        try {
            System.out.print("\nWhich Project would you like to update? Enter the Project ID: ");

            int toUpdate = -1;
            boolean validInputToUpdate = false;

            // While loop so that a valid input is added for the ID (its an integer)
            while (!validInputToUpdate) {
                try {
                    toUpdate = scanner.nextInt();
                    scanner.nextLine();

                    // Checks if its a value within a range of tables id's
                    if (toUpdate > 0 && toUpdate <= lastProjectId) {
                        validInputToUpdate = true;
                    } else {
                        System.out.println("Invalid Project ID. Please enter a valid Project ID.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Project ID.");
                    scanner.nextLine();
                }
            }

            System.out.print("\nEnter project name: ");
            String project_name = scanner.nextLine();

            System.out.print("\nEnter building type: ");
            String building_type = scanner.nextLine();

            System.out.print("\nEnter the projects physical address: ");
            String project_physical_address = scanner.nextLine();

            System.out.print("\nEnter the projects ERF number: ");
            String erf_number = scanner.nextLine();

            double total_fee = 0.0;
            boolean validTotalFee = false;
            while (!validTotalFee) {
                try {
                    System.out.print("\nEnter the total fee of the project: ");
                    total_fee = scanner.nextDouble();
                    scanner.nextLine();
                    validTotalFee = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for total fee.");
                    scanner.nextLine();
                }
            }

            double total_amount_paid = 0.0;
            boolean validTotalAmountPaid = false;
            while (!validTotalAmountPaid) {
                try {
                    System.out.print("\nEnter the amount still to be paid for the project: ");
                    total_amount_paid = scanner.nextDouble();
                    scanner.nextLine();
                    validTotalAmountPaid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for total amount paid.");
                    scanner.nextLine();
                }
            }

            System.out.print("\nEnter the project deadline date (YYYY-MM-DD): ");
            String deadline_DateString = scanner.nextLine();

            System.out.print("\nIs the project finalised? (1 = true || 0 = false): ");
            int finalisedInt = scanner.nextInt();
            scanner.nextLine();

            boolean finalised = (finalisedInt == 1);

            String completion_Date = null;

            // Only if finalis is true, the user is prompted to enter a completion date
            if (finalised) {
                System.out.print("\nEnter the project completion date (YYYY-MM-DD): ");
                completion_Date = scanner.nextLine();
            }

            int architect_id = 0;
            boolean validInputAdd_Architect = false;

            // While loop so that a valid input is added for the quantity (its a integer)
            while (!validInputAdd_Architect) {
                try {
                    printAllFromArchitect(statement);
                    System.out.print("Select a Architect. Enter the Architect ID: ");
                    architect_id = scanner.nextInt();
                    scanner.nextLine();
                    validInputAdd_Architect = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Architect ID.");
                    scanner.nextLine();
                }
            }

            int contractor_id = 0;
            boolean validInputAdd_Contractor = false;

            // While loop so that a valid input is added for the quantity (its a integer)
            while (!validInputAdd_Contractor) {
                try {
                    printAllFromContractor(statement);
                    System.out.print("Select a Contractor. Enter the Contractor ID: ");
                    contractor_id = scanner.nextInt();
                    scanner.nextLine();
                    validInputAdd_Contractor = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Contractor ID.");
                    scanner.nextLine();
                }
            }

            int customer_id = 0;
            boolean validInputAdd_Customer = false;

            // While loop so that a valid input is added for the quantity (its a integer)
            while (!validInputAdd_Customer) {
                try {
                    printAllFromCustomer(statement);
                    System.out.print("Select a Customer. Enter the Customer ID: ");
                    customer_id = scanner.nextInt();
                    scanner.nextLine();
                    validInputAdd_Customer = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Customer ID.");
                    scanner.nextLine();
                }
            }

            // IF the project name is empty, getCustomerSurname function is called to obtain
            // the relevant customer surname and appends it to the building type to create a
            // name for the project
            if (project_name.isEmpty()) {
                String customerSurname = getCustomerSurname(statement, customer_id);
                project_name = building_type + " " + customerSurname;
            }

            int rowsAffected = statement.executeUpdate(
                    "UPDATE Projects " +
                            "SET project_name = '" + project_name + "', " +
                            "building_type = '" + building_type + "', " +
                            "physical_address = '" + project_physical_address + "', " +
                            "erf_number = '" + erf_number + "', " +
                            "total_fee = " + total_fee + ", " +
                            "total_amount_paid = " + total_amount_paid + ", " +
                            "deadline = '" + deadline_DateString + "', " +
                            "Finalised = '" + finalisedInt + "', " +
                            "Completion_date = " + (completion_Date != null ? "'" + completion_Date + "'" : "NULL")
                            + ", " +
                            "architect_id = " + architect_id + ", " +
                            "contractor_id = " + contractor_id + ", " +
                            "customer_id = " + customer_id + " " +
                            "WHERE project_number = " + toUpdate);

            System.out.println("Query complete, " + rowsAffected + " row updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the information of an existing Architect in the Architects table.
     *
     * @param statement        The Statement to execute the SQL query.
     * @param lastContractorId The ID of the last Architect in the database.
     * @param scanner          The Scanner object to read user input.
     * @throws InputMismatchException
     */
    public static void updateArchitect(Statement statement, int lastArchitectId, Scanner scanner) {
        try {
            System.out.print("\nWhich Architect would you like to update? Enter the Architect ID: ");

            int toUpdate = -1;
            boolean validInputToUpdate = false;

            // While loop so that a valid input is added for the ID (its an integer)
            while (!validInputToUpdate) {
                try {
                    toUpdate = scanner.nextInt();
                    scanner.nextLine();

                    // Checks if its a value and within a range of table id's
                    if (toUpdate > 0 && toUpdate <= lastArchitectId) {
                        validInputToUpdate = true;
                    } else {
                        System.out.println("Invalid Architect ID. Please enter a valid Architect ID.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Architect ID.");
                    scanner.nextLine();
                }
            }

            System.out.print("\nEnter architect name: ");
            String architect_name = scanner.nextLine();

            System.out.print("\nEnter architect telephone number: ");
            String architect_telephone_number = scanner.nextLine();

            System.out.print("\nEnter architect email address: ");
            String architect_email_address = scanner.nextLine();

            System.out.print("\nEnter architect physical address: ");
            String architect_physical_address = scanner.nextLine();

            int rowsAffected = statement.executeUpdate(
                    "UPDATE Architects " +
                            "SET architect_name = '" + architect_name + "', " +
                            "telephone_number = '" + architect_telephone_number + "', " +
                            "email_address = '" + architect_email_address + "', " +
                            "physical_address = '" + architect_physical_address + "' " +
                            "WHERE architect_id = " + toUpdate);

            // Prints the results of the query
            System.out.println("Query complete, " + rowsAffected + " row updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the information of an existing Contractor in the Contractors table.
     *
     * @param statement        The Statement to execute the SQL query.
     * @param lastContractorId The ID of the last Contractor in the database.
     * @param scanner          The Scanner object to read user input.
     * @throws InputMismatchException
     */
    public static void updateContractor(Statement statement, int lastContractorId, Scanner scanner) {
        try {
            System.out.print("\nWhich Contractor would you like to update? Enter the Contractor ID: ");

            int toUpdate = -1;
            boolean validInputToUpdate = false;

            // While loop so that a valid input is added for the ID (its an integer)
            while (!validInputToUpdate) {
                try {
                    toUpdate = scanner.nextInt();
                    scanner.nextLine();

                    // Checks if its a value and within a range of table id's
                    if (toUpdate > 0 && toUpdate <= lastContractorId) {
                        validInputToUpdate = true;
                    } else {
                        System.out.println("Invalid Contractor ID. Please enter a valid Contractor ID.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Contractor ID.");
                    scanner.nextLine();
                }
            }

            System.out.print("\nEnter contractor name: ");
            String contractor_name = scanner.nextLine();

            System.out.print("\nEnter contractor telephone number: ");
            String contractor_telephone_number = scanner.nextLine();

            System.out.print("\nEnter contractor email address: ");
            String contractor_email_address = scanner.nextLine();

            System.out.print("\nEnter contractor physical address: ");
            String contractor_physical_address = scanner.nextLine();

            int rowsAffected = statement.executeUpdate(
                    "UPDATE Contractors " +
                            "SET contractor_name = '" + contractor_name + "', " +
                            "telephone_number = '" + contractor_telephone_number + "', " +
                            "email_address = '" + contractor_email_address + "', " +
                            "physical_address = '" + contractor_physical_address + "' " +
                            "WHERE contractor_id = " + toUpdate);

            System.out.println("Query complete, " + rowsAffected + " row updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the information of an existing customer in the Customers table.
     *
     * @param statement      The Statement to execute the SQL query.
     * @param lastCustomerId The ID of the last customer in the database.
     * @param scanner        The Scanner object to read user input.
     * @throws InputMismatchException
     */
    public static void updateCustomer(Statement statement, int lastCustomerId, Scanner scanner) {
        try {
            System.out.print("\nWhich Customer would you like to update? Enter the Customer ID: ");

            int toUpdate = -1;
            boolean validInputToUpdate = false;

            // While loop so that a valid input is added for the ID (its an integer)
            while (!validInputToUpdate) {
                try {
                    toUpdate = scanner.nextInt();
                    scanner.nextLine();

                    // Checks if its a value and within a range of table id's
                    if (toUpdate > 0 && toUpdate <= lastCustomerId) {
                        validInputToUpdate = true;
                    } else {
                        System.out.println("Invalid Customer ID. Please enter a valid Customer ID.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Customer ID.");
                    scanner.nextLine();
                }
            }

            System.out.print("\nEnter customer name: ");
            String customer_name = scanner.nextLine();

            System.out.print("\nEnter customer telephone number: ");
            String customer_telephone_number = scanner.nextLine();

            System.out.print("\nEnter customer email address: ");
            String customer_email_address = scanner.nextLine();

            System.out.print("\nEnter customer physical address: ");
            String customer_physical_address = scanner.nextLine();

            int rowsAffected = statement.executeUpdate(
                    "UPDATE Customers " +
                            "SET customer_name = '" + customer_name + "', " +
                            "telephone_number = '" + customer_telephone_number + "', " +
                            "email_address = '" + customer_email_address + "', " +
                            "physical_address = '" + customer_physical_address + "' " +
                            "WHERE customer_id = " + toUpdate);

            // Prints the results of the query
            System.out.println("Query complete, " + rowsAffected + " row updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***************************************************************************************************************/
    // Adding Functions:
    /***************************************************************************************************************/

    /**
     * Adds a new project entry to the Projects table.
     *
     * @param statement     The Statement to execute the SQL query.
     * @param scanner       The Scanner object to read user input.
     * @param lastProjectId The ID of the last project in the database.
     * @throws SQLException
     * @throws InputMismatchException
     */
    public static void addProject(Statement statement, Scanner scanner, int lastProjectId) throws SQLException {
        // Calculates the ID for the next project entry
        int newProjectId = lastProjectId + 1;

        System.out.print("\nEnter project name: ");
        String project_name = scanner.nextLine();

        System.out.print("\nEnter building type: ");
        String building_type = scanner.nextLine();

        System.out.print("\nEnter the projects physical address: ");
        String project_physical_address = scanner.nextLine();

        System.out.print("\nEnter the projects ERF number: ");
        String erf_number = scanner.nextLine();

        double total_fee = 0.0;
        boolean validTotalFee = false;
        while (!validTotalFee) {
            try {
                System.out.print("\nEnter the total fee of the project: ");
                total_fee = scanner.nextDouble();
                scanner.nextLine();
                validTotalFee = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for total fee.");
                scanner.nextLine();
            }
        }

        double total_amount_paid = 0.0;
        boolean validTotalAmountPaid = false;
        while (!validTotalAmountPaid) {
            try {
                System.out.print("\nEnter the amount still to be paid for the project: ");
                total_amount_paid = scanner.nextDouble();
                scanner.nextLine();
                validTotalAmountPaid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for total amount paid.");
                scanner.nextLine();
            }
        }

        System.out.print("\nEnter the project deadline date (YYYY-MM-DD): ");
        String deadline_DateString = scanner.nextLine();

        System.out.print("\nIs the project finalised? (1 = true || 0 = false): ");
        int finalisedInt = scanner.nextInt();
        scanner.nextLine();

        boolean finalised = (finalisedInt == 1);

        String completion_Date = null;

        // Only if finalis is true, the user is prompted to enter a completion date
        if (finalised) {
            System.out.print("\nEnter the project completion date (YYYY-MM-DD): ");
            completion_Date = scanner.nextLine();
        }

        int architect_id = 0;
        boolean validInputAdd_Architect = false;

        // While loop so that a valid input is added for the quantity (its a integer)
        while (!validInputAdd_Architect) {
            try {
                printAllFromArchitect(statement);
                System.out.print("Select a Architect. Enter the Architect ID: ");
                architect_id = scanner.nextInt();
                scanner.nextLine();
                validInputAdd_Architect = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for Architect ID.");
                scanner.nextLine();
            }
        }

        int contractor_id = 0;
        boolean validInputAdd_Contractor = false;

        // While loop so that a valid input is added for the quantity (its a integer)
        while (!validInputAdd_Contractor) {
            try {
                printAllFromContractor(statement);
                System.out.print("Select a Contractor. Enter the Contractor ID: ");
                contractor_id = scanner.nextInt();
                scanner.nextLine();
                validInputAdd_Contractor = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for Contractor ID.");
                scanner.nextLine();
            }
        }

        int customer_id = 0;
        boolean validInputAdd_Customer = false;

        // While loop so that a valid input is added for the quantity (its a integer)
        while (!validInputAdd_Customer) {
            try {
                printAllFromCustomer(statement);
                System.out.print("Select a Customer. Enter the Customer ID: ");
                customer_id = scanner.nextInt();
                scanner.nextLine();
                validInputAdd_Customer = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for Customer ID.");
                scanner.nextLine();
            }
        }

        // IF the project name is empty, getCustomerSurname function is called to obtain
        // the relevant customer surname and appends it to the building type to create a
        // name for the project
        if (project_name.isEmpty()) {
            String customerSurname = getCustomerSurname(statement, customer_id);
            project_name = building_type + " " + customerSurname;
        }

        int rowsAffected = statement.executeUpdate(
                "INSERT INTO Projects " +
                        "VALUES (" + newProjectId + ", " + "'" + project_name + "', " + "'" + building_type
                        + "', '" + project_physical_address + "', " + "'" + erf_number + "', " + total_fee + ", "
                        + total_amount_paid + ", " + "'" + deadline_DateString + "', '" + finalisedInt + "', "
                        + (completion_Date != null ? "'" + completion_Date + "'" : "NULL") + ", "
                        + architect_id + ", " + contractor_id + ", " + customer_id + ")");

        System.out.println("Query complete, " + rowsAffected + " rows added.");
    }

    /**
     * Retrieves the last ID from the Projects table in the database.
     *
     * @param statement The Statement to execute the SQL query.
     * @return the last ID found in the books table
     * @throws SQLException
     */
    public static int getLastIdFromProject(Statement statement) throws SQLException {
        int lastId = 0;
        ResultSet results = statement.executeQuery("SELECT MAX(project_number) FROM Projects");
        if (results.next()) {
            lastId = results.getInt(1);
        }
        return lastId;
    }

    /**
     * Retrieves the surname of a customer based on the provided customer ID.
     * 
     * @param statement  The Statement to execute the SQL query.
     * @param customerId The ID of the customer for the surname that will be used.
     * @return The surname of the customer if found or "Unknown" if the customer is
     *         not found.
     * @throws SQLException
     */
    public static String getCustomerSurname(Statement statement, int customerId) throws SQLException {
        ResultSet resultSet = statement
                .executeQuery("SELECT customer_name FROM Customers WHERE customer_id = " + customerId);

        if (resultSet.next()) {
            String customerName = resultSet.getString("customer_name");
            // The customer name is split by a blank space and add to an array
            // The surname name is then returned
            String[] nameParts = customerName.split(" ");
            if (nameParts.length > 0) {
                return nameParts[nameParts.length - 1];
            }
        }

        return "Unknown";
    }

    /**
     * Adds a new customer entry to the Architects table.
     *
     * @param statement       The Statement to execute the SQL query.
     * @param scanner         The Scanner object to read user input.
     * @param lastArchitectId The ID of the last Architect in the database.
     * @throws SQLException
     */
    public static void addArchitect(Statement statement, Scanner scanner, int lastArchitectId) throws SQLException {
        // Calculates the ID for the architect entry
        int newArchitectId = lastArchitectId + 1;

        System.out.print("\nEnter architect name: ");
        String architect_name = scanner.nextLine();

        System.out.print("\nEnter architect telephone number: ");
        String architect_telephone_number = scanner.nextLine();

        System.out.print("\nEnter architect email address: ");
        String architect_email_address = scanner.nextLine();

        System.out.print("\nEnter architect physical address: ");
        String architect_physical_address = scanner.nextLine();

        int rowsAffected = statement.executeUpdate(
                "INSERT INTO Architects VALUES (" + newArchitectId + ", '" + architect_name + "', '"
                        + architect_telephone_number + "', '" + architect_email_address + "', '"
                        + architect_physical_address + "')");

        System.out.println("Query complete, " + rowsAffected + " rows added.");
    }

    /**
     * Retrieves the last ID from the Architects table in the database.
     *
     * @param statement The Statement to execute the SQL query.
     * @return the last ID found in the books table
     * @throws SQLException
     */
    public static int getLastIdFromArchitect(Statement statement) throws SQLException {
        int lastId = 0;
        ResultSet results = statement.executeQuery("SELECT MAX(architect_id) FROM Architects");
        if (results.next()) {
            lastId = results.getInt(1);
        }
        return lastId;
    }

    /**
     * Adds a new customer entry to the Contractors table.
     *
     * @param statement        The Statement to execute the SQL query.
     * @param scanner          The Scanner object to read user input.
     * @param lastContractorId The ID of the last Contractor in the database.
     * @throws SQLException
     */
    public static void addContractor(Statement statement, Scanner scanner, int lastContractorId) throws SQLException {
        // Calculates the ID for the contractor entry
        int newContractorId = lastContractorId + 1;

        System.out.print("\nEnter contractor name: ");
        String contractor_name = scanner.nextLine();

        System.out.print("\nEnter contractor telephone number: ");
        String contractor_telephone_number = scanner.nextLine();

        System.out.print("\nEnter contractor email address: ");
        String contractor_email_address = scanner.nextLine();

        System.out.print("\nEnter contractor physical address: ");
        String contractor_physical_address = scanner.nextLine();

        int rowsAffected = statement.executeUpdate(
                "INSERT INTO Contractors VALUES (" + newContractorId + ", '" + contractor_name + "', '"
                        + contractor_telephone_number + "', '" + contractor_email_address + "', '"
                        + contractor_physical_address + "')");

        System.out.println("Query complete, " + rowsAffected + " rows added.");
    }

    /**
     * Retrieves the last ID from the Contractors table in the database.
     *
     * @param statement The Statement to execute the SQL query.
     * @return the last ID found in the books table
     * @throws SQLException
     */
    public static int getLastIdFromContractor(Statement statement) throws SQLException {
        int lastId = 0;
        ResultSet results = statement.executeQuery("SELECT MAX(contractor_id) FROM Contractors");
        if (results.next()) {
            lastId = results.getInt(1);
        }
        return lastId;
    }

    /**
     * Adds a new customer entry to the Customers table.
     *
     * @param statement      The Statement to execute the SQL query.
     * @param scanner        The Scanner object to read user input.
     * @param lastCustomerId The ID of the last customer in the database.
     * @throws SQLException
     */
    public static void addCustomer(Statement statement, Scanner scanner, int lastCustomerId) throws SQLException {
        // Calculates the ID for the customer entry
        int newCustomerId = lastCustomerId + 1;

        System.out.print("\nEnter customer name: ");
        String customer_name = scanner.nextLine();

        System.out.print("\nEnter customer telephone number: ");
        String customer_telephone_number = scanner.nextLine();

        System.out.print("\nEnter customer email address: ");
        String customer_email_address = scanner.nextLine();

        System.out.print("\nEnter customer physical address: ");
        String customer_physical_address = scanner.nextLine();

        int rowsAffected = statement.executeUpdate(
                "INSERT INTO Customers VALUES (" + newCustomerId + ", '" + customer_name + "', '"
                        + customer_telephone_number + "', '" + customer_email_address + "', '"
                        + customer_physical_address + "')");

        System.out.println("Query complete, " + rowsAffected + " rows added.");
    }

    /**
     * Retrieves the last ID from the Customers table in the database.
     *
     * @param statement The Statement to execute the SQL query.
     * @return the last ID found in the books table
     * @throws SQLException
     */
    public static int getLastIdFromCustomer(Statement statement) throws SQLException {
        int lastId = 0;
        ResultSet results = statement.executeQuery("SELECT MAX(customer_id) FROM Customers");
        if (results.next()) {
            lastId = results.getInt(1);
        }
        return lastId;
    }

    /***************************************************************************************************************/
    // Deleting Functions:
    /***************************************************************************************************************/

    /**
     * Deletes a Project record from the Projects table using the provided Project
     * ID.
     *
     * @param statement The Statement to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     * @throws InputMismatchException
     */
    public static void deleteProject(Statement statement, Scanner scanner) throws SQLException {
        int toDelete = 0;
        boolean validInputDelete = false;

        // While loop so that a valid input is added for the id (it's an integer)
        while (!validInputDelete) {
            try {
                System.out.print("\nWhich project would you like to delete? Enter the Project ID: ");
                toDelete = scanner.nextInt();
                scanner.nextLine();
                validInputDelete = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for Project ID.");
                scanner.nextLine();
            }
        }

        int rowsAffected = statement.executeUpdate(
                "DELETE FROM Projects WHERE project_number = " + toDelete);

        System.out.println("Query complete, " + rowsAffected + " row removed.");
    }

    /**
     * Deletes a Architect record from the Architects table using the provided
     * Architect ID.
     *
     * @param statement The Statement to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     * @throws InputMismatchException
     */
    public static void deleteArchitect(Statement statement, Scanner scanner) throws SQLException {
        int toDelete = 0;
        boolean validInputDelete = false;

        // While loop so that a valid input is added for the id (it's an integer)
        while (!validInputDelete) {
            try {
                System.out.print("\nWhich Architect would you like to delete? Enter the Architect ID: ");
                toDelete = scanner.nextInt();
                scanner.nextLine();
                validInputDelete = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for Architect ID.");
                scanner.nextLine();
            }
        }

        int rowsAffected = statement.executeUpdate(
                "DELETE FROM Architects WHERE architect_id = " + toDelete);

        System.out.println("Query complete, " + rowsAffected + " row removed.");
    }

    /**
     * Deletes a Contractor record from the Contractors table using the provided
     * Contractor ID.
     *
     * @param statement The Statement to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     * @throws InputMismatchException
     */
    public static void deleteContractor(Statement statement, Scanner scanner) throws SQLException {
        int toDelete = 0;
        boolean validInputDelete = false;

        // While loop so that a valid input is added for the id (it's an integer)
        while (!validInputDelete) {
            try {
                System.out.print("\nWhich Contractor would you like to delete? Enter the Contractor ID: ");
                toDelete = scanner.nextInt();
                scanner.nextLine();
                validInputDelete = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for Contractor ID.");
                scanner.nextLine();
            }
        }

        int rowsAffected = statement.executeUpdate(
                "DELETE FROM Contractors WHERE contractor_id = " + toDelete);

        System.out.println("Query complete, " + rowsAffected + " row removed.");
    }

    /**
     * Deletes a Customer record from the Customers table using the provided
     * Customer ID.
     *
     * @param statement The Statement to execute the SQL query.
     * @param scanner   The Scanner object to read user input.
     * @throws SQLException
     * @throws InputMismatchException
     */
    public static void deleteCustomer(Statement statement, Scanner scanner) throws SQLException {
        int toDelete = 0;
        boolean validInputDelete = false;

        // While loop so that a valid input is added for the id (it's an integer)
        while (!validInputDelete) {
            try {
                System.out.print("\nWhich Customer would you like to delete? Enter the Customer ID: ");
                toDelete = scanner.nextInt();
                scanner.nextLine();
                validInputDelete = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for Customer ID.");
                scanner.nextLine();
            }
        }

        int rowsAffected = statement.executeUpdate(
                "DELETE FROM Customers WHERE customer_id = " + toDelete);

        System.out.println("Query complete, " + rowsAffected + " row removed.");
    }

    /***************************************************************************************************************/
    // Printing Functions:
    /***************************************************************************************************************/

    /**
     * Prints all Project records from the Projects table.
     *
     * @param statement The Statement to execute the SQL query.
     * @return Prints all the records from the Projects table
     * @throws SQLException
     */
    public static void printAllFromProject(Statement statement) throws SQLException {

        ResultSet results = statement.executeQuery(
                "SELECT project_number, project_name, building_type, physical_address, erf_number, total_fee, total_amount_paid, deadline, Finalised, Completion_date, architect_id, contractor_id, customer_id FROM Projects");
        System.out.println("\nCurrent Projects:");
        while (results.next()) {
            System.out.println(
                    results.getInt("project_number") + ", "
                            + results.getString("project_name") + ", "
                            + results.getString("building_type") + ", "
                            + results.getString("physical_address") + ", "
                            + results.getString("erf_number") + ", "
                            + results.getString("total_fee") + ", "
                            + results.getString("total_amount_paid") + ", "
                            + results.getString("deadline") + ", "
                            + results.getString("Finalised") + ", "
                            + results.getString("Completion_date") + ", "
                            + results.getString("architect_id") + ", "
                            + results.getString("contractor_id") + ", "
                            + results.getInt("customer_id"));
        }
    }

    /**
     * Prints all Architect records from the Architects table.
     *
     * @param statement The Statement to execute the SQL query.
     * @return Prints all the records from the Architects table
     * @throws SQLException
     */
    public static void printAllFromArchitect(Statement statement) throws SQLException {

        ResultSet results = statement.executeQuery(
                "SELECT architect_id, architect_name, telephone_number, email_address, physical_address FROM Architects");
        System.out.println("\nCurrent Architects:");
        while (results.next()) {
            System.out.println(
                    results.getInt("architect_id") + ", "
                            + results.getString("architect_name") + ", "
                            + results.getString("telephone_number") + ", "
                            + results.getString("email_address") + ", "
                            + results.getString("physical_address"));
        }

    }

    /**
     * Prints all Contractor records from the Contractors table.
     *
     * @param statement The Statement to execute the SQL query.
     * @return Prints all the records from the Contractors table
     * @throws SQLException
     */
    public static void printAllFromContractor(Statement statement) throws SQLException {

        ResultSet results = statement.executeQuery(
                "SELECT contractor_id, contractor_name, telephone_number, email_address, physical_address FROM Contractors");
        System.out.println("\nCurrent Contractors:");
        while (results.next()) {
            System.out.println(
                    results.getInt("contractor_id") + ", "
                            + results.getString("contractor_name") + ", "
                            + results.getString("telephone_number") + ", "
                            + results.getString("email_address") + ", "
                            + results.getString("physical_address"));
        }

    }

    /**
     * Prints all Customer records from the Customers table.
     *
     * @param statement The Statement to execute the SQL query.
     * @return Prints all the records from the Customers table
     * @throws SQLException
     */
    public static void printAllFromCustomer(Statement statement) throws SQLException {

        ResultSet results = statement.executeQuery(
                "SELECT customer_id, customer_name, telephone_number, email_address, physical_address FROM Customers");
        System.out.println("\nCurrent Customers:");
        while (results.next()) {
            System.out.println(
                    results.getInt("customer_id") + ", "
                            + results.getString("customer_name") + ", "
                            + results.getString("telephone_number") + ", "
                            + results.getString("email_address") + ", "
                            + results.getString("physical_address"));
        }

    }

}
