public class TesteConexao {
    public static void main(String[] args) {

        // Simplificando
        try (Conexao conexao = new Conexao()) {
            conexao.leDados();
        } catch (IllegalStateException e) {
            System.out.println("Erro na conexão");
        }

        /*Conexao con = null;
        try {
            con = new Conexao();
            con.leDados();
        } catch (IllegalStateException e) {
            System.out.println("Erro na conexão");
        } finally {
            con.fecha();
        }*/
    }
}
