package com.sakura.tally.db;

/**
 * 表示收入或者支出具体类型的类
 */
public class TypeBean {
    int id;
    /**
     * 类型名称
     */
    String typename;
    /**
     * 未被选中图片id
     */
    int imageId;
    /**
     * 被选中图片id
     */
    int simageId;
    /**
     * 收入-1  支出-0
     */
    int kind;


    public TypeBean() {
    }

    public TypeBean(int id, String typename, int imageId, int simageId, int kind) {
        this.id = id;
        this.typename = typename;
        this.imageId = imageId;
        this.simageId = simageId;
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
     * @return imageId
     */
    public int getImageId() {
        return imageId;
    }

    /**
     * 设置
     *
     * @param imageId
     */
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    /**
     * 获取
     *
     * @return simageId
     */
    public int getSimageId() {
        return simageId;
    }

    /**
     * 设置
     *
     * @param simageId
     */
    public void setSimageId(int simageId) {
        this.simageId = simageId;
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
