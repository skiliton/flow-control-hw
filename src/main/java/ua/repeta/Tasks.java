package ua.repeta;

import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Tasks {

    private Tasks() {
    }

    public static long task1(int a, int b) {
        if (b > 9 || b < 0) {
            throw new IllegalArgumentException("Argument b has to be a single digit");
        }
        if (a < 0) {
            throw new IllegalArgumentException("Argument a cannot be negative");
        }
        if (a<10) {
            return a==b ? 1 : 0;
        }
        return IntStream
                .iterate(1, v -> v < a, v -> v * 10)
                .map(v -> (a / v) % 10)
                .filter(v -> v == b)
                .count();
    }

    public static IntSummaryStatistics task2(Scanner scanner) {
        return IntStream.iterate(0, v -> scanner.hasNextInt(), Math::incrementExact)
                .map(v -> scanner.nextInt())
                .summaryStatistics();
    }

    public static List<String> task3A(int height) {
        return streamTableValues(0)
                .limit(height)
                .map(str -> String.format("%-" + height * 2 + "s", str))
                .collect(Collectors.toList());
    }

    public static List<String> task3B(int height) {
        return streamTableValues(1)
                .limit(height)
                .map(str -> String.format("%" + height * 2 + "s", str))
                .collect(Collectors.toList());
    }

    private static Stream<String> streamTableValues(int seed) {
        return IntStream
                .iterate(0, Math::incrementExact)
                .mapToObj(v ->
                        IntStream.rangeClosed(seed, seed + v)
                )
                .map(stream -> stream
                        .mapToObj(i -> i + " ")
                        .collect(
                                StringBuffer::new,
                                StringBuffer::append,
                                StringBuffer::append
                        )
                )
                .map(StringBuffer::reverse)
                .map(StringBuffer::toString);
    }

}
