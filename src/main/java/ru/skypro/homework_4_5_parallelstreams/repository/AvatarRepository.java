package ru.skypro.homework_4_5_parallelstreams.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skypro.homework_4_5_parallelstreams.model.Avatar;

import java.util.Optional;

public interface AvatarRepository extends PagingAndSortingRepository<Avatar, Long> {

    Optional<Avatar> findByStudentId(Long studentId);
}
