import balancedWordsCounter.BalancedWordsCounter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BalancedWordsCounterTest {

    @DataProvider(name = "correctInput")
    public static Object[][] correctInput(){
        return new Object[][] {
                {"aabbabcccba", 28},
                {"", 0}
        };
    }

    @DataProvider(name = "incorrectInput")
    public static Object[][] incorrectInput(){
        return new Object[][] {
                {"abababa1"},
                {null}
        };
    }

    @Test(dataProvider = "correctInput")
    public void correctInputTest(String input, Integer result){
        BalancedWordsCounter balancedWordsCounter = new BalancedWordsCounter();
        Assert.assertEquals(balancedWordsCounter.count(input), result);
    }

    @Test(dataProvider = "incorrectInput", expectedExceptions = {RuntimeException.class})
    public void incorrectInputTest(String input){
        BalancedWordsCounter balancedWordsCounter = new BalancedWordsCounter();
        balancedWordsCounter.count(input);
    }
}
