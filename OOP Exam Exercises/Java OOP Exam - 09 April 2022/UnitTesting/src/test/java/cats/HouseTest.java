package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTest {
    public static final int HOUSE_CAPACITY = 10;
    public static final int HOUSE_MINIMUM_CAPACITY = 1;
    public static final int CAT_COUNT = 2;
    public static final int HOUSE_INVALID_CAPACITY = -1;
    private House house;
    private Cat cat1;
    private Cat cat2;

    @Before
    public void setUp() {
        cat1 = new Cat("Teda");
        cat2 = new Cat("Desa");
        house = new House("shortHouse", HOUSE_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void setNameThrowExceptionSuccessfully() {
        House house = new House("", HOUSE_CAPACITY);
    }

    @Test
    public void getName() {
        Assert.assertEquals(house.getName(), "shortHouse");
    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(house.getCapacity(), HOUSE_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityUnder0ThrowException() {
        House house = new House("flat", HOUSE_INVALID_CAPACITY);
    }


    @Test
    public void getCount() {
        house.addCat(cat1);
        house.addCat(cat2);

        Assert.assertEquals(house.getCount(), CAT_COUNT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCatNoCapacityThrowException() {
        House house = new House("flat", HOUSE_MINIMUM_CAPACITY);
        house.addCat(cat1);
        house.addCat(cat2);
    }

    @Test
    public void removeCatByNameSuccess() {
        house.addCat(cat1);
        house.removeCat("Teda");
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCatByWrongNameThrowException() {
        house.addCat(cat1);
        house.removeCat("Vasil");
    }

    @Test
    public void catForSaleSuccess() {
        house.addCat(cat1);
        house.addCat(cat2);
        Cat testCat = house.catForSale("Desa");

        Assert.assertEquals(cat2,testCat);
        Assert.assertFalse(testCat.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void catForSaleMissingThrowException() {
        house.addCat(cat1);
        house.addCat(cat2);

        house.catForSale("Vasil");
    }

    @Test
    public void testStatistics() {
        house.addCat(cat1);

        Assert.assertEquals(house.statistics(), "The cat Teda is in the house shortHouse!");
    }

}