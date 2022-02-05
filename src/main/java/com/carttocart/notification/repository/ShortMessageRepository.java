package com.carttocart.notification.repository;

import com.carttocart.notification.model.entity.ShortMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShortMessageRepository extends JpaRepository<ShortMessage, Long> {

    @Query("select t from ShortMessage t where t.sendingFlag = false and t.counter < 10 order by t.creationDate desc")
    List<ShortMessage> shortMessageList(Pageable pageable);
}
