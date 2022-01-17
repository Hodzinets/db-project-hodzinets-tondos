package com.db.app.service.implementation;

import com.db.app.database.model.Supplier;
import com.db.app.database.repository.SupplierRepository;
import com.db.app.mapper.SupplierMapper;
import com.db.app.model.response.SupplierResponse;
import com.db.app.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupplierMapper supplierMapper;

    public List<SupplierResponse> getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.stream()
                .map(item -> supplierMapper.toSupplierResponse(item)).collect(Collectors.toList());
    }

    @Override
    public SupplierResponse getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
