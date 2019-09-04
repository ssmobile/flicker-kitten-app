package com.example.flickrkitten.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("link")
	private String link;

	@SerializedName("description")
	private String description;

	@SerializedName("modified")
	private String modified;

	@SerializedName("generator")
	private String generator;

	@SerializedName("title")
	private String title;

	@SerializedName("items")
	private List<Item> items;

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setModified(String modified){
		this.modified = modified;
	}

	public String getModified(){
		return modified;
	}

	public void setGenerator(String generator){
		this.generator = generator;
	}

	public String getGenerator(){
		return generator;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setItems(List<Item> items){
		this.items = items;
	}

	public List<Item> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"link = '" + link + '\'' + 
			",description = '" + description + '\'' + 
			",modified = '" + modified + '\'' + 
			",generator = '" + generator + '\'' + 
			",title = '" + title + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}