package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Quote;
import com.example.demo.services.QuoteRepository;

@RestController
@RequestMapping("api/quotes")
public class MycontrollerTask {
	
	private final QuoteRepository quoteRepository;
	
	@GetMapping("/")
	public String forward()
	{
		return "Welcome To Infotrix";
	}
	
	
	public MycontrollerTask(QuoteRepository quoteRepository)
	{
		this.quoteRepository = quoteRepository;
	}
	
	
	@GetMapping("/random")
	public Quote getRandomQuote()
	{
		return quoteRepository.getRandomQuote();
	}
	
	@GetMapping("/{id}")
    public Quote getQuote(@PathVariable Long id) {
        return quoteRepository.getQuoteById(id);
    }
	
	@GetMapping("/all")
    public List<Quote> getAllQuotes() {
        return quoteRepository.getAllQuotes();
    }

    @PostMapping("/add")
    public Quote addQuote(@RequestBody Quote quote) {
        return quoteRepository.addQuote(quote);
    }

    @PutMapping("/{id}")
    public Quote updateQuote(@PathVariable Long id, @RequestBody Quote updatedQuote) {
        return quoteRepository.updateQuote(id, updatedQuote);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Long id) {
        quoteRepository.deleteQuote(id);
    }
}