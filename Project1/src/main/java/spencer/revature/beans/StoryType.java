package spencer.revature.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="story_type")
public class StoryType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String storytype;
	private Integer points;
	
	public StoryType() {
		setId(0);
		setStorytype("");
		setPoints(0);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStorytype() {
		return storytype;
	}

	public void setStorytype(String storytype) {
		this.storytype = storytype;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
}
