public class Data {

    private int dia;
	private int mes;
	private int ano;

	public Data(int d, int m, int a) {
		init(d, m, a);
	}

	private void init(int dia, int mes, int ano) {
		this.setDia(dia);
		this.setMes(mes);

		if (ano >= 1900) {
			this.setAno(ano);

		}
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	private boolean eAnoBisexto() {
		return (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0));
	}

	private boolean eUltimaDia() {
		return dia == diasNoMes();
	}

	private int diasNoMes() {
		if (mes == 2) {
			return eAnoBisexto() ? 29 : 28;
		} else if (mes == 7 || mes == 8) {
			return 31;
		} else if (mes <= 6) {
			return mes % 2 == 0 ? 30 : 31;
		}
		return mes % 2 == 1 ? 30 : 31;
	}

	private void adicionaDia() {
		if (eUltimaDia()) {
			dia = 1;
			if (mes < 12) {
				mes++;
			} else {
				mes = 1;
				ano++;
			}
		} else
			dia++;
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
}
