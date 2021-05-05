import model.CorrecaoPotassio;
import model.FontesPotassio;
import model.CorrecaoFosforo;
import model.FontesFosforo;
import model.Nutrientes;
import model.Solo;
import model.TexturaSolo;
import org.junit.Assert;
import org.junit.Test;

public class TestBoards {

  @Test
  public void TestSoilBoard(){
    Solo solo1 = new Solo(9.0, 0.35, 6.0, 1.5, 9.0, 0.0, 0.0);
    Solo solo2 = new Solo(12.0, 0.25, 3.0, 1.0, 6.0, 0.0, 0.0);

    // Teste dos teores ideias com textura solo em argiloso
    Assert.assertEquals(solo1.getFosforo(), TexturaSolo.ARGILOSO.getValoresIdeais().getFosforo(), 0.0);
    Assert.assertEquals(solo1.getPotassio(), TexturaSolo.ARGILOSO.getValoresIdeais().getPotassio(), 0.0);
    Assert.assertEquals(solo1.getCalcio(), TexturaSolo.ARGILOSO.getValoresIdeais().getCalcio(), 0.0);
    Assert.assertEquals(solo1.getMagnesio(), TexturaSolo.ARGILOSO.getValoresIdeais().getMagnesio(), 0.0);
    Assert.assertEquals(solo1.getEnxofre(), TexturaSolo.ARGILOSO.getValoresIdeais().getEnxofre(), 0.0);
    Assert.assertEquals(solo1.getAluminio(), TexturaSolo.ARGILOSO.getValoresIdeais().getAluminio(), 0.0); 
    Assert.assertEquals(solo1.getAcidez(), TexturaSolo.ARGILOSO.getValoresIdeais().getAcidez(), 0.0);

    // Teste dos teores ideais com textura solo em textura média
    Assert.assertEquals(solo2.getFosforo(), TexturaSolo.TEXTURA_MEDIA.getValoresIdeais().getFosforo(), 0.0);
    Assert.assertEquals(solo2.getPotassio(), TexturaSolo.TEXTURA_MEDIA.getValoresIdeais().getPotassio(), 0.0);
    Assert.assertEquals(solo2.getCalcio(), TexturaSolo.TEXTURA_MEDIA.getValoresIdeais().getCalcio(), 0.0);
    Assert.assertEquals(solo2.getMagnesio(), TexturaSolo.TEXTURA_MEDIA.getValoresIdeais().getMagnesio(), 0.0);
    Assert.assertEquals(solo2.getEnxofre(), TexturaSolo.TEXTURA_MEDIA.getValoresIdeais().getEnxofre(), 0.0);
    Assert.assertEquals(solo2.getAluminio(), TexturaSolo.TEXTURA_MEDIA.getValoresIdeais().getAluminio(), 0.0); 
    Assert.assertEquals(solo2.getAcidez(), TexturaSolo.TEXTURA_MEDIA.getValoresIdeais().getAcidez(), 0.0);

    // Teste dos cálculos
    Assert.assertEquals(7.54, new Solo(8.59, 0.15, 5.76, 1.63, 3.67, 0.0, 5.35).getSCmol(), 0.0);
    Assert.assertEquals(12.89, new Solo(8.59, 0.15, 5.76, 1.63, 3.67, 0.0, 5.35).getCTCCmol(), 0.0);    
    Assert.assertEquals(58.49, new Solo(8.59, 0.15, 5.76, 1.63, 3.67, 0.0, 5.35).getVPercentual(), 0.1);
    Assert.assertEquals(3.07, new Solo(8.59, 0.15, 5.76, 1.63, 3.67, 0.0, 5.35).getMOPercentual(30.7), 0.1);
    Assert.assertEquals(17.84, new Solo(8.59, 0.15, 5.76, 1.63, 3.67, 0.0, 5.35).getCarbono(3.07), 0.1);
  }

