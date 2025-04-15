package sm.ptfs.week2.cms.model;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class Company {
    private static final Logger log = LogManager.getLogger();

    private final String name;
    private final Set<Employee> employees = new HashSet<>();
    private final Set<Project> projects = new HashSet<>();

    private Company(String name){
        this.name = name;
    }

    public static Company createCompany(String name){
        return new Company(name);
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void reassignEmployee(Employee emp, Project from, Project to){
        if (from.getEmployees().contains(emp)) {
            emp.removeFromProject(from);
            emp.assignToProject(to);
            log.debug("Reassigned: {} from: {} to: {}",  emp.getName(), from.getName(), to.getName());
        } else {
            log.debug("Employee: {} is not assigned to a project: {}", emp.getName(), from.getName());
        }
    }

    public void paySalary(Employee emp) {
        log.debug("Paying to employee: {}", emp.getName());
        emp.paySalary();
    }

    public void paySalary(Project project) {
        log.debug("Paying to employees from project: {}", project.getName());
        for (Employee emp : project.getEmployees()) {
            emp.paySalary();
        }
    }

    public void paySalary() {
        log.debug("Paying to company employees: {}", name);
        for (Employee emp : employees) {
            emp.paySalary();
        }
    }

    public Set<Project> getProjects() {
        return projects;
    }
}
