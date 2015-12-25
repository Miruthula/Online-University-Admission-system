package model;

public class UserApplication {
    private String applnId;
    private String applicationStatus;
    private String termId;
    private String termName;
    private String programId;
    private String programName;
    private UserPersonalDetails personalDtls;
    private UserContactDetails permanentAddress;
    private UserContactDetails postalAddress;
    private UserEducationalQualifications ugQual;
    private UserEducationalQualifications pgQual;
    private UserDocumentProofs docProof;
    private UserTestScores testScores;
    private boolean finalSubmit;

    /**
     * @return the personalDtls
     */
    public UserPersonalDetails getPersonalDtls() {
        return personalDtls;
    }

    /**
     * @param personalDtls the personalDtls to set
     */
    public void setPersonalDtls(UserPersonalDetails personalDtls) {
        this.personalDtls = personalDtls;
    }

    /**
     * @return the permanentAddress
     */
    public UserContactDetails getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * @param permanentAddress the permanentAddress to set
     */
    public void setPermanentAddress(UserContactDetails permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    /**
     * @return the postalAddress
     */
    public UserContactDetails getPostalAddress() {
        return postalAddress;
    }

    /**
     * @param postalAddress the postalAddress to set
     */
    public void setPostalAddress(UserContactDetails postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * @return the ugQual
     */
    public UserEducationalQualifications getEducationQual() {
        return getUgQual();
    }

    /**
     * @param educationQual the ugQual to set
     */
    public void setEducationQual(UserEducationalQualifications educationQual) {
        this.setUgQual(educationQual);
    }

    /**
     * @return the docProof
     */
    public UserDocumentProofs getDocProof() {
        return docProof;
    }

    /**
     * @param docProof the docProof to set
     */
    public void setDocProof(UserDocumentProofs docProof) {
        this.docProof = docProof;
    }

    /**
     * @return the applicationStatus
     */
    public String getApplicationStatus() {
        return applicationStatus;
    }

    /**
     * @param applicationStatus the applicationStatus to set
     */
    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    /**
     * @return the termId
     */
    public String getTermId() {
        return termId;
    }

    /**
     * @param termId the termId to set
     */
    public void setTermId(String termId) {
        this.termId = termId;
    }

    /**
     * @return the termName
     */
    public String getTermName() {
        return termName;
    }

    /**
     * @param termName the termName to set
     */
    public void setTermName(String termName) {
        this.termName = termName;
    }

    /**
     * @return the programId
     */
    public String getProgramId() {
        return programId;
    }

    /**
     * @param programId the programId to set
     */
    public void setProgramId(String programId) {
        this.programId = programId;
    }

    /**
     * @return the programName
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * @param programName the programName to set
     */
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    /**
     * @return the applnId
     */
    public String getApplnId() {
        return applnId;
    }

    /**
     * @param applnId the applnId to set
     */
    public void setApplnId(String applnId) {
        this.applnId = applnId;
    }

    /**
     * @return the ugQual
     */
    public UserEducationalQualifications getUgQual() {
        return ugQual;
    }

    /**
     * @param ugQual the ugQual to set
     */
    public void setUgQual(UserEducationalQualifications ugQual) {
        this.ugQual = ugQual;
    }

    /**
     * @return the pgQual
     */
    public UserEducationalQualifications getPgQual() {
        return pgQual;
    }

    /**
     * @param pgQual the pgQual to set
     */
    public void setPgQual(UserEducationalQualifications pgQual) {
        this.pgQual = pgQual;
    }

    /**
     * @return the testScores
     */
    public UserTestScores getTestScores() {
        return testScores;
    }

    /**
     * @param testScores the testScores to set
     */
    public void setTestScores(UserTestScores testScores) {
        this.testScores = testScores;
    }

    /**
     * @return the finalSubmit
     */
    public boolean isFinalSubmit() {
        return finalSubmit;
    }

    /**
     * @param finalSubmit the finalSubmit to set
     */
    public void setFinalSubmit(boolean finalSubmit) {
        this.finalSubmit = finalSubmit;
    }
}
