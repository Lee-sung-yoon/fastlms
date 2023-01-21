package com.example.fastlms.course.repository;

import com.example.fastlms.course.entity.Course;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<List<Course>> findByCategoryId(long categoryId);


}
