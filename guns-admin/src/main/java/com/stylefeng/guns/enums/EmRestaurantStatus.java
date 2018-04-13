package com.stylefeng.guns.enums;

public enum EmRestaurantStatus {

    AUDIT(10, "审核中"),
    OPEN(20, "开业"),
    PAUSE(30, "歇业"),
    CLOSE(40, "关闭");

    private final Integer value;
    private final String title;

    EmRestaurantStatus(Integer value, String title) {
        this.value = value;
        this.title = title;
    }

    public Integer value() {
        return value;
    }

    public Integer getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public static EmRestaurantStatus of(final Integer value) {
        for (EmRestaurantStatus rpt : EmRestaurantStatus.values()) {
            if (rpt.value == value) {
                return rpt;
            }
        }
        return null;
    }
}