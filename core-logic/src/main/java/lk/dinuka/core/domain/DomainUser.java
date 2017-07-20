package lk.dinuka.core.domain;

/**
 * Created by dinuka on 7/17/17.
 */
public class DomainUser {
    private int userId;
    private String userName;
    private String userEmail;
    private String memberType;

    public DomainUser(int userId, String userName, String userEmail, String memberType) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.memberType = memberType;
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

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

}
