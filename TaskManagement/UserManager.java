package Weekly_Assignment.TaskManagement;

import java.util.ArrayList;
import java.util.List;

import static Weekly_Assignment.TaskManagement.ClassroomManager.classroomList;
import static Weekly_Assignment.TaskManagement.Main.scanner;

public class UserManager
{
    List<User> userList ;
    public UserManager()
    {
        userList= new ArrayList<>();
    }
    //add User
    public User addUser()
    {
        System.out.println("Enter the Classroom Id where you want the user to be registered");
        String classroomId= scanner.next();
        if(classroomList.containsKey(classroomId))
        {
            System.out.println("Enter the username of the User");
            String username= scanner.next();
            System.out.println("Enter the password of the classroom of user");
            String password = scanner.next();
            User newUser = new User(username,password);
            Classroom classroomWhereToAdd = classroomList.get(classroomId);
            classroomWhereToAdd.userList.add(newUser);
            userList.add(newUser);    //Adding to the separate list also
            System.out.println("User is successfully added in classroom with id : "+ classroomId);
            return newUser;
        }
        else
        {
            System.out.println("Sorry but the classroom with this id does not exits");
            return null;
        }
    }

    //delete User
    public void deleteUser()
    {
        System.out.println("Enter the classroom Id from where you want to delete the user");
        String classroomId = scanner.next();
        if(classroomList.containsKey(classroomId))
        {
            System.out.println("Enter the username of the user whom you want to delete");
            String username = scanner.next();
            Classroom classroomToSelect = classroomList.get(classroomId);
            User userToDelete= null;
            for(User user: classroomToSelect.userList)
            {
                if(user.getUsername().equals(username))
                {
                    userToDelete= user;
                    break;
                }
            }
            if(userToDelete!= null)
            {
                classroomToSelect.userList.remove(userToDelete);
                userList.remove(userToDelete);     //removing from separate List also
                System.out.println("User with username "+ username + " is deleted successfully");
            }
            else
            {
                System.out.println("User does not exists");
            }
        }
        else
        {
            System.out.println("The Classroom with this id does not exits");
        }
    }


    //View Users in a particular Classroom
    public void viewStudents()
    {
        System.out.println("Enter the classroom Id whose Students you want to display");
        String classroomId = scanner.next();
        if(classroomList.containsKey(classroomId))
        {
            Classroom classroomToSelect = classroomList.get(classroomId);
            if(classroomToSelect.userList.size()!=0)
            {
                for(User user: classroomToSelect.userList)
                {
                    System.out.println(user);
                }
            }
            else
            {
                System.out.println("No any student is registered for this classroom id");
            }
        }
        else
        {
            System.out.println("Classroom with this id does not exists");
        }
    }
    //Display all Students
    public void viewAllStudents()
    {
        if(userList.size()!=0)
        {
            for(User user: userList)
            {
                System.out.println(user);
            }
        }
        else
        {
            System.out.println("No any user Exits yet");
        }
    }

    //Login User
    public User loginUser()
    {
        System.out.println("Enter the username ");
        String username= scanner.next();
        System.out.println("Enter the password");
        String password = scanner.next();
        User userToFind = null;
        for(User user: userList)
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                userToFind = user;
                break;
            }
        }
        if(userToFind!=null)
        {
            System.out.println("User is log in");
            return userToFind;
        }
        else
        {
            return null;
        }
    }


}
