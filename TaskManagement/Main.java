package Weekly_Assignment.TaskManagement;

import java.util.Scanner;
public class Main
{
    static User userToLogin=null;
    static AdminManager adminManager = new AdminManager();
    static ClassroomManager classroomManager= new ClassroomManager();
    static UserManager userManager= new UserManager();
    static TaskManager taskManager = new TaskManager();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {

        System.out.println("Welcome");
        System.out.println("Select one Option");
        System.out.println("1. Admin");
        System.out.println("2. User");
        int option=scanner.nextInt();
        switch (option)
        {
            case 1:
            {
                String filePath = "C:/Users/91774/Desktop/AVI soft/Weekly_Assignment/TaskManagement/admin.csv";
                adminManager.readAdminData(filePath);
                System.out.println(adminManager.adminList);
                System.out.println("You want to login or register? ");
                System.out.println("1. Login");
                System.out.println("2. Register");
                int credentialOption= scanner.nextInt();
                switch (credentialOption)
                {
                    case 1:
                    {
                       if(adminManager.loginAdmin())
                       {
                           adminMenu();
                       }
                      else
                       {
                           System.out.println("Admin is not valid");
                       }
                      break;
                    }
                    case 2:
                    {
                        adminManager.registerAdmin();
                        adminMenu();
                        break;
                    }
                    default:
                        System.out.println("Select valid option");
                }
            }
            case 2:
            {
                System.out.println("You want to login or register? ");
                System.out.println("1. Login");
                System.out.println("2. Register to a Classroom");
                int credentialOption= scanner.nextInt();
                switch (credentialOption)
                {
                    case 1:
                    {
                        userToLogin = userManager.loginUser();
                        if(userToLogin!=null)
                        {
                            userMenu();
                        }
                        else
                        {
                            System.out.println("User is not valid");
                        }
                        break;
                    }
                    case 2:
                    {
                        userToLogin=  userManager.addUser();
                        if(userToLogin!=null)

                        {
                            userMenu();
                        }
                        else
                        {
                            System.out.println("User cannot be registered");
                        }
                        break;
                    }
                    default:
                        System.out.println("Select valid option");
                }
            }
            default:
                System.out.println("Please Enter a valid option");
        }
    }

    public static void adminMenu()
    {
        while(true)
        {
            System.out.println("Select the option that you want to select ");
            System.out.println("0. Exit");
            System.out.println("1. Add Classroom");
            System.out.println("2. Delete Classroom");
            System.out.println("3. Add User");
            System.out.println("4. Delete User");
            System.out.println("5. Assign Task ");
            System.out.println("6. Delete Task");
            System.out.println("7. View Users(or Student) in a Classroom");
            System.out.println("8. View Tasks that are assigned to User in a classrooms");
            System.out.println("9. View All Users");
            System.out.println("10. View Submitted Task of Users");
            System.out.println("11. View Missing Tasks");
            System.out.println("12. Show Classrooms");
            System.out.println("13. Exit Admin Roll");
//            System.out.println("13. Show Admin");
            int adminOption = scanner.nextInt();
            if(adminOption==0 || adminOption==13)
            {
                System.out.println("Exited");
                break;
            }
            switch (adminOption)
            {
                case 1:
                {
                    classroomManager.addClassroom();
                    break;
                }
                case 2:
                {
                    classroomManager.deleteClassroom();
                    break;
                }
                case 3:
                {
                    userManager.addUser();
                    break;
                }
                case 4:
                {
                    userManager.deleteUser();
                    break;
                }
                case 5:
                {
                    taskManager.assignTask();
                    break;
                }
                case 6:
                {
                    taskManager.deleteTask();
                    break;
                }
                case 7:
                {
                    userManager.viewStudents();
                    break;
                }
                case 8:
                {
                    taskManager.viewTasks();
                    break;
                }
                case 9:
                {
                    userManager.viewAllStudents();
                    break;
                }
                case 12:
                {
                    classroomManager.showClassrooms();
                    break;
                }
            }
        }
    }

    public static void userMenu()
    {
        System.out.println("Welcome");
        while(true)
        {
            System.out.println("Select option");
            System.out.println("0. Exit");
            System.out.println("1. View Assigned Tasks");
            System.out.println("2. Submit Tasks");
            System.out.println("3. See all Pending Tasks");
            System.out.println("4. See all Submitted Tasks");
            int option = scanner.nextInt();
            if(option==0)
            {
                System.out.println("Exited");
                break;
            }
            switch (option)
            {
                case 1:
                {
                    taskManager.viewTasks();
                    break;
                }
                case 2:
                {
                    userToLogin.submitTask();
                    break;
                }
                case 3:
                {
                    userToLogin.pendingTasks();
                    break;
                }
                case 4:
                {
                    userToLogin.submittedTasks();
                    break;
                }
                default:
                {
                    System.out.println("You have entered an invlaid otption");
                }
            }
        }
    }
}
