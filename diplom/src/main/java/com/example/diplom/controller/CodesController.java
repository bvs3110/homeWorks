package com.example.diplom.controller;


import com.example.diplom.dto.CodesDto;
import com.example.diplom.exception.ValidationException;
import com.example.diplom.service.CodesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/codes")
@AllArgsConstructor
public class CodesController {
    private final CodesService codesService;

    @PostMapping("/save")
    public CodesDto saveCode(@RequestBody CodesDto codesDto) throws ValidationException {
        return codesService.saveCode(codesDto);
    }

    @PostMapping("/findByCode")
    public CodesDto findByCode(@RequestParam String code) {
        return codesService.findByCode(code);
    }

    @GetMapping("/findByArt")
    public List<CodesDto> findByArt(@RequestParam String art) {
        return codesService.findByArt(art);
    }

    @GetMapping("/findByArtSize")
    public List<CodesDto> findByArtSize(@RequestParam String art, @RequestParam Integer size ) {
        return codesService.findByArtSize(art, size);
    }

}
