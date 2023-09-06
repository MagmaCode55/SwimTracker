public class User {
    
    private String name = "";
    private String schoolName = "";
    private String userType = "";
    public int userNum = 0;

    public User( int userNum, String name, String schoolName, String userType){
        this.name = name;
        this.schoolName = schoolName;
        this.userType = userType;
        this.userNum = userNum;

    }


    public String getName(){
        return name;
    }

    public String getSchoolName(){
        return schoolName;
    }
    
    public String getUserType(){
        return userType;
    }

    public int getUserId(){
        return userNum;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public void setUserId(int userNum){
        this.userNum = userNum;
    }
    @Override
    public String toString(){
        return "User ID: " + this.getUserId() +
                "| Name: " + this.getName() +
                "| School: " + this.getSchoolName() +
                "| User type: " + this.getUserType();
    }

}
