package com.stylefeng.guns.enums;

public enum EmYn {

    YES(1, "有效"),
    NO(0, "无效");

    private final Integer value;
    private final String title;

    EmYn(Integer value, String title) {
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

    public static EmYn of(final Integer value) {
        for (EmYn rpt : EmYn.values()) {
            if (rpt.value == value) {
                return rpt;
            }
        }
        return null;
    }
}