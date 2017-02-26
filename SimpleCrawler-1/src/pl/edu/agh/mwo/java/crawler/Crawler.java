package pl.edu.agh.mwo.java.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Crawler {

	protected String urlToProcess;

	public Crawler(String initUrl) throws MalformedURLException
	{
		urlToProcess = initUrl;
	}

	protected TextExtractor textExtractor;
	
	
	
	public void run () throws IOException
	{

		Document doc = null;
		doc = Jsoup.connect(urlToProcess).get();

		TextExtractor textExtractor = new TextExtractor();
		String[] sentences = textExtractor.textExtractor(doc);
		
		for(int i = 0 ; i < sentences.length ; i++)
		{

			if ((sentences[i]).contains("du¿o"))
			System.out.println(sentences[i]);
	
		}	
		
		
		for (int i = 0; i < sentences.length ; i++) {
			char charToFind = 'p';
			int charCount = 0;
			for (int j = 0; j < sentences[i].length(); j++)
			{
				if ((sentences[i]).charAt(j) == charToFind) {
					charCount++;
					if (charCount == 10)
					System.out.println(sentences[i]);
				}
			}
		}
	}


	
}
