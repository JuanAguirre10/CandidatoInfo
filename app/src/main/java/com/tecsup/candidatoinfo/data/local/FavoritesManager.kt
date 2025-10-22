package com.tecsup.candidatoinfo.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "favorites")

class FavoritesManager(private val context: Context) {

    private val FAVORITES_KEY = stringSetPreferencesKey("favorite_candidates")

    val favoritesFlow: Flow<Set<String>> = context.dataStore.data
        .map { preferences ->
            preferences[FAVORITES_KEY] ?: emptySet()
        }

    suspend fun addFavorite(candidatoId: String) {
        context.dataStore.edit { preferences ->
            val currentFavorites = preferences[FAVORITES_KEY] ?: emptySet()
            preferences[FAVORITES_KEY] = currentFavorites + candidatoId
        }
    }

    suspend fun removeFavorite(candidatoId: String) {
        context.dataStore.edit { preferences ->
            val currentFavorites = preferences[FAVORITES_KEY] ?: emptySet()
            preferences[FAVORITES_KEY] = currentFavorites - candidatoId
        }
    }

    suspend fun isFavorite(candidatoId: String): Boolean {
        var result = false
        context.dataStore.data.map { preferences ->
            val favorites = preferences[FAVORITES_KEY] ?: emptySet()
            result = favorites.contains(candidatoId)
        }
        return result
    }
}