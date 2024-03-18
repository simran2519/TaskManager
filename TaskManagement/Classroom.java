package Weekly_Assignment.TaskManagement;

import java.util.ArrayList;
import java.util.List;

public class Classroom
{
    private final String classroomId;
    private String classroomName;
    List<User> userList;
    List<Task> taskList;

    Classroom(String classroomId, String classroomName)
    {
        this.classroomId = classroomId;
        this.classroomName= classroomName;
        userList= new ArrayList<>();
        taskList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId='" + classroomId + '\'' +
                ", classroomName='" + classroomName + '\'' +
                ", userList=" + userList +
                ", taskList=" + taskList +
                '}';
    }
}
