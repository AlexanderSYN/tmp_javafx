package ru.katin.katinbilet.model;

public class Colledge {
    public Colledge(int num_pp, int student_cipher, String full_name,
                    int birthd_day, int birthd_month, int birthd_year) {
        this.num_pp = num_pp;
        this.student_cipher = student_cipher;
        this.full_name = full_name;
        this.birthd_day = birthd_day;
        this.birthd_month = birthd_month;
        this.birthd_year = birthd_year;
    }

    private int num_pp;
    private int student_cipher;
    private String full_name;
    private int birthd_day;
    private int birthd_month;
    private int birthd_year;

    public int getNum_pp() {
        return num_pp;
    }
    public int getStudent_cipher() {
        return student_cipher;
    }
    public String getFull_name() {
        return full_name;
    }
    public int getBirthd_day() {
        return birthd_day;
    }

    public int getBirthd_month() {
        return birthd_month;
    }

    public int getBirthd_year() {
        return birthd_year;
    }


}
