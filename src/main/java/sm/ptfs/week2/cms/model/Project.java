package sm.ptfs.week2.cms.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class Project {
    private static final Logger log = LogManager.getLogger();
    String name;
    Set<Employee> employees = new HashSet<>();

    private Project(String name) {
        this.name = name;
    }

    public static Project createProject(String name){
        return new Project(name);
    }

    public void addEmployee(Employee emp){
        log.debug("Employee added to project: [{}] {}", name, emp.name);
        employees.add(emp);
    }

    public void removeEmployee(Employee emp){
        log.debug("Employee removed to project: [{}] {}", name, emp.name);
        employees.remove(emp);
    }

    public Set<Employee> getEmployees(){
        return employees;
    }

    public String getName(){
        return name;
    }

}
