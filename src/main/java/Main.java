import java.time.LocalDate;
import java.util.*;


public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        if (employeeMaxSalary != null)
            System.out.println(employeeMaxSalary);

    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year
        Optional<Employee> worker;
        worker = staff.stream().filter((e) ->
                {
                    Calendar date = Calendar.getInstance();
                    date.setTime(e.getWorkStart());
                    return date.get(Calendar.YEAR) == year;
                }).max(Comparator.comparing(Employee::getSalary));
        return worker.orElse(null);
    }

}