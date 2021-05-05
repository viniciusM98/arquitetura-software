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
}