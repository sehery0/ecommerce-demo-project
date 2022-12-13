package com.etiya.ecommercedemo3.repository.abstracts;

import com.etiya.ecommercedemo3.entities.concretes.Invoice;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
