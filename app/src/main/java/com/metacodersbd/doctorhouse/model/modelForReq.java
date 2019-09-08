package com.metacodersbd.doctorhouse.model;

public class modelForReq {

    String adate , charge , docID , docName , docloc  , docCat  ,page  , pname , postid , stats     ;

    public modelForReq() {
    }

    public modelForReq(String adate, String charge, String docID, String docName, String docloc, String docCat, String page, String pname, String postid, String stats) {
        this.adate = adate;
        this.charge = charge;
        this.docID = docID;
        this.docName = docName;
        this.docloc = docloc;
        this.docCat = docCat;
        this.page = page;
        this.pname = pname;
        this.postid = postid;
        this.stats = stats;
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocloc() {
        return docloc;
    }

    public void setDocloc(String docloc) {
        this.docloc = docloc;
    }

    public String getDocCat() {
        return docCat;
    }

    public void setDocCat(String docCat) {
        this.docCat = docCat;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }
}
