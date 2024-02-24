package com.sakura.tally.user;

/**
 * @author : Akubi
 * @date : 2024/2/24 22:41
 */
public class UserBean {
    /**
     * 判断登录状态
     */
    private int loginOut;
    /**
     * 用户id
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;

    public UserBean() {
    }

    public UserBean(int loginOut, String username, String password) {
        this.loginOut = loginOut;
        this.username = username;
        this.password = password;
    }

    public int getLoginOut() {
        return loginOut;
    }

    public void setLoginOut(int loginOut) {
        this.loginOut = loginOut;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
