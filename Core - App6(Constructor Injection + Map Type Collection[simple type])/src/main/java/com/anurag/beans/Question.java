package com.anurag.beans;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Question {
	private int id;
	private String name;
	private Map<String, String>answers;
	public Question(int id, String name, Map<String, String> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answers = answers;
	}
	public void displayInfo() {
		System.out.println("Question ID :"+id);
		System.out.println("Question Name :"+name);
		System.out.println("Answers..... :-");
		Set<Entry<String,String>>set=answers.entrySet();
		Iterator<Entry<String,String>>itr=set.iterator();
		while (itr.hasNext()) {
			Map.Entry<String,String> entry = itr.next();
			System.out.println("Answer:"+entry.getKey()+"Posted By:"+entry.getValue());
		}
		/*Set<String>keys=answers.keySet();
		Iterator<String>itr=keys.iterator();
		while (itr.hasNext()) {
			String key =itr.next();
			String value=answers.get(key);
			System.out.println("Answer: "+key+" Posted By: "+value);
		}*/
	}
}
