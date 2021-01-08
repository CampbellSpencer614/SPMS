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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String pass;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_role_id")
	private UserRole user_role;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="pitch_accepted",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="pitch_id"))
	private Set<Pitch> pitchs;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_committee",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="committee_id"))
	private Set<Committee> committees;
	
	public Users() {
		setId(0);
		setUsername("");
		setPass("");
	}
public Set<Committee> getCommittees() {
		return committees;
	}

	public void setCommittees(Set<Committee> committees) {
		this.committees = committees;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public UserRole getUser_role() {
		return user_role;
	}

	public void setUser_role(UserRole user_role) {
		this.user_role = user_role;
	}
	public Set<Pitch> getPitchs() {
		return pitchs;
	}
	public void setPitchs(Set<Pitch> pitchs) {
		this.pitchs = pitchs;
	}

}
