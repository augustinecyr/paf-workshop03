package com.sg.app.pafworkshopd3.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static com.sg.app.pafworkshopd3.repository.Queries.*;

import com.sg.app.pafworkshopd3.models.OrderDetails;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderDetails getDiscountedOrderDetails(Integer orderId) {
        // prevent inheritance
        final List<OrderDetails> ordDetails = new LinkedList<>();
        // perform the query
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_ORDER_DETAILS_WITH_DISCOUNT, orderId);

        while (rs.next()) {
            ordDetails.add(OrderDetails.create(rs));
        }
        return ordDetails.get(0);
    }
}