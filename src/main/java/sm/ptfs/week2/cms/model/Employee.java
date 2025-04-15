package sm.ptfs.week2.cms.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public abstract class Employee {
    private static final Logger log = LogManager.getLogger();
    protected String name;
    protected double salary;
    protected Set<Project> projects = new HashSet<>();

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void assignToProject(Project project) {
        log.debug("Employee assigned to project: [{}] {}", project.getName(), name);
        project.addEmployee(this);
        projects.add(project);
    }

    public void removeFromProject(Project project) {
        log.debug("Employee removed from project: [{}] {}", project.getName(), name);
        project.removeEmployee(this);
        projects.remove(project);
    }

    public abstract void paySalary();

    public String getName() {
        return name;
    }
}
