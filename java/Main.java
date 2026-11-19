package main;
import java.util.ArrayList;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;


public class Main {
 public static void main(String[] args) {

  InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
  int tipoFinanciamento = interfaceUsuario.pedirTipoFinanciamento();
  double valorImovel = interfaceUsuario.pedirValorImovel();
  double taxaJurosAnual = interfaceUsuario.pedirTaxaJuros();
  int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();

  ArrayList<Financiamento> financiamentos = new ArrayList<>();

  Financiamento financiamento1;

  if (tipoFinanciamento == 1) {
   double areaConstruida = interfaceUsuario.pedirAreaConstruida();
   double areaTerreno = interfaceUsuario.pedirAreaTerreno();

   financiamento1 = new Casa(valorImovel, prazoFinanciamento,
           taxaJurosAnual, areaConstruida, areaTerreno);

  } else if (tipoFinanciamento == 2) {
   int numeroVagas = interfaceUsuario.pedirNumeroVagasGaragem();
   int numeroAndar = interfaceUsuario.pedirNumeroAndar();

   financiamento1 = new Apartamento(valorImovel, prazoFinanciamento,
           taxaJurosAnual, numeroVagas, numeroAndar);

  } else {
   String tipoZona = interfaceUsuario.pedirTipoZona();

   financiamento1 = new Terreno(valorImovel, prazoFinanciamento,
           taxaJurosAnual, tipoZona);
  }
  Financiamento financiamento2 =
          new Casa(450000, 30, 0.09, 120, 400);

  Financiamento financiamento3 =
          new Apartamento(900000, 10, 0.11, 2, 9);

  Financiamento financiamento4 =
          new Apartamento(360000, 15, 0.05, 1, 4);

  Financiamento financiamento5 =
          new Terreno(190000, 12, 0.15, "Residencial");

  financiamentos.add(financiamento1);
  financiamentos.add(financiamento2);
  financiamentos.add(financiamento3);
  financiamentos.add(financiamento4);
  financiamentos.add(financiamento5);

  double totalValorImoveis = 0;
  double totalValorFinanciamentos = 0;

  for (Financiamento financiamento : financiamentos) {
   financiamento.mostrarDadosNaTela();

   totalValorImoveis += financiamento.getValorImovel();
   totalValorFinanciamentos += financiamento.calcularTotaldoPagamento();
  }

  System.out.println("\nTotal dos valores dos imóveis: R$ "
          + totalValorImoveis);

  System.out.println("Total dos valores dos financiamentos: R$ "
          + totalValorFinanciamentos);
 }
 }