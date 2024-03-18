package Weekly_Assignment.TaskManagement;

import java.util.ArrayList;
import java.util.List;

import static Weekly_Assignment.TaskManagement.ClassroomManager.classroomList;
import static Weekly_Assignment.TaskManagement.Main.scanner;

public class User
{
    private String username;
    private String password;
    private String status;
    List<Task> userTaskList;
    public User (String username,String password)
    {
        this.username= username;
        this.password= password;
        userTaskList= new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userTaskList=" + userTaskList +
                '}';
    }

    //submit Task
    public void submitTask()
    {
        if(userTaskList.size()!=0)
        {
            for(Task task: userTaskList)
            {
                System.out.println(task);
            }
            System.out.println("Select the Task which you want to submit");
                String title = scanner.next();
                Task taskToSubmit= null;
                for(Task task: userTaskList)
                {
                    if(task.getTitle().equals(title))
                    {
                        taskToSubmit= task;
                        break;
                    }
                }
                if(taskToSubmit!=null)
                {
                    taskToSubmit.setStatus("submitted");
                    System.out.println("Task has been Submitted");
                }
                else
                {
                    System.out.println(" no any task exits with this id");
                }
        }
        else
        {
            System.out.println("No any task is assigned to this user");
        }
    }

    //See all Pending Tasks
    public void pendingTasks()
    {
            if(userTaskList.size()!=0)
            {
                for(Task task: userTaskList)
                {
                    if(task.getStatus().equals("pending"))
                    {
                        System.out.println(task);
                    }
                }
            }
            else
            {
                System.out.println("No any pending task");
            }
    }

    public void submittedTasks()
    {
        if(userTaskList.size()!=0)
        {
            for (Task task: userTaskList)
            {
                if(task.getStatus().equals("submitted"))
                {
                    System.out.println(task);
                }
            }
        }
        else
        {
            System.out.println("No any submission is done yet");
        }
    }
}
