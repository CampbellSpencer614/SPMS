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
@Table
public class Attachment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String attachment;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pitch_id")
	private Pitch pitch;
	
	public Attachment() {
		id=0;
		attachment="";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Pitch getPitch() {
		return pitch;
	}
	public void setPitch(Pitch pitch) {
		this.pitch = pitch;
	}
}
