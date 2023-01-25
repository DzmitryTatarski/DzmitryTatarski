import bubbleSort.BubbleSort;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class BubbleSortTest {

    @DataProvider(name = "input")
    public static Object[][] input(){
        return new Object[][] {
                {List.of(1,4,5,6,8,3,8), List.of(1,3,4,5,6,8,8)},
                {List.of(-9.3,0.2,4,0.1,5,9), List.of(-9.3,0.1,0.2,4,5,9)},
                {List.of(), List.of()},
                {Stream.of(null, (Number) 5.0001).toList(), List.of(5.0001)}
        };
    }

    @Test(dataProvider = "input")
    public void test(List<Number> input, List<Number> result){
        BubbleSort bubbleSort = new BubbleSort();
        Assert.assertEquals(bubbleSort.sort(input), result);
    }

    @Test(expectedExceptions = {RuntimeException.class})
    public void testNull(){
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(null);
    }

}
