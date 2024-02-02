package com.subhadip.hibernatejpa1.repository;

import com.subhadip.hibernatejpa1.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
