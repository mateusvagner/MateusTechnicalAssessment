package com.mat.mateus_technical_assessment

import com.mat.mateus_technical_assessment.data.local.LocalStorage

class FakeLocalStorage: LocalStorage {
    override fun saveCredentials() {
        // no-op
    }
}