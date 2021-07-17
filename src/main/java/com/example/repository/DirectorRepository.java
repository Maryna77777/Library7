package com.example.repository;

import com.example.entity.Director;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DirectorRepository extends JpaRepository<Director,Long> {
    Director findByLastNameDirector(String lastNameDirector);
    Page<Director> findAll(Pageable pageable);
  //  Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
