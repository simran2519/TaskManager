package Weekly_Assignment.TaskManagement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static Weekly_Assignment.TaskManagement.Main.scanner;

public class AdminManager {
    Admin admin= new Admin("simran19", "1234");
    List<Admin> adminList;

    AdminManager() {
        readAdminData("C:/Users/91774/Desktop/AVI soft/Weekly_Assignment/TaskManagement/admin.csv");
        adminList = new ArrayList<>();
    }

    //Read Admin Data
    public List<Admin> readAdminData(String filePath) {
        adminList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header row if it exists
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String adminUsername = row[0];
                String adminPassword = row[1];
                Admin admin = new Admin(adminUsername, adminPassword);
                adminList.add(admin);
                System.out.println("Admin is adding from file to List");

            }
        } catch (IOException e) {
            e.printStackTrace();

            return adminList;
        }
        return null;
    }

//add admin
    public void registerAdmin()
    {
        System.out.println("Enter the username of admin");
        String adminUsername = scanner.next();
        System.out.println("Enter the Password of admin");
        String adminPassword = scanner.next();
        for (Admin admin : adminList) {
                if (admin.getUsername().equals(adminUsername)) {
                    System.out.println("Admin with this username is already exits");
                    return;
                }
            }
        Admin admin = new Admin(adminUsername,adminPassword);
        adminList.add(admin);
        System.out.println("Admin is added successfully");
        System.out.println(adminList);

    }

    //admin Login
    public boolean loginAdmin()
    {
        System.out.println("Enter the Admin username ");
        String adminUsername= scanner.next();
        System.out.println("enter the admin Password");
        String adminPassword = scanner.next();
        if(adminPassword.equals(admin.getPassword()) && adminUsername.equals(admin.getUsername()))
        {
            System.out.println("Admin is login ");
            return true;
        }
        else
        {
            System.out.println("Admin does not exists");
            return false;
        }
    }

//    //    add admin
//    public void registerAdmin() {
//        System.out.println("Enter the username of admin");
//        String adminUsername = scanner.next();
//        System.out.println("Enter the Password of admin");
//        String adminPassword = scanner.next();
//        for (Admin admin : adminList) {
//                if (admin.getUsername().equals(adminUsername)) {
//                    System.out.println("Admin with this username is already exits");
//                    return;
//                }
//            }
//            writeAdminToCSV("C:/Users/91774/Desktop/AVI soft/Weekly_Assignment/TaskManagement/admin.csv", adminUsername, adminPassword);
//    }

    public static void writeAdminToCSV(String filePath, String adminUsername, String adminPassword) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(adminUsername + "," + adminPassword);
            writer.newLine();
            writer.flush();
            System.out.println("Admin is added to CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
