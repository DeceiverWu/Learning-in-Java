package effectivejava.item2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-24
 * Time: 10:30
 */
public class NutritionFactsTest {

    public static void main(String[] args) {
        NutritionFacts1 nutritionFacts1 = new NutritionFacts1.Builder(240, 8).calories(2).carbohydrate(20).build();
    }

}