  @Test
  public void TestPhosphorCorrectionBoard(){
    Solo solo = new Solo(8.59, 0.15, 5.76, 1.63, 3.67, 0.0, 0.0);

    // Cálculo da quantidade aplicar para cada fonte fófosro
    Assert.assertEquals(123.95, new CorrecaoFosforo(1260, solo, FontesFosforo.SUPERFOSFATO_SIMPLES, 12, 70).quantidadeAplicarElemento(), 0.1);
    Assert.assertEquals(54.41, new CorrecaoFosforo(1260, solo, FontesFosforo.SUPERFOSFATO_TRIPLO, 12, 70).quantidadeAplicarElemento(), 0.1);
    Assert.assertEquals(46.48, new CorrecaoFosforo(1260, solo, FontesFosforo.MAP, 12, 70).quantidadeAplicarElemento(), 0.1);
    Assert.assertEquals(49.58, new CorrecaoFosforo(1260, solo, FontesFosforo.DAP, 12, 70).quantidadeAplicarElemento(), 0.1);   
    Assert.assertEquals(123.95, new CorrecaoFosforo(1260, solo, FontesFosforo.YOORIN, 12, 70).quantidadeAplicarElemento(), 0.1);
    Assert.assertEquals(67.60, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSFATO_ARAD, 12, 70).quantidadeAplicarElemento(), 0.1);
    Assert.assertEquals(76.93, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSFATO_GAFSA, 12, 70).quantidadeAplicarElemento(), 0.1);
    Assert.assertEquals(69.72, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSFATO_DAOUI, 12, 70).quantidadeAplicarElemento(), 0.1);
    Assert.assertEquals(92.96, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSF_PATOS_MINAS, 70, 1260).quantidadeAplicarElemento(), 0.1);
    Assert.assertEquals(120.60, new CorrecaoFosforo(1260, solo, FontesFosforo.ESCORIA_THOMAS, 12, 70).quantidadeAplicarElemento(), 0.1);
    Assert.assertEquals(42.90, new CorrecaoFosforo(1260, solo, FontesFosforo.ACIDO_FOSFORICO, 12, 70).quantidadeAplicarElemento(), 0.1);
    Assert.assertEquals(123.95, new CorrecaoFosforo(1260, solo, FontesFosforo.MULTIF_MAGNESIANO, 12, 70).quantidadeAplicarElemento(), 0.1); 

    // Teste dos cálculos de nutrientes adicionais para cada fonte de fósforo
    Assert.assertArrayEquals(new Object[][] {{new double[] {34.70622222222223, 12.395079365079367}}, {new Nutrientes[] {Nutrientes.CALCIO, Nutrientes.ENXOFRE}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.SUPERFOSFATO_SIMPLES, 12, 70).correcaoElemento());
    Assert.assertArrayEquals(new Object[][] {{new double[] {10.883484320557493, 0.0}}, {new Nutrientes[] {Nutrientes.CALCIO, null}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.SUPERFOSFATO_TRIPLO, 12, 70).correcaoElemento());
    Assert.assertArrayEquals(new Object[][] {{new double[] {4.183339285714286, 0.0}}, {new Nutrientes[] {Nutrientes.NITROGENIO, null}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.MAP, 12, 70).correcaoElemento());       
    Assert.assertArrayEquals(new Object[][] {{new double[] {7.932850793650795, 0.0}}, {new Nutrientes[] {Nutrientes.NITROGENIO, null}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.DAP, 12, 70).correcaoElemento());
    Assert.assertArrayEquals(new Object[] [] {{new double[] {18.59261904761905, 34.70622222222223}}, {new Nutrientes[] {Nutrientes.MAGNESIO, Nutrientes.CALCIO}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.YOORIN, 12, 70).correcaoElemento());      
    Assert.assertArrayEquals(new Object[][] {{new double[] {35.15695238095238, 0.0}}, {new Nutrientes[] {Nutrientes.CALCIO, null}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSFATO_ARAD, 12, 70).correcaoElemento());
    Assert.assertArrayEquals(new Object[][] {{new double[] {40.006187192118226, 0.0}}, {new Nutrientes[] {Nutrientes.CALCIO, null}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSFATO_GAFSA, 12, 70).correcaoElemento());
    Assert.assertArrayEquals(new Object[][] {{new double[] {31.375044642857144, 0.0}}, {new Nutrientes[] {Nutrientes.CALCIO, null}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSFATO_DAOUI, 12, 70).correcaoElemento());
    Assert.assertArrayEquals(new Object[][] {{new double[] {26.02966666666667, 0.0}}, {new Nutrientes[] {Nutrientes.CALCIO, null}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSF_PATOS_MINAS, 12, 70).correcaoElemento());
    Assert.assertArrayEquals(new Object[][] {{new double[] {53.06433976833977, 0.0}}, {new Nutrientes[] {Nutrientes.CALCIO, null}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.ESCORIA_THOMAS, 12, 70).correcaoElemento());
    Assert.assertArrayEquals(new Object[][]{{new double[] {0.0, 0.0}}, {new Nutrientes[] {null, null}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.ACIDO_FOSFORICO, 12, 70).correcaoElemento());
    Assert.assertArrayEquals(new Object[][] {{new double[] {13.634587301587302, 22.31114285714286}}, {new Nutrientes[] {Nutrientes.ENXOFRE, Nutrientes.CALCIO}}}, new CorrecaoFosforo(1260, solo, FontesFosforo.MULTIF_MAGNESIANO, 12, 70).correcaoElemento());

    // Teste dos cálculos de custo do alqueire para cada fonte de fósforo
    Assert.assertEquals(156.17, new CorrecaoFosforo(1260, solo, FontesFosforo.SUPERFOSFATO_SIMPLES, 12, 70).calcularCustoAlqueire(),0.1);
    Assert.assertEquals(68.56, new CorrecaoFosforo(1260, solo, FontesFosforo.SUPERFOSFATO_TRIPLO, 70, 1260).calcularCustoAlqueire(),0.1);       
    Assert.assertEquals(58.56, new CorrecaoFosforo(1260, solo, FontesFosforo.MAP, 70, 1260).calcularCustoAlqueire(),0.1);      
    Assert.assertEquals(62.46, new CorrecaoFosforo(1260, solo, FontesFosforo.DAP, 70, 1260).calcularCustoAlqueire(),0.1);     
    Assert.assertEquals(156.17, new CorrecaoFosforo(1260, solo, FontesFosforo.YOORIN, 70, 1260).calcularCustoAlqueire(),0.1);    
    Assert.assertEquals(85.18, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSFATO_ARAD, 70, 1260).calcularCustoAlqueire(),0.1);        
    Assert.assertEquals(96.93, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSFATO_GAFSA, 70, 1260).calcularCustoAlqueire(),0.1);       
    Assert.assertEquals(87.84, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSFATO_DAOUI, 70, 1260).calcularCustoAlqueire(),0.1);        
    Assert.assertEquals(117.12, new CorrecaoFosforo(1260, solo, FontesFosforo.FOSF_PATOS_MINAS, 70, 1260).calcularCustoAlqueire(),0.1);       
    Assert.assertEquals(151.94, new CorrecaoFosforo(1260, solo, FontesFosforo.ESCORIA_THOMAS, 70, 1260).calcularCustoAlqueire(),0.1);        
    Assert.assertEquals(54.05, new CorrecaoFosforo(1260, solo, FontesFosforo.ACIDO_FOSFORICO, 70, 1260).calcularCustoAlqueire(),0.1);       
    Assert.assertEquals(156.17, new CorrecaoFosforo(1260, solo, FontesFosforo.MULTIF_MAGNESIANO, 70, 1260).calcularCustoAlqueire(),0.1);
  }

  @Test
  public void TestPotassiumCorrectionBoard(){
    Solo solo = new Solo(8.59, 0.15, 5.76, 1.63, 3.67, 0.0, 5.35);

    // Teste da participação do potássio atual
    Assert.assertEquals(1.2, new CorrecaoPotassio(2500.00, solo, FontesPotassio.CLORETO_POTASSIO, 3.0).participacaoPotassioAtual(), 0.1);

    // Teste da participação do potássio na CTC após correção
    Assert.assertEquals(3.0, new CorrecaoPotassio(2500.00, solo, FontesPotassio.CLORETO_POTASSIO, 3.0).participacaoPotassioCorrecao(), 0.1);

    // Teste da participação do potássio na CTC desejada
    Assert.assertEquals(3.0, new CorrecaoPotassio(2500.00, solo, FontesPotassio.CLORETO_POTASSIO, 3.0).participacaoPotassioPercentualIdeal(), 0.1);

    // Teste da quantidade aplicar do potássio
    Assert.assertEquals(450.55, new CorrecaoPotassio(2500.00, solo, FontesPotassio.CLORETO_POTASSIO, 3.0).quantidadeAplicarElemento(), 0.1);  
    Assert.assertEquals(502.53, new CorrecaoPotassio(2500.00, solo, FontesPotassio.SULFATO_POTASSIO, 3.0).quantidadeAplicarElemento(), 0.1); 
    Assert.assertEquals(1187.80, new CorrecaoPotassio(2500.00, solo, FontesPotassio.SULFATO_POTASSIO_MAGNESIO, 3.0).quantidadeAplicarElemento(), 0.1); 

    // Teste da quantidade fornecida de potássio
    Assert.assertArrayEquals(new Object[][] {{new double [] {0.0,0.0}},{new Nutrientes[] {null, null}}},  new CorrecaoPotassio(2500.00, solo, FontesPotassio.CLORETO_POTASSIO, 3.0).correcaoElemento());
    Assert.assertArrayEquals(new Object[][] {{new double[] {85.43049230769232, 0.0}}, {new Nutrientes[] {Nutrientes.ENXOFRE, null}}}, new CorrecaoPotassio(2500.00, solo, FontesPotassio.SULFATO_POTASSIO, 3.0).correcaoElemento());
    Assert.assertArrayEquals(new Object[][] {{new double[] {261.3168, 213.80465454545453}}, {new Nutrientes[] {Nutrientes.ENXOFRE, Nutrientes.MAGNESIO}}}, new CorrecaoPotassio(2500.00, solo, FontesPotassio.SULFATO_POTASSIO_MAGNESIO, 3.0).correcaoElemento());

    // Teste de custo do alqueire
    Assert.assertEquals(1126.37, new CorrecaoPotassio(2500.00, solo, FontesPotassio.CLORETO_POTASSIO, 3.0).calcularCustoAlqueire(), 0.1);
    Assert.assertEquals(1256.33, new CorrecaoPotassio(2500.00, solo, FontesPotassio.SULFATO_POTASSIO, 3.0).calcularCustoAlqueire(), 0.1);
    Assert.assertEquals(2969.51, new CorrecaoPotassio(2500.00, solo, FontesPotassio.SULFATO_POTASSIO_MAGNESIO, 3.0).calcularCustoAlqueire(), 0.1);
  }
}