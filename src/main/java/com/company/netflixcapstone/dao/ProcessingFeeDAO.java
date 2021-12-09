package com.company.netflixcapstone.dao;

import com.company.netflixcapstone.model.ProcessingFee;
import java.util.List;

/**
 * Created by bonallure on 12/9/21
 */
public interface ProcessingFeeDAO {

    ProcessingFee create(ProcessingFee processingFee);

    ProcessingFee read(String product_type);

    List<ProcessingFee> readAll();

    void update(ProcessingFee processingFee);

    void delete(String product_type);
}
