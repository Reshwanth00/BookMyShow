package com.example.Book_my_show_backend.Controllers;
import com.example.Book_my_show_backend.Dtos.MovieRequestDto;
import com.example.Book_my_show_backend.Models.MovieEntity;
import com.example.Book_my_show_backend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add")
    public String addMovie(@RequestBody MovieRequestDto movieRequestDto){
        return movieService.addMovie(movieRequestDto);
    }
    @GetMapping("/get-movie")
    public MovieEntity getMovie(@RequestParam String name){
        return movieService.getMovie(name);
    }
    @GetMapping("/all-movies")
    public List<String> allMovies(){
        return movieService.allMovies();
    }
}
