
package com.highway.bakery.repo;

import com.highway.bakery.model.Order;
import com.highway.bakery.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(OrderStatus status);

    @Query("select o from Order o where cast(o.id as string) like concat('%', ?1, '%') or o.customerPhone like concat('%', ?1, '%')")
    List<Order> search(String query);
}
