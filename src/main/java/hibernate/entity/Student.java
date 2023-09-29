package hibernate.entity;

public class Student {
	private Integer studentId;
	private String studentName;
	private Integer studentMark;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentName, Integer studentMark) {
		super();
		this.studentName = studentName;
		this.studentMark = studentMark;
	}

	public Student(Integer studentId, String studentName, Integer studentMark) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMark = studentMark;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentMark() {
		return studentMark;
	}

	public void setStudentMark(Integer studentMark) {
		this.studentMark = studentMark;
	}

	@Override
	public String toString() {
		return String.format("Student [%-3d | %-15s | %-25s]", studentId, studentName, studentMark);
	}

}
