import javax.swing.JOptionPane;
import java.util.Random;

public class Computador {

	private int pPoints = 0, Lvl = 0, eJogada = 0;
	private int TipoEJogada;
	private char pCampo[] = new char[9];
	private char sTipoEJogada;

	private ComputadorA CPUA;
	private ComputadorB CPUB;
	private ComputadorC CPUC;	

	// Inicia a Classe correspondente ao nível selecionado
	private void ativaCPU(int nCPU) {
		switch (Lvl) {
		case 1:
			CPUA = new ComputadorA();
			break;
		case 2:
			CPUB = new ComputadorB();
			break;
		case 3:
			CPUC = new ComputadorC();
			break;
		}
	}

	// Chama a jpgada da CPU conforme o nível selecionado
	public int jogadaCPU() {

		int jogada = 0;

		switch (Lvl) {
		case 1:
			jogada = CPUA.retJogada();
			break;
		case 2:
			jogada = CPUB.retJogada();
			break;
		case 3:
			jogada = CPUC.retJogada();
			break;
		}

		return jogada;

	}

	// Cria uma jogada aleatória
	public int Jogadarandom() {
		int jogada = getRandomNumber(1, 9);
		while (pCampo[jogada - 1] != 'n') {
			jogada = getRandomNumber(1, 9);
		}
		return jogada;
	}

	// Verifica situação de perigo na linha 1
	public Boolean jeLinha1() {

		int AdvPoints = 0, pVazio = 0, pAlvo = 0;

		Boolean Caso = false;

		if (pCampo[0] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[0] == 'n') {
			pAlvo = 0;
			pVazio++;
		}
		if (pCampo[1] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[1] == 'n') {
			pAlvo = 1;
			pVazio++;
		}
		if (pCampo[2] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[2] == 'n') {
			pAlvo = 2;
			pVazio++;
		}

		if ((AdvPoints == 2) && (pVazio == 1)) {
			seteJogada(pAlvo);
			Caso = true;
		}

		return Caso;

	}

	// Verifica situação de perigo na linha 2
	public Boolean jeLinha2() {

		int AdvPoints = 0, pVazio = 0, pAlvo = 0;

		Boolean Caso = false;

		if (pCampo[3] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[3] == 'n') {
			pAlvo = 3;
			pVazio++;
		}
		if (pCampo[4] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[4] == 'n') {
			pAlvo = 4;
			pVazio++;
		}
		if (pCampo[5] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[5] == 'n') {
			pAlvo = 5;
			pVazio++;
		}

		if ((AdvPoints == 2) && (pVazio == 1)) {
			seteJogada(pAlvo);
			Caso = true;
		}

		return Caso;
	}

	// Verifica situação de perigo na linha 3
	public Boolean jeLinha3() {

		int AdvPoints = 0, pVazio = 0, pAlvo = 0;

		Boolean Caso = false;

		if (pCampo[6] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[6] == 'n') {
			pAlvo = 6;
			pVazio++;
		}
		if (pCampo[7] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[7] == 'n') {
			pAlvo = 7;
			pVazio++;
		}
		if (pCampo[8] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[8] == 'n') {
			pAlvo = 8;
			pVazio++;
		}

		if ((AdvPoints == 2) && (pVazio == 1)) {
			seteJogada(pAlvo);
			Caso = true;
		}

		return Caso;
	}

	// Verifica situação de perigo na coluna 1
	public Boolean jeColuna1() {

		int AdvPoints = 0, pVazio = 0, pAlvo = 0;

		Boolean Caso = false;

		if (pCampo[0] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[0] == 'n') {
			pAlvo = 0;
			pVazio++;
		}
		if (pCampo[3] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[3] == 'n') {
			pAlvo = 3;
			pVazio++;
		}
		if (pCampo[6] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[6] == 'n') {
			pAlvo = 6;
			pVazio++;
		}

		if ((AdvPoints == 2) && (pVazio == 1)) {
			seteJogada(pAlvo);
			Caso = true;
		}

		return Caso;
	}

