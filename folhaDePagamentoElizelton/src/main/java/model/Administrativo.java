package model;

public class Administrativo extends Funcionario {

    public Administrativo(String nome, double salario, String sexo) {
        setNome(nome);
        setSalario(salario);
        setSexo(sexo);
    }

    @Override
    public double getSalarioFinal() {
        return salario;
    }

    @Override
    public String toString() {
        return "Administrativo {" + "nome=" + nome + " salario=" + salario + '}';
    }

}