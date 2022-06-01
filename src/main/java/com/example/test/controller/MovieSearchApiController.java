package com.example.test.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.test.dao.MovieRepository;
import com.example.test.pojo.dto.CharacterDTO;
import com.example.test.pojo.dto.MovieSearchRequestDTO;
import com.example.test.pojo.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LoggingMXBean;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/search")
public class MovieSearchApiController {

    @Autowired
    public MovieRepository movieRepository;

    private String movie_type;
    private int movie_time;

    @RequestMapping(value = "/movie", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<Object> search(@Valid @RequestBody MovieSearchRequestDTO movieSearchRequestDTO, HttpServletRequest request) {
        /*String search = request.getParameter("search");
        JSONObject json = JSONObject.parseObject(search);
        JSONObject condition = json.getJSONObject("search_condition");*/

        movie_type = movieSearchRequestDTO.getMovie_type();
        movie_time = movieSearchRequestDTO.getMovie_time();

        List<MovieEntity> movie = new ArrayList<>();
        if (movie_type != null && movie_time != 0) {
            movie = movieRepository.findMovieEntitiesByTypeAndMonth(movie_type, movie_time);
        }else if(movie_type != null){
            movie = movieRepository.findMovieEntitiesByType(movie_type);
        }else if(movie_time != 0){
            movie = movieRepository.findMovieEntitiesByMonth(movie_time);
        }

        return ResponseEntity.ok(movie);
    }

    /*@RequestMapping(value = "/test", produces = {"application/json;charset=UTF-8"})
    public String test(@Valid @RequestBody CharacterDTO characterDTO, HttpServletRequest request){
        System.out.println(characterDTO);
        return "success";
    }*/
}


