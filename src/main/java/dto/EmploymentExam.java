package dto;

public class EmploymentExam {
	private int id;
	private String companyName;
	private String examDate;
	private int accountId;
	private String note;
	private String createdAt;

	public EmploymentExam(int id, String companyName, String examDate, int accountId, String note, String createdAt) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.examDate = examDate;
		this.accountId = accountId;
		this.note = note;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
