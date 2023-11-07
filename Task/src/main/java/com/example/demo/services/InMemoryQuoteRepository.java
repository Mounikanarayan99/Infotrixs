package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Quote;

@Repository
public class InMemoryQuoteRepository implements QuoteRepository {
	
	private List<Quote> quotes;
	private Long nextId = 4L;

    public InMemoryQuoteRepository() {
        quotes = new ArrayList<>();
        quotes.add(new Quote(1L, "The only way to do great work is to love what you do.","Jacob"));
        quotes.add(new Quote(2L, "In the middle of every difficulty lies opportunity.","Bhargav"));
        quotes.add(new Quote(3L, "You miss 100% of the shots you don't take.","Goury"));
        quotes.add(new Quote(4L,"Your worth consists in what you are and not in what you have.","Mounika"));
        quotes.add(new Quote(5L,"If you see someone without a smile give them one of yours.","Nanna"));
        quotes.add(new Quote(6L,"Nature is pleased with simplicity. And nature is no dummy.","Isaac Newton"));
        quotes.add(new Quote(7L,"Your neighbor is the man who needs you","Elbert Hubbard"));
        quotes.add(new Quote(8L,"Always do what is right. It will gratify half of mankind and astound the other","Mark Twain"));
        quotes.add(new Quote(9L,"Your worth consists in what you are and not in what you have.","Thomas Edison"));
    }

    @Override
    public List<Quote> getAllQuotes() {
        
    	return quotes;
    }

    @Override
    public Quote getRandomQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex);
    }
    
    @Override
    public Quote getQuoteById(Long id) {
        return quotes.stream()
                .filter(quote -> quote.getId()==id)
                .findFirst()
                .orElse(null);
    }

	@Override
	public Quote addQuote(Quote quote) {
		// TODO Auto-generated method stub
		quote.setId(nextId++);
        quotes.add(quote);
        return quote;
	}

	@Override
	public Quote updateQuote(Long id, Quote updatedQuote) {
		// TODO Auto-generated method stub
		for (int i = 0; i < quotes.size(); i++) {
            Quote existingQuote = quotes.get(i);
            if (existingQuote.getId()==id) {
                updatedQuote.setId(id);
                quotes.set(i, updatedQuote);
                return updatedQuote;
            }
        }
		return null;
	}

	@Override
	public void deleteQuote(Long id) {
		// TODO Auto-generated method stub
		quotes.removeIf(quote -> quote.getId()==id);
		
	}

}
