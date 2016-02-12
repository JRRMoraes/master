package com.JRRMoraes.LIB_Uteis.GUI;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;

public class Mensageiro {

    private static boolean selecao = false;


    public static void avisar(Context contexto, String titulo, String texto) {
        AlertDialog.Builder vConstrutorAviso = new AlertDialog.Builder(
                contexto);
        vConstrutorAviso
                .setTitle(titulo)
                .setMessage(texto)
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog vAviso = vConstrutorAviso.create();
        vAviso.show();
    }


    public static void errar(Context contexto, String titulo, String texto, String erro) {
        if (!TextUtils.isEmpty(texto)) {
            titulo += "  --  " + texto;
        }

        Log.e(getApplicationName(contexto), String.format("%s :  %s", titulo, erro));

        AlertDialog.Builder vConstrutorErro = new AlertDialog.Builder(contexto);
        vConstrutorErro
                .setTitle(titulo)
                .setMessage(erro)
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog vErro = vConstrutorErro.create();
        vErro.show();
    }


    public static void errar(Context contexto, String titulo, String texto, Exception erro) {
        erro.printStackTrace();
        errar(contexto, titulo, texto, erro.getMessage());
    }


    public static void informar(Context contexto, String titulo, String texto) {
        AlertDialog.Builder vConstrutorInformacao = new AlertDialog.Builder(
                contexto);
        vConstrutorInformacao
                .setTitle(titulo)
                .setMessage(texto)
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog vInformacao = vConstrutorInformacao.create();
        vInformacao.show();
    }


    public static boolean questionar_SimNao(Context contexto, String titulo, String texto,
                                            String labelSim, String labelNao) {
        selecao = false;
        AlertDialog.Builder vConstrutorQuestao = new AlertDialog.Builder(
                contexto);
        vConstrutorQuestao
                .setTitle(titulo)
                .setMessage(texto)
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_dialer)
                .setPositiveButton(labelSim,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                selecao = true;
                                dialog.cancel();
                            }
                        })
                .setNegativeButton(labelNao,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                selecao = false;
                                dialog.cancel();
                            }
                        });
        AlertDialog vQuestao = vConstrutorQuestao.create();
        vQuestao.show();
        return selecao;
    }


    public static boolean questionar_SimNao(Context contexto, String titulo, String texto) {
        selecao = false;
        AlertDialog.Builder vConstrutorQuestao = new AlertDialog.Builder(
                contexto);
        vConstrutorQuestao
                .setTitle(titulo)
                .setMessage(texto)
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_dialer)
                .setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                selecao = true;
                                dialog.cancel();
                            }
                        })
                .setNegativeButton(android.R.string.no,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                selecao = false;
                                dialog.cancel();
                            }
                        });
        AlertDialog vQuestao = vConstrutorQuestao.create();
        vQuestao.show();
        return selecao;
    }


    public static String getApplicationName(Context contexto) {
        return contexto.getApplicationInfo().loadLabel(contexto.getPackageManager()).toString();
    }
}