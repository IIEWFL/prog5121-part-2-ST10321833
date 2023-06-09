package PoePart1and2;

import javax.swing.JOptionPane;

public class PoePart2 {
   //Java string - javatpoint (no date) www.javatpoint.com. Available at: https://www.javatpoint.com/java-string (Accessed: 09 June 2023). 
   //Hartman, J. (2023) Java string manipulation: Functions and methods with example, Guru99. Available at: https://www.guru99.com/java-strings.html (Accessed: 09 June 2023). 
   //https://www.google.com/search?q=how+to+handle+strings+java+netbeans&biw=1280&bih=577&tbm=vid&sxsrf=APwXEdeEhU4YHq6-xD4ZqRA4Ct3-w1rVrA%3A1686311944071&ei=CBSDZNztA-aC9u8P4YyN6AM&ved=0ahUKEwjckaDDkbb_AhVmgf0HHWFGAz0Q4dUDCA0&uact=5&oq=how+to+handle+strings+java+netbeans&gs_lcp=Cg1nd3Mtd2l6LXZpZGVvEAMyBQghEKABOgQIIxAnOgUIABCABDoGCAAQFhAeOggIABAWEB4QCjoICCEQFhAeEB06BwghEKABEAo6CAgAEAgQHhANOggIABCKBRCGA1C7Blj0OmDaQWgAcAB4AIABzgOIAcUqkgEGMy0xMy4ymAEAoAEBwAEB&sclient=gws-wiz-video#fpstate=ive&vld=cid:0a052a4d,vid:J8JHOFwB6oM
  //Add junit5 jar files.2022.Youtube.added by VCSOIT.[Online].Available at:https://www.youtube.com/watch?v=fQaUsfEzGdw&list=PL480DYS-b_kfHSYf2yzLgto_mwDr_U-Q6&index=3 [Accessed 30 April 2023]

    
    public static String firstname;
    public static String lastname;
    public static String username;
    public static String userpassword;
    public static boolean loggedIn = false;
    public static int totalhours = 0;
    public static int taskcount = 0;

   
    public static boolean passwordComplexity(String password) {
        boolean eightCharacters = password.length() >= 8;
        boolean capitalLetter = false;
        boolean digit = false;
        boolean specialCharacter = false; 

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                capitalLetter = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if ("!@#$%^&*+=".indexOf(c) >= 0) {
                specialCharacter = true;
            }
        }
        return eightCharacters && capitalLetter && digit && specialCharacter;
    }

    //Loops in java: Java for loop (syntax, program, example) - javatpoint (no date) www.javatpoint.com. Available at: https://www.javatpoint.com/java-for-loop (Accessed: 09 June 2023). 
    //Java for loop (no date) Programiz. Available at: https://www.programiz.com/java-programming/for-loop (Accessed: 09 June 2023). 
    //(No date a) Programiz. Available at: https://www.programiz.com/java-programming/for-loop (Accessed: 09 June 2023). 
    //(No date a) Google search. Google. Available at: https://www.google.com/search?q=creating%2Band%2Bworking%2Bwith%2Bloops%2Bjava&amp;sxsrf=APwXEdd_QtS66YwBKnB-i55O9YGzYK4Zow%3A1686312393005&amp;source=lnms&amp;tbm=vid&amp;sa=X&amp;ved=2ahUKEwiLgqmZk7b_AhWEilwKHfMVAEAQ_AUoAXoECAEQAw&amp;biw=1280&amp;bih=577&amp;dpr=1.5#fpstate=ive&amp;vld=cid:7a19a459,vid:hs45eeZ326U (Accessed: 09 June 2023). 
   //(2023) GeeksforGeeks. GeeksforGeeks. Available at: https://www.geeksforgeeks.org/java-do-while-loop-with-examples/ (Accessed: 09 June 2023). 
    
    
    public static boolean usernameValidity(String username) {
        boolean fiveCharacters = username.length() == 5;
        boolean underscore = false;

        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            if ("_".indexOf(ch) >= 0) {
                underscore = true;
            }
        }
        return fiveCharacters && underscore;
    }

   
    public static String registerUser() {
        System.out.println("Please enter your firstname: ");
        firstname = JOptionPane.showInputDialog("Please enter your firstname:");

        System.out.println("Please enter your lastname: ");
        lastname = JOptionPane.showInputDialog("Please enter your lastname:");

        System.out.println("Please enter a username (No longer than 5 characters and must contain an underscore): ");
        username = JOptionPane.showInputDialog("Please enter a username (No longer than 5 characters and must contain an underscore):");

        while (!usernameValidity(username)) {
            System.out.println("The username is invalid, please try again: ");
            username = JOptionPane.showInputDialog("The username is invalid, please try again:");
        }

        System.out.println("Please enter a userpassword (At least 8 characters, must contain a capital letter, digit, and special character): ");
        userpassword = JOptionPane.showInputDialog("Please enter a userpassword (At least 8 characters, must contain a capital letter, digit, and special character):");

        while (!passwordComplexity(userpassword)) {
            System.out.println("Password is invalid, please try again: ");
            userpassword = JOptionPane.showInputDialog("Password is invalid, please try again:");
        }

        return "Registed successful";
    }

    
    public static boolean loginUser() {
        while (!loggedIn) {
            String loginUsername = JOptionPane.showInputDialog("Please enter your username to login:");
            String loginPassword = JOptionPane.showInputDialog("Please enter your password to login:");

            if (loginUsername.equals(username) && loginPassword.equals(userpassword)) {
                loggedIn = true;
            } else {
                JOptionPane.showMessageDialog(null, "Username or password is incorrect, please try again");
            }
        }
        return loggedIn;
    }

   
    public static boolean loginStatus() {
        loggedIn = true;
        JOptionPane.showMessageDialog(null, "Welcome " + firstname + " " + lastname + ", it is good to see you again!");
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");

        return loggedIn;
    }

   

   public static void handleMenuOptions() {
        boolean quit = false;
        while (!quit) {
            String option = JOptionPane.showInputDialog(
                    "Please select an option:\n" +
                            "1) Add tasks\n" +
                            "2) Show report\n" +
                            "3) Quit"
            );

            switch (option) {
                case "1":
                    int taskCount = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks you want to add:"));
                    addTasks(taskCount);
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case "3":
                    quit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option, please try again.");
            }
        }

        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalhours);
    }

 
    public static void addTasks(int count) {
        for (int i = 0; i < count; i++) {
            Task task = createTask();
            JOptionPane.showMessageDialog(null, "Task successfully captured\n" + task.printTaskDetails());
            totalhours += task.getTaskDuration();
            taskcount++;
        }
    }

   
     public static Task createTask() {
        String taskName = JOptionPane.showInputDialog("Enter the task name:");
        String taskDescription = JOptionPane.showInputDialog("Enter the task description (max 50 characters):");

        while (taskDescription.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            taskDescription = JOptionPane.showInputDialog("Enter the task description (max 50 characters):");
        }

        String developerFirstName = JOptionPane.showInputDialog("Enter the developer's first name:");
        String developerLastName = JOptionPane.showInputDialog("Enter the developer's last name:");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration in hours:"));

       
        String[] statusOptions = { "To Do", "Done", "Doing" };
        int statusChoice = JOptionPane.showOptionDialog(null, "Select the task status:", "Task Status",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, statusOptions, statusOptions[0]);

        String taskStatus = statusOptions[statusChoice];

        return new Task(taskName, taskDescription, developerFirstName, developerLastName, taskDuration, taskStatus);
    }

    public static void main(String[] args) {
        registerUser();
        if (loginUser()) {
            loginStatus();
            handleMenuOptions();
        } else {
            JOptionPane.showMessageDialog(null, "Username or password is incorrect.");
        }
    }
}

