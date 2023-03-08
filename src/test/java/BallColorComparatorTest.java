import com.innowise.internship.comparators.BallColorComparator;
import com.innowise.internship.model.Ball;
import com.innowise.internship.model.Color;
import com.innowise.internship.model.impl.BasketBall;
import com.innowise.internship.model.impl.FootBall;
import com.innowise.internship.model.impl.TennisBall;
import java.util.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BallColorComparatorTest {

    private static Comparator<Ball> comparator;

    @BeforeAll
    static void setComparator() {
        comparator = new BallColorComparator();
    }

    @Test
    void lessThanSituationTest() {
        var o1 = new BasketBall(10, "Nike", Color.RED);
        var o2 = new TennisBall(12, "Adidas", Color.BLUE);

        Assertions.assertTrue(comparator.compare(o1, o2) < 0);
    }

    @Test
    void equalObjectsTest() {
        var o1 = new BasketBall(12, "Nike", Color.RED);
        var o2 = new FootBall(12, "Adidas", Color.RED);

        Assertions.assertEquals(0, comparator.compare(o1, o2));
        Assertions.assertEquals(0, comparator.compare(o1, o1));
    }

    @Test
    void greaterThanSituationTest() {
        var o1 = new BasketBall(10, "Nike", Color.BLUE);
        var o2 = new TennisBall(12, "Adidas", Color.RED);

        Assertions.assertTrue(comparator.compare(o1, o2) > 0);
    }
}