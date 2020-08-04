package com.deliverit.desafio.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.deliverit.desafio.model.Invoice;
import com.deliverit.desafio.model.dto.InvoiceDtoReq;
import com.deliverit.desafio.model.dto.InvoiceDtoRes;
import com.deliverit.desafio.service.InvoiceService;

@RestController
@RequestMapping("invoice")
public class InvoiceController {

	private InvoiceService invoiceService;
	
	InvoiceController(InvoiceService invoiceService){
		this.invoiceService = invoiceService;
	}

	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody InvoiceDtoReq request, UriComponentsBuilder uriBuilder){
		Invoice invoice = invoiceService.create(request);
		URI uri = uriBuilder.path("/invoice/{id}").buildAndExpand(invoice.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<Page<InvoiceDtoRes>> getAll(Pageable pageable){
		return ResponseEntity.ok(invoiceService.getAll(pageable).map(InvoiceDtoRes::from));
	}
	
	@GetMapping("/{invoiceId}")
	public ResponseEntity<InvoiceDtoRes> get(@PathVariable("invoiceId") long id) {
		return ResponseEntity.ok(InvoiceDtoRes.from(invoiceService.get(id)));
	}

}
