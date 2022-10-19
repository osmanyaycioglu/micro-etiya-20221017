package org.training.ms.etiya.msorder.rest.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.training.ms.etiya.msorder.rest.models.MealRest;
import org.training.ms.etiya.msorder.rest.models.OrderRest;
import org.training.ms.etiya.msorder.services.models.Meal;
import org.training.ms.etiya.msorder.services.models.Order;

import java.util.List;

@Mapper
public interface IOrderMapper {

    IOrderMapper ORDER_MAPPER = Mappers.getMapper(IOrderMapper.class);

    @Mapping(source = "customer",target = "customerName")
    Order toOrder(OrderRest orderRest);

    @Mapping(source = "customerName",target = "customer")
    OrderRest toOrderRest(Order order);

    Meal toMeal(MealRest meal);

    MealRest toMealRest(Meal meal);

    List<Order> toOrders(List<OrderRest> orderRest);

    List<OrderRest> toOrderRests(List<Order> order);

    List<Meal> toMeals(List<MealRest> meal);

    List<MealRest> toMealRests(List<Meal> meal);


}
