package DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
	    private Integer idUser;
	    private String loginName;
	    private String password;
	    private String fname;
	    private String lname;
	    private String studentNumber;

	    private String token;
	    private Date timestamp;
	    private Set<QuizTaken> quizTakens = new HashSet<QuizTaken>(0);

	    public User() {
	    }

		public Integer getIdUser() {
			return idUser;
		}

		public void setIdUser(Integer idUser) {
			this.idUser = idUser;
		}

		public String getLoginName() {
			return loginName;
		}

		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getStudentNumber() {
			return studentNumber;
		}

		public void setStudentNumber(String studentNumber) {
			this.studentNumber = studentNumber;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}

		public Set<QuizTaken> getQuizTakens() {
			return quizTakens;
		}

		public void setQuizTakens(Set<QuizTaken> quizTakens) {
			this.quizTakens = quizTakens;
		}

		public User(String loginName, String password, String studentNumber) {
			super();
			this.loginName = loginName;
			this.password = password;
			this.studentNumber = studentNumber;
		}

		public User(String loginName, String password, String fname, String lname, String studentNumber,
				Set<QuizTaken> quizTakens) {
			super();
			this.loginName = loginName;
			this.password = password;
			this.fname = fname;
			this.lname = lname;
			this.studentNumber = studentNumber;
			this.quizTakens = quizTakens;
		}
	    
}
