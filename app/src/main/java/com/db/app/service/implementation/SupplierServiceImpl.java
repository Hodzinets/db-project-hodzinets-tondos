package com.db.app.service.implementation;

import com.db.app.database.repository.SupplierRepository;
import com.db.app.model.response.SupplierResponse;
import com.db.app.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public List<SupplierResponse> getAll() {
        return null;
    }
}
