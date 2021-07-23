package com.kodlamaio.hrms.core.utilities.adapters.mernis;

import com.kodlamaio.hrms.mernisService.FakeMernisService;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements MernisService {

    FakeMernisService client = new FakeMernisService();

    @Override
    public boolean checkIfRealPerson(String nationalityId, String firstName, String lastName, int dateOfBirth) {
        boolean result = client.TCKimlikDogrula(nationalityId, firstName, lastName, dateOfBirth);

        return result;
    }
}
