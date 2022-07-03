import java.awt.Color;

import javax.swing.JOptionPane;

public class Campo {

	public Jogador Player; // folha de controle do Jogador

	private char pSinal[] = new char[9], aSinal;
	private Boolean fResposta = false, fJogo = false;

	public void LimpaCampo() {

		// Limpa variáveis do campo para recomeçar o jogo

		setfResposta(false);
		setfJogo(false);
		setSinalAtual('n');
		limpa_vPosSinal();

		// Questiona Player inicialização do jogo
		setSinalAtual(Player.selecionaPlayer());

	}

	// Limpa vetor de sinais preenchidos no campo
	public void limpa_vPosSinal() {
		for (int i = 1; i < 10; i++) {
			setpSinal('n', i);
		}
	}

	// Envia estado atual do campo para CPU decidir sua próxima jogada
	public void sendCampo_CPU() {
		Player.CPU.FieldToCPU(pSinal);
	}

	// Inicia a classe Jogador e questiona os modos de jogo
	public void iniciaPlayers() {
		Player = new Jogador();
		Player.selecionaGameMode();
	}

	// Método get do sianl atual (Vez do jogador)
	public char getSinalAtual() {
		return aSinal;
	}

	// Método set do sianl atual (Vez do jogador)
	public void setSinalAtual(char aSin) {
		this.aSinal = aSin;
	}

	// Salva jogada do sinal atual para a posição do campo selecionada caso a
	// posição esteja vazia
	public boolean setSinal(char sBotao, int btNum) {

		if (sBotao == 'n') {
			this.pSinal[btNum - 1] = aSinal;
			return true;
		} else {
			return false;
		}
	}

//	Recebe Classe do botão selecionado verifica se o mesmo está vazio
//	caso não esteja ele obtém o sinal atual conforme a vez do jogador
//	e atualiza o sinal do botão

