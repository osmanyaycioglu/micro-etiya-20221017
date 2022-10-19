package org.training.ms.etiya.msorder.services.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.training.ms.etiya.msorder.services.models.EOrderState;
import org.training.ms.etiya.msorder.services.models.Order;

import java.util.List;

public interface IOrderDao extends JpaRepository<Order, Long> {

    @Query("update Order o set o.orderState=?2 where o.orderId=?1")
    @Modifying
    @Transactional
    int updateStatus(Long orderId,
                     EOrderState orderState);

    List<Order> findByOrderState(EOrderState orderState);

    List<Order> findByCustomerNumber(String customerNumber);

    List<Order> findByCustomerNameAndCustomerNumber(String customerName,String customerNumber);

    List<Order> findByCustomerNameAndCustomerNumberOrderByCustomerName(String customerName,String customerNumber);

    @Query("select o from Order o where o.orderState=:st")
    List<Order> searchOrderState(@Param("st") EOrderState orderState);

    @Query(value = "select * from order o where o.order_state=:st",nativeQuery = true)
    List<Order> searchOrderStateNative(@Param("st") EOrderState orderState);

}
