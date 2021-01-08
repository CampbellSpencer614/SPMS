package spencer.revature.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pitch_status")
public class PitchStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String status;
	@Column(name="date_approved")
	private Date dateApproved;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="associate_id")
	private Users associate;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="general_id")
	private Users general;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="senior_id")
	private Users senior;
	
	public PitchStatus() {
		setId(0);
		setStatus("");
	}
	
	public Date getDateApproved() {
		return dateApproved;
	}

	public void setDateApproved(Date dateApproved) {
		this.dateApproved = dateApproved;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Users getAssociate() {
		return associate;
	}

	public void setAssociate(Users associate) {
		this.associate = associate;
	}

	public Users getGeneral() {
		return general;
	}

	public void setGeneral(Users general) {
		this.general = general;
	}

	public Users getSenior() {
		return senior;
	}

	public void setSenior(Users senior) {
		this.senior = senior;
	}
	
}
