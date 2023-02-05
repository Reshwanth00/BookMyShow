package com.example.Book_my_show_backend.Controllers;
import com.example.Book_my_show_backend.Dtos.TheaterRequestDto;
import com.example.Book_my_show_backend.Models.TheaterEntity;
import com.example.Book_my_show_backend.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;
    @PostMapping("/add")
    public String addTheater(@RequestBody TheaterRequestDto theaterRequestDto){
        return theaterService.createTheater(theaterRequestDto);
    }
    @GetMapping("/theaterId")
    public TheaterEntity getTheater(@RequestParam Integer theaterId){
        return theaterService.getTheater(theaterId);
    }
    @GetMapping("/get-all-theaters")
    public List<String> getAllTheater(){
        return theaterService.getAllTheater();
    }
}
