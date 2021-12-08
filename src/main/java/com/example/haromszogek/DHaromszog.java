package com.example.haromszogek;

public class DHaromszog {

    private double aOldal;
    private double bOldal;
    private double cOldal;
    private int sorSzama;

    public DHaromszog(String sor, int sorSzama) throws Exception {
        this.sorSzama = sorSzama;
        sor = sor.replace(',', '.');
        String[] adatok = sor.split(" ");
        this.setaOldal(Double.parseDouble(adatok[0]));
        this.setbOldal(Double.parseDouble(adatok[1]));
        this.setcOldal(Double.parseDouble(adatok[2]));
        this.EllNovekvoSorrend();
        this.EllMegszerkesztheto();
        this.EllDerekszogu();
    }

    public void setaOldal(double aOldal) throws Exception {
        if (aOldal < 0) {
            throw new Exception("Az a oldalnak nagyobbnak kell lennie, mint nulla!");
        }
        this.aOldal = aOldal;
    }

    public void setbOldal(double bOldal) throws Exception {
        if (bOldal < 0) {
            throw new Exception("A b oldalnak nagyobbnak kell lennie, mint nulla!");
        }
        this.bOldal = bOldal;
    }

    public void setcOldal(double cOldal) throws Exception {
        if (cOldal < 0) {
            throw new Exception("A c oldalnak nagyobbnak kell lennie, mint nulla!");
        }
        this.cOldal = cOldal;
    }

    public void setSorSzama(int sorSzama) {
        this.sorSzama = sorSzama;
    }

    private boolean EllDerekszogu() throws Exception {
        if (Math.pow(this.cOldal, 2) == Math.pow(this.aOldal, 2) + Math.pow(this.bOldal, 2)) {
            return true;
        }
        throw new Exception(this.sorSzama + ".sor: A háromszög nem derékszögű");
    }

    private boolean EllMegszerkesztheto() throws Exception {
        if (this.aOldal + this.bOldal >= this.cOldal) {
            return true;
        }
        throw new Exception(this.sorSzama + ".sor: A háromszög nem szerkeszthető");
    }

    private boolean EllNovekvoSorrend() throws Exception {
        if (this.aOldal <= this.bOldal && this.bOldal <= this.cOldal) {
            return true;
        }
        throw new Exception(this.sorSzama + ".sor: A megadott adattagok sorrendje hibás! ");
    }

    public double getaOldal() {
        return aOldal;
    }

    public double getbOldal() {
        return bOldal;
    }

    public double getcOldal() {
        return cOldal;
    }

    public int getSorSzama() {
        return sorSzama;
    }

    public double getKerulet() {
        return this.aOldal + this.bOldal + this.cOldal;
    }

    public double getTerulet() {
        return aOldal * bOldal / 2;
    }

    @Override
    public String toString() {
        return String.format("%d sor: a = %.2f b = %.2f c = %.2f ",
                this.sorSzama, this.aOldal, this.bOldal, this.cOldal);
    }
}
