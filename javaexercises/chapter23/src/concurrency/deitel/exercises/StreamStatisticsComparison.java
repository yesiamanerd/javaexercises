package concurrency.deitel.exercises;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.LongSummaryStatistics;
import java.util.stream.LongStream;

public class StreamStatisticsComparison {

    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        // create array of random long values
        long[] values = generator.longs(10_000_000, 1, 1_001).toArray();

        // perform calculations separately
        Instant separateStart = Instant.now();
        long count = Arrays.stream(values).count();
        long sum = Arrays.stream(values).sum();
        long min = Arrays.stream(values).min().getAsLong();
        long max = Arrays.stream(values).max().getAsLong();
        double average = Arrays.stream(values).average().getAsDouble();
        Instant separateEnd = Instant.now();

        // display results
        System.out.println("Calculations performed separately:");
        System.out.printf("    count: %d%n", count);
        System.out.printf("      sum: %d%n", sum);
        System.out.printf("      min: %d%n", min);
        System.out.printf("      max: %d%n", max);
        System.out.printf("  average: %f%n", average);
        System.out.printf("Total time in milliseconds: %d%n%n",
                Duration.between(separateStart, separateEnd).toNanos());


        // time sum operation with sequential stream
        LongStream stream1 = Arrays.stream(values).sequential();
        System.out.println("Calculating statistics with sequential stream:");
        Instant sequentialStart = Instant.now();
        LongSummaryStatistics results1 = stream1.summaryStatistics();
        Instant sequentialEnd = Instant.now();

        // display results
        displayStatistics(results1);
        System.out.printf("Total time in milliseconds: %d%n%n",
                Duration.between(sequentialStart, sequentialEnd).toNanos());

        // time sum operations with parallel stream
        LongStream stream2 = Arrays.stream(values).parallel();
        System.out.println("Calculating statistics on Parallel Stream");
        Instant parallelStart = Instant.now();
        LongSummaryStatistics results2 = stream2.summaryStatistics();
        Instant parallelEnd = Instant.now();


        // display results
        displayStatistics(results1);
        System.out.printf("Total time in milliseconds: %d%n%n",
                Duration.between(sequentialStart, sequentialEnd).toNanos());

    }

    // display LongSummaryStatistics values
    private static void displayStatistics(LongSummaryStatistics stats){
        System.out.println("Statistics");
        System.out.printf("    count: %d%n", stats.getCount());
        System.out.printf("      sum: %d%n", stats.getSum());
        System.out.printf("      min: %d%n", stats.getMin());
        System.out.printf("      max: %d%n", stats.getMax());
        System.out.printf("  average: %f%n", stats.getAverage());
    }
}
