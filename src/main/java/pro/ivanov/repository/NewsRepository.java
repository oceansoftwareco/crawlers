package pro.ivanov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import pro.ivanov.entity.News;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface NewsRepository extends PagingAndSortingRepository<News, Long>, JpaRepository<News, Long> {
    Page<News> findAll(Pageable pageable);

    List<News> findAllByDate(LocalDate date);

    Page<News> findAllByDate(LocalDate date, Pageable pageable);
}
