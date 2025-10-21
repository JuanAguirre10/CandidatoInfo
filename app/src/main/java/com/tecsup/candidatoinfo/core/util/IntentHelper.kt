package com.tecsup.candidatoinfo.core.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

object IntentHelper {

    fun openExternalLink(context: Context, url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(
                context,
                "No se pudo abrir el enlace",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun shareText(context: Context, text: String, title: String = "Compartir") {
        try {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, text)
            }
            context.startActivity(Intent.createChooser(intent, title))
        } catch (e: Exception) {
            Toast.makeText(
                context,
                "No se pudo compartir",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun sendEmail(context: Context, email: String, subject: String, body: String) {
        try {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, body)
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(
                context,
                "No se pudo abrir el email",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}