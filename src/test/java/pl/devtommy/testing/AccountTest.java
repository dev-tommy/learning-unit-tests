package pl.devtommy.testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newAccountShouldNotBeActivateAfterCreation() {
        //given, when
        Account newAccount = new Account();
        //then
        //assertFalse(newAccount.isActive(), "Check if new account is not active");
        //assertThat(newAccount.isActive(), equalTo(false));
        assertThat(newAccount.isActive(), is(false));
    }

    @Test
    void accountShouldBeActivateAfterActivation() {
        //given
        Account newAccount = new Account();
        //when
        newAccount.activate();
        //then
        //assertTrue(newAccount.isActive(),"Check if new account is active");
        assertThat(newAccount.isActive(), is(true));
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
        //given
        Account account = new Account();
        //when
        Address address = account.getDefaultDeliveryAddress();
        //then
        //assertNull(address);
        assertThat(address, is(nullValue()));
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
        //given
        Address address = new Address("Street", "10");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);
        //when
        address = account.getDefaultDeliveryAddress();
        //then
        //assertNotNull(address);
        assertThat(address, is(notNullValue()));
    }
}