	// Verifica situação de perigo na coluna 2
	public Boolean jeColuna2() {

		int AdvPoints = 0, pVazio = 0, pAlvo = 0;

		Boolean Caso = false;

		if (pCampo[1] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[1] == 'n') {
			pAlvo = 1;
			pVazio++;
		}
		if (pCampo[4] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[4] == 'n') {
			pAlvo = 4;
			pVazio++;
		}
		if (pCampo[7] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[7] == 'n') {
			pAlvo = 7;
			pVazio++;
		}

		if ((AdvPoints == 2) && (pVazio == 1)) {
			seteJogada(pAlvo);
			Caso = true;
		}

		return Caso;
	}

	// Verifica situação de perigo na coluna 3
	public Boolean jeColuna3() {

		int AdvPoints = 0, pVazio = 0, pAlvo = 0;

		Boolean Caso = false;

		if (pCampo[2] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[2] == 'n') {
			pAlvo = 2;
			pVazio++;
		}
		if (pCampo[5] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[5] == 'n') {
			pAlvo = 5;
			pVazio++;
		}
		if (pCampo[8] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[8] == 'n') {
			pAlvo = 8;
			pVazio++;
		}

		if ((AdvPoints == 2) && (pVazio == 1)) {
			seteJogada(pAlvo);
			Caso = true;
		}

		return Caso;
	}

	// Verifica situação de perigo na diagonal 1
	public Boolean jeDiagonal1() {

		int AdvPoints = 0, pVazio = 0, pAlvo = 0;

		Boolean Caso = false;

		if (pCampo[0] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[0] == 'n') {
			pAlvo = 0;
			pVazio++;
		}
		if (pCampo[4] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[4] == 'n') {
			pAlvo = 4;
			pVazio++;
		}
		if (pCampo[8] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[8] == 'n') {
			pAlvo = 8;
			pVazio++;
		}

		if ((AdvPoints == 2) && (pVazio == 1)) {
			seteJogada(pAlvo);
			Caso = true;
		}

		return Caso;
	}

	// Verifica situação de perigo na diagonal 2
	public Boolean jeDiagonal2() {

		int AdvPoints = 0, pVazio = 0, pAlvo = 0;

		Boolean Caso = false;

		if (pCampo[2] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[2] == 'n') {
			pAlvo = 2;
			pVazio++;
		}
		if (pCampo[4] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[4] == 'n') {
			pAlvo = 4;
			pVazio++;
		}
		if (pCampo[6] == getsTipoEJogada()) {
			AdvPoints++;
		} else if (pCampo[6] == 'n') {
			pAlvo = 6;
			pVazio++;
		}

		if ((AdvPoints == 2) && (pVazio == 1)) {
			seteJogada(pAlvo);
			Caso = true;
		}

		return Caso;
	}
	

	// Verifica situação favorável ou perigosa no campo de acordo com tipo
	public Boolean JogadaEstrategica(int Tipo) {

		Boolean Nice = false;
		
		// Seleciona tipo 1 para verificar perigo e 2 para vantagem
		setTipoEJogada(Tipo);

		int encotrado_pFav = 0;

		if (jeLinha1()) {
			Nice = true;
		} else if (jeLinha2()) {
			Nice = true;
		} else if (jeLinha3()) {
			Nice = true;
		} else if (jeColuna1()) {
			Nice = true;
		} else if (jeColuna2()) {
			Nice = true;
		} else if (jeColuna3()) {
			Nice = true;
		} else if (jeDiagonal1()) {
			Nice = true;
		} else if (jeDiagonal2()) {
			Nice = true;
		}

		if (Nice) {
			encotrado_pFav = geteJogada();
		}

		seteJogada(encotrado_pFav);

		return Nice;

	}

