package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna, krajnja;
    private boolean pripada_poc, pripada_kraj;

    public Interval(double p, double k, boolean pp, boolean pk)
            throws IllegalArgumentException {
        if (p>k) throw new IllegalArgumentException();
        pocetna=p;
        krajnja=k;
        pripada_poc=pp;
        pripada_kraj=pk;
    }

    public Interval(){
        pripada_poc=false;
        pripada_kraj=false;
        pocetna=0;
        krajnja=0;
    }

    public boolean isNull(){
        if(  pripada_poc==false && pripada_kraj==false && pocetna==0 && krajnja==0) return true;
        return false;
    }

    public boolean isIn(double s) {
        if(pripada_poc==true && pripada_kraj==true && s>=pocetna && s<=krajnja) return true;
        if(pripada_poc==true && pripada_kraj==false && s>=pocetna && s<krajnja) return true;
        if(pripada_poc==false && pripada_kraj==true && s>pocetna && s<=krajnja) return true;
        if(pripada_poc==false && pripada_kraj==false && s>pocetna && s<krajnja) return true;
        return false;
    }

    public Interval intersect(Interval s){
        Interval pom= new Interval();
        if( s.pocetna>krajnja || pocetna>s.krajnja) return pom;
        if(s.pocetna> pocetna) {
            pom.pocetna=s.pocetna;
            if (s.pripada_poc==true) pom.pripada_poc=true;
            else pom.pripada_poc=false;
        }
        else if (s.pocetna<pocetna) { pom.pocetna=pocetna;
                if (pripada_poc==true) pom.pripada_poc=true;
                else pom.pripada_poc=false;
            }
        if(s.krajnja<krajnja) { pom.krajnja=s.krajnja;
            if (s.pripada_kraj==true) pom.pripada_kraj=true;
            else pom.pripada_kraj=false;
        }
        else if(s.krajnja>krajnja) { pom.krajnja=krajnja;
            if (pripada_kraj==true) pom.pripada_kraj=true;
            else pom.pripada_kraj=false;
        }
        return pom;
    }

    public static Interval intersect(Interval a, Interval b){
        Interval pom= new Interval();
        if( a.pocetna>b.krajnja || b.pocetna>a.krajnja) return pom;
        if(a.pocetna>b.pocetna) {
            pom.pocetna=a.pocetna;
            if (a.pripada_poc==true) pom.pripada_poc=true;
            else pom.pripada_poc=false;
        }
        else if (a.pocetna<b.pocetna) { pom.pocetna=b.pocetna;
            if (b.pripada_poc==true) pom.pripada_poc=true;
            else pom.pripada_poc=false;
        }
        if(a.krajnja<b.krajnja) { pom.krajnja=a.krajnja;
            if (a.pripada_kraj==true) pom.pripada_kraj=true;
            else pom.pripada_kraj=false;
        }
        else if(a.krajnja>b.krajnja) { pom.krajnja=b.krajnja;
            if (b.pripada_kraj==true) pom.pripada_kraj=true;
            else pom.pripada_kraj=false;
        }
        return pom;
    }

    @Override
    public String toString(){
        String s=new String();
        if(this.equals(new Interval())) return "()";
        if(pripada_poc==true) s+="[";
        else s+="(";
        s+=pocetna+","+krajnja;
        if(pripada_kraj==true) s+="]";
        else s+=")";
        return s;
    }

    @Override
    public boolean equals(Object s){
        Interval p=(Interval) s;
        if(  pripada_poc==p.pripada_poc && pripada_kraj==p.pripada_kraj && pocetna==p.pocetna && krajnja==p.krajnja) return true;
        return false;
    }
}