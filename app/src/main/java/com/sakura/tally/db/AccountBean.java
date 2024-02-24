package com.sakura.tally.db;

/**
 * @author : Akubi
 * @date : 2024/1/26 17:35
 */
public class AccountBean {
    int id;
    /**
     * 类型
     */
    String typename;
    /**
     * 被选中类型图片
     */
    int sImageId;
    /**
     * 备注
     */
    String beizhu;
    /**
     * 价格
     */
    float money;
    /**
     * 保存时间字符串
     */
    String time;
    int year;
    int month;
    int day;
    /**
     * 类型  收入---1   支出---0
     */
    int kind;

    public AccountBean() {
    }

    public AccountBean(int id, String typename, int sImageId, String beizhu, float money,
                       String time, int year, int month, int day, int kind) {
        this.id = id;
        this.typename = typename;
        this.sImageId = sImageId;
        this.beizhu = beizhu;
        this.money = money;
        this.time = time;
        this.year = year;
        this.month = month;
        this.day = day;
        this.kind = kind;
    }

    /**
     * 获取
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return typename
     */
    public String getTypename() {
        return typename;
    }

    /**
     * 设置
     *
     * @param typename
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * 获取
     *
     * @return sImageId
     */
    public int getSImageId() {
        return sImageId;
    }

    /**
     * 设置
     *
     * @param sImageId
     */
    public void setSImageId(int sImageId) {
        this.sImageId = sImageId;
    }

    /**
     * 获取
     *
     * @return beizhu
     */
    public String getBeizhu() {
        return beizhu;
    }

    /**
     * 设置
     *
     * @param beizhu
     */
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    /**
     * 获取
     *
     * @return money
     */
    public float getMoney() {
        return money;
    }

    /**
     * 设置
     *
     * @param money
     */
    public void setMoney(float money) {
        this.money = money;
    }

    /**
     * 获取
     *
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置
     *
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * 设置
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * 获取
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * 设置
     *
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * 获取
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * 设置
     *
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * 获取
     *
     * @return kind
     */
    public int getKind() {
        return kind;
    }

    /**
     * 设置
     *
     * @param kind
     */
    public void setKind(int kind) {
        this.kind = kind;
    }


}
