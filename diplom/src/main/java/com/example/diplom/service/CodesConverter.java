package com.example.diplom.service;

import com.example.diplom.dto.CodesDto;
import com.example.diplom.entity.Codes;
import org.springframework.stereotype.Component;

@Component
public class CodesConverter {
   public Codes fromCodesDtoToCodes(CodesDto codesDto){
       Codes codes = new Codes();
       codes.setId(codesDto.getId());
       codes.setCode(codesDto.getCode());
       codes.setArt(codesDto.getArt());
       codes.setSize(codesDto.getSize());
       return codes;
   }
   public CodesDto fromCodesToCodesDto(Codes codes){
       CodesDto codesDto = new CodesDto();
       codesDto.setId(codes.getId());
       codesDto.setCode(codes.getCode());
       codesDto.setArt(codes.getArt());
       codesDto.setSize(codes.getSize());
       return codesDto;
   }
}
