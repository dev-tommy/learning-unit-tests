package pl.devtommy.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newAccountShouldNotBeActivateAfterCreation() {
        //given, when
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive(), "Check if new account is not active");
    }

    @Test
    void accountShouldBeActivateAfterActivation() {
        //given
        Account newAccount = new Account();
        //when
        newAccount.activate();
        //then
        assertTrue(newAccount.isActive(),"Check if new account is active");
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
        //given
        Account account = new Account();
        //when
        Address address = account.getDefaultDeliveryAddress();
        //then
        assertNull(address);

    }
}
