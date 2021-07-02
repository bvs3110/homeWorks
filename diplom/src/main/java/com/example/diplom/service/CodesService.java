package com.example.diplom.service;

import com.example.diplom.dto.CodesDto;
import com.example.diplom.entity.Codes;
import com.example.diplom.exception.ValidationException;

import java.util.List;

public interface CodesService {
    CodesDto saveCode(CodesDto codesDto) throws ValidationException;
    CodesDto findByCode(String code);
    List<CodesDto> findByArt(String art);
    List<CodesDto> findByArtSize(String art, Integer Size);
}
