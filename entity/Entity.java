package Main.entity;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Customer_Tracker")
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "A")
    private String a;

    @Column(name = "B")
    private String b;

    @Column(name = "C")
    private String c;

    @Column(name = "D")
    private String d;

    @Column(name = "E")
    private String e;

    @Column(name = "F")
    private String f;

    @Column(name = "G")
    private String g;

    @Column(name = "H")
    private String h;

    @Column(name = "I")
    private String i;

    @Column(name = "J")
    private String j;

    public Entity() {}

    public Entity(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getA() {
        return a;
    } public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    } public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    } public void setC(String c) {
        this.c = c;
    }

    public String getD() { return d; } public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    } public void setE(String e) {
        this.e = e;
    }

    public String getF() {
        return f;
    } public void setF(String f) {
        this.f = f;
    }

    public String getG() {
        return g;
    } public void setG(String g) {
        this.g = g;
    }

    public String getH() {
        return h;
    } public void setH(String h) {
        this.h = h;
    }

    public String getI() {
        return i;
    } public void setI(String i) {
        this.i = i;
    }

    public String getJ() {
        return j;
    } public void setJ(String j) {
        this.j = j;
    }

    @Override
    public String toString() {
        return a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h + ", " + i + ", " + j;
    }
}
