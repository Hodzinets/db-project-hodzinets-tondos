package com.db.app.service.implementation;

import com.db.app.database.model.Category;
import com.db.app.database.model.Supplier;
import com.db.app.database.repository.SupplierRepository;
import com.db.app.exception.NotFoundException;
import com.db.app.mapper.SupplierMapper;
import com.db.app.model.request.CreateSupplierRequest;
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
        Supplier supplier = findById(id);
        return supplierMapper.toSupplierResponse(supplier);
    }

    @Override
    public SupplierResponse create(CreateSupplierRequest request) {
        Supplier newSupplier = Supplier.builder()
                .companyName(request.getCompanyName())
                .contactName(request.getContactName())
                .contactTitle(request.getContactTitle())
                .address(request.getAddress())
                .city(request.getCity())
                .region(request.getRegion())
                .postalCode(request.getPostalCode())
                .country(request.getCountry())
                .phone(request.getPhone())
                .fax(request.getFax())
                .homePage(request.getHomePage())
            .build();

        Supplier supplier = supplierRepository.save(newSupplier);

        return supplierMapper.toSupplierResponse(supplier);
    }

    @Override
    public void delete(Long id) {

    }

    private Supplier findById(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new NotFoundException("Supplier not found"));
    }
}
