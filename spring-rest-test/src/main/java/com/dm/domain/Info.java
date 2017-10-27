package com.dm.domain;

public class Info {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                '}';
    }
}
