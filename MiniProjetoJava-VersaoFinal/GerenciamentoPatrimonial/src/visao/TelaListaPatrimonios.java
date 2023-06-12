package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaListaPatrimonios {
	private JFrame janelaLista = new JFrame("Patrimônios da Empresa");
	private JLabel textoLista = new JLabel("Patrimônios da Empresa");
	//private JList<String> patrimonios;
	
	public TelaListaPatrimonios() {
		janelaLista.setLayout(null);
		
		janelaLista.setBounds(515, 505, 500, 300);
		textoLista.setBounds(155, 5, 175, 30);
		textoLista.setFont(new Font("Arial", Font.BOLD, 14));
		
		janelaLista.add(textoLista);
		janelaLista.setVisible(true);
	}	
}
