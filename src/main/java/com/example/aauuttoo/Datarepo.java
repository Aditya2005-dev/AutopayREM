package com.example.aauuttoo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Datarepo extends JpaRepository<Model, Integer> {

}