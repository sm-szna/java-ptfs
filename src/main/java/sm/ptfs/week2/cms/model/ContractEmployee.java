package sm.ptfs.week2.cms.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContractEmployee extends Employee{
    private static final Logger log = LogManager.getLogger();

    public ContractEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void paySalary() {
        log.debug("Salary paid: {}, {}", name, salary);
    }


}
