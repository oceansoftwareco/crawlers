package org.ivanovx.respositories;

import org.ivanovx.models.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends PagingAndSortingRepository<News, Long>, CrudRepository<News, Long> {
    Page<News> findAll(Pageable pageable);
}
