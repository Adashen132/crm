package com.cyb.crm.workbench.dao;

import com.cyb.crm.workbench.domain.Customer;

public interface CustomerDao {

    Customer getCustomerByName(String company);

    int save(Customer cus);
}
