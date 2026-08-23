/* IPaymentService.java
   Payment Service Interface
   Author: Bongikazi Mnyamana (222718404) */

package za.ac.cput.service;

import za.ac.cput.domain.Payment;

public interface IPaymentService extends IService<Payment, Long> {

    Payment read(Long paymentId);
    boolean delete(Long paymentId);
}