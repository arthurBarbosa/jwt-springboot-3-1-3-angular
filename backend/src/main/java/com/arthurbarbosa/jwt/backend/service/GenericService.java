package com.arthurbarbosa.jwt.backend.service;

import com.arthurbarbosa.jwt.backend.dtos.GenericDTO;
import com.arthurbarbosa.jwt.backend.exceptions.AppException;
import com.arthurbarbosa.jwt.backend.repositories.GenericRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class GenericService<E, D extends GenericDTO, R extends JpaRepository<E, Long>> {
    protected final R repository;

    protected abstract E copyDtoToEntity(D dto);

    protected abstract D copyEntityToDto(E entity);

    public D findById(Long id) {
        var e = repository.findById(id).orElseThrow(() -> new AppException("Entity Not found", HttpStatus.NOT_FOUND));
        var d = copyEntityToDto(e);
        return d;
    }

}
