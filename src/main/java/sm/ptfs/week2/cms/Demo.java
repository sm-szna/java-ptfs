package sm.ptfs.week2.cms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sm.ptfs.week2.cms.model.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Demo {
    private static Logger log = LoggerFactory.getLogger(Demo.class);

    static Random r = new Random();
    static String[] randomEmployeeNames = {
            "Lena Whitaker",
            "Marcus Velez",
            "Ava Thornton",
            "Jasper Lin",
            "Nina Patel",
            "Elliot Granger",
            "Sofia Mendes",
            "Caleb O'Connor",
            "Diana Koenig",
            "Omar Alvarez"
    };
    static double defaultTaxRate = 0.05;

    public static void run(){
        Company company = Company.createCompany("HardwareMind S.A.");

        Project projectBest = Project.createProject("BEPITEW: BEst Project In ThE World");
        Project projectYaap = Project.createProject("YAAP: Yet Another Average Project");

        company.addProject(projectBest);
        company.addProject(projectYaap);

        Random r = new Random();
        Set<Employee> employees = generateRandomEmployees(10);
        for(Employee emp : employees){
            company.addEmployee(emp);
            (r.nextBoolean() ? projectBest : projectYaap).addEmployee(emp);
        }

        company.paySalary();

        log.info("Paying to project test...");
        for(Project project : company.getProjects()) {
            company.paySalary(project);
        }

        log.info("Paying to employee test...");
        for (Employee employee : employees) {
            company.paySalary(employee);
        }

        log.info("PReassign test...");
        for (Employee employee : employees) {
            company.reassignEmployee(employee, projectYaap, projectBest);
        }
    }

    public static Employee generateRandomEmployee(){
        String name = randomEmployeeNames[r.nextInt(randomEmployeeNames.length)];
        double salary = getRandomSalary(70,99);
        return r.nextBoolean() ? new B2BEmployee(name, salary, defaultTaxRate) : new ContractEmployee(name, salary);
    }

    public static Set<Employee> generateRandomEmployees(int numberOfEmployees){
        Set<Employee> employees = new HashSet<>();
        for(int i = 0; i < numberOfEmployees; i++){
            employees.add(generateRandomEmployee());
        }
        return employees;
    }

    private static double getRandomSalary(Integer from, Integer to){
        return r.nextDouble(from, to) * 100;
    }
}