	public void clickBotao(javax.swing.JButton pbotao, int nbotao) {

		char pBotao, bResult;

		bResult = 'n';

		// verifica se o botão está vazio
		if (pbotao.getText().length() == 0) {
			pBotao = 'n';
		} else {
			pBotao = pbotao.getText().charAt(0);
		}

		// adiciona o sinal ao botão caso esteja vazio, senão ele avisa que o botão já
		// foi selecionado

		if (setSinal(pBotao, nbotao)) {

			bResult = getpSinal(nbotao - 1);

			pbotao.setText(String.valueOf(bResult));

			if (bResult == 'O') {
				pbotao.setForeground(Color.blue);
			}
			if (bResult == 'X') {
				pbotao.setForeground(Color.red);
			}

			alteraSinalAtual();

		} else {
			JOptionPane.showMessageDialog(null, "Opção ja foi selecionada!", "Atenção!",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// Método criado apenas para desenhar o tabuleiro para conferência das variáveis
	// no objeto
	public void desenha_tabuleiro() {
		String aCampo = ("Tabuleiro: \n" + String.valueOf(getpSinal(0)) + " | " + String.valueOf(getpSinal(1)) + " | "
				+ String.valueOf(getpSinal(2)) + '\n' + String.valueOf(getpSinal(3)) + " | "
				+ String.valueOf(getpSinal(4)) + " | " + String.valueOf(getpSinal(5)) + '\n'
				+ String.valueOf(getpSinal(6)) + " | " + String.valueOf(getpSinal(7)) + " | "
				+ String.valueOf(getpSinal(8)));
		JOptionPane.showMessageDialog(null, aCampo, "Atenção!", JOptionPane.INFORMATION_MESSAGE);
	}

	// Limpeza dos botões no tabuleiro
	public void cBotao(javax.swing.JButton botao1, javax.swing.JButton botao2, javax.swing.JButton botao3,
			javax.swing.JButton botao4, javax.swing.JButton botao5, javax.swing.JButton botao6,
			javax.swing.JButton botao7, javax.swing.JButton botao8, javax.swing.JButton botao9) {
		botao1.setText("");
		botao2.setText("");
		botao3.setText("");
		botao4.setText("");
		botao5.setText("");
		botao6.setText("");
		botao7.setText("");
		botao8.setText("");
		botao9.setText("");
	}

	// Método para mostrar e ocultar o tabuleiro
	public void vPanel(javax.swing.JPanel gPanel, Boolean Opcao) {
		gPanel.setVisible(Opcao);
	}

	// Método para atualizar a vez do jogador no tabuleiro
	public void pLabel(javax.swing.JLabel gLabel, char aPlayer) {
		if (aPlayer == 'O') {
			gLabel.setText("Player 1");
			gLabel.setForeground(Color.blue);
		}
		if (aPlayer == 'X') {
			if (Player.getPvCPU()) {
				gLabel.setText("CPU");
			} else {
				gLabel.setText("Player 2");
			}

			gLabel.setForeground(Color.red);
		}
	}

	// Altera o sinal atual para o próximo após a jogada anterior finalizada
	public void alteraSinalAtual() {

		verificaCampos();

		if (aSinal == 'O') {
			setSinalAtual('X');
		} else if (aSinal == 'X') {
			setSinalAtual('O');
		}

	}

	// Caso haja um vencedor verifica qual player ganhou e exibe na tela
	public Boolean verificavencedor(char vSinal) {

		String Mensagem = null, Vencedor = null;

		if (vSinal == 'O') {
			Player.incPoints(1);
			Vencedor = "Player 1";
			Mensagem = "Fim de jogo! \n" + "Vencedor: " + Vencedor;
		} else if (vSinal == 'X') {
			Player.incPoints(2);
			if (Player.getPvCPU()) {
				Vencedor = "CPU";
			} else {
				Vencedor = "Player 2";
			}
			Mensagem = "Fim de jogo! \n" + "Vencedor: " + Vencedor;
		} else if (vSinal == 'v') {
			Mensagem = "Fim de jogo! \n" + "VELHA!";
		}

		JOptionPane.showMessageDialog(null, Mensagem, "Fim de jogo!", JOptionPane.INFORMATION_MESSAGE);

		this.fJogo = true;

		return fJogo;

	}

	// Após término do jogo exibe opção para inicio de um novo jogo ou encerramento
	// da aplicação
	public void questionaNovoJogo() {

		Object[] options = { "Continuar", "Finalizar" };

		int opcao = JOptionPane.showOptionDialog(null, "Deseja jogar novamente?", "Fim de jogo",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if (opcao == 0) {
			setfResposta(true);
		} else if (opcao == 1) {
			System.exit(0);
		}

	}

	// Verifica se há alguma trinca positiva ou um empate
	public void verificaCampos() {

		if ((pSinal[0] == pSinal[1]) && (pSinal[1] == pSinal[2]) && (pSinal[2] != 'n')) {
			verificavencedor(pSinal[0]);
		} else if ((pSinal[3] == pSinal[4]) && (pSinal[4] == pSinal[5]) && (pSinal[5] != 'n')) {
			verificavencedor(pSinal[3]);
		} else if ((pSinal[6] == pSinal[7]) && (pSinal[7] == pSinal[8]) && (pSinal[8] != 'n')) {
			verificavencedor(pSinal[6]);
		} else if ((pSinal[0] == pSinal[3]) && (pSinal[3] == pSinal[6]) && (pSinal[6] != 'n')) {
			verificavencedor(pSinal[0]);
		} else if ((pSinal[1] == pSinal[4]) && (pSinal[4] == pSinal[7]) && (pSinal[7] != 'n')) {
			verificavencedor(pSinal[1]);
		} else if ((pSinal[2] == pSinal[5]) && (pSinal[5] == pSinal[8]) && (pSinal[8] != 'n')) {
			verificavencedor(pSinal[2]);
		} else if ((pSinal[0] == pSinal[4]) && (pSinal[4] == pSinal[8]) && (pSinal[8] != 'n')) {
			verificavencedor(pSinal[0]);
		} else if ((pSinal[6] == pSinal[4]) && (pSinal[4] == pSinal[2]) && (pSinal[2] != 'n')) {
			verificavencedor(pSinal[6]);
		} else if ((pSinal[0] != 'n') && (pSinal[1] != 'n') && (pSinal[2] != 'n') && (pSinal[3] != 'n')
				&& (pSinal[4] != 'n') && (pSinal[5] != 'n') && (pSinal[6] != 'n') && (pSinal[7] != 'n')
				&& (pSinal[8] != 'n')) {
			verificavencedor('v');
		}

	}

	// Métodos Get e Set de fResposta,fJogo e pSinal
	public Boolean getfResposta() {
		return fResposta;
	}

	public void setfResposta(Boolean fResposta) {
		this.fResposta = fResposta;
	}

	public Boolean getfJogo() {
		return fJogo;
	}

	public void setfJogo(Boolean fJogo) {
		this.fJogo = fJogo;
	}

	public char getpSinal(int pos) {
		return pSinal[pos];
	}

	public void setpSinal(char sin, int pos) {
		this.pSinal[pos - 1] = sin;
	}

}
