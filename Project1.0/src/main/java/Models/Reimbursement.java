package Models;

import java.util.Date;
import java.time.LocalTime;

public class Reimbursement {

	
	private int reinbursementId;
	private int reinbursementAmount;
	private Date reimbursementSubmitted;
	private Date reinbursementResloved;
	private String reinbursementDesc;
	private String reimbursementReciept;
	private int reinbursementAuthor;
	private int reinbursementResolver;
	private int reinbursementStatusId;
	private int reinbursementTypeId;
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int amount, Date reimbSubmitted, int reimbAuthor, int reimbStatusId, int reimbTypeId) {
		this.reinbursementAmount = amount;
		this.reimbursementSubmitted = reimbSubmitted;
		this.reinbursementAuthor = reimbAuthor;
		this.reinbursementStatusId = reimbStatusId;
		this.reinbursementTypeId = reimbTypeId;
	}

	

	public Reimbursement(int reinbursementId, int reinbursementAmount, Date reimbursementSubmitted,
			Date reinbursementResloved, String reinbursementDesc, String reimbursementReciept, int reinbursementAuthor,
			int reinbursementResolver, int reinbursementStatusId, int reinbursementTypeId) {
		super();
		this.reinbursementId = reinbursementId;
		this.reinbursementAmount = reinbursementAmount;
		this.reimbursementSubmitted = reimbursementSubmitted;
		this.reinbursementResloved = reinbursementResloved;
		this.reinbursementDesc = reinbursementDesc;
		this.reimbursementReciept = reimbursementReciept;
		this.reinbursementAuthor = reinbursementAuthor;
		this.reinbursementResolver = reinbursementResolver;
		this.reinbursementStatusId = reinbursementStatusId;
		this.reinbursementTypeId = reinbursementTypeId;
	}

		

	public Reimbursement(int reinbursementAmount, String reinbursementDesc, int reinbursementStatusId,
						 int reinbursementTypeId) {
		super();
		this.reinbursementAmount = reinbursementAmount;
		this.reinbursementDesc = reinbursementDesc;
		this.reinbursementStatusId = reinbursementStatusId;
		this.reinbursementTypeId = reinbursementTypeId;
		
	}

	public Reimbursement(int int1, int int2, Date date, Date date2, String string, int int3, int int4, int int5,
			int int6, int int7) {
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(Date sqlDate, int i, int j, int k) {
		this.reinbursementResloved = sqlDate;
		this.reinbursementResolver = i;
		this.reinbursementStatusId = j;
		this.reinbursementId = k;
		
		
	}

	public int getReinbursementId() {
		return reinbursementId;
	}

	public void setReinbursementId(int reinbursementId) {
		this.reinbursementId = reinbursementId;
	}

	public int getReinbursementAmount() {
		return reinbursementAmount;
	}

	public void setReinbursementAmount(int reinbursementAmount) {
		this.reinbursementAmount = reinbursementAmount;
	}

	public String getReinbursementDesc() {
		return reinbursementDesc;
	}

	public void setReinbursementDesc(String reinbursementDesc) {
		this.reinbursementDesc = reinbursementDesc;
	}

	public Date getReimbursementSubmitted() {
		return reimbursementSubmitted;
	}

	public void setReimbursementSubmitted(Date reimbursementSubmitted) {
		this.reimbursementSubmitted = reimbursementSubmitted;
	}

	public Date getReinbursementResloved() {
		return reinbursementResloved;
	}

	public void setReinbursementResloved(Date reinbursementResloved) {
		this.reinbursementResloved = reinbursementResloved;
	}

	public String getReimbursementReciept() {
		return reimbursementReciept;
	}

	public void setReimbursementReciept(String reimbursementReciept) {
		this.reimbursementReciept = reimbursementReciept;
	}

	public int getReinbursementAuthor() {
		return reinbursementAuthor;
	}

	public void setReinbursementAuthor(int reinbursementAuthor) {
		this.reinbursementAuthor = reinbursementAuthor;
	}

	public int getReinbursementResolver() {
		return reinbursementResolver;
	}

	public void setReinbursementResolver(int reinbursementResolver) {
		this.reinbursementResolver = reinbursementResolver;
	}

	public int getReinbursementStatusId() {
		return reinbursementStatusId;
	}

	public void setReinbursementStatusId(int reinbursementStatusId) {
		this.reinbursementStatusId = reinbursementStatusId;
	}

	public int getReinbursementTypeId() {
		return reinbursementTypeId;
	}

	public void setReinbursementTypeId(int reinbursementTypeId) {
		this.reinbursementTypeId = reinbursementTypeId;
	}



	@Override
	public String toString() {
		return "\n Reimbursement [reinbursementId=" + reinbursementId + ", reinbursementAmount=" + reinbursementAmount
				+ ", reimbursementSubmitted=" + reimbursementSubmitted + ", reinbursementResloved="
				+ reinbursementResloved + ", reinbursementDesc=" + reinbursementDesc + ", reimbursementReciept="
				+ reimbursementReciept + ", reinbursementAuthor=" + reinbursementAuthor + ", reinbursementResolver="
				+ reinbursementResolver + ", reinbursementStatusId=" + reinbursementStatusId + ", reinbursementTypeId="
				+ reinbursementTypeId + "]";
	}



	
	
}
