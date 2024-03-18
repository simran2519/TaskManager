package Weekly_Assignment.TaskManagement;

public class Task
{
    private String title;
    private String description;
    private String priority;
    private String dueDate;
    private String status;
    Task(String title, String description, String priority, String dueDate, String status)
    {
        this.title= title;
        this.description=description;
        this.priority= priority;
        this.dueDate= dueDate;
        this.status= status;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
