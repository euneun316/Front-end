package kr.pe.playdata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book{
	private int isbn;
	private String title;
	private String author;
}