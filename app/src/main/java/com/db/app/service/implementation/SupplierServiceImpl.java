package com.db.app.service.implementation;

import com.db.app.database.model.Category;
import com.db.app.database.model.Supplier;
import com.db.app.database.repository.SupplierRepository;
import com.db.app.exception.NotFoundException;
import com.db.app.mapper.SupplierMapper;
import com.db.app.model.request.CreateSupplierRequest;
import com.db.app.model.request.UpdateSupplierRequest;
import com.db.app.model.response.SupplierResponse;
import com.db.app.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.util.StringUtils.hasText;

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
    public SupplierResponse update(Long id, UpdateSupplierRequest request) {
        Supplier.SupplierBuilder supplierBuilder = findById(id).toBuilder();

        if(hasText(request.getCompanyName())) {
            supplierBuilder.companyName(request.getCompanyName());
        }

        if(hasText(request.getContactName())) {
            supplierBuilder.contactName(request.getContactName());
        }

        if(hasText(request.getContactTitle())) {
            supplierBuilder.contactTitle(request.getContactTitle());
        }

        if(hasText(request.getAddress())) {
            supplierBuilder.address(request.getAddress());
        }

        if(hasText(request.getCity())) {
            supplierBuilder.city(request.getCity());
        }

        if(hasText(request.getRegion())) {
            supplierBuilder.region(request.getRegion());
        }

        if(hasText(request.getPostalCode())) {
            supplierBuilder.postalCode(request.getPostalCode());
        }

        if(hasText(request.getCountry())) {
            supplierBuilder.country(request.getCountry());
        }

        if(hasText(request.getPhone())) {
            supplierBuilder.phone(request.getPhone());
        }

        if(hasText(request.getFax())) {
            supplierBuilder.fax(request.getFax());
        }

        if(hasText(request.getHomePage())) {
            supplierBuilder.homePage(request.getHomePage());
        }

        Supplier supplier = supplierRepository.save(supplierBuilder.build());
        return supplierMapper.toSupplierResponse(supplier);
    }

    @Override
    public void delete(Long id) {
        Supplier supplier = findById(id);
        supplierRepository.delete(supplier);
    }

    private Supplier findById(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new NotFoundException("Supplier not found"));
    }
}
