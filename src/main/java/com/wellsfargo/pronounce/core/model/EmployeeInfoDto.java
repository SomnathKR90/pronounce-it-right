package com.wellsfargo.pronounce.core.model;

public class EmployeeInfoDto {

    private Long empId;
    private String empName;
    private String title;
    private String email;
    private String legalName;
    private String namePhoneme;
    private String pronunciation;
    private String role;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }
    
    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getNamePhoneme() {
        return namePhoneme;
    }

    public void setNamePhoneme(String namePhoneme) {
        this.namePhoneme = namePhoneme;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}