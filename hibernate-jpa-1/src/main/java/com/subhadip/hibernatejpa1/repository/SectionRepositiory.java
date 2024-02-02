package com.subhadip.hibernatejpa1.repository;

import com.subhadip.hibernatejpa1.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepositiory extends JpaRepository<Section, Integer> {
}
