package com.seu.CMT.pojo;

public class UserFilm {
    private String name;
    private int filmid;
    private double length;
    private long time;

    public UserFilm() {
    }

    public UserFilm(String name, int filmid, double length, long time) {
        this.name = name;
        this.filmid = filmid;
        this.length = length;
        this.time = time;
    }

    public int getFilmid() {
        return filmid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserFilm{" +
                "name='" + name + '\'' +
                ", filmid=" + filmid +
                ", length=" + length +
                ", time=" + time +
                '}';
    }
}
