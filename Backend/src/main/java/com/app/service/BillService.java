package com.app.service;

import com.app.entities.Bill;

public interface BillService {
 Bill generateBill(Bill bill);
 
 Bill getBillByOrderId(Long oid);
 
 Bill getBillById(Long id);
}
