package spencer.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity
@Table
public class Story {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String tagline;
	@Column(name="detailed_desc")
	private String detaileddesc;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="story_type_id")
	private StoryType storytype;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="genre_id")
	private Genre genre;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="draft_id")
	private Draft draft;
	
	public Story() {
		setId(0);
		setTitle("");
		setTagline("");
		setDetailed_desc("");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getDetailed_desc() {
		return detaileddesc;
	}

	public void setDetailed_desc(String detaileddesc) {
		this.detaileddesc = detaileddesc;
	}

	public StoryType getStoryType() {
		return storytype;
	}

	public void setStoryType(StoryType storytype) {
		this.storytype = storytype;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Draft getDraft() {
		return draft;
	}

	public void setDraft(Draft draft) {
		this.draft = draft;
	}
	
}
