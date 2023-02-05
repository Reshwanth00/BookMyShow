package com.example.Book_my_show_backend.Service;


import com.example.Book_my_show_backend.Dtos.MovieRequestDto;
import com.example.Book_my_show_backend.Models.MovieEntity;
import com.example.Book_my_show_backend.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieRequestDto movieRequestDto){

        //Convert Dto to Entity layer for saving it to the Database.
        MovieEntity movie = MovieEntity.builder().movieName(movieRequestDto.getName()).duration(movieRequestDto.getDuration()).releaseDate(movieRequestDto.getReleaseDate()).build();

        movieRepository.save(movie);

        return "Movie Added successfully";
    }
    public List<String> allMovies() {
        List<MovieEntity> movieEntities = movieRepository.findAll();
        List<String> strings = new ArrayList<>();
        for(MovieEntity movie:movieEntities){
            strings.add(movie.getMovieName());
        }
        return strings;
    }

    public MovieEntity getMovie(String name) {
        return movieRepository.findByMovieName(name);
    }

}
