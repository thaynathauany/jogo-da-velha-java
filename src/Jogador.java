import javax.swing.JOptionPane;

public class Jogador {

	public Computador CPU; // Folha de controle do Computador
	private int p1Points = 0, p2Points = 0;
	private boolean PvCPU = false;

	// Métodos Get e Set de p1Points, p2Points e PvCPU
	public int getpPoints() {
		return p1Points;
	}

	public void setpPoints(int p1Points) {
		this.p1Points = p1Points;
	}

	public int getP2Points() {
		return p2Points;
	}

	public void setP2Points(int p2Points) {
		this.p2Points = p2Points;
	}

	public boolean getPvCPU() {
		return PvCPU;
	}

	public void setPvCPU(boolean pvCPU) {
		this.PvCPU = pvCPU;
	}

	// Incrementa pontuação conforme jogador selecionado
	public void incPoints(int nPlayer) {
		if (nPlayer == 1) {
			this.p1Points++;
		} else if (nPlayer == 2) {
			this.p2Points++;
		}
	}

	// Inicia classe Computador
	public void iniciaCPU() {
		CPU = new Computador();
		setPvCPU(true);
		selecionaNivel();
	}

	// Recebe classe doa Labels que exibem a pontuação dos Players no tabuleiro e
	// atualizam conforme pontuação atual
	public void atuLPoints(javax.swing.JLabel pLabel1, javax.swing.JLabel pLabel2) {
		pLabel1.setText(String.valueOf(p1Points));
		pLabel2.setText(String.valueOf(p2Points));
	}

	// Opção de Modo de Jogo Multiplayer ou contra o Computador
	public void selecionaGameMode() {

		Object[] options = { "PvP", "PvCPU", "Encerrar" };

		int opcao = JOptionPane.showOptionDialog(null, "Selecione o modo de jogo", "Inicio de jogo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if (opcao == 0) {
			setPvCPU(false);
		}
		if (opcao == 1) {
			setPvCPU(true);
			iniciaCPU();
		}
		if (opcao == 2) {
			System.exit(0);
		}

	}

	// Opção de Nível de Jogo da CPU
	public void selecionaNivel() {

		Object[] options = { "Fácil", "Médio", "Difícil", "Encerrar" };

		int opcao = JOptionPane.showOptionDialog(null, "Selecione o nível de jogo", "Inicio de jogo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if (opcao == 0) {
			CPU.setLvl(1);
		}
		if (opcao == 1) {
			CPU.setLvl(2);
		}
		if (opcao == 2) {
			CPU.setLvl(3);
		}
		if (opcao == 3) {
			System.exit(0);
		}

	}

	// Opção de Player inicial
	public char selecionaPlayer() {

		char oRetorno = 'n';

		Object[] options = { "Player 1", "Player2", "Encerrar" };

		int opcao = JOptionPane.showOptionDialog(null, "Qual player iniciará?", "Inicio de jogo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

		if (opcao == 0) {
			oRetorno = 'O';
		}
		if (opcao == 1) {
			oRetorno = 'X';
		}
		if (opcao == 2) {
			System.exit(0);
		}

		return oRetorno;

	}

}