	// Obtém um valor aleatório conforme parâmetros informados
	public int getRandomNumber(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	// Classe do Computador de nível 1
	public class ComputadorA extends Computador {

		public int retJogada() {
			return Jogadarandom();
		}

	}

	// Classe do Computador de nível 2
	public class ComputadorB extends Computador {

		public int retJogada() {

			int pPOS = 0;

			if (JogadaEstrategica(1)) {
				pPOS = geteJogada() + 1;
			} else {
				pPOS = Jogadarandom();
			}

			return pPOS;
		}
	}

	// Classe do Computador de nível 3
	public class ComputadorC extends Computador {
		
		public int retJogada() {

			int pPOS = 0;
			
			if (JogadaEstrategica(2)) {
				pPOS = geteJogada() + 1;
			} else
			if (JogadaEstrategica(1)) {
				pPOS = geteJogada() + 1;
			} else {
				pPOS = Jogadarandom();
			}

			return pPOS;
		}
	}

	// Envia situação do Campo para o CPU atualizar e envia o mesmo ao computador do nível selecionado
	public void FieldToCPU(char[] vField) {
		Set_vCampo(vField);
		sendCampo_nCPU(pCampo);
	}

	// Atualiza situação do campo conforme parametro informado
	public void Set_vCampo(char[] vField) {
		for (int i = 1; i < 10; i++) {
			setpSinal(vField[i - 1], i);
		}
	}

	// Envia situação do campo para a CPU de acordo com seu nível
	private void sendCampo_nCPU(char[] vField) {
		switch (Lvl) {
		case 1:
			CPUA.Set_vCampo(vField);
			break;
		case 2:
			CPUB.Set_vCampo(vField);
			break;
		case 3:
			CPUC.Set_vCampo(vField);
			break;
		}
	}	

	// Desenha campo atual para conferência
	public void print_field() {
		switch (Lvl) {
		case 1:
			CPUA.desenha_tabuleiro();
			break;
		case 2:
			CPUB.desenha_tabuleiro();
			break;
		case 3:
			CPUC.desenha_tabuleiro();
			break;
		}
	}

	// Sesenha o campo
	public void desenha_tabuleiro() {
		String aCampo = ("Tabuleiro: \n" + String.valueOf(getpSinal(0)) + '|' + String.valueOf(getpSinal(1)) + '|'
				+ String.valueOf(getpSinal(2)) + '\n' + String.valueOf(getpSinal(3)) + '|'
				+ String.valueOf(getpSinal(4)) + '|' + String.valueOf(getpSinal(5)) + '\n'
				+ String.valueOf(getpSinal(6)) + '|' + String.valueOf(getpSinal(7)) + '|'
				+ String.valueOf(getpSinal(8)));
		JOptionPane.showMessageDialog(null, aCampo, "Atenção!", JOptionPane.INFORMATION_MESSAGE);
	}

	// Métodos Get e Set de: sTipoEJogada,eJogada,TipoEJogada,pPoints,Lvl e pCampo
	// Para o Método setLvl é iniciada a Classe correspondente ao nível selecionado
	public int geteJogada() {
		return eJogada;
	}

	public void seteJogada(int pJogada) {
		this.eJogada = pJogada;
	}	
	
	public int getpPoints() {
		return pPoints;
	}

	public void setpPoints(int pPoints) {
		this.pPoints = pPoints;
	}
	
	public char getpSinal(int pos) {
		return pCampo[pos];
	}

	public void setpSinal(char sin, int pos) {
		this.pCampo[pos - 1] = sin;
	}

	public int getLvl() {
		return Lvl;
	}

	public void setLvl(int lvl) {
		this.Lvl = lvl;
		ativaCPU(lvl);
	}

	public int getTipoEJogada() {
		return TipoEJogada;
	}

	public void setTipoEJogada(int tipoEJogada) {
		this.TipoEJogada = tipoEJogada;
		
		if (TipoEJogada == 1) {
			setsTipoEJogada('O');
		} else
		if (TipoEJogada == 2) {
			setsTipoEJogada('X');
		} 
	}

	public char getsTipoEJogada() {
		return sTipoEJogada;
	}

	public void setsTipoEJogada(char sTipoEJogada) {
		this.sTipoEJogada = sTipoEJogada;
	}

}
