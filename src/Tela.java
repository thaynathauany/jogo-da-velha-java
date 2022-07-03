import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.WindowEvent;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel jPanelGame;
	private JButton jButton01;
	private JButton jButton03;
	private JButton jButton02;
	private JButton jButton07;
	private JButton jButton08;
	private JButton jButton09;
	private JButton jButton06;
	private JLabel jLb_aPlayer;
	private JLabel jLb_aPlayer_1;
	private JLabel jLb_aPlayer_2;
	private JLabel jLb_aPlayer_3;
	private JLabel jLb_aPyr_01;
	private JLabel jLb_aPlayer_5;
	private JLabel jLb_aPyr_02;
	private JButton jButton05;
	private JButton jButton04;
	public Campo interacao; // folha de controle do campo

	public static void main(String[] args) {
		
		// Função principal
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		
		// Constrói os itens de tela

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null); // Para a tela abrir no centro do monitor

		jPanelGame = new JPanel();
		jPanelGame.setBounds(197, 111, 400, 396);
		contentPane.add(jPanelGame);
		jPanelGame.setLayout(null);

		jButton01 = new JButton("");
		jButton01.setFont(new Font("Segoe UI", Font.BOLD, 80));
		jButton01.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton01.setBounds(10, 11, 120, 120);
		jPanelGame.add(jButton01);

		jButton03 = new JButton("");
		jButton03.setFont(new Font("Segoe UI", Font.BOLD, 80));
		jButton03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton03.setBounds(270, 11, 120, 120);
		jPanelGame.add(jButton03);

		jButton02 = new JButton("");
		jButton02.setFont(new Font("Segoe UI", Font.BOLD, 80));
		jButton02.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton02.setBounds(140, 11, 120, 120);
		jPanelGame.add(jButton02);

		jButton07 = new JButton("");
		jButton07.setFont(new Font("Segoe UI", Font.BOLD, 80));
		jButton07.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton07.setBounds(10, 266, 120, 120);
		jPanelGame.add(jButton07);

		jButton08 = new JButton("");
		jButton08.setFont(new Font("Segoe UI", Font.BOLD, 80));
		jButton08.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton08.setBounds(140, 266, 120, 120);
		jPanelGame.add(jButton08);

		jButton09 = new JButton("");
		jButton09.setFont(new Font("Segoe UI", Font.BOLD, 80));
		jButton09.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton09.setBounds(270, 266, 120, 120);
		jPanelGame.add(jButton09);

		jButton06 = new JButton("");
		jButton06.setFont(new Font("Segoe UI", Font.BOLD, 80));
		jButton06.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton06.setBounds(270, 138, 120, 120);
		jPanelGame.add(jButton06);

		jButton05 = new JButton("");
		jButton05.setFont(new Font("Segoe UI", Font.BOLD, 80));
		jButton05.setBounds(140, 138, 120, 120);
		jPanelGame.add(jButton05);

		jButton04 = new JButton("");
		jButton04.setFont(new Font("Segoe UI", Font.BOLD, 80));
		jButton04.setBounds(10, 138, 120, 120);
		jPanelGame.add(jButton04);

		jLb_aPlayer = new JLabel("Player");
		jLb_aPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		jLb_aPlayer.setFont(new Font("Segoe UI", Font.BOLD, 36));
		jLb_aPlayer.setBounds(321, 27, 156, 55);
		contentPane.add(jLb_aPlayer);

		jLb_aPlayer_1 = new JLabel("Player");
		jLb_aPlayer_1.setForeground(Color.BLUE);
		jLb_aPlayer_1.setHorizontalAlignment(SwingConstants.CENTER);
		jLb_aPlayer_1.setFont(new Font("Segoe UI", Font.BOLD, 36));
		jLb_aPlayer_1.setBounds(10, 11, 156, 55);
		contentPane.add(jLb_aPlayer_1);

		jLb_aPlayer_2 = new JLabel("Player");
		jLb_aPlayer_2.setForeground(Color.RED);
		jLb_aPlayer_2.setHorizontalAlignment(SwingConstants.CENTER);
		jLb_aPlayer_2.setFont(new Font("Segoe UI", Font.BOLD, 36));
		jLb_aPlayer_2.setBounds(618, 11, 156, 55);
		contentPane.add(jLb_aPlayer_2);

		jLb_aPlayer_3 = new JLabel("Vit\u00F3rias:");
		jLb_aPlayer_3.setForeground(Color.BLUE);
		jLb_aPlayer_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		jLb_aPlayer_3.setBounds(38, 66, 54, 16);
		contentPane.add(jLb_aPlayer_3);

		jLb_aPyr_01 = new JLabel("0");
		jLb_aPyr_01.setForeground(Color.BLUE);
		jLb_aPyr_01.setFont(new Font("Segoe UI", Font.BOLD, 12));
		jLb_aPyr_01.setBounds(89, 66, 54, 16);
		contentPane.add(jLb_aPyr_01);

		jLb_aPlayer_5 = new JLabel("Vit\u00F3rias:");
		jLb_aPlayer_5.setForeground(Color.RED);
		jLb_aPlayer_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		jLb_aPlayer_5.setBounds(648, 66, 54, 16);
		contentPane.add(jLb_aPlayer_5);

		jLb_aPyr_02 = new JLabel("0");
		jLb_aPyr_02.setForeground(Color.RED);
		jLb_aPyr_02.setFont(new Font("Segoe UI", Font.BOLD, 12));
		jLb_aPyr_02.setBounds(699, 66, 54, 16);
		contentPane.add(jLb_aPyr_02);

		jPanelGame.setVisible(false);

		// Operação ativada ao abrir o programa
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				inittelainteracao();
				initGame();
			}
		});

		// Operações ativadas ao clicar nos botões
		jButton01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btClick(jButton01, 1);
			}
		});
		jButton02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btClick(jButton02, 2);
			}
		});
		jButton03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btClick(jButton03, 3);
			}
		});
		jButton04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btClick(jButton04, 4);
			}
		});
		jButton05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btClick(jButton05, 5);
			}
		});
		jButton06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btClick(jButton06, 6);
			}
		});
		jButton07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btClick(jButton07, 7);
			}
		});
		jButton08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btClick(jButton08, 8);
			}
		});
		jButton09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btClick(jButton09, 9);
			}
		});
	}

	// Inicia a classe Campo para interação com o player
	public void inittelainteracao() {
		interacao = new Campo();
		interacao.iniciaPlayers();
	}

	// Realiza os processos de inicio de jogo
	public void initGame() {

		interacao.cBotao(jButton01, jButton02, jButton03, jButton04, jButton05, jButton06, jButton07, jButton08,
				jButton09);
		jPanelGame.setVisible(false);
		jLb_aPlayer.setText("Player");
		jLb_aPlayer.setForeground(Color.BLACK);

		interacao.Player.atuLPoints(jLb_aPyr_01, jLb_aPyr_02);

		interacao.LimpaCampo();
		jPanelGame.setVisible(true);
		obter_vPlayer();
	}

	// Verifica qual a vez do jogador
	public void obter_vPlayer() {

		interacao.pLabel(jLb_aPlayer, interacao.getSinalAtual());

		if ((interacao.Player.getPvCPU()) && (interacao.getSinalAtual() == 'X')) {
			interacao.sendCampo_CPU();
			//interacao.Player.CPU.print_field();
			jogadaCPU(interacao.Player.CPU.jogadaCPU());			
		}
	}

	// Realiza as jogadas conforme o retorno da classe Computador
	private void jogadaCPU(int jogada) {
		switch (jogada) {
		case 1:
			btClick(jButton01, 1);
			break;
		case 2:
			btClick(jButton02, 2);
			break;
		case 3:
			btClick(jButton03, 3);
			break;
		case 4:
			btClick(jButton04, 4);
			break;
		case 5:
			btClick(jButton05, 5);
			break;
		case 6:
			btClick(jButton06, 6);
			break;
		case 7:
			btClick(jButton07, 7);
			break;
		case 8:
			btClick(jButton08, 8);
			break;
		case 9:
			btClick(jButton09, 9);
			break;
		}
	}

	// Realiza os processos após a chamada do click do botão
	public void btClick(javax.swing.JButton pbotao, int bPos) {

		// Captura informação dos cliques dos botões
		interacao.clickBotao(pbotao, bPos);
		verifica_fJogo();
		obter_vPlayer();
	}

	// Verifica se o jogo se encontra finalizado
	public void verifica_fJogo() {

		if (interacao.getfJogo()) {
			interacao.Player.atuLPoints(jLb_aPyr_01, jLb_aPyr_02);
			interacao.questionaNovoJogo();
		}
		if (interacao.getfResposta()) {
			initGame();
		}

	}

}
