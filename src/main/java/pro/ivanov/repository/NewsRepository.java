package pro.ivanov.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import pro.ivanov.entity.News;

import java.util.Optional;

@Repository
public interface NewsRepository extends PagingAndSortingRepository<News, Long> {
    Page<News> findAll(Pageable pageable);

    Optional<News> findById(long id);
}
