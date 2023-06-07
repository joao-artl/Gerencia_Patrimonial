package modelo;

public class Test {
	static Empresa empresa;
	static Filial f1;
	static ItemDePatrimonio i1, i2, i3, i4;
	
	public static void main(String[] args) {	
		empresa = new Empresa("Dzodak", 80118834000135L, "dzodak.matriz@dzodak.com",
							  61986649324L, "SQS 312 Bloco C, Asa Sul, Brasilia, DF");
		
		f1 = new Filial("Barthen", empresa.getCnpj()+100, "barthen.filial@dzodak.com",
						61986649276L, "SQN 101 Bloco A, Asa Norte, Brasilia, DF");
		
		i1 = new Utilitario("notebook Lenovo","IdeaPad 3i", "Gerenciamento de dados", 2023.99, 5);
		i2 = new Utilitario("armario", "75 x 32 x 170 cm, madeira", "Armazenamento", 219.90, 14);
		i3 = new Veiculo("carro", "rosa choque", "GTR R35 Godzilla", "Nissan", 1253178.00, 1);
		i4 = new Imobiliario("apartamento", 174, 1260000, "SQN 403 Bloco G, Asa Norte, Brasilia, DF");
	
		System.out.println(empresa.toString());
		System.out.println(f1.toString());
		System.out.println("\n~ Patrimonios:");
		System.out.println(i1.toString());
		System.out.println(i2.toString());
		System.out.println(i3.toString());
		System.out.println(i4.toString());
	}
}