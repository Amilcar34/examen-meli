package com.mercadolibre.examen.traductormorse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolibre.examen.traductormorse.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{
	
	List<Message> findByRecipientIgnoreCase(String recipient);
}
