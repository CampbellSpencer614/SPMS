package spencer.revature.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Pitch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pitch_status_id")
	private PitchStatus pitchstatus;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private Users user;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="story_id")
	private Story story;
	
	public Pitch() {
		setId(0);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PitchStatus getPitchStatus() {
		return pitchstatus;
	}

	public void setPitchStatus(PitchStatus pitchstatus) {
		this.pitchstatus = pitchstatus;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}
	
	
	
}
