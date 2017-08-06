import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {
   public static void main(String[] args){
      // initialize array of Employees
      Employee[] employees = {
         new Employee("Jason", "Red", 5000, "IT"),
         new Employee("Ashley", "Green", 7600, "IT"),
         new Employee("Matthew", "Indigo", 3587.5, "Sales"),
         new Employee("James", "Indigo", 4700.77, "Marketing"),
         new Employee("Luke", "Indigo", 6200, "IT"),
         new Employee("Jason", "Blue", 3200, "Sales"),
         new Employee("Wendy", "Brown", 4236.5, "Marketing")
      };

      // get List view of Employeeds
      List<Employee> list = Arrays.asList(employees);

      // display all Employees
      System.out.println("Complete Employee list:");
      list.stream().forEach(System.out::println);

      // Predicate that returns true for salaries in the range $4000-$6000
      Predicate<Employee> fourToSixThousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

      // display Employees with salaries in the range of $4000 to $6000
      // sorted into ascending order by salary
      System.out.printf(
         "%nEmployees earning $4000-$6000 per month sorted by salary: %n");
      list.stream().filter(fourToSixThousand)
         .sorted(Comparator.comparing(Employee::getSalary))
         .forEach(System.out::println);

      // display first Employee with salary in the range $4000-$6000
      System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
         list.stream()
            .filter(fourToSixThousand)
            .findFirst()
            .get());









      // Functions for getting first and last names from an Employee
      Function<Employee, String> byFirstName = Employee::getFirstName;
      Function<Employee, String> byLastName = Employee::getLastName;

      // Comparator for comparing Employees by first name then last name
      Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

      // sort Employees by last name, then first name
      System.out.printf(
         "%nEmployees in ascending order by last name then first:%n");
      list.stream()
         .sorted(lastThenFirst)
         .forEach(System.out::println);

      // sort employees in descending order by last name, then first name
      System.out.printf(
         "%nEmployees in descending order by last name then fist name:%n"
      );
      list.stream()
         .sorted(lastThenFirst.reversed())
         .forEach(System.out::println);

      // display unique employee last names sorted
      System.out.printf("%nUnique employee last names:%n");
      list.stream()
         .map(Employee::getLastName)
         .distinct()
         .sorted()
         .forEach(System.out::println);

      // display only first and last names
      System.out.printf("%nEmployee names in order by last name then first name:%n");
      list.stream()
         .sorted(lastThenFirst)
         .map(Employee::getName)
         .forEach(System.out::println);

      // group Employees by department
      System.out.printf("%nEmployees by department: %n");
      Map<String, List<Employee>> groupedByDepartment =
         list.stream()
         .collect(Collectors.groupingBy(Employee::getDepartment));
      groupedByDepartment.forEach(
         (department, employeesInDepartment) ->
         {
            System.out.println(department);
            employeesInDepartment.forEach(
               employee -> System.out.printf("    %s%n", employee.getName())
            );
         }
      );


      // count number of Employees in each department
      System.out.printf("%nCount of Employees by department:%n");
      Map<String, Long> employeeCountByDepartment =
         list.stream()
         .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
      employeeCountByDepartment.forEach(
         (department, count) -> System.out.printf(
            "%s has %d employee(s)%n", department, count)
         );


      // sum of Employee salaries with DoubleStream sum method
      System.out.printf(
         "%nSum of Employees' salaries (via sum method): $ %.2f%n",
         list.stream()
            .mapToDouble(Employee::getSalary)
         .sum());

      // calculate sum of Employee salaries with Stream reduce method
      System.out.printf(
         "%nSum of Employees' salaries (via reduce method): $ %.2f%n",
         list.stream()
            .mapToDouble(Employee::getSalary)
            .reduce(0, (value1, value2) -> value1 + value2)
      );

      // average of Employees salaries with DoubleStream average method
      System.out.printf("%nAverage of Employees' salaries: $ %.2f%n",
         list.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .getAsDouble());


   }
}
