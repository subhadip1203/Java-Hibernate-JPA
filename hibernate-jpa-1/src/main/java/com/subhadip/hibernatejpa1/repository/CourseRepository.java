package com.subhadip.hibernatejpa1.repository;

import com.subhadip.hibernatejpa1.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
