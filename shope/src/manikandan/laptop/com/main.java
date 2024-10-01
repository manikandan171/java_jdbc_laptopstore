package manikandan.laptop.com;

import java.util.Scanner;

public class main {
    private static final Store store = new Store();
    private static final String ADMIN_USERNAME = "mani";
    private static final String ADMIN_PASSWORD = "manikandan";

    public static void main(String[] args) throws usererror {
        login loginSystem = new login();
   
        Scanner sc = new Scanner(System.in);
        User currentUser;

       
        loginSystem.addAdmin(ADMIN_USERNAME, ADMIN_PASSWORD);

        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Show Users");
            System.out.println("4. Exit");
            int opt = sc.nextInt();
            sc.nextLine(); 
            switch (opt) {
                case 1:
                    loginSystem.signUp();
                    break;
                case 2:
                    currentUser = loginSystem.authenticate();
                    if (currentUser != null) 
                    {
                        if ("admin".equals(currentUser.getRole()))
                        {
                            adminActions(sc, currentUser);
                        } 
                        else if ("user".equals(currentUser.getRole()))
                        {
                            userActions(sc, currentUser);
                        }
                    }
                    break;
                case 3:
                    loginSystem.showUsers();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    static void adminActions(Scanner sc, User admin) throws usererror {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Laptop");
            System.out.println("2. Update Laptop");
            System.out.println("3. Search Laptop");
            System.out.println("4. Remove Laptop");
            System.out.println("5. Show All Laptops");
            System.out.println("6. Exit");
            int option = sc.nextInt();
            sc.nextLine(); 
            switch (option) {
                case 1:
                    computer c = new computer();
                    System.out.println("Enter the user Name:");
                    c.setUname(sc.nextLine());
                    System.out.println("Enter the Laptop Brand:");
                    c.setName(sc.nextLine());
                    System.out.println("Enter the Model name:");
                    c.setModel_name(sc.nextLine());
                    System.out.println("Enter the Price:");
                    c.setPrice(sc.nextInt());
                    sc.nextLine(); 
                    System.out.println("Enter the processor type:");
                    c.setProcessor_type(sc.nextLine());
                    store.add(c);
                    
                    break;
                case 2:
                    store.show();
                    System.out.println("Enter the id:");
                    String id = sc.nextLine();
                    store.update(id);
//                    if (cToUpdate != null) {
//                        System.out.println("1. Username");
//                        System.out.println("2. Product Name");
//                        System.out.println("3. Model");
//                        System.out.println("4. Price");
//                        System.out.println("5. Type");
//                        System.out.println("Enter the update number:");
//                        int idn = sc.nextInt();
//                        sc.nextLine(); 
//                        switch (idn) {
//                            case 1:
//                                System.out.println("Enter new Username:");
//                                cToUpdate.setUname(sc.nextLine());
//                                
//                                break;
//                            case 2:
//                                System.out.println("Enter new Product Name:");
//                                cToUpdate.setName(sc.nextLine());
//                                break;
//                            case 3:
//                                System.out.println("Enter new Model:");
//                                cToUpdate.setModel_name(sc.nextLine());
//                                break;
//                            case 4:
//                                System.out.println("Enter new Price:");
//                                cToUpdate.setPrice(sc.nextInt());
//                                sc.nextLine(); 
//                                break;
//                            case 5:
//                                System.out.println("Enter new Type:");
//                                cToUpdate.setProcessor_type(sc.nextLine());
//                                break;
//                            default:
//                                System.out.println("Invalid option. Please try again.");
//                        }
//                    } else {
//                        System.out.println("Laptop not found.");
//                    }
                    break;
                case 3:
                    store.show();
                    System.out.println("Enter the id:");
                    id = sc.nextLine();
                    try {
                        computer cToSearch = store.search(id);
                        if (cToSearch != null) 
                        {
                            System.out.println(cToSearch);
                        } 
                        else
                        {
                            throw new usererror("ID not found"); 
                        }
                    } catch (usererror e) 
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    store.show();
                    System.out.println("Enter the id:");
                    id = sc.nextLine();
                    store.remove(id);
                    break;
                case 5:
                    store.show();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    static void userActions(Scanner sc, User user) {
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. Search Laptop");
            System.out.println("2. Show All Laptops");
            System.out.println("3. Exit");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    store.show();
                    System.out.println("Enter the id:");
                    String id = sc.nextLine();
                    computer c = store.search(id);
                    System.out.println(c);
                    break;
                case 2:
                    store.show();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
