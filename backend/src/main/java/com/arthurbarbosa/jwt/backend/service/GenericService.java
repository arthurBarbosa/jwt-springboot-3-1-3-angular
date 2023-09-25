package com.arthurbarbosa.jwt.backend.service;

import com.arthurbarbosa.jwt.backend.repositories.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericService<T, ID, R extends GenericRepository<T, ID>> {

    protected R repository;


}
