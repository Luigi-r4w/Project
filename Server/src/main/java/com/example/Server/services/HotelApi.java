package com.example.Server.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.example.Server.dao.HotelDAO;
import com.example.Server.dto.Hotel;
import com.example.Server.dto.HotelInfo;
import com.example.Server.services.HotelRes.HotelInfoRes;
import com.google.gson.Gson;


public class HotelApi {
    HotelDAO hotel = new HotelDAO();

    public ArrayList<Hotel> hotelApiCity(String city) throws IOException, InterruptedException{
        
        String cityId = CityID(city);
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
    
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://booking-com.p.rapidapi.com/v1/hotels/search?checkout_date=2024-09-15&order_by=popularity&filter_by_currency=AED&room_number=1&dest_id="+cityId+"&dest_type=city&adults_number=2&checkin_date=2024-09-14&locale=en-gb&units=metric&include_adjacency=true&children_number=2&categories_filter_ids=class%3A%3A2%2Cclass%3A%3A4%2Cfree_cancellation%3A%3A1&page_number=0&children_ages=5%2C0"))
		.header("X-RapidAPI-Key", "293acc30c2msh2762dd407645365p1b0a5djsnded21308c160")
		.header("X-RapidAPI-Host", "booking-com.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        HotelRes hotelRes = gson.fromJson(response.body(), HotelRes.class);
        
        ArrayList<HotelInfoRes> result = hotelRes.getResults();
        
        for (HotelInfoRes hotelInfoRes : result) {
            String id = hotelInfoRes.getId();
            String name = hotelInfoRes.getName();
            String main_photo_url = hotelInfoRes.getMain_photo_url();
            Hotel hotelResponde = new Hotel(name, id, city, main_photo_url);
            hotels.add(hotelResponde);
        }
    
        return hotels;
    } 

    public String CityID(String city) throws IOException, InterruptedException{

        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://booking-com.p.rapidapi.com/v1/hotels/locations?name="+city+"&locale=en-gb"))
		.header("X-RapidAPI-Key", "293acc30c2msh2762dd407645365p1b0a5djsnded21308c160")
		.header("X-RapidAPI-Host", "booking-com.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());  
        Gson gson = new Gson();
        Location[] locations = gson.fromJson(response.body(), Location[].class);
        String id = locations[0].getDest_id();

        return id;
    }
    
    public HotelInfo info(String id) throws Exception {
        HotelInfo hotelInfo = new HotelInfo();

        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://booking-com.p.rapidapi.com/v2/hotels/details?currency=AED&locale=en-gb&checkout_date=2024-09-15&hotel_id="+id+"&checkin_date=2024-09-14"))
		.header("X-RapidAPI-Key", "293acc30c2msh2762dd407645365p1b0a5djsnded21308c160")
		.header("X-RapidAPI-Host", "booking-com.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        hotelInfo = gson.fromJson(response.body(), HotelInfo.class);
        return hotelInfo;
    }

}

class Location {
    private String dest_id;
   
    public String getDest_id() {
        return dest_id;
    }

    public void setDest_id(String dest_id) {
        this.dest_id = dest_id;
    }

}

class HotelRes {


    private ArrayList<HotelInfoRes> result;

    /**
     * HotelInfoRes
     */
    public class HotelInfoRes {
        
        private String hotel_id;

        private String hotel_name;

        private String main_photo_url;

        public String getMain_photo_url() {
            return main_photo_url;
        }

        public void setMain_photo_url(String main_photo_url) {
            this.main_photo_url = main_photo_url;
        }

        public String getName() {
            return hotel_name;
        }

        public void setName(String hotel_name) {
            this.hotel_name = hotel_name;
        }

        public String getId() {
            return hotel_id;
        }

        public void setId(String id) {
            this.hotel_id = id;
        }

    }

    public ArrayList<HotelInfoRes> getResults() {
        return result;
    }

    public void setResults(ArrayList<HotelInfoRes> results) {
        this.result = results;
    }
}


