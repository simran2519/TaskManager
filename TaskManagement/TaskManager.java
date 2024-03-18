package Weekly_Assignment.TaskManagement;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static Weekly_Assignment.TaskManagement.ClassroomManager.classroomList;
import static Weekly_Assignment.TaskManagement.Main.scanner;

public class TaskManager
{
    List<Task> taskList ;
    public TaskManager()
    {
        taskList= new ArrayList<>();
    }

    //add or Assign Task
    public  void assignTask()
    {
        System.out.println("Enter the id of Category where you want to add new Task");
        String classroomId = scanner.next();
        if(classroomList.containsKey(classroomId))
        {
            Classroom classroomToSelect = classroomList.get(classroomId);
            System.out.println("Enter the title of the Task ");
            String title = scanner.next();
            System.out.println("Enter the description of the Task");
            String description= scanner.next();
            System.out.println("Enter the priority of the Task");
            String priority = scanner.next();
            System.out.println("Enter the due date");
            String dueDate = scanner.next();
            System.out.println("Enter the status of the Task");
            String status = scanner.next();

            Task task = new Task(title,description,priority,dueDate,status);
            classroomToSelect.taskList.add(task);
            System.out.println("Task is successfully added in the classroom");

            System.out.println("Select the option");
            System.out.println("1. Assign Task to a particular Student");
            System.out.println("2. Assign Task to every Student that have joined the Classroom ");
            int option = scanner.nextInt();
            switch (option)
            {
                case 1:
                {
                    System.out.println("Enter the username whom you want to Assign the Task");
                    String username = scanner.next();
                    User userToAssignTask= null;
                    for(User user: classroomToSelect.userList)
                    {
                        if(username.equals(user.getUsername()))
                        {
                            userToAssignTask= user;
                            break;
                        }
                    }
                    if(userToAssignTask!=null)
                    {
                        userToAssignTask.userTaskList.add(task);
                        System.out.println("Task is assigned to Selected Student");
                    }
                    else
                    {
                        System.out.println("User does not exists");

                    }
                    break;
                }
                case 2:
                {
                    if(classroomToSelect.userList.size()!=0)
                    {
                        for(User user: classroomToSelect.userList)
                        {
                            user.userTaskList.add(task);
                        }
                    }
                    else
                    {
                        System.out.println("NO any user exists yet");
                    }
                    break;
                }
                default:
                {
                    System.out.println("You have selected invalid option");
                }
            }
        }
        else
        {
            System.out.println("Classroom with this id does not exits");
        }
    }

    //delete Task
    public void deleteTask()
    {
        System.out.println("Enter the classroom id whose task you want to remove or delete");
        String classroomId = scanner.next();
        if(classroomList.containsKey(classroomId))
        {
            Classroom classroomToSelect = classroomList.get(classroomId);
            System.out.println("Enter the title of the Task ");
            String title = scanner.next();
            Task taskToDelete= null;
            for(Task task : classroomToSelect.taskList)
            {
                if(title.equals(task.getTitle()))
                {
                    taskToDelete= task;
                    break;
                }
            }
            if(taskToDelete!= null)
            {
                classroomToSelect.taskList.remove(taskToDelete);
                System.out.println("Task is deleted from Classroom ");
            }
            else
            {
                System.out.println("Task with this title does not exits");
            }

            for(User user : classroomToSelect.userList)
            {
                if(user.userTaskList.size()!=0)
                {
                    user.userTaskList.remove(taskToDelete);
                }
            }
            System.out.println("Task is de- assign from Students");
        }
        else
        {
            System.out.println("Classroom with this id does not exits");
        }
    }


    //View Users in a particular Classroom
    public void viewTasks()
    {
        System.out.println("Enter the classroom Id whose Tasks you want to display");
        String classroomId = scanner.next();
        if(classroomList.containsKey(classroomId))
        {
            Classroom classroomToSelect = classroomList.get(classroomId);
            if(classroomToSelect.taskList.size()!=0)
            {
                for(Task task: classroomToSelect.taskList)
                {
                    System.out.println(task);
                }
            }
            else
            {
                System.out.println("No any task  is assigned for this classroom id");
            }
        }
        else
        {
            System.out.println("Classroom with this id does not exists");
        }
    }

}
