package spencer.revature.beans;

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
@Table(name="info_request")
public class InfoRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pitch_status_id")
	private PitchStatus pitchstatus;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sender_id")
	private Users sender;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="target_id")
	private Users target;
	public Users getSender() {
		return sender;
	}
	public void setSender(Users sender) {
		this.sender = sender;
	}
	public Users getTarget() {
		return target;
	}
	public void setTarget(Users target) {
		this.target = target;
	}
	public PitchStatus getPitchStatus() {
		return pitchstatus;
	}
	public void setPitchStatus(PitchStatus pitchstatus) {
		this.pitchstatus = pitchstatus;
	}
	
	
}
