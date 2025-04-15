package sm.ptfs.week2.cms.model;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class B2BEmployee extends Employee{

    private static final Logger log = LogManager.getLogger();
    private final double taxRate;

    public B2BEmployee(String name, double salary, double taxRate) {
        super(name, salary);
        this.taxRate = taxRate;
    }

    @Override
    public void paySalary() {
        log.debug("Salary paid: {}, {}", name, salary);
        payTaxes();
    }

    protected void payTaxes(){
        double tax = taxRate * salary;
        log.debug("Tax paid: {}, {}", name, tax);
    }
}
