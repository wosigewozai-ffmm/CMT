package com.seu.CMT.pojo;

public class Film {
    private int id;
    private String name;
    private double length;
    private String type;
    private String location;
    private int year;
    private double score;
    private String authority;
    private String picture;
    private String movie;
    private String intro;
    private String actor;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    private long time;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Film() {
    }

    public Film(int id, String name, double length, String type, String location, int year, double score, String authority, String picture, String movie) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.type = type;
        this.location = location;
        this.year = year;
        this.score = score;
        this.authority = authority;
        this.picture = picture;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", year=" + year +
                ", score=" + score +
                ", authority='" + authority + '\'' +
                ", picture='" + picture + '\'' +
                ", movie='" + movie + '\'' +
                '}';
    }
}
