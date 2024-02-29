package com.automation.example.hybrid.repository;

import com.automation.example.hybrid.tables.Data;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends JpaRepository<Data, String> {
    List<Data> findByWordStartingWith(String startsWith);
}
