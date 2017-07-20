package lk.dinuka.web.model;

import java.util.List;

/**
 * Created by dinuka on 7/17/17.
 */
public class FormUser {
    private int userId;
    private String userName;
    private String userEmail;
    private String memberType;
    private List<String> memberTypelist;

    public FormUser() {

    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public List<String> getMemberTypelist() {
        return memberTypelist;
    }

    public void setMemberTypelist(List<String> memberTypelist) {
        this.memberTypelist = memberTypelist;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
