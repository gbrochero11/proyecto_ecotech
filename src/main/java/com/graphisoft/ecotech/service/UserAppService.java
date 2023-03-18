package com.graphisoft.ecotech.service;

import com.graphisoft.ecotech.utils.ResponseModel;

public interface UserAppService {

    ResponseModel loginUserApp(String userName, String password);
    ResponseModel orderServicesAssigned(Long idResource);
}
