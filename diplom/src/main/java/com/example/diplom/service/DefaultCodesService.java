package com.example.diplom.service;


import com.example.diplom.dto.CodesDto;
import com.example.diplom.entity.Codes;
import com.example.diplom.exception.ValidationException;
import com.example.diplom.repository.CodesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultCodesService implements CodesService {
    private final CodesRepository codesRepository;
    private final CodesConverter codesConverter;

    public CodesDto saveCode(CodesDto codesDto) throws ValidationException {
        validateCodesDto(codesDto);
        Codes savedCodes = codesRepository.save(codesConverter.fromCodesDtoToCodes(codesDto));
        return codesConverter.fromCodesToCodesDto(savedCodes);
    }

    public CodesDto findByCode(String code) {
        Codes codes = codesRepository.findByCode(code);
        if (codes != null) {
            return codesConverter.fromCodesToCodesDto(codes);
        }
        return null;
    }

    public List<CodesDto> findByArt(String art) {
        return codesRepository.findByArt(art)
                .stream()
                .map(codesConverter::fromCodesToCodesDto)
                .collect(Collectors.toList());
    }

    public List<CodesDto> findByArtSize(String art, Integer size) {
        return codesRepository.findByArtSize(art, size)
                .stream()
                .map(codesConverter::fromCodesToCodesDto)
                .collect(Collectors.toList());
    }

    private void validateCodesDto(CodesDto codesDto) throws ValidationException {
        if (isNull(codesDto)) {
            throw new ValidationException("Объект codes не установлен");
        }
        if (isNull(codesDto.getCode()) || codesDto.getCode().isEmpty()) {
            throw new ValidationException("Поле code пустое");
        }
        if (isNull(codesDto.getArt()) || codesDto.getArt().isEmpty()) {
            throw new ValidationException("Поле art пустое");
        }
    }

}
