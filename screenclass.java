package com.example.java;

public class screenclass extends movieclass{
    private String screennum;
    private String category;
    private String timing;
    public String getScreennum() {
        return screennum;
    }
    public void setScreennum(String screennum) {
        this.screennum = screennum;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getTiming() {
        return timing;
    }
    public void setTiming(String timing) {
        this.timing = timing;
    }
//        public screenclass(String moviename,String duration , String agelimit,String screennum, String category, String timing) {
//        super(moviename,duration,agelimit);
//        setScreennum(screennum);
//        setCategory(category);
//        setTiming(timing);
//    }

    public void connector(String moviename,String duration , String agelimit,String screennum, String category, String timing)
    {
        setScreennum(screennum);
        setCategory(category);
        setTiming(timing);
        super.setMoviename(moviename);
        super.setDuaration(duration);
        super.setAgelimit(agelimit);
    }
}
