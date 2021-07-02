package com.example.diplom.repository;

import com.example.diplom.dto.CodesDto;
import com.example.diplom.entity.Codes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodesRepository extends JpaRepository<Codes, Integer> {
    Codes findByCode(String code);
    List<Codes> findByArt(String art);
    @Query("SELECT c FROM Codes c WHERE c.art = ?1 AND c.size = ?2")
    List<Codes> findByArtSize(String art, Integer Size);
}
