package edu.javial.testNG.explore;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * DataProviders smoke test ala example found in
 *
 * @see <a href="http://practicalunittesting.com/">
 *     Practical Unit Testingwith TestNG and Mockito
 *      <i>Tomek Kaczanowski</i></a>
 */
@Test
public class ExploreTestNGDataProvidersTest {
    /**
     * notice that the book has this as a static method, but that's not necessary
     */
    @DataProvider
    private final Object[][] getMoney() {
        return new Object[][]{
                {10, "USD"},
                {20, "EUR"}
        };
    }

    class Money {
        private final int amount;
        private final String currency;

        public Money(int amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        public int getAmount() {
            return amount;
        }

        public String getCurrency() {
            return currency;
        }

        public boolean equals(Object o) {
            if (o instanceof Money) {
                Money money = (Money) o;
                return money.getCurrency().equals(getCurrency())
                        && getAmount() == money.getAmount();
            }
            return false;
        }
    }

    /**
     * smoke test: injecting test data via DataProviders annotation
     * @param amount money
     * @param currency species
     */
    @Test(dataProvider = "getMoney")
    public void constructorShouldSetAmountAndCurrency(
            int amount, String currency) {
        Money money = new Money(amount, currency);
        assertEquals(money.getAmount(), amount);
        assertEquals(money.getCurrency(), currency);
    }
}

