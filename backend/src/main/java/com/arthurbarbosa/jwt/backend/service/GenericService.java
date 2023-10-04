package com.arthurbarbosa.jwt.backend.service;

import com.arthurbarbosa.jwt.backend.dtos.GenericDTO;
import com.arthurbarbosa.jwt.backend.exceptions.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public Page<D> findAll(Pageable pageable) {
        Page<E> result = repository.findAll(pageable);
        return result.map(x -> copyEntityToDto(x));
    }

    @Transactional
    public D insert(D dto) {
        E e = copyDtoToEntity(dto);
        E entitySave = repository.save(e);
        return copyEntityToDto(entitySave);
    }


    @Transactional
    public D update(Long id, D dto) {
        E product = repository.findById(id).orElseThrow(() -> new AppException("Entity Not found", HttpStatus.NOT_FOUND));
        product = copyDtoToEntity(dto);
        E save = repository.save(product);
        return copyEntityToDto(save);
    }
}
