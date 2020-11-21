package android.example.com.classtacular;

public class subject {

    private String msubjectName;
    private int mtotalClasses;
    private int mpresent;
    private int mabsent;

    public subject(String subjectName, int totalClasses, int present, int absent) {
        this.msubjectName = subjectName;
        this.mtotalClasses = totalClasses;
        this.mpresent = present;
        this.mabsent = absent;
    }

    public int getMabsent() {
        return mabsent;
    }

    public int getMpresent() {
        return mpresent;
    }

    public int getMtotalClasses() {
        return mtotalClasses;
    }

    public String getMsubjectName() {
        return msubjectName;
    }

    public void incrementPresent() {
        this.mpresent++;
        this.mtotalClasses++;
    }

    public void incrementAbsent() {
        this.mabsent++;
        this.mtotalClasses++;
    }
}
