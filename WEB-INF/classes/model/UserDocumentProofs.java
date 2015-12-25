package model;

import java.io.InputStream;

public class UserDocumentProofs {
    private InputStream sop;
    private InputStream resume;
    private InputStream reco1;
    private InputStream reco2;
    private InputStream ug_proof;
    private InputStream pg_proof;
    private InputStream id_proof;

    /**
     * @return the sop
     */
    public InputStream getSop() {
        return sop;
    }

    /**
     * @param sop the sop to set
     */
    public void setSop(InputStream sop) {
        this.sop = sop;
    }

    /**
     * @return the resume
     */
    public InputStream getResume() {
        return resume;
    }

    /**
     * @param resume the resume to set
     */
    public void setResume(InputStream resume) {
        this.resume = resume;
    }

    /**
     * @return the reco1
     */
    public InputStream getReco1() {
        return reco1;
    }

    /**
     * @param reco1 the reco1 to set
     */
    public void setReco1(InputStream reco1) {
        this.reco1 = reco1;
    }

    /**
     * @return the reco2
     */
    public InputStream getReco2() {
        return reco2;
    }

    /**
     * @param reco2 the reco2 to set
     */
    public void setReco2(InputStream reco2) {
        this.reco2 = reco2;
    }

    /**
     * @return the ug_proof
     */
    public InputStream getUg_proof() {
        return ug_proof;
    }

    /**
     * @param ug_proof the ug_proof to set
     */
    public void setUg_proof(InputStream ug_proof) {
        this.ug_proof = ug_proof;
    }

    /**
     * @return the pg_proof
     */
    public InputStream getPg_proof() {
        return pg_proof;
    }

    /**
     * @param pg_proof the pg_proof to set
     */
    public void setPg_proof(InputStream pg_proof) {
        this.pg_proof = pg_proof;
    }

    /**
     * @return the id_proof
     */
    public InputStream getId_proof() {
        return id_proof;
    }

    /**
     * @param id_proof the id_proof to set
     */
    public void setId_proof(InputStream id_proof) {
        this.id_proof = id_proof;
    }
}
