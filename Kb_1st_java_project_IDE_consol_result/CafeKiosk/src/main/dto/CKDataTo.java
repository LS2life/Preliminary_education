package main.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CKDataTo {
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
}
