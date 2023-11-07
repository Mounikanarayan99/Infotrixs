package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Quote;

public interface QuoteRepository {

	List<Quote> getAllQuotes();
    Quote getRandomQuote();
    Quote addQuote(Quote quote);
    Quote updateQuote(Long id, Quote updatedQuote);
    void deleteQuote(Long id);
    public Quote getQuoteById(Long id);
}
