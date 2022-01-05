package com.db.app.database.repository;

import com.db.app.database.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetails.Id> {
    List<OrderDetails> findByIdOrderIDId(Long orderId);
}
