package com.example.maintenance.presentation.ui.give.dialog

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.maintenance.presentation.entity.GiveWithEmployee

class GiveDialogContract : ActivityResultContract<GiveWithEmployee?, GiveWithEmployee?>() {
    override fun createIntent(context: Context, input: GiveWithEmployee?): Intent {
        val intent = Intent(context, GiveDialog::class.java)
        intent.putExtra("give", input)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): GiveWithEmployee? {
        if (resultCode == Activity.RESULT_OK && intent != null) {
            return intent.getParcelableExtra("resultGive")
        }
        return null
    }
}