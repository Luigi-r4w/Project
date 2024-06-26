package com.example.Server.dto;

public class Hotel {

    private String name;
    private String id;
    private String city;
    private String max_photo_url;
    private String city_research;


    public String getCity_research() {
        return city_research;
    }
    public void setCity_research(String city_research) {
        this.city_research = city_research;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    

    public Hotel(String name, String id, String city, String max_photo_url, String city_research){
        this.name = name;
        this.id = id;
        this.city = city;
        this.max_photo_url = max_photo_url;
        this.city_research = city_research;
    }
    public String getMain_photo_url() {
        return max_photo_url;
    }
    public void setMain_photo_url(String max_photo_url) {
        this.max_photo_url = max_photo_url;
    }
   

}
