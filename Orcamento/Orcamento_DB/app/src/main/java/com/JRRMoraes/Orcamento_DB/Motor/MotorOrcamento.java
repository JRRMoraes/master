package com.JRRMoraes.Orcamento_DB.Motor;

import android.content.Context;
import android.content.Intent;
import com.JRRMoraes.LIB_Uteis.BD.IEsquema;
import com.JRRMoraes.LIB_Uteis.BD.MotorBanco;
//import com.JRRMoraes.LIB_Uteis.BD.SplashActivity;

public class MotorOrcamento {
	private static Context fContexto;
	private static IEsquema fEsquemaOrcamento;
	private MotorBanco fMotorBanco;

	public MotorOrcamento(Context contexto) {
		fContexto = contexto;
		fEsquemaOrcamento = new EsquemaOrcamento();
		fMotorBanco = new MotorBanco();
		fMotorBanco.esquema = fEsquemaOrcamento;
	}

	public boolean iniciar() {
		// Chamar Tela Splash
		Intent vIntent = new Intent(fContexto, SplashActivity.class);
		fContexto.startActivity(vIntent);
		
		// Conectar ao Banco de Dados
		if (!fMotorBanco.conectar()) {
			return false;
		}

		return true;
	}

}
