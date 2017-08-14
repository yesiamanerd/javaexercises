/*
7.10 (Sales Commissions) Use a one-dimensional array to solve the following problem: A com-
pany pays its salespeople on a commission basis. The salespeople receive $200 per week plus 9% of
their gross sales for that week. For example, a salesperson who grosses $5,000 in sales in a week re-
ceives $200 plus 9% of $5,000, or a total of $650. Write an application (using an array of counters)
that determines how many of the salespeople earned salaries in each of the following ranges (assume
that each salesperson’s salary is truncated to an integer amount):
a) $200–299
b) $300–399
c) $400–499
d) $500–599
e) $600–699
f) $700–799
g) $800–899
h) $900–999
i) $1,000 and over
Summarize the results in tabular format.
*/

public class Ex_0710_SalesCommission {
    public static void main(String[] args){
        int[] sales = { 5000, 2300, 7300, 7400, 6900, 7500, 6800 };

        int[] salaries = calculateSalaries(sales);

        System.out.printf("%s%n%n", "Occurrences of salaries within a range:");
        displaySalaryRanges(salaries);
    }

    private static int[] calculateSalaries(int[] values) {
        int[] calculatedValues = new int[values.length];

        for(int i = 0; i < values.length; i++){
            calculatedValues[i] = (int)(200 + values[i] * 0.09);
        }

        return calculatedValues;
    }

    public static void displaySalaryRanges(int[] salaries){
        System.out.printf("%12s%12s%n", "Range", "Quantity");

        int[] frequency = new int[12];

        for(int value : salaries)
            frequency[(value / 100)]++;

        for(int i = 0; i < 9; i++) {

            // print range labels
            if (i == 8)
                System.out.printf("%5s ", "$1,000 and over");
            else
                System.out.printf("       $%5s ", (200 + i * 100) + "-" + (299 + i * 100));

            // print occurrences
            for(int stars = 0; stars < frequency[i + 2]; stars++)
                System.out.printf("%s", "*");

            System.out.println();
        }
    }
}
