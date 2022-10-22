package dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CafeManagerDTO implements Serializable {
    private static String superUser = "su";
    private static String superPass = "as";
    private String id;
    private String password;
    private boolean admin;
    private String name;
    private long phone;
    private String birthday;
    private int grade = 2;
    private int rewardsPoint;
    private String dateOfJoin;
    private LocalDateTime localDateTime;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    // Date
    private String getDateOfJoin = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));

    @Override
    public String toString() {
        return "CafeDTO [ id = " + id +
                " , password = " + password +
                " , 이름 = " + name +
                " , 생년월일 = " + birthday +
                " , 등급 = " + grade +
                " , RewardPoint = " + rewardsPoint +
                " , 가입일 = " + dateOfJoin +" ] ";
    }
    // Get | set
    public String getDateOfJoin() {
        return dateOfJoin;
    }
    public void setDateOfJoin(String dateofjoin) {
        this.dateOfJoin = dateofjoin;
    }


    public static String getSuperUser() {return superUser;}
    public void setSuperUser(String superuser) { superUser = superuser; }


    public static String getSuperPass() { return superPass; }
    public void setSuperPass(String superpass) { superPass = superpass; }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public boolean getAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }


    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getRewardsPoint() {
        return rewardsPoint;
    }
    public void setRewardsPoint(int rewardsPoint) {
        this.rewardsPoint = rewardsPoint;
    }
}


