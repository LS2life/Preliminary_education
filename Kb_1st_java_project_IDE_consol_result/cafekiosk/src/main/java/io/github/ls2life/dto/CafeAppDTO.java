package io.github.ls2life.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CafeAppDTO implements Serializable {
    private static String superUser = "su";
    private static String superPass = "as";
    private String id;
    private String password;
    private String name;
    private long phone;
    private String birthday;
    private int rewardsPoint;
    private  String etc;
    private boolean admin = false;
    private String dateOfJoin;
    private LocalDateTime localDateTime;


    @Override
    public String toString() {
        return "CafeDTO [ ID : " + id +
                " , password : " + password +
                " , 이름 : " + name +
                " , 생년월일 : " + birthday +
                " , 전화번호 : " + phone +
                " , Rewards Point : " + rewardsPoint +
                " , 기타 : " + etc +
                " , 등급 : " + admin +
                " , 가입일 : " + dateOfJoin +" ] ";
    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }


    // Date
    private String getDateOfJoin = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));


    // Get | set
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


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }


    public int getRewardsPoint() {
        return rewardsPoint;
    }
    public void setRewardsPoint(int rewardsPoint) {
        this.rewardsPoint = rewardsPoint;
    }


    public String getEtc() { return etc; }
    public void setEtc(String etc) { this.etc = etc; }


    public boolean getAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    public String getDateOfJoin() {
        return dateOfJoin;
    }
    public void setDateOfJoin(String dateofjoin) {
        this.dateOfJoin = dateofjoin;
    }
}


