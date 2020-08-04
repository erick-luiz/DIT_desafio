package com.deliverit.desafio.service;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deliverit.desafio.exception.NotFoundResource;
import com.deliverit.desafio.model.Invoice;
import com.deliverit.desafio.model.dto.InvoiceDtoReq;
import com.deliverit.desafio.repository.InvoiceRepository;

@Service
public class InvoiceService {

	private InvoiceRepository invoiceRepository;

	public InvoiceService(InvoiceRepository invoiceRepository){
		this.invoiceRepository = invoiceRepository;
	}

	public Invoice create(InvoiceDtoReq invoiceDto) {
		Invoice invoice = Invoice.from(invoiceDto);
		return invoiceRepository.save(invoice);
	}

	public Invoice get(long id) {
		return invoiceRepository.findById(id).orElseThrow(() -> new NotFoundResource("{}"));
	}

	public Page<Invoice> getAll(Pageable pageable) {
		return invoiceRepository.findAll(pageable);
	}

	@Transactional
	public InvoiceDtoReq update(InvoiceDtoReq invoiceDto, long id) {
		Invoice invoice = get(id);
		BeanUtils.copyProperties(invoiceDto, invoice);
		return invoiceDto;
	}

	public void delete(long id) {
		invoiceRepository.delete(get(id));
	}

}
