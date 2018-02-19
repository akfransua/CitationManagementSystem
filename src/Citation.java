
public class Citation {
	private int ID;
	private String title;
	private String authors;
	private String publisher;
	private String location;
	private String volume;
	private String issue;
	private String pages;
	private String year;
	private String isbn;
	private String summary;
	
	public Citation() {
		title ="";
		authors = "";
		publisher = "";
		location = "";
		volume = "";
		issue = "";
		pages = "";
		year = "";
		isbn = "";
		summary = "";
	}
	
	public Citation(String title, String authors, String publisher, String location, String volume, 
			String issue, String pages, String year, String isbn, String summary) {
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.location = location;
		this.volume = volume;
		this.issue = issue;
		this.pages = pages;
		this.year = year;
		this.isbn = isbn;
		this.summary = summary;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
}
