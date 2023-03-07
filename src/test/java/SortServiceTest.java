import com.innowise.internship.comparators.BallSizeComparator;
import com.innowise.internship.model.Ball;
import com.innowise.internship.model.Color;
import com.innowise.internship.model.impl.BaseBall;
import com.innowise.internship.model.impl.BasketBall;
import com.innowise.internship.model.impl.FootBall;
import com.innowise.internship.model.impl.TennisBall;
import com.innowise.internship.sort.SortService;
import com.innowise.internship.sort.impl.OddEvenSortServiceImpl;
import com.innowise.internship.sort.impl.QuickSortServiceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SortServiceTest {

    static Stream<SortService> sortServiceStream() {
        return Stream.of(
            new OddEvenSortServiceImpl(),
            new QuickSortServiceImpl()
        );
    }

    @ParameterizedTest
    @MethodSource("sortServiceStream")
    void oddCountElementsTestDefaultScenario(SortService sortService) {
        var actual = Arrays.asList(
            new BaseBall(6, "Demix", Color.BLACK),
            new FootBall(2, "Anta", Color.GREEN),
            new BasketBall(4, "Nike", Color.RED),
            new FootBall(6, "Nike", Color.GREEN),
            new BaseBall(12, "Adidas", Color.BLUE));


        var expected = new ArrayList<>(actual);

        sortService.sort(actual, new BallSizeComparator());
        expected.sort(new BallSizeComparator());

        Assertions.assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("sortServiceStream")
    void evenCountElementsTestDefaultScenario(SortService sortService) {
        var actual = Arrays.asList(
            new BaseBall(6, "Demix", Color.BLACK),
            new FootBall(2, "Anta", Color.GREEN),
            new BasketBall(4, "Nike", Color.RED),
            new FootBall(6, "Nike", Color.GREEN),
            new BaseBall(12, "Adidas", Color.BLUE),
            new TennisBall(32, "Nike", Color.RED));

        var expected = new ArrayList<>(actual);

        sortService.sort(actual, new BallSizeComparator());
        expected.sort(new BallSizeComparator());

        Assertions.assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("sortServiceStream")
    void emptyArraySortTest(SortService sortService) {
        var actual = new ArrayList<Ball>();
        var expected = new ArrayList<Ball>();

        Assertions.assertDoesNotThrow(() -> sortService.sort(actual, new BallSizeComparator()));
        Assertions.assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("sortServiceStream")
    void oneElementArrayTest(SortService sortService) {
        var actual = new ArrayList<>(List.of(new Ball[]{
            new BaseBall(6, "Nike", Color.BLUE)
        }));

        var expected = new ArrayList<>(actual);

        Assertions.assertDoesNotThrow(() -> sortService.sort(actual, new BallSizeComparator()));
        Assertions.assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("sortServiceStream")
    void reversedArrayTest(SortService sortService) {
        var actual = Arrays.asList(
            new BaseBall(12, "Demix", Color.BLACK),
            new FootBall(7, "Anta", Color.GREEN),
            new BasketBall(6, "Nike", Color.RED),
            new FootBall(4, "Nike", Color.GREEN),
            new BaseBall(2, "Adidas", Color.BLUE));

        var expected = new ArrayList<>(actual);

        sortService.sort(actual, new BallSizeComparator());
        expected.sort(new BallSizeComparator());

        Assertions.assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("sortServiceStream")
    void twoElementArrayTest(SortService sortService) {
        var actual = Arrays.asList(
            new BaseBall(12, "Demix", Color.BLACK),
            new FootBall(7, "Anta", Color.GREEN));

        var expected = new ArrayList<>(actual);

        sortService.sort(actual, new BallSizeComparator());
        expected.sort(new BallSizeComparator());

        Assertions.assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("sortServiceStream")
    void sameSizeElementArrayTest(SortService sortService) {
        var actual = Arrays.asList(
            new BaseBall(2, "Demix", Color.BLACK),
            new FootBall(2, "Anta", Color.GREEN),
            new BasketBall(2, "Nike", Color.RED),
            new FootBall(2, "Nike", Color.GREEN),
            new BaseBall(2, "Adidas", Color.BLUE));

        var expected = new ArrayList<>(actual);

        sortService.sort(actual, new BallSizeComparator());

        Assertions.assertIterableEquals(expected, actual);
    }
}
