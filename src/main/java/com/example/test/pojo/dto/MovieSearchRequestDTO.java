package com.example.test.pojo.dto;

import javax.validation.Valid;

public class MovieSearchRequestDTO {

    @Valid
    private String movie_type;
    private int movie_time;

    public String getMovie_type() {
        return movie_type;
    }

    public void setMovie_type(String movie_type) {
        this.movie_type = movie_type;
    }

    public int getMovie_time() {
        return movie_time;
    }

    public void setMovie_time(int movie_time) {
        this.movie_time = movie_time;
    }

}
