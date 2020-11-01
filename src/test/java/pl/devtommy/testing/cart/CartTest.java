package pl.devtommy.testing.cart;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.devtommy.testing.Meal;
import pl.devtommy.testing.cart.Cart;
import pl.devtommy.testing.order.Order;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test cases for Cart")
class CartTest {

    @Disabled
    @Test
    @DisplayName("Cart is able to process 1000 orders in 10ms")
    void simulateLargeOrder() {
        //given
        Cart cart = new Cart();

        //when, then
        assertTimeout(Duration.ofMillis(10), cart::simulateLargeOrder);
    }

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToCart() {
        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(), anyOf( //one condition is enough
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertAll("This is a group assertions fo cart",
                () -> assertThat(cart.getOrders(), notNullValue()) ,
                () -> assertThat(cart.getOrders(), hasSize(1)) ,
                () -> assertThat(cart.getOrders(), is(not(empty()))) ,
                () -> assertThat(cart.getOrders(), is(not(emptyCollectionOf(Order.class)))),
                () -> assertThat(cart.getOrders().get(0).getMeals(), empty()),
                () -> {
                    List<Meal> mealList = cart.getOrders().get(0).getMeals();
                    assertThat(mealList, empty());
                }

        );
    }
}