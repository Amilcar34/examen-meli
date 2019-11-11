
package com.mercadolibre.examen.traductormorse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mercadolibre.examen.traductormorse.domain.Message;
import com.mercadolibre.examen.traductormorse.dto.MessageResponseDTO;
import com.mercadolibre.examen.traductormorse.service.MessageService;

@Controller
public class HomeController {

	@Autowired
	private MessageService messageSenderService;

	@GetMapping("/")
	public String login() {
		return "login";
	}

	@GetMapping("/home")
	public String home(String name, String lastname, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("lastname", lastname);
		return "index";
	}

	@GetMapping("/message")
	public String message(String name, String lastname, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("lastname", lastname);
		List<Message> messages = messageSenderService.findMessageByRecipient(name + " " + lastname);
		model.addAttribute("messages", parseToMessageResponseDTO(messages));
		return "message";
	}

	private List<MessageResponseDTO> parseToMessageResponseDTO(List<Message> messages) {
		Map<String, List<Message>> messagesGroupByFrom = messages.stream()
				.collect(Collectors.groupingBy(Message::getSender));

		List<MessageResponseDTO> messagesResponseDTO = new ArrayList<MessageResponseDTO>();
		for (Entry<String, List<Message>> messageGroupByFrom : messagesGroupByFrom.entrySet()) {
			MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
			messageResponseDTO.setFrom(messageGroupByFrom.getKey());
			messageResponseDTO.setMessage(messageGroupByFrom.getValue().stream().map(message -> message.getMessage())
					.collect(Collectors.toList()));
			messagesResponseDTO.add(messageResponseDTO);
		}
		return messagesResponseDTO;

	}
}
