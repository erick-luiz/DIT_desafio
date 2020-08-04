package com.deliverit.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverit.desafio.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
