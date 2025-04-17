package PRATIQUONS1_BDD_POO;

public class Vol {
	private String numeroVol;
	private String villeDepart;
	private String villeArrive;
	
	public Vol(String numeroVol,String villeDepart,String villeArrive) {
		this.numeroVol=numeroVol;
		this.villeDepart=villeDepart;
		this.villeArrive=villeArrive;
		
	}
	public String getNumeroVol() {
        return numeroVol;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getVilleArrive() {
        return villeArrive;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public void setVilleArrive(String villeArrive) {
        this.villeArrive = villeArrive;
    }

    
    @Override
    public String toString() {
       return "Vol(" + numeroVol + ", " + villeDepart + ", " + villeArrive + ")";
    }
}