class Task {
    private String task_Name;
    private String task_Description;
    private String developer_FirstName;
    private String developer_LastName;
    private int task_Duration;
    private int task_Number;
    private String task_ID;
    private String task_Status;
    private static int total_Hours = 0;

    public Task(String taskName, String taskDescription, String developerFirstName, String developerLastName,
                int taskDuration, String taskStatus) {
        this.task_Name = taskName;
        this.task_Description = taskDescription;
        this.developer_FirstName = developerFirstName;
        this.developer_LastName = developerLastName;
        this.task_Duration = taskDuration;
        this.task_Number = PoePart2.taskcount;
        this.task_ID = createTaskID();
        this.task_Status = taskStatus;
        total_Hours += taskDuration;
    }

    public String getTaskName() {
        return task_Name;
    }

    public String getTaskDescription() {
        return task_Description;
    }

    public String getDeveloperFirstName() {
        return developer_FirstName;
    }

    public String getDeveloperLastName() {
        return developer_LastName;
    }

    public int getTaskDuration() {
        return task_Duration;
    }

    public int getTaskNumber() {
        return task_Number;
    }

    public String getTaskID() {
        return task_ID;
    }

    public String getTaskStatus() {
        return task_Status;
    }

    public void setTaskStatus(String taskStatus) {
        this.task_Status = taskStatus;
    }

    public boolean checkTaskDescription() {
        return task_Description.length() <= 50;
    }

    private String createTaskID() {
        String firstTwoLetters = task_Name.substring(0, Math.min(task_Name.length(), 2)).toUpperCase();
        String lastThreeLetters = developer_LastName.substring(Math.max(0, developer_LastName.length() - 3)).toUpperCase();
        return firstTwoLetters + ":" + task_Number + ":" + lastThreeLetters;
    }

    public String printTaskDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Task Name: ").append(task_Name).append("\n")
                .append("Task Number: ").append(task_Number).append("\n")
                .append("Task Description: ").append(task_Description).append("\n")
                .append("Developer Details: ").append(developer_FirstName).append(" ").append(developer_LastName).append("\n")
                .append("Task Duration: ").append(task_Duration).append(" hours").append("\n")
                .append("Task ID: ").append(task_ID).append("\n")
                .append("Task Status: ").append(task_Status);
        return details.toString();
    }

    public static int returnTotalHours() {
        return total_Hours;
    }
}