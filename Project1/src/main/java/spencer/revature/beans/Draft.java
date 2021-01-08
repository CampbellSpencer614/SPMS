package spencer.revature.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Draft {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String story;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="approval_status_id")
	private ApprovalStatus approvalstatus;
	
	public Draft() {
		id=0;
		story="";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public ApprovalStatus getApprovalStatus() {
		return approvalstatus;
	}
	public void setApprovalStatus(ApprovalStatus approvalstatus) {
		this.approvalstatus = approvalstatus;
	}
}
