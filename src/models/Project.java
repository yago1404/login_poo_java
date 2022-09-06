package models;

import java.util.ArrayList;

public class Project {
    private String projectName;
    private ArrayList<User> usersList;

    public Project(String projectName, ArrayList<User> usersList) {
        this.projectName = projectName;
        this.usersList = usersList;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public ArrayList<User> getUsersList() {
        return this.usersList;
    }

    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public boolean removeUser(String email) {
        for(User user: this.usersList) {
            if (user.getEmail().equals(email)) {
                this.usersList.remove(user);
                return true;
            }
        }
        return false;
    }
}
