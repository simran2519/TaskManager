package Weekly_Assignment.TaskManagement;

import java.util.HashMap;
import java.util.List;

import static Weekly_Assignment.TaskManagement.Main.scanner;

public class ClassroomManager
{
   static HashMap<String ,Classroom>classroomList;
    ClassroomManager()
    {
        classroomList= new HashMap<>();
    }
    //add Classroom
    public void addClassroom()
    {
        System.out.println("Enter the id of classroom");
        String classroomId = scanner.next();
        System.out.println("Enter the name of classroom");
        String classroomName = scanner.next();
        if(!classroomList.containsValue(classroomId))
        {
            Classroom classroom = new Classroom(classroomId,classroomName);
            classroomList.put(classroomId,classroom);
            System.out.println("Classroom is added");
        }
        else
        {
            System.out.println("Classroom with this Id is already exiting Please enter classroom with different id");
        }

    }

    //Delete the classroom
    public void deleteClassroom() {
        System.out.println("Enter the id of the classroom that you want to delete");
        String classroomId = scanner.next();
        if (classroomList.containsValue(classroomId)) {
            Classroom classroomToDelete = classroomList.get(classroomId);
            classroomList.remove(classroomToDelete);
            System.out.println("Classroom is deleted");
        } else {
            System.out.println("Classroom with this id does not exits");
        }
    }

    //View Classrooms
    public void showClassrooms()
    {
        for(Classroom classroom : classroomList.values())
        {
            System.out.println(classroom);
        }
    }



}
