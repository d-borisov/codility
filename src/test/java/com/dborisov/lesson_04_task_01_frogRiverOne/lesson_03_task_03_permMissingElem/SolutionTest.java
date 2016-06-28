package com.dborisov.lesson_04_task_01_frogRiverOne.lesson_03_task_03_permMissingElem;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class SolutionTest {


    @Test
    public void negativeSecondIsNotAvailable() throws Exception {
        try {
            forX(1)
                    .andArrayOf()
                    .leaf(-1, 1);
            fail("Here should be an exception because second 0 skipped");
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
            assertThat(e.getMessage(), is("Second should be: 0"));
        }

        try {
            forX(1)
                    .andArrayOf()
                    .leaf(0, 1)
                    .leaf(-1, 1);
            fail("Here should be an exception because second 1 skipped");
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
            assertThat(e.getMessage(), is("Second should be: 1"));
        }
    }

    @Test
    public void secondsShouldGoOneByOne() throws Exception {
        try {
            forX(1)
                    .andArrayOf()
                    .leaf(1, 1);
            fail("Here should be an exception because second 0 skipped");
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
            assertThat(e.getMessage(), is("Second should be: 0"));
        }

        try {

            forX(1)
                    .andArrayOf()
                    .leaf(0, 1)
                    .leaf(2, 1);
            fail("Here should be an exception because second 1 skipped");
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
            assertThat(e.getMessage(), is("Second should be: 1"));
        }
    }

    @Test
    public void testPreconditionsExceedMaximumLenght() throws Exception {
        final SolutionsAssertionsBuilder builder = forX(1).andArrayOf();
        for (int i = 0; i <= Solution.MAXIMUM_LARGE; i++) {
            builder.leaf(i, i);
        }
        builder.done().resultIs(Solution.CANNOT_PASS);
    }

    @Test
    public void testPreconditionsExceedMaximumX() throws Exception {
        forX(Solution.MAXIMUM_LARGE + 1).andArrayOf()
                .leaf(0, 1)
                .done()
                .resultIs(Solution.CANNOT_PASS);
    }

    @Test
    public void testPreconditionsInvalidPositionValue() throws Exception {
        // less than 1
        forX(1).andArrayOf()
                .leaf(0, 0)
                .done()
                .resultIs(Solution.CANNOT_PASS);

        // greater than X
        forX(1).andArrayOf()
                .leaf(0, 2)
                .done()
                .resultIs(Solution.CANNOT_PASS);
    }

    @Test
    public void testPreconditionsWhenXEqualsZero() throws Exception {
        final SolutionsAssertionsBuilder builder = forX(0).andArrayOf();

        int second = 0;
        for (int i = 0; i < new Random().nextInt(1_000_000); i++) {
            builder.leaf(second++, new Random().nextInt());
        }

        builder.done().resultIs(Solution.CANNOT_PASS);
    }

    @Test
    public void cannotPassIfNotEnoughLeafs() throws Exception {
        forX(1).andArrayOf()
                .done()
                .resultIs(Solution.CANNOT_PASS);

        forX(2).andArrayOf()
                .leaf(0, 1)
                .done()
                .resultIs(Solution.CANNOT_PASS);

        forX(3).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 1)
                .done()
                .resultIs(Solution.CANNOT_PASS);
    }

    @Test
    public void notAllPlacesFilledWithLeafs() throws Exception {
        forX(2).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 1)
                .done()
                .resultIs(Solution.CANNOT_PASS);

        forX(2).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 1)
                .leaf(2, 1)
                .leaf(3, 1)
                .done()
                .resultIs(Solution.CANNOT_PASS);

        forX(3).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 2)
                .done()
                .resultIs(Solution.CANNOT_PASS);

        forX(3).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 2)
                .leaf(2, 2)
                .leaf(3, 1)
                .leaf(4, 1)
                .leaf(5, 2)
                .done()
                .resultIs(Solution.CANNOT_PASS);
    }

    @Test
    public void testOneJump() throws Exception {
        forX(1).andArrayOf()
                .leaf(0, 1)
                .done()
                .resultIs(0);

        forX(1).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 1)
                .done()
                .resultIs(0);

        forX(1).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 1)
                .leaf(2, 1)
                .done()
                .resultIs(0);

        forX(1).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 1)
                .leaf(2, 1)
                .leaf(3, 1)
                .done()
                .resultIs(0);

    }

    @Test
    public void testTwoJumps() throws Exception {
        forX(2).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 2)
                .done()
                .resultIs(1);

        forX(2).andArrayOf()
                .leaf(0, 2)
                .leaf(1, 1)
                .done()
                .resultIs(1);

        forX(2).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 1)
                .leaf(2, 2)
                .done()
                .resultIs(2);

        forX(2).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 1)
                .leaf(2, 1)
                .leaf(3, 2)
                .done()
                .resultIs(3);

        forX(2).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 1)
                .leaf(2, 1)
                .leaf(3, 2)
                .leaf(4, 2)
                .leaf(5, 2)
                .done()
                .resultIs(3);

        forX(2).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 1)
                .leaf(2, 1)
                .leaf(3, 1)
                .leaf(4, 1)
                .leaf(5, 2)
                .done()
                .resultIs(5);
    }

    @Test
    public void testThreeJumps() throws Exception {
        forX(3).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 2)
                .leaf(2, 3)
                .done()
                .resultIs(2);

        forX(3).andArrayOf()
                .leaf(0, 2)
                .leaf(1, 1)
                .leaf(2, 3)
                .done()
                .resultIs(2);

        forX(3).andArrayOf()
                .leaf(0, 3)
                .leaf(1, 2)
                .leaf(2, 1)
                .done()
                .resultIs(2);

        forX(3).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 3)
                .leaf(2, 1)
                .leaf(3, 2)
                .done()
                .resultIs(3);

        forX(3).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 2)
                .leaf(2, 1)
                .leaf(3, 3)
                .leaf(4, 2)
                .leaf(5, 2)
                .done()
                .resultIs(3);

        forX(3).andArrayOf()
                .leaf(0, 1)
                .leaf(1, 1)
                .leaf(2, 1)
                .leaf(3, 1)
                .leaf(4, 1)
                .leaf(5, 2)
                .leaf(6, 3)
                .done()
                .resultIs(6);
    }

    @Test
    public void testFromCodility() throws Exception {
        forX(5)
                .andArrayOf()
                .leaf(0, 1)
                .leaf(1, 3)
                .leaf(2, 1)
                .leaf(3, 4)
                .leaf(4, 2)
                .leaf(5, 3)
                .leaf(6, 5)
                .leaf(7, 4)
                .done()
                .resultIs(6);
    }

    private static SolutionsAssertionsBuilder forX(int X) {
        return new SolutionsAssertionsBuilder(X);
    }

    private static class SolutionsAssertionsBuilder {
        private final int X;
        private int[] leafs = new int[0];

        private SolutionsAssertionsBuilder(int X) {
            this.X = X;
        }

        private SolutionsAssertionsBuilder andArrayOf() {
            return new SolutionsAssertionsBuilder(X);
        }

        private SolutionsAssertionsBuilder leaf(int timeInSeconds, int position) {
            final int nextSecondShouldBe = this.leafs.length;
            if (nextSecondShouldBe != timeInSeconds) {
                throw new RuntimeException("Second should be: " + nextSecondShouldBe);
            }

            final IntStream newElement = IntStream.builder().add(position).build();
            this.leafs = IntStream.concat(IntStream.of(this.leafs), newElement).toArray();

            return this;
        }

        private SolutionsAssertions done() {
            return new SolutionsAssertions(this.X, this.leafs);
        }
    }

    private static class SolutionsAssertions {
        private final int X;
        private final int[] A;

        private SolutionsAssertions(int X, int[] A) {
            this.X = X;
            this.A = A;
        }

        private void resultIs(int result) {
            final Solution solution = new Solution();
            assertThat(String.format("For leafs %s and X=%d", Arrays.toString(A), X),
                    solution.solution(X, A),
                    is(result));
        }
    }
}