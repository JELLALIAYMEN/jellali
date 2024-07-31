package com.example.gestioncantine.Rep;

import com.example.gestioncantine.dto.MenuDTO;
import com.example.gestioncantine.entites.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Menurep extends JpaRepository<Menu, Long> {



}
