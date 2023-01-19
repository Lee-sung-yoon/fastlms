package com.example.fastlms.course.repository;

import com.example.fastlms.course.entity.Course;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.time.LocalDateTime;

public interface CourseRepository extends JpaRepository<Course, Long> {


}
